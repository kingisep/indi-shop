package com.indi.shop.dto.rest;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.indi.shop.IndiConstants;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PriceListRequestDto implements Serializable {
    private static final long serialVersionUID = 5950882987912677056L;
    
    @ApiParam(value = "Id of the product")
    @NotNull(message = "productId required")
    private Long productId;
    
    @ApiParam(value = "Id of the brand")
    @NotNull(message = "brandId required")
    private Long brandId;
    
    @ApiParam(value = "Date in Gregorian calendar " + IndiConstants.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = IndiConstants.DATE_TIME_FORMAT)
    @NotNull(message = "date required")
    private LocalDateTime date;

}
