package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.CreditCardDto;
import com.hasansahin.airlineticketingsystem.service.CreditCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/creditCards")
public class CreditCardController {
    private final CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<CreditCardDto> save(@RequestBody @Valid CreditCardDto creditCardDto) {
        return ResponseEntity.ok(creditCardService.save(creditCardDto));
    }
}
