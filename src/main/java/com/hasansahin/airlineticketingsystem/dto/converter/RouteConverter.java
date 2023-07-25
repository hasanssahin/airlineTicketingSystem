package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.create.RouteCreateDto;
import com.hasansahin.airlineticketingsystem.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteConverter {
	public Route convertRouteCreateDtoToRoute(RouteCreateDto routeCreateDto){
		return new Route(routeCreateDto.getRouteName());
	}

	public RouteDto convertRouteToRouteDto(Route route){
		return new RouteDto(route.getRouteName(), route.getUuid());
	}
}
