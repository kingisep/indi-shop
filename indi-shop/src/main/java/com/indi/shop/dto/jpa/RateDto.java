package com.indi.shop.dto.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RateDto  implements Serializable{
    private static final long serialVersionUID = 2863281268257612961L;
    
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
