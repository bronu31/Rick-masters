package com.microservice.rickmaster.repository;

import com.microservice.rickmaster.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    @Query(value = "SELECT \"brigadeID\",\n" +
            "      100-weight_after_roasting/weight*100 from message where \"brigadeID\"=20\n" +
            "group by \"brigadeID\",100-weight_after_roasting/weight*100",

            nativeQuery = true)
    List<Object> lossesByBrigade(Integer brigade);
    @Query(value = "SELECT \"brigadeID\",\n" +
            "     100-weight_after_roasting/weight*100, country from message\n" +
            "where country=?1\n" +
            "group by country,\"brigadeID\",100-weight_after_roasting/weight*100" , nativeQuery = true)
    List<Object> lossesByCountry(String country);
}
