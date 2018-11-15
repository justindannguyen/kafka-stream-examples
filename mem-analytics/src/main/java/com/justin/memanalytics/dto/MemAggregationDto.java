/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memanalytics.dto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class MemAggregationDto {
  private Long date;
  private Float minMemUsage;
  private Float maxMemUsage;
  private Float avgMemUsage;
  private Float totalMemUsage;
  private Integer totalCount;

  public Float getAvgMemUsage() {
    return avgMemUsage;
  }

  public Long getDate() {
    return date;
  }

  public Float getMaxMemUsage() {
    return maxMemUsage;
  }

  public Float getMinMemUsage() {
    return minMemUsage;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public Float getTotalMemUsage() {
    return totalMemUsage;
  }

  public void setAvgMemUsage(final Float avgMemUsage) {
    this.avgMemUsage = avgMemUsage;
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

  public void setTotalCount(final Integer totalCount) {
    this.totalCount = totalCount;
  }

  public void setTotalMemUsage(final Float totalMemUsage) {
    this.totalMemUsage = totalMemUsage;
  }
}
