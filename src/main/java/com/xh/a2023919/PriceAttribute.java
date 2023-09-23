package com.xh.a2023919;

import lombok.Data;

/**
 * @author Xiao Hong
 * @since 2023-09-22
 */
@Data
public abstract class PriceAttribute {

    private Long id;

    private Long productId;

    private String name;

    private PriceAttributeType type;

    private PriceAttribute parent;


    public enum PriceAttributeType{

        //
        QUANTITY,

        ENUMERATE;

    }


}
