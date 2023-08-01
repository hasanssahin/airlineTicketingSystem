package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.CreditCardDto;
import com.hasansahin.airlineticketingsystem.dto.converter.CreditCardConverter;
import com.hasansahin.airlineticketingsystem.model.CreditCard;
import com.hasansahin.airlineticketingsystem.repository.CreditCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceTest {
    @Mock
    CreditCardConverter creditCardConverter;

    @Mock
    CreditCardRepository creditCardRepository;

    @InjectMocks
    CreditCardService creditCardService;

    @Test
    void save() {
        CreditCard creditCard = new CreditCard("4221161122330005", "123");
        CreditCardDto creditCardDto = new CreditCardDto("4221161122330005", "123");

        when(creditCardRepository.save(creditCard)).thenReturn(creditCard);
        when(creditCardConverter.convertCreditCardToCreditCartDto(creditCard)).thenReturn(creditCardDto);
        when(creditCardConverter.convertCreditCardDtoToCreditCard(creditCardDto)).thenReturn(creditCard);

        CreditCardDto resultCreditCardDto = creditCardService.save(creditCardDto);

        assertEquals(creditCardDto.getCvc(), resultCreditCardDto.getCvc());
    }
}
