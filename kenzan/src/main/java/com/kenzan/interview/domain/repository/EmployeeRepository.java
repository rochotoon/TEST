/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.kenzan.interview.domain.model.Employee;

/**
 * interface definition for {@link employee} access.
 *
 * <p>
 *  Define methods to access , create and update new records for {@link Employees}
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

  /**
   * <p>
   * Fetch all ACTIVE Employees
   * </p>
   *
   * @return List<Employee> dataset
   */
  @Query("SELECT emp FROM Employee emp WHERE status = com.kenzan.interview.domain.model.StatusType.ACTIVE")
  List<Employee> findAllActive();


  /**
   * <p>
   * Fetch all ACTIVE Employees base on Id
   * </p>
   *
   * @param Long Employee id
   * @return List<Employee> dataset
   */
  @Query("SELECT emp FROM Employee emp WHERE status = com.kenzan.interview.domain.model.StatusType.ACTIVE AND id = ?1")
  List<Employee> findById(Long id);

  /**
   * <p>
   * 
   * </p>
   *
   * @param firstName value
   * @param lastName value
   * @param middleInitial value
   * @param id  value
   * @return  List<Employee> dataset
   */
  List<Employee> findByFirstNameAndLastNameAndMiddleInitialOrId(String firstName, String lastName, String middleInitial,
      Long id);
}
