package com.dojo.api.configuration;

import com.dojo.api.model.ExchangeRate;
import com.dojo.api.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public DataInitializer(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void run(String... args) {
        ExchangeRate rate1 = new ExchangeRate("USD", "EUR", new BigDecimal("0.85"));
        ExchangeRate rate2 = new ExchangeRate("EUR", "USD", new BigDecimal("1.18"));

        exchangeRateRepository.saveAll(Arrays.asList(rate1, rate2));
    }
}
