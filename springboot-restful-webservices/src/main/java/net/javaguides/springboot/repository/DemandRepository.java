package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Long> {
    
}
