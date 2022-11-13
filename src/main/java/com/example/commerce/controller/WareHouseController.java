package com.example.commerce.controller;

import com.example.commerce.dto.warehouse.WarehouseStockDto;
import com.example.commerce.entity.avg.AvgSUM;
import com.example.commerce.entity.warehouse.WarehouseStockEntity;
import com.example.commerce.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WareHouseController {

    private final WarehouseService warehouseService;

    @GetMapping(value = "/index")
    public String index(Model model){

        List<WarehouseStockEntity> warehouseStockEntities = warehouseService.searchStock();

        //avg
        double coff_avg = warehouseService.avgSql();
        System.out.println("avg================="+coff_avg);

        coff_avg = coff_avg / 10000 * 100.0;
        System.out.println("avg================="+coff_avg);

        model.addAttribute("wareEntity",warehouseStockEntities);
        //desc 정렬로 가장 위에 있는 재고를 가져온다
        //통계를 보여줘야 하기 때문에 한달 통계 입고나 출고를 보여준다
        model.addAttribute("test1", warehouseStockEntities.get(0).getStock());

        model.addAttribute("coff_avg",coff_avg);

        return "warehouse/index";
    }

    @PostMapping(value="/admins/insertorder")
    public @ResponseBody ResponseEntity orderPost(@RequestBody WarehouseStockDto warehouseStockDto) {
        System.out.println(warehouseStockDto);
        try{
            warehouseService.insertOver(warehouseStockDto);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("주문이 완료 되었습니다.",HttpStatus.OK);
    }

    @GetMapping(value = "/ajaxProject")
    public @ResponseBody ResponseEntity ajaxProject(){
        System.out.println("ajaxStart==================");
        try{
            AvgSUM ajaxSum = warehouseService.ajaxCoff();
            return new ResponseEntity<AvgSUM>(ajaxSum,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
