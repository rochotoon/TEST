/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.service;

import java.util.List;
import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import com.kenzan.interview.domain.model.Employee;

/**
 * Implements the interface: IEmployeeService
 *
 * <p>
 * Class that performes business actions over {@link Employee} model.
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
public interface IEmployeeService {

  /**
   * <p>
   * Fetch all <b>Active</b> {@link Employee}
   * </p>
   *
   * @return List<Employee> employee list
   */
    List<Employee> getAllEMployeesNoFilter();

    /**
     * <p>
     * Fetch <b>Active</b> employee base on employee Id.
     * </p>
     *
     * @param id employee id
     * @return List<Employee> employees 
     */
    List<Employee> getEmployeeById(Long id);

    /**
     * <p>
     * Generates a new record of {@link Employee} 
     * </p>
     *
     * @param employeCreationDTO represents employee REST output
     * @return List<Employee> employees 
     */
    List<Employee> createEmployee(EmployeCreationDTO employeCreationDTO);

    /**
     * <p>
     * Modifies an existing record of {@link Employee} 
     * </p>
     *
     * @param employeCreationDTO represents employee REST output
     * @return List<Employee> employees 
     */
    List<Employee> updateEmployee(EmployeCreationDTO employeCreationDTO);

    /**
     * <p>
     * Deletes(Inactivate) an existing record of {@link Employee} 
     * </p>
     *
     * @param employeCreationDTO represents employee REST output
     * @return boolean returns a positive boolean if all was successfull. 
     */
    boolean deleteEmployee(EmployeCreationDTO employeCreationDTO);
}