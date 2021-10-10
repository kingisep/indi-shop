package test.com.indi.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.indi.shop.dto.jpa.PriceDto;

@TestMethodOrder(OrderAnnotation.class)
class PriceControllerTest<T> extends CommonTest<T> {

    private final static String LIST_PRICES_END_POINT_URL = "/price/find/";
    
    private final static String TEST_CASE_1_DATE = "2021-06-14 10:00:00";
    private final static String TEST_CASE_2_DATE = "2021-06-14 16:00:00";
    private final static String TEST_CASE_3_DATE = "2021-06-14 21:00:00";
    private final static String TEST_CASE_4_DATE = "2021-06-15 10:00:00";
    private final static String TEST_CASE_5_DATE = "2021-06-16 21:00:00";
    
    private final static Long BRAND_ZARA = 1L;
    private final static Long PRODUCT = 35455L;
    private final static Long PRICE_1 = 1L;
    private final static Long PRICE_2 = 2L;
    private final static Long PRICE_3 = 3L;
    private final static Long PRICE_4 = 4L;

    @Test
    @Order(1)
    void listFilteredPrices1() throws Exception {
        ParameterizedTypeReference<PriceDto> responseType = 
                new ParameterizedTypeReference<PriceDto>() {};
        HttpEntity<PriceDto> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort(LIST_PRICES_END_POINT_URL))
                .queryParam("date", TEST_CASE_1_DATE)
                .queryParam("brandId", BRAND_ZARA.toString())
                .queryParam("productId", PRODUCT.toString());
        
        ResponseEntity<PriceDto> resp = restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                responseType
        );

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(PRICE_1 , resp.getBody().getId());
    }
    
    @Test
    @Order(2)
    void listFilteredPrices2() throws Exception {
        ParameterizedTypeReference<PriceDto> responseType = 
                new ParameterizedTypeReference<PriceDto>() {};
        HttpEntity<PriceDto> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort(LIST_PRICES_END_POINT_URL))
                .queryParam("date", TEST_CASE_2_DATE)
                .queryParam("brandId", BRAND_ZARA.toString())
                .queryParam("productId", PRODUCT.toString());
        
        ResponseEntity<PriceDto> resp = restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                responseType
        );

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(PRICE_2 , resp.getBody().getId());

    }
    
    @Test
    @Order(3)
    void listFilteredPrices3() throws Exception {
        ParameterizedTypeReference<PriceDto> responseType = 
                new ParameterizedTypeReference<PriceDto>() {};
        HttpEntity<PriceDto> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort(LIST_PRICES_END_POINT_URL))
                .queryParam("date", TEST_CASE_3_DATE)
                .queryParam("brandId", BRAND_ZARA.toString())
                .queryParam("productId", PRODUCT.toString());
        
        ResponseEntity<PriceDto> resp = restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                responseType
        );

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(PRICE_1 , resp.getBody().getId());
    }
    
    @Test
    @Order(4)
    void listFilteredPrices4() throws Exception {
        ParameterizedTypeReference<PriceDto> responseType = 
                new ParameterizedTypeReference<PriceDto>() {};
        HttpEntity<PriceDto> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort(LIST_PRICES_END_POINT_URL))
                .queryParam("date", TEST_CASE_4_DATE)
                .queryParam("brandId", BRAND_ZARA.toString())
                .queryParam("productId", PRODUCT.toString());
        
        ResponseEntity<PriceDto> resp = restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                responseType
        );

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(PRICE_3 , resp.getBody().getId());
    }
    
    @Test
    @Order(5)
    void listFilteredPrices5() throws Exception {
        ParameterizedTypeReference<PriceDto> responseType = 
                new ParameterizedTypeReference<PriceDto>() {};
        HttpEntity<PriceDto> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort(LIST_PRICES_END_POINT_URL))
                .queryParam("date", TEST_CASE_5_DATE)
                .queryParam("brandId", BRAND_ZARA.toString())
                .queryParam("productId", PRODUCT.toString());
        
        ResponseEntity<PriceDto> resp = restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                responseType
        );

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(PRICE_4 , resp.getBody().getId());
    }
}
