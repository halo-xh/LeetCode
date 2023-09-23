package com.xh.a2023919;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PriceAttributeEnum extends PriceAttribute {

    private List<AttributeEnum> enumValues;


    @Data
    public static class AttributeEnum {

        private Long id;

        private String enumName;
    }

}
