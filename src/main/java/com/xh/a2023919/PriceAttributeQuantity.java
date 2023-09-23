package com.xh.a2023919;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PriceAttributeQuantity extends PriceAttribute {

    private String unit;


}
