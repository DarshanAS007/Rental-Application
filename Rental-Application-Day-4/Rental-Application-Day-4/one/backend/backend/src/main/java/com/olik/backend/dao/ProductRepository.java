package com.olik.backend.dao;

import com.olik.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {


    @Query(value = "INSERT INTO products (name, pricePerHour, availableFromDateTime, availableToDateTime) VALUES (:name, :pricePerHour, :availableFromDateTime, :availableToDateTime)", nativeQuery = true)
    Product saveProduct(
            @Param("name") String name,
            @Param("pricePerHour") double pricePerHour,
            @Param("availableFromDateTime") LocalDateTime availableFromDateTime,
            @Param("availableToDateTime") LocalDateTime availableToDateTime
    );


    @Query("SELECT p.* FROM Product p LEFT JOIN Rent r ON p.productId = r.productId WHERE p.availableFromDateTime >= :searchingFromDateTime AND p.availableToDateTime >= :searchingFromDateTime AND ((:searchingFromDateTime < r.rentingFromDateTime AND :searchingToDateTime < r.rentingFromDateTime) OR (:searchingFromDateTime > r.rentingToDateTime AND :searchingToDateTime < r.rentingToDateTime) OR (:searchingFromDateTime <> r.rentingFromDateTime OR :searchingToDateTime <> r.rentingToDateTime))")
    List<Product> findAvailableProductsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);



}


/*

SELECT p.*
FROM Product p
LEFT JOIN Rent r ON p.productId = r.productId
WHERE p.availableFromDateTime >= :searchingFromDateTime
  AND p.availableToDateTime >= :searchingFromDateTime
  AND (
    (:searchingFromDateTime < r.rentingFromDateTime AND :searchingToDateTime < r.rentingFromDateTime)
    OR (:searchingFromDateTime > r.rentingToDateTime AND :searchingToDateTime < r.rentingToDateTime)
    OR (:searchingFromDateTime <> r.rentingFromDateTime OR :searchingToDateTime <> r.rentingToDateTime)
    OR r.rentId IS NULL
  );


SELECT p FROM products p WHERE p.availableFromDateTime >= :startDate AND p.availableToDateTime <= :endDate

 */