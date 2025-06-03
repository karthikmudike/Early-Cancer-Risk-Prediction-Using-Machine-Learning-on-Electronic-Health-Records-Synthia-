package com.karthikyadavmudike.learn_spring_boot.BillPayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface BillPaymentRepository extends JpaRepository<BillPayment, Long>{

}
