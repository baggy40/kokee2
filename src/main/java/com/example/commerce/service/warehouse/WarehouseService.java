package com.example.commerce.service.warehouse;

import com.example.commerce.dto.warehouse.WarehouseStockDto;
import com.example.commerce.entity.ItemEntity;
import com.example.commerce.entity.avg.AvgSUM;
import com.example.commerce.entity.warehouse.WarehouseEntity;
import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import com.example.commerce.repository.AvgRopository;
import com.example.commerce.repository.ItemRepository;
import com.example.commerce.repository.warehouse.WarehouseRepository;
import com.example.commerce.repository.warehouse.WarehouseStockRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WarehouseService {

    private final WarehouseStockRepository warehouseStockRepository;
    private final WarehouseRepository warehouseRepository;
    private final ItemRepository itemRepository;

    private final AvgRopository avgRopository;

    public List<WarehouseStockEntity> searchStock(){
        List<WarehouseStockEntity> warehouseEntities = warehouseStockRepository.findAll();

        return warehouseEntities;
    }

    public Integer avgSql(){
        return avgRopository.coffAvg();
    }

    public AvgSUM ajaxCoff(){
        return avgRopository.ajaxAvg();
    }


    public void insertOver(WarehouseStockDto warehouseStockDto){
        Long item_id = Long.valueOf(warehouseStockDto.getItem_id());
        Long ware_id = Long.valueOf(warehouseStockDto.getWarehouse_id());

        System.out.println("item_id============"+item_id );

        WarehouseEntity warehouseEntity = warehouseRepository.findById(ware_id).get();
        ItemEntity itemEntity = itemRepository.findById(item_id).get();
        WarehouseStockEntity beforeWare = warehouseStockRepository.selectDescSQL(item_id,ware_id);

        Integer total = 0;

        if (beforeWare !=null){
            if (beforeWare.getStock() !=null){
                total = beforeWare.getStock()+warehouseStockDto.getReceiving();
            }else{
                total += warehouseStockDto.getReceiving();
            }
        }else{
            total += warehouseStockDto.getReceiving();
        }

        System.out.println("total=================="+ total);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        WarehouseStockEntity warehouseStockEntity = mapper.map(warehouseStockDto, WarehouseStockEntity.class);
        warehouseStockEntity.setWarehouseEntity(warehouseEntity);
        warehouseStockEntity.setItemEntity(itemEntity);
        warehouseStockEntity.setStock(total);
        warehouseStockEntity.setForwarding(0);
        warehouseStockEntity.setCreateDate(LocalDateTime.now());

        warehouseStockRepository.save(warehouseStockEntity);
    }

}
