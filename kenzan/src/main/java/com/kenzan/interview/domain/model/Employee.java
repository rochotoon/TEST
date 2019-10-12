/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.domain.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import org.apache.commons.lang3.Validate;
import com.kenzan.interview.application.employee.web.dto.EmployeCreationDTO;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Entity representation of {@link Employee}.
 *
 * <p>
 * Definition of {@link Employee} database object
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@Slf4j
@Entity
@Table(name = "employees", indexes = {@Index(name = "EMPLOYEE_ID_U1", columnList = "EMPLOYEE_ID", unique = true),
    @Index(name = "EMPLOYEE_NAME_U2", columnList = "FIRST_NAME, MIDDLE_INITIAL, LAST_NAME", unique = true)})
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@ApiModel(description = "Entity for EMployees database table representation")
@Cacheable(false)
@EqualsAndHashCode
public final class Employee {

  private static final String VALIDATE_NOT_BLANK = " can not be Blank.";
  private static final String VALIDATE_DOB = " can not be equal or greater than todays date.";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EMPLOYEE_ID", nullable = false, insertable = true, unique = true)
  private Long id; // - Unique identifier for an employee

  @Column(name = "FIRST_NAME", length = 50)
  private String firstName; // - Employees first name

  @Column(name = "MIDDLE_INITIAL", length = 50)
  private String middleInitial; // - Employees middle initial

  @Column(name = "LAST_NAME", length = 50)
  private String lastName; // - Employeed last name

  @Column(name = "DATE_OF_BIRTH")
  private LocalDate DateOfBirth; // - Employee birthday and year

  @Column(name = "DATE_OF_EMPLOYMENT")
  private Instant DateOfEmployment; // - Employee start date

  @Column(name = "STATUS", length = 10)
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private StatusType status = StatusType.ACTIVE; // - ACTIVE or INACTIVE

  /**
   * <p>
   * validate employee payload and persiste the data into database.
   * </p>
   *
   * @param employeePayload payload
   * @return Employee instance
   */
  public Employee persistChanges(EmployeCreationDTO employeePayload) {

    this.firstName = Validate.notBlank(employeePayload.getFirstName(), VALIDATE_NOT_BLANK);
    this.lastName = Validate.notBlank(employeePayload.getLastName(), VALIDATE_NOT_BLANK);

    Validate.isTrue(
        !Objects.isNull(employeePayload.getDateOfBirth()) && LocalDate.now().isAfter(employeePayload.getDateOfBirth()),
        VALIDATE_DOB);
    this.DateOfBirth = employeePayload.getDateOfBirth();

    this.DateOfEmployment = employeePayload.getDateOfEmployment();
    this.middleInitial = employeePayload.getMiddleInitial();
    this.status = employeePayload.getStatus();
    return this;
  }

  /**
   * <p>
   * validate employee payload and persist the changes into database.
   * </p>
   *
   * @param employeePayload payload
   * @return Employee instance
   */
  public Employee updateChanges(EmployeCreationDTO employeePayload) {

    this.firstName = Objects.isNull(employeePayload.getFirstName()) ? this.firstName : employeePayload.getFirstName();
    this.lastName = Objects.isNull(employeePayload.getLastName()) ? this.lastName : employeePayload.getLastName();

    this.DateOfBirth =
        !Objects.isNull(employeePayload.getDateOfBirth()) ? employeePayload.getDateOfBirth() : this.DateOfBirth;

    Validate.isTrue(LocalDate.now().isAfter(this.DateOfBirth), VALIDATE_DOB);

    this.DateOfEmployment = Objects.isNull(employeePayload.getDateOfEmployment()) ? this.DateOfEmployment
        : employeePayload.getDateOfEmployment();
    this.middleInitial =
        Objects.isNull(employeePayload.getMiddleInitial()) ? this.middleInitial : employeePayload.getMiddleInitial();
    this.status = Objects.isNull(employeePayload.getStatus()) ? this.status : employeePayload.getStatus();
    return this;
  }

  /**
   * <p>
   * validate employee payload and persiste the data into database.
   * </p>
   *
   * @param employeePayload payload
   * @return Employee instance
   */
  public Employee deleteChanges(EmployeCreationDTO employeePayload) {

    this.status = StatusType.INACTIVE;
    return this;
  }

}
