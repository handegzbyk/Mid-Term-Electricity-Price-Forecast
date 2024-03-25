package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Demand;
import net.javaguides.springboot.service.DemandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/demands")
public class DemandController {

    private DemandService demandService;

    // build create Demand REST API
    @PostMapping
    public ResponseEntity<Demand> createUser(@RequestBody Demand demand){
        Demand savedDemand = demandService.createDemand(demand);
        return new ResponseEntity<>(savedDemand, HttpStatus.CREATED);
    }

    // build get demand by id REST API
    // http://localhost:8080/api/demands/1
    @GetMapping("{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") Long demandId){
        Demand demand = demandService.getDemandById(demandId);
        return new ResponseEntity<>(demand, HttpStatus.OK);
    }

    // Build Get All Demands REST API
    // http://localhost:8080/api/demands
    @GetMapping
    public ResponseEntity<List<Demand>> getAllDemands(){
        List<Demand> demands = demandService.getAllDemands();
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/demands/1
    public ResponseEntity<Demand> updateDemand(@PathVariable("id") Long demandId,
                                           @RequestBody Demand demand){
        demand.setId(demandId);
        Demand updatedDemand = demandService.updateDemand(demand);
        return new ResponseEntity<>(updatedDemand, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDemand(@PathVariable("id") Long demandId){
        demandService.deleteDemand(demandId);
        return new ResponseEntity<>("Demand successfully deleted!", HttpStatus.OK);
    }
}