package com.xh.a2023919;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
public class PricePlanTest {

    public static void main(String[] args) {
        PriceAttributeEnum attribute = new PriceAttributeEnum();
        attribute.setName("版本");
        attribute.setType(PriceAttribute.PriceAttributeType.ENUMERATE);
        PriceAttributeEnum a2 = new PriceAttributeEnum();
        a2.setName("档位");
        a2.setType(PriceAttribute.PriceAttributeType.ENUMERATE);
        PriceAttributeQuantity a3 = new PriceAttributeQuantity();
        a3.setName("用户数");
        a3.setType(PriceAttribute.PriceAttributeType.QUANTITY);

        PricePlanSPU planSPU = new PricePlanSPUBuyout();
        planSPU.setName("A8定价");
        planSPU.setStrategyEnum(PricePlanSPU.PricePlanSPUEnum.BUYOUT);
        planSPU.setDirectSellDiscountLimit(7.5f);
        planSPU.setDirectSellDiscountLimit(6.5f);

        ProductLine productLine = new ProductLine();
        productLine.setName("A8");
        planSPU.setProductLine(productLine);

        ProductVersion productVersion = new ProductVersion();
        productVersion.setName("V8.1SP1");
        planSPU.setProductVersion(productVersion);

        PricePlanSKU pricePlanSKU = new PricePlanSKU();
        pricePlanSKU.setPricePlanSPU(planSPU);
        pricePlanSKU.setPriceAttributeEnums(Arrays.asList(a2, attribute));

        pricePlanSKU.setPricePlanStrategy(PricePlanSKU.PricePlanStrategy.TIERED_PRICING);

        PriceAttributeQuantityDetail quantityDetail = new PriceAttributeQuantityDetail();
        quantityDetail.setPriceAttributeQuantity(a3);
        quantityDetail.setMax(99999);
        quantityDetail.setMin(1);
        quantityDetail.setStep(100);

        PriceAttributeQuantityDetail.QuantityInterval interval = new PriceAttributeQuantityDetail.QuantityInterval();
        interval.setStart(1);
        interval.setEnd(100);
        interval.setPriceStagy(PriceAttributeQuantityDetail.QuantityInterval.PriceStagy.UNIT_PRICE);
        interval.setPrice(new BigDecimal(1000));


        PriceAttributeQuantityDetail.QuantityInterval interval2 = new PriceAttributeQuantityDetail.QuantityInterval();
        interval2.setStart(100);
        interval2.setEnd(1000);
        interval2.setPriceStagy(PriceAttributeQuantityDetail.QuantityInterval.PriceStagy.UNIT_PRICE);
        interval2.setPrice(new BigDecimal(1000));

        quantityDetail.setIntervals(Arrays.asList(interval, interval2));



        pricePlanSKU.setQuantityDetail(quantityDetail);


    }
}
