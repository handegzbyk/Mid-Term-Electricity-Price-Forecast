package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.MeritOrder;
import net.javaguides.springboot.service.MeritOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/meritorders")
public class MeritOrderController {

    private MeritOrderService meritOrderService;

    // build create MeritOrder REST API
    @PostMapping
    public ResponseEntity<MeritOrder> createUser(@RequestBody MeritOrder meritOrder){
        MeritOrder savedMeritOrder = meritOrderService.createMeritOrder(meritOrder);
        return new ResponseEntity<>(savedMeritOrder, HttpStatus.CREATED);
    }

    // build get merit order by id REST API
    // http://localhost:8080/api/meritorders/1
    @GetMapping("{id}")
    public ResponseEntity<MeritOrder> getMeritOrderById(@PathVariable("id") Long meritOrderId){
        MeritOrder meritOrder = meritOrderService.getMeritOrderById(meritOrderId);
        return new ResponseEntity<>(meritOrder, HttpStatus.OK);
    }

    // Build Get All MeritOrders REST API
    // http://localhost:8080/api/meritorders
    @GetMapping
    public ResponseEntity<List<MeritOrder>> getAllMeritOrders(){
        List<MeritOrder> meritOrders = meritOrderService.getAllMeritOrders();
        return new ResponseEntity<>(meritOrders, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/meritorders/1
    public ResponseEntity<MeritOrder> updateMeritOrder(@PathVariable("id") Long meritOrderId,
                                           @RequestBody MeritOrder meritOrder){
        meritOrder.setId(meritOrderId);
        MeritOrder updatedMeritOrder = meritOrderService.updateMeritOrder(meritOrder);
        return new ResponseEntity<>(updatedMeritOrder, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMeritOrder(@PathVariable("id") Long meritOrderId){
        meritOrderService.deleteMeritOrder(meritOrderId);
        return new ResponseEntity<>("Merit Order successfully deleted!", HttpStatus.OK);
    }
}