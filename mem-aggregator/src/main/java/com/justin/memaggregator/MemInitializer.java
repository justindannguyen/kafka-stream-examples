/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator;

import org.apache.kafka.streams.kstream.Initializer;

import com.justin.memaggregator.dto.MemAggregationDto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class MemInitializer implements Initializer<MemAggregationDto> {
  @Override
  public MemAggregationDto apply() {
    final MemAggregationDto dto = new MemAggregationDto();
    dto.setTotalCount(0);
    dto.setTotalMemUsage(0f);
    return dto;
  }
}
