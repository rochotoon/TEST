/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.adapter;

import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import com.kenzan.interview.application.employee.web.dto.RestResultDTO;
import com.kenzan.interview.domain.model.Employee;

/**
 * Adapter class that implements the interface: {@link IEmployeeAdapter IEmployeeAdapter}
 *
 * <p>
 * Generate REST output applying an standard way using {@link RestResultDTO RestResultDTO}
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
public interface IEmployeeAdapter {

  /**
   * <p>
   * calls needed logic to <B>DELETE</B> a users. In this case we are just making status = to INACTIVE
   * </p>
   *
   * @param newEmployee new employee
   * @return RestResultDTO standard way to retrieve REST output
   */
    RestResultDTO generateRespForEmployeeDelete(EmployeCreationDTO newEmployee);

    /**
     * <p>
     * calls needed logic to <B>UPDATE</B> a users. 
     * </p>
     *
     * @param newEmployee new employee
     * @return RestResultDTO standard way to retrieve REST output
     */
    RestResultDTO generateRespForEmployeeUpdate(EmployeCreationDTO newEmployee);

    /**
     * <p>
     * calls needed logic to <B>CREATE</B> users.
     * </p>
     *
     * @param newEmployee new employee
     * @return RestResultDTO standard way to retrieve REST output
     */
    RestResultDTO generateRespForEmployeeCreation(EmployeCreationDTO newEmployee);

    /**
     * <p>
     * Fetch {@link Employee} data base on ID
     * </p>
     *
     * @param id employee id
     * @return RestResultDTO standard way to retrieve REST output
     */
    RestResultDTO generateResponseByEmployeeId(Long id);

    /**
     * <p>
     * Fetch {@link Employee} <u>List</u> . Note:  <B>ACTIVE</B> employees
     * </p>
     *
     * @return RestResultDTO standard way to retrieve REST output
     */
    RestResultDTO generateResponseForAllActiveEmployees();
}
