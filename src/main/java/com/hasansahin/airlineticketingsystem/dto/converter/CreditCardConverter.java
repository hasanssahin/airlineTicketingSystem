package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.CreditCardDto;
import com.hasansahin.airlineticketingsystem.model.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardConverter {
	public CreditCard convertCreditCardDtoToCreditCard(CreditCardDto creditCardDto) {
		return new CreditCard(creditCardDto.getCreditCardNumber(), creditCardDto.getCvc());
	}

	public CreditCardDto convertCreditCardToCreditCartDto(CreditCard creditCard) {
		return new CreditCardDto(creditCard.getCreditCardNumber(), creditCard.getCvc());
	}
}