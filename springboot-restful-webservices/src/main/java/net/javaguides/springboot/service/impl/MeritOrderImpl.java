package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.MeritOrder;
import net.javaguides.springboot.repository.MeritOrderRepository;
import net.javaguides.springboot.service.MeritOrderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MeritOrderImpl implements MeritOrderService {

    private MeritOrderRepository meritOrderRepository;

    @Override
    public MeritOrder createMeritOrder(MeritOrder meritOrder) {
        return meritOrderRepository.save(meritOrder);
    }

    @Override
    public MeritOrder getMeritOrderById(Long meritOrderId) {
        Optional<MeritOrder> optionalMeritOrder = meritOrderRepository.findById(meritOrderId);
        return optionalMeritOrder.get();
    }

    @Override
    public List<MeritOrder> getAllMeritOrders() {
        return meritOrderRepository.findAll();
    }

    @Override
    public MeritOrder updateMeritOrder(MeritOrder meritOrder) {
        MeritOrder existingMeritOrder = meritOrderRepository.findById(meritOrder.getId()).get();
        existingMeritOrder.setName(meritOrder.getName());
        existingMeritOrder.setFuelType(meritOrder.getFuelType());
        existingMeritOrder.setCapacity(meritOrder.getCapacity());
        existingMeritOrder.setOp(meritOrder.getOp());
        existingMeritOrder.setProduction(meritOrder.getProduction());
        existingMeritOrder.setPrice(meritOrder.getPrice());
        existingMeritOrder.setSfkCapacity(meritOrder.getSfkCapacity());
        MeritOrder updatedMeritOrder = meritOrderRepository.save(existingMeritOrder);
        return updatedMeritOrder;
    }

    @Override
    public void deleteMeritOrder(Long meritOrderId) {
        meritOrderRepository.deleteById(meritOrderId);
    }
}