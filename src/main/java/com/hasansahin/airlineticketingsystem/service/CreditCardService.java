package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.CreditCardDto;
import com.hasansahin.airlineticketingsystem.dto.converter.CreditCardConverter;
import com.hasansahin.airlineticketingsystem.exception.GenericException;
import com.hasansahin.airlineticketingsystem.model.CreditCard;
import com.hasansahin.airlineticketingsystem.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final CreditCardConverter creditCardConverter;

    public CreditCardDto save(CreditCardDto creditCardDto) {
        CreditCard creditCard = creditCardConverter.convertCreditCardDtoToCreditCard(creditCardDto);
        creditCard.setCreditCardNumber(editNumber(creditCard.getCreditCardNumber()));
        creditCard.setCreditCardNumber(maskCreditCardNumber(creditCard.getCreditCardNumber()));
        return creditCardConverter.convertCreditCardToCreditCartDto(creditCardRepository.save(creditCard));
    }

    private String editNumber(String creditCardNumber) {
        String regex = "\\D";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(creditCardNumber);
        return matcher.replaceAll("");
    }

    private String maskCreditCardNumber(String creditCardNumber) {
        int visibleDigits = 6;
        int totalDigits = creditCardNumber.length();
        int maskedLength = totalDigits - (visibleDigits + 4);

        String maskedPortion = "*".repeat(maskedLength);
        String visibleDigitsPart = creditCardNumber.substring(0, visibleDigits);
        String lastFourDigits = creditCardNumber.substring(totalDigits - 4);

        return visibleDigitsPart + maskedPortion + lastFourDigits;
    }

    protected CreditCard findByCvcProtected(String cvc) {
        return creditCardRepository.findByCvc(cvc).orElseThrow(()->new GenericException("Credit card not found", HttpStatus.NOT_FOUND));
    }
}
