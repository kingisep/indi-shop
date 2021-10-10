package com.indi.shop.service.impl;


import static com.indi.shop.jpa.repository.PriceRepository.filterPriceSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.shop.dto.jpa.PriceDto;
import com.indi.shop.dto.rest.PriceListRequestDto;
import com.indi.shop.jpa.mapper.JpaMapper;
import com.indi.shop.jpa.model.PriceEntity;
import com.indi.shop.jpa.repository.PriceRepository;
import com.indi.shop.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepo;
    @Autowired
    private JpaMapper jpaMapper;

    @Override
    public PriceDto findFilteredPrice(PriceListRequestDto dto) {
        PriceEntity price = priceRepo.findAll(filterPriceSpec(dto)).stream().max(PriceEntity::compareTo).orElse(null);
        return jpaMapper.priceEntityToPriceDto(price);

    }

}
