package com.example.commerce.warehouse;

import com.example.commerce.dto.ItemDto;
import com.example.commerce.dto.warehouse.WarehouseDto;
import com.example.commerce.entity.ItemEntity;
import com.example.commerce.entity.warehouse.WarehouseEntity;
import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import com.example.commerce.repository.ItemRepository;
import com.example.commerce.repository.warehouse.WarehouseRepository;
import com.example.commerce.repository.warehouse.WarehouseStockRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class WarehouseTest {
    
    @Autowired
    WarehouseStockRepository warehouseStockRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ItemRepository itemRepository;
    
    @PersistenceContext
    EntityManager em;
    
    public ItemEntity createItem(){
        ItemDto itemDto = new ItemDto();
        itemDto.setProduct_gubun("Coffee");
        itemDto.setProduct_name("원두커피");
        itemDto.setPrice(3000);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ItemEntity itemEntity = mapper.map(itemDto, ItemEntity.class);
        return itemEntity;
    }

    public WarehouseEntity createWarehouse(){
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setWarehouse_name("newyork_01");
        warehouseDto.setLocation("34_bt");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        WarehouseEntity warehouseEntity = mapper.map(warehouseDto, WarehouseEntity.class);
        return warehouseEntity;
    }

    @Test
    @DisplayName("창고 아이템 조회")
    public void findItemTest(){
        ItemEntity itemEntity = createItem();
        itemRepository.save(itemEntity);

        WarehouseEntity warehouseEntity = createWarehouse();
        warehouseRepository.save(warehouseEntity);

        WarehouseStockEntity warehouseStockEntity =new WarehouseStockEntity();
        warehouseStockEntity.setWarehouseEntity(warehouseEntity);
        warehouseStockRepository.save(warehouseStockEntity);

        em.flush();
        em.clear();

        WarehouseStockEntity saved = warehouseStockRepository.findById(warehouseStockEntity.getId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(saved.getId(), itemEntity.getId());
    }
    @Test
    @DisplayName("전체 조회")
    public void findAllTest(){
        List<WarehouseStockEntity> findAll = warehouseStockRepository.findAll();
        for(WarehouseStockEntity exs : findAll){
            System.out.println(exs.toString());

        }
    }

}
