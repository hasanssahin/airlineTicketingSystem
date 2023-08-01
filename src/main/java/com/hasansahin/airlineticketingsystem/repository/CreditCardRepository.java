package com.hasansahin.airlineticketingsystem.repository;

import com.hasansahin.airlineticketingsystem.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByCvc(String cvc);
}
