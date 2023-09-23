package com.xh.a2023919;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@Data
public class PriceAttributeQuantityDetail {

    private PriceAttributeQuantity priceAttributeQuantity;

    private Integer step;

    private Integer max;

    private Integer min;

    private List<QuantityInterval> intervals;


    @Data
    public static class QuantityInterval {

        private Integer start;

        private Integer end;

        private PriceStagy priceStagy;

        private BigDecimal price;

        public enum PriceStagy {

            UNIT_PRICE,

            FIXED_TOTAL_PRICE;

        }


    }

}
