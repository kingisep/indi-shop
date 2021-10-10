package com.indi.shop.dto.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceDto  implements Serializable {
    private static final long serialVersionUID = 2863281268257612961L;
    
    private Long id;
    private String name;
    private Integer priority;
    private BigDecimal price;
    private String currency;
    private ProductDto product;
    private BrandDto brand;
    private RateDto rate;    

}
