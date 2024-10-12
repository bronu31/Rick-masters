package com.microservice.rickmaster.repository;

import com.microservice.rickmaster.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

    @Query(value = "SELECT sum(weight), sort,country from coffee\n" +
            "group by sort,country", nativeQuery = true)
    List<Object> returnSums();
    @Query(value = "SELECT sum(weight), sort from coffee where sort =?1 group by sort", nativeQuery = true)
    List<Object> returnSumsFilterBySort(String sort);
    @Query(value = "SELECT sum(weight), country from coffee\n" +
            "where country =?1 \n" +
            "group by country", nativeQuery = true)
    List<Object> returnSumsFilterByCountry(String countryOfOrigin);
    @Query(value = "SELECT sum(weight), sort, country from coffee\n" +
            "where country =?1 and sort =?2  \n" +
            "group by country,sort", nativeQuery = true)
    List<Object> returnSums(String country, String sort);

}
