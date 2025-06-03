package com.karthikyadavmudike.learn_spring_boot.CustomerService;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerServiceRepository extends JpaRepository<CustomerService, Long> {
	
	
}
