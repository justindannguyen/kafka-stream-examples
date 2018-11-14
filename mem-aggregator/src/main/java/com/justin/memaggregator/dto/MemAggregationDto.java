/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator.dto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class MemAggregationDto {
  private Long date;
  private Float minMemUsage;
  private Float maxMemUsage;

  public Long getDate() {
    return date;
  }

  public Float getMaxMemUsage() {
    return maxMemUsage;
  }

  public Float getMinMemUsage() {
    return minMemUsage;
  }

  public void setDate(final Long date) {
    this.date = date;
  }

  public void setMaxMemUsage(final Float maxMemUsage) {
    this.maxMemUsage = maxMemUsage;
  }

  public void setMinMemUsage(final Float minMemUsage) {
    this.minMemUsage = minMemUsage;
  }
}
