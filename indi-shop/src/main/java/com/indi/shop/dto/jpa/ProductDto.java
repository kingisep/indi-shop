package com.indi.shop.dto.jpa;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 9128188039183228750L;
    
    private Long id;
    private String name;
    private String description;
    private String size;

}
