package com.hasansahin.airlineticketingsystem.repository;

import com.hasansahin.airlineticketingsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
	Route findByUuid(String uuid);
}
