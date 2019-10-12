/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.commons.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kenzan.interview.application.employee.commons.Constants;
import com.kenzan.interview.application.employee.service.IEmployeeService;
import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import com.kenzan.interview.domain.model.Employee;
import com.kenzan.interview.domain.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implements the interface: {@link IEmployeeService}
 *
 * <p>
 * Class that performes business actions over {@link Employee} model.
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

  EmployeeRepository employeeRepository;

  /**
   * <p>
   * Function that handles the String Values To Long
   * </p>
   *
   * @param employeeRepository main
   */
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  /**
   * <p>
   * Fetch all <b>Active</b> {@link Employee}
   * </p>
   *
   * @return List<Employee> employee list
   */
  @Override
  public List<Employee> getAllEMployeesNoFilter() {
    return employeeRepository.findAllActive();
  }

  /**
   * <p>
   * Fetch <b>Active</b> employee base on employee Id.
   * </p>
   *
   * @param id employee id
   * @return List<Employee> employees 
   */
  @Override
  public List<Employee> getEmployeeById(Long id) {
    return employeeRepository.findById(id);
  }

  /**
   * <p>
   * Generates a new record of {@link Employee} 
   * </p>
   *
   * @param employeCreationDTO represents employee REST output
   * @return List<Employee> employees 
   */
  @Override
  public List<Employee> createEmployee(EmployeCreationDTO employeCreationDTO) {
    Employee employee = Employee.builder().build().persistChanges(employeCreationDTO);
    employeeRepository.save(employee);
    return Arrays.asList(employee);
  }

  /**
   * <p>
   * Modifies an existing record of {@link Employee} 
   * </p>
   *
   * @param employeCreationDTO represents employee REST output
   * @return List<Employee> employees 
   */
  @Override
  public List<Employee> updateEmployee(EmployeCreationDTO employeCreationDTO) {
    List<Employee> employee = fetchEmployee(employeCreationDTO);

    log.info(employeCreationDTO.toString());

    if (employee.isEmpty())
      throw new IllegalArgumentException(Constants.ERROR_NO_ACTIVE_EMPLOYEES);
    employee.forEach(emp -> employeeRepository.save(emp.updateChanges(employeCreationDTO)));

    return employee;

  }

  /**
   * <p>
   * Deletes(Inactivate) an existing record of {@link Employee} 
   * </p>
   *
   * @param employeCreationDTO represents employee REST output
   * @return boolean returns a positive boolean if all was successfull. 
   */
  @Override
  public boolean deleteEmployee(EmployeCreationDTO employeCreationDTO) {
    List<Employee> employee = fetchEmployee(employeCreationDTO);

    if (employee.isEmpty())
      throw new IllegalArgumentException(Constants.ERROR_NO_ACTIVE_EMPLOYEES);

    employee.forEach(emp -> employeeRepository.save(emp.deleteChanges(employeCreationDTO)));
    return true;
  }

  /**
   * <p>
   * Fetch all <b>Active</b> employee base on employee Id or first name - last name - middle name combination.
   * </p>
   *
   * @param employeCreationDTO represents employee REST output
   * @return List<Employee> employees 
   */
  private List<Employee> fetchEmployee(EmployeCreationDTO employeCreationDTO) {
    return employeeRepository.findByFirstNameAndLastNameAndMiddleInitialOrId(employeCreationDTO.getFirstName(),
        employeCreationDTO.getLastName(), employeCreationDTO.getMiddleInitial(), employeCreationDTO.getEmployeeId());
  }

}
