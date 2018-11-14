/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator.dto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class InputDto {
  private Long date;
  private Float usage;

  public Long getDate() {
    return date;
  }

  public Float getUsage() {
    return usage;
  }

  public void setDate(final Long date) {
    this.date = date;
  }

  public void setUsage(final Float usage) {
    this.usage = usage;
  }
}
