package com.indi.shop.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indi.shop.dto.jpa.PriceDto;
import com.indi.shop.dto.rest.PriceListRequestDto;
import com.indi.shop.service.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping(value = "/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/find")
    @ApiOperation(value = "Allows to retrieve filtered paginated price list")
    public ResponseEntity<PriceDto> findFilteredPrice(
            @ApiParam(value = "List application request") @Valid PriceListRequestDto request) {
        PriceDto price = priceService.findFilteredPrice(request);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

}
