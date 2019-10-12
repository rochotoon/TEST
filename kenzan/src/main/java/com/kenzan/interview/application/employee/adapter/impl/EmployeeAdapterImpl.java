/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.adapter.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kenzan.interview.application.employee.adapter.IEmployeeAdapter;
import com.kenzan.interview.application.employee.commons.Constants;
import com.kenzan.interview.application.employee.commons.RestOuputMarshaller;
import com.kenzan.interview.application.employee.service.IEmployeeService;
import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import com.kenzan.interview.application.employee.web.dto.RestResultDTO;
import com.kenzan.interview.domain.model.Employee;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
@Component
public class EmployeeAdapterImpl implements IEmployeeAdapter {

  IEmployeeService employeeService;

  RestOuputMarshaller<RestResultDTO> output;

  /**
   * <p>
   * Main constructor.
   * </p>
   *
   * @param employeeService obj retains bussiness rules.
   */
  @Autowired
  public EmployeeAdapterImpl(IEmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  /**
   * <p>
   * calls needed logic to <B>DELETE</B> a users. In this case we are just making status = to INACTIVE
   * </p>
   *
   * @param newEmployee new employee
   * @return RestResultDTO standard way to retrieve REST output
   */
  @Override
  public RestResultDTO generateRespForEmployeeDelete(EmployeCreationDTO newEmployee) {
    output = () -> {
      boolean response = employeeService.deleteEmployee(newEmployee);

      return response
          ? RestResultDTO.builder().result(Constants.REST_SUCCESS)
              .message(String.format(Constants.REST_EMPLOYEE_DELETED, newEmployee.getEmployeeId())).build()
          : RestResultDTO.builder().result(Constants.REST_FAIL).message(Constants.ERROR_UNABLE_TO_DELETE).build();
    };

    return output.get();

  }

  /**
   * <p>
   * calls needed logic to <B>UPDATE</B> a users. 
   * </p>
   *
   * @param newEmployee new employee
   * @return RestResultDTO standard way to retrieve REST output
   */
  @Override
  public RestResultDTO generateRespForEmployeeUpdate(EmployeCreationDTO newEmployee) {
    output = () -> {
      List<Employee> response = employeeService.updateEmployee(newEmployee);

      return (!response.isEmpty()) ? RestResultDTO.builder().result(Constants.REST_SUCCESS).output(response).build()
          : RestResultDTO.builder().result(Constants.REST_FAIL).message(Constants.ERROR_UNABLE_TO_CREATE).build();
    };

    return output.get();

  }

  /**
   * <p>
   * calls needed logic to <B>CREATE</B> users.
   * </p>
   *
   * @param newEmployee new employee
   * @return RestResultDTO standard way to retrieve REST output
   */
  @Override
  public RestResultDTO generateRespForEmployeeCreation(EmployeCreationDTO newEmployee) {
    output = () -> {
      List<Employee> response = employeeService.createEmployee(newEmployee);

      return (!response.isEmpty()) ? RestResultDTO.builder().result(Constants.REST_SUCCESS).output(response).build()
          : RestResultDTO.builder().result(Constants.REST_FAIL).message(Constants.ERROR_UNABLE_TO_CREATE).build();
    };

    return output.get();

  }

 
  /**
   * <p>
   * Fetch {@link Employee} data base on ID
   * </p>
   *
   * @param id employee id
   * @return RestResultDTO standard way to retrieve REST output
   */
  @Override
  public RestResultDTO generateResponseByEmployeeId(Long id) {

    output = () -> {
      List<Employee> response = employeeService.getEmployeeById(id);

      return (!response.isEmpty()) ? RestResultDTO.builder().result(Constants.REST_SUCCESS).output(response).build()
          : RestResultDTO.builder().result(Constants.REST_NO_DATA_FOUND).message(Constants.ERROR_NO_ACTIVE_EMPLOYEES)
              .build();
    };

    return output.get();
  }

  /**
   * <p>
   * Fetch {@link Employee} <u>List</u> . Note:  <B>ACTIVE</B> employees
   * </p>
   *
   * @return RestResultDTO standard way to retrieve REST output
   */
  @Override
  public RestResultDTO generateResponseForAllActiveEmployees() {

    output = () -> {

      List<Employee> response = employeeService.getAllEMployeesNoFilter();

      return !response.isEmpty() ? RestResultDTO.builder().result(Constants.REST_SUCCESS).output(response).build()
          : RestResultDTO.builder().result(Constants.REST_NO_DATA_FOUND).message(Constants.ERROR_NO_ACTIVE_EMPLOYEES)
              .build();
    };

    return output.get();
  }

}
