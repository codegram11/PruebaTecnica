package com.dojo.api.controller;

import com.dojo.api.domain.ConversionRequest;
import com.dojo.api.domain.ConversionResult;
import com.dojo.api.exceptions.CurrencyConversionException;
import com.dojo.api.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyConversionService conversionService;

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestBody ConversionRequest request) {
        try {
            ConversionResult result = conversionService.convertCurrency(request.getSourceCurrency(), request.getTargetCurrency(), request.getAmount());
            return ResponseEntity.ok(result);
        } catch (CurrencyConversionException ex) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}
