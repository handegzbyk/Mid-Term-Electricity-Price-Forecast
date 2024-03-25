package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Demand;
import net.javaguides.springboot.repository.DemandRepository;
import net.javaguides.springboot.service.DemandService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DemandServiceImpl implements DemandService {

    private DemandRepository demandRepository;

    @Override
    public Demand createDemand(Demand demand) {
        return demandRepository.save(demand);
    }

    @Override
    public Demand getDemandById(Long demandId) {
        Optional<Demand> optionalDemand = demandRepository.findById(demandId);
        return optionalDemand.get();
    }

    @Override
    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    @Override
    public Demand updateDemand(Demand demand) {
        Demand existingDemand = demandRepository.findById(demand.getId()).get();
        existingDemand.setDate(demand.getDate());
        existingDemand.setHour(demand.getHour());
        existingDemand.setResidual(demand.getResidual());
        existingDemand.setMarketPrice(demand.getMarketPrice());
        existingDemand.setSfkPrice(demand.getSfkPrice());
        Demand updatedDemand = demandRepository.save(existingDemand);
        return updatedDemand;
    }

    @Override
    public void deleteDemand(Long demandId) {
        demandRepository.deleteById(demandId);
    }
}