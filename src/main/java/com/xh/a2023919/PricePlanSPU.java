package com.xh.a2023919;

import lombok.Data;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@Data
public abstract class PricePlanSPU {

    private Long id;

    private String name;

    private Long productId;

    private PricePlanSPUEnum strategyEnum;

    private ProductLine productLine;

    private ProductVersion productVersion;

    private Float directSellDiscountLimit;

    private Float distributeSellDiscountLimit;


    public enum PricePlanSPUEnum {

        //
        COMMON,

        BUYOUT,

        SUBSCRIPTION;


    }

}
