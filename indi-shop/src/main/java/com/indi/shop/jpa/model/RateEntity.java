package com.indi.shop.jpa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RATE")
@Data
public class RateEntity implements Serializable {
    private static final long serialVersionUID = -2136753383852733083L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id; 
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    
    @Column(name = "START_DATE", nullable = true)
    private LocalDateTime startDate;
    
    @Column(name = "END_DATE", nullable = true)
    private LocalDateTime endDate;
    
}
