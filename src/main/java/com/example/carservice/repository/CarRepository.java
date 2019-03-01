package com.example.carservice.repository;

import com.example.carservice.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Long>, PagingAndSortingRepository<Car, Long> {

    List<Car> findAll();

    // Fetch cars by brand
    List<Car> findByBrand(String brand);
    // Fetch cars by color
    List<Car> findByColor(String color);
    // Fetch cars by year
    List<Car> findByYear(int year);

    // Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);
    // Fetch cars by brand or color
    List<Car> findByBrandOrColor(String brand, String color);

    // Fetch cars by brand and sort by year
     List<Car> findByBrandOrderByYearAsc(String brand);

    // Fetch cars by brand using SQL
    @Query("SELECT c FROM Car c WHERE c.brand = ?1")
    List<Car> findByBrandSql(String brand);

    // Fetch cars by brand using SQL
    @Query("SELECT c FROM Car c WHERE c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

}
