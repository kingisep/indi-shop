package com.indi.shop.dto.jpa;

import java.io.Serializable;

import lombok.Data;

@Data
public class BrandDto  implements Serializable{
    private static final long serialVersionUID = 2863281268257612961L;
    
    private Long id;
    private String name;

}
