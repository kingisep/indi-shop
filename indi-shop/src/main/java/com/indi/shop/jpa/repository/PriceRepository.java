package com.indi.shop.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.indi.shop.dto.rest.PriceListRequestDto;
import com.indi.shop.jpa.model.PriceEntity;
import com.indi.shop.jpa.model.ProductEntity;
import com.indi.shop.jpa.model.RateEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {
    
    static Specification<PriceEntity> filterPriceSpec(PriceListRequestDto dto) {
            return (price, query, builder) -> {

                List<Predicate> predicates = new ArrayList<>(0);

                // Date 
                Fetch<PriceEntity, RateEntity> rateFetch = price.fetch("rate", JoinType.INNER);
                Join<PriceEntity, RateEntity> rateJoin = (Join<PriceEntity, RateEntity>) rateFetch;
                predicates.add(builder.lessThanOrEqualTo(rateJoin.get("startDate"), dto.getDate()));
                predicates.add(builder.greaterThanOrEqualTo(rateJoin.get("endDate"), dto.getDate()));

                // Product
                Fetch<PriceEntity, ProductEntity> productFetch = price.fetch("product", JoinType.INNER);
                Join<PriceEntity, ProductEntity> productJoin = (Join<PriceEntity, ProductEntity>) productFetch;
                predicates.add(builder.equal(productJoin.get("id"), dto.getProductId()));

                // Brand
                Fetch<PriceEntity, ProductEntity> brandFetch = price.fetch("brand", JoinType.INNER);
                Join<PriceEntity, ProductEntity> brandJoin = (Join<PriceEntity, ProductEntity>) brandFetch;
                predicates.add(builder.equal(brandJoin.get("id"), dto.getBrandId()));

                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
