package com.indi.shop.jpa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BRAND")
@Data
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = -7695694239762795119L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id; 
    
    @Column(name = "NAME", nullable = false)
    private String name;

}
