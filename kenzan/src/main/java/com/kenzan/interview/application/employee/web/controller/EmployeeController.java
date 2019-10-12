/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.kenzan.interview.application.employee.adapter.IEmployeeAdapter;
import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



/**
 * class that handle REST calls.
 *
 * <p>
 * Handle {@link POST,GET,PUT & DELETE} verbs from HTTP request. 
 * </p>
 * NOTE: For DELETE only under <u>header basic authorization</u> 
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@RestController
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    IEmployeeAdapter employeeAdapter;

    /**
     * <p>
     * Main constructor of EmployeeController
     * </p>
     *
     * @param employeeAdapter needed to retrieve expected results.
     */
    @Autowired
    public EmployeeController(IEmployeeAdapter employeeAdapter) {
        this.employeeAdapter = employeeAdapter;
    }

    /**
     * <p>
     * Fetch all ACTIVE Employees
     * </p>
     *
     * @return ResponseEntity<?> REST result for employee
     */
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all existing ACTIVE employees")
    public ResponseEntity<?> getEmployeesList() {
        return ResponseEntity.ok().body(employeeAdapter.generateResponseForAllActiveEmployees());
    }

    /**
     * <p>
     * Fetch a specific employee base on ID .
     * </p>
     *
     * @param id represents employee id
     * @return ResponseEntity<?> REST result for employee
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get an existing employee base on ID")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(employeeAdapter.generateResponseByEmployeeId(id));
    }

    /**
     * <p>
     * Generate a new record of Employee.
     * </p>
     *
     * @param newEmployee  employee payload
     * @return ResponseEntity<?> REST result for employee
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new employee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeCreationDTO newEmployee) {
        log.info(newEmployee.toString());
        return ResponseEntity.status(201).body(employeeAdapter.generateRespForEmployeeCreation(newEmployee));
    }

    /**
     * <p>
     * Update a existing employee
     * </p>
     *
     * @param newEmployee  employee payload
     * @return ResponseEntity<?> REST result for employee
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a existing employee")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeCreationDTO newEmployee) {
        log.info(newEmployee.toString());
        return ResponseEntity.status(201).body(employeeAdapter.generateRespForEmployeeUpdate(newEmployee));
    }

    /**
     * <p>
     * Deleting a existing employee
     * </p>
     *
     * @param newEmployee  employee payload
     * @return ResponseEntity<?> REST result for employee
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleting a existing employee")
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeCreationDTO newEmployee) {
        log.info(newEmployee.toString());
        return ResponseEntity.status(201).body(employeeAdapter.generateRespForEmployeeDelete(newEmployee));
    }

}
