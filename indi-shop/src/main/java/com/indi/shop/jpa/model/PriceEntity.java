package com.indi.shop.jpa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "PRICE", uniqueConstraints = @UniqueConstraint(columnNames={"PRIORITY", "PRODUCT_ID", "BRAND_ID", "RATE_ID"}))
@Data
public class PriceEntity implements Serializable , Comparable<PriceEntity> {
    private static final long serialVersionUID = 2024672187666393756L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id; 
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;
    
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    
    @Column(name = "CURRENCY", nullable = false)
    private String currency;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brand;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATE_ID", nullable = false)
    private RateEntity rate;

    @Override
    public int compareTo(PriceEntity other) {
        return this.getPriority().compareTo(other.getPriority());
    }
}
