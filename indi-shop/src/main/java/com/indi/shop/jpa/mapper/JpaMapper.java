package com.indi.shop.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.indi.shop.dto.jpa.BrandDto;
import com.indi.shop.dto.jpa.PriceDto;
import com.indi.shop.dto.jpa.ProductDto;
import com.indi.shop.dto.jpa.RateDto;
import com.indi.shop.jpa.model.BrandEntity;
import com.indi.shop.jpa.model.PriceEntity;
import com.indi.shop.jpa.model.ProductEntity;
import com.indi.shop.jpa.model.RateEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface JpaMapper {

    ProductDto productEntityToProductDto(ProductEntity ent);
    PriceDto priceEntityToPriceDto(PriceEntity ent);
    BrandDto brandEntityToBrandDto(BrandEntity ent);
    RateDto rateEntityToRateDto(RateEntity ent);

}
