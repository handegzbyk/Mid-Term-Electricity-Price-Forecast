package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.MeritOrder;
import net.javaguides.springboot.entity.Demand;
import net.javaguides.springboot.entity.ExtendedMeritOrder;
import net.javaguides.springboot.service.MeritOrderService;
import net.javaguides.springboot.service.DemandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;



@RestController
@AllArgsConstructor
@RequestMapping("api/prices")
public class PriceController {

    private MeritOrderService meritOrderService;
    private DemandService demandService;

    // Build Get All Prices REST API
    // http://localhost:8080/api/prices
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMeritOrdersAndFirstDemand(){
        Map<String, Object> result = new HashMap<>();
        List<MeritOrder> meritOrders = meritOrderService.getAllMeritOrders();
        List<Demand> demands = demandService.getAllDemands();
        List<Float> selectedPrices = new ArrayList<>();
        List<String> combinedDates = new ArrayList<>();
        
        //result.put("meritOrders", meritOrders);
        // Sadece ilk demand'i alıyoruz
        if (!demands.isEmpty()) {
            for (Demand demand : demands) {
                float sfkPrice = demand.getSfkPrice();
                float residual = demand.getResidual();

                // Her bir MeritOrder için işlem yap
                List<ExtendedMeritOrder> extendedMeritOrders = new ArrayList<>();
                for (MeritOrder meritOrder : meritOrders) {
                    long id = meritOrder.getId();
                    String name = meritOrder.getName();
                    String fuelType = meritOrder.getFuelType();
                    Float capacity = meritOrder.getCapacity();
                    Float op = meritOrder.getOp();
                    Float production = meritOrder.getProduction();
                    Float price = meritOrder.getPrice();
                    Float sfkCapacity = meritOrder.getSfkCapacity();
                    Float processedValue = (production * price - sfkCapacity * sfkPrice) / production;

                    extendedMeritOrders.add(new ExtendedMeritOrder(id,name,fuelType,capacity,op,production,price,sfkCapacity, processedValue));
                }

                extendedMeritOrders.sort(Comparator.comparing(ExtendedMeritOrder::getProcessedValue));
                // Her bir ExtendedMeritOrder nesnesinin birikimli üretim miktarını güncelle
                float productionCumulative = 0.0f;
                for (ExtendedMeritOrder extendedMeritOrder : extendedMeritOrders) {
                    productionCumulative += extendedMeritOrder.getProduction();
                    extendedMeritOrder.setProduction(productionCumulative);
                }
                for (ExtendedMeritOrder extendedMeritOrder : extendedMeritOrders) {
                    if (extendedMeritOrder.getProduction() >= residual) {
                        float selectedPrice = extendedMeritOrder.getProcessedValue();
                        selectedPrices.add(selectedPrice);
                        break;
                    }
                }
                String combinedDate = demand.getDate() + " " + demand.getHour();
                combinedDates.add(combinedDate);
            result.put("selectedPrices", selectedPrices);
            result.put("combinedDates", combinedDates);
            } 
            }
        else {
                result.put("firstDemand", "No demand found");
        }

            return new ResponseEntity<>(result, HttpStatus.OK);
    }
}