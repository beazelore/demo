package com.softserve.demoproject.repository;

import com.softserve.demoproject.model.Call;
import com.softserve.demoproject.projection.CallStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends CrudRepository<Call, Long> {
    @Query(nativeQuery = true, value = "SELECT cl.city AS city, COUNT(*) AS cnt FROM call_logs AS cl GROUP BY cl.city")
    Iterable<CallStatistics> countByCity();

    @Query(nativeQuery = true,
            value = "SELECT * FROM call_logs where (client_id,duration) = (select cl.client_id,  max(duration) from call_logs as cl " +
                    "where call_time between :startDate and :endDate and cl.client_id=:clientId group by cl.client_id)")
    List<Call> getLongestCall(@Param("clientId") Long clientId, @Param("startDate")String startDate,
                              @Param("endDate") String endDate);
}
