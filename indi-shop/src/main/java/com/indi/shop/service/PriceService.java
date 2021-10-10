package com.indi.shop.service;

import com.indi.shop.dto.jpa.PriceDto;
import com.indi.shop.dto.rest.PriceListRequestDto;

public interface PriceService {

    PriceDto findFilteredPrice(PriceListRequestDto request);
}
