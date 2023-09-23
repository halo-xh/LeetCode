package com.xh.a2023919;

import lombok.Data;

import java.util.List;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@Data
public class PricePlanSKU {

    private Long id;

    private PricePlanSPU pricePlanSPU;

    private PriceAttributeQuantityDetail quantityDetail;

    private List<PriceAttributeEnum> priceAttributeEnums;

    private PricePlanStrategy pricePlanStrategy;

    public enum PricePlanStrategy {

        //
        COMMON,

        TIERED_PRICING,

        TIERED_PRICING_ACCUMULATIVE;

    }


}
