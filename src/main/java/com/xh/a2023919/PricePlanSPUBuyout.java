package com.xh.a2023919;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PricePlanSPUBuyout extends PricePlanSPU {

    private BigDecimal basePrice;


}
