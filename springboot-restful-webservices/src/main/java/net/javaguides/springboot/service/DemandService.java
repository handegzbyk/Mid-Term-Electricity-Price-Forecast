package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Demand;

import java.util.List;

public interface DemandService {
    Demand createDemand(Demand demand);

    Demand getDemandById(Long demandId);

    List<Demand> getAllDemands();

    Demand updateDemand(Demand demand);

    void deleteDemand(Long demandId);
}

