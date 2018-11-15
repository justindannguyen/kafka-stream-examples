/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator;

import java.io.IOException;

import org.apache.kafka.streams.kstream.Aggregator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.memaggregator.dto.InputDto;
import com.justin.memaggregator.dto.MemAggregationDto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class MemAggregator implements Aggregator<String, String, MemAggregationDto> {

  ObjectMapper objectMapper = new ObjectMapper();

  public MemAggregator() {
    objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Override
  public MemAggregationDto apply(final String key, final String value,
      final MemAggregationDto aggregate) {
    InputDto inputDto;
    try {
      inputDto = objectMapper.readValue(value, InputDto.class);
      final Float inputUsage = inputDto.getUsage();
      if (aggregate.getDate() == null) {
        aggregate.setDate(inputDto.getDate());
        aggregate.setMinMemUsage(inputUsage);
        aggregate.setMaxMemUsage(inputUsage);
      }
      if (aggregate.getMaxMemUsage() < inputUsage) {
        aggregate.setMaxMemUsage(inputUsage);
      }
      if (aggregate.getMinMemUsage() > inputUsage) {
        aggregate.setMinMemUsage(inputUsage);
      }
      aggregate.setTotalCount(aggregate.getTotalCount() + 1);
      aggregate.setTotalMemUsage(aggregate.getTotalMemUsage() + inputUsage);
      aggregate.setAvgMemUsage(aggregate.getTotalMemUsage() / aggregate.getTotalCount());
      return aggregate;
    } catch (final IOException ex) {
      throw new RuntimeException("Can't parse the input Dto", ex);
    }
  }
}
