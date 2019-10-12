/*
 * ====================================================================================
 *
 * Copyright (c) 2019 Kenzan and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */
package com.kenzan.interview.application.employee.commons;

import com.kenzan.interview.application.employee.web.dto.RestResultDTO;
import com.kenzan.interview.domain.model.Employee;

/**
 * interface that helps to catch any error. 
 *
 * <p>
 * Encapsulate and reduce boiler plate code using default behaviour for every single operation over  {@link Employee}'s <U>List</U>
 * </p>
 *
 * @author Rodrigo Flores
 * @since 2019-10-10
 *
 */
@FunctionalInterface
public interface RestOuputMarshaller<T extends RestResultDTO> {
  /**
   * <p>
   * Main method to implement from outside.
   * </p>
   *
   */
  T change();

  /**
   * <p>
   * perform outside logic and fetch the results.
   * </p>
   *
   * @return RestResultDTO standar way of REST
   */
  default RestResultDTO get() {
    try {
      return change();
    } catch (Exception ex) {
      return RestResultDTO.builder().result(Constants.TRANSFORM_FAIL)
          .message(String.format(Constants.ERROR_FOUND, ex.getMessage())).build();
    }
  }
}


