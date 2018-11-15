/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memanalytics.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tuan3.nguyen@gmail.com
 */
@Document(value = "alerts")
public class Alert {
  @Id
  private String id;

  private String type;
  private Date date;
  private Float value;

  public Date getDate() {
    return date;
  }

  public String getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public Float getValue() {
    return value;
  }

  public void setDate(final Date date) {
    this.date = date;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public void setValue(final Float value) {
    this.value = value;
  }
}
