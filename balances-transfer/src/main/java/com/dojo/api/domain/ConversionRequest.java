package com.dojo.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {

    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal amount;

}
