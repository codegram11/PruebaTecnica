package com.dojo.api.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResult{

    private BigDecimal amount;
    private BigDecimal convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;

}
