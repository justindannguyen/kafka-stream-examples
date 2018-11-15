/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memanalytics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.justin.memanalytics.entity.Alert;

/**
 * @author tuan3.nguyen@gmail.com
 */
@Repository
public interface AlertRepository extends MongoRepository<Alert, String> {

}
