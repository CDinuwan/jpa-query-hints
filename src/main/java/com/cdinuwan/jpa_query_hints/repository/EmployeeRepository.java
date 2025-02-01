package com.cdinuwan.jpa_query_hints.repository;

import com.cdinuwan.jpa_query_hints.entity.Employee;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    @QueryHints( {
            @QueryHint(name = "org.hibernate.readOnly", value = "true"),
            @QueryHint(name = "org.hibernate.fetchSize", value = "50"),
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.query.timeout", value = "2000")
    })
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") double salary);
}
