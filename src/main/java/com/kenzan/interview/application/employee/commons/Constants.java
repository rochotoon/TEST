/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.commons;

/**
 * Static class for constants.
 * <p>
 * Class that store immutable values.
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
public class Constants {

  public static final String KENZAN_MAIN_PATH = "com.kenzan.interview";
  public static final String KENZAN_CONTROLLERS_PATH =
      new StringBuilder().append(KENZAN_MAIN_PATH).append(".application.employee.web.controller").toString();

  public static final String ERROR_NO_ACTIVE_EMPLOYEES = "No active employees were found.";
  public static final String ERROR_FOUND = "An Unexpected error occurs: %s thru the logic.";

  public static final String TRANSFORM_FAIL = "FAIL";
  
  public static final String REST_SUCCESS = "SUCCESS";
  public static final String REST_FAIL = "FAIL";
  public static final String REST_EMPLOYEE_DELETED = "Employee Id %s deleted Successfull.";
  public static final String REST_NO_DATA_FOUND = "NO_DATA_FOUND";
  
  public static final String ERROR_UNABLE_TO_CREATE = "No record was created. Review the logs.";
  public static final String ERROR_UNABLE_TO_DELETE = "No record was deleted. Review the logs.";

  /**
   * <p>
   * Main constructor hidden to avoid new instances. This is just a <u>singleton</u>.
   * </p>
   */
  private Constants() {
    throw new AssertionError();
  }
}
