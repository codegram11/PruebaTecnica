package com.dojo.api.service;

import com.dojo.api.domain.ConversionResult;
import com.dojo.api.exceptions.CurrencyConversionException;
import com.dojo.api.model.ExchangeRate;
import com.dojo.api.repository.ExchangeRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CurrencyConversionService {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionService.class);

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ConversionResult convertCurrency(String sourceCurrency, String targetCurrency, BigDecimal amount) {
        try {
            Optional<ExchangeRate> rateOptional = Optional.ofNullable(exchangeRateRepository.findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency));

            ExchangeRate rate = rateOptional.orElseThrow(() -> new CurrencyConversionException("Tipo de cambio no encontrado"));

            BigDecimal convertedAmount = amount.multiply(rate.getRate());

            return new ConversionResult(amount, convertedAmount, sourceCurrency, targetCurrency, rate.getRate());
        } catch (CurrencyConversionException ex) {
            logger.error("Error en la conversión de moneda", ex);
            throw ex;
        } catch (Exception ex) {
            logger.error("Error interno en la conversión de moneda", ex);
            throw new CurrencyConversionException("Error interno en la conversión de moneda");
        }
    }
}
