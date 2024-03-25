package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.MeritOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeritOrderRepository extends JpaRepository<MeritOrder, Long> {
    
}
