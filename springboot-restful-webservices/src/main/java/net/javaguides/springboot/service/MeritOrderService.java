package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.MeritOrder;

import java.util.List;

public interface MeritOrderService {
    MeritOrder createMeritOrder(MeritOrder meritOrder);

    MeritOrder getMeritOrderById(Long meritOrderId);

    List<MeritOrder> getAllMeritOrders();

    MeritOrder updateMeritOrder(MeritOrder meritOrder);

    void deleteMeritOrder(Long meritOrderId);
}

