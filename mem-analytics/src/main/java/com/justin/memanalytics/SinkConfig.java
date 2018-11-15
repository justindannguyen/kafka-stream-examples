/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memanalytics;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.justin.memanalytics.dto.MemAggregationDto;
import com.justin.memanalytics.entity.Alert;
import com.justin.memanalytics.repository.AlertRepository;

/**
 * @author tuan3.nguyen@gmail.com
 */
@EnableBinding(Sink.class)
public class SinkConfig {

  @Autowired
  private AlertRepository alertRepository;

  @StreamListener(Sink.INPUT)
  public void process(final MemAggregationDto input) {
    final Float avgMemUsage = input.getAvgMemUsage();
    if (avgMemUsage < 80) {
      return;
    }

    final Alert alert = new Alert();
    alert.setDate(new Date());
    alert.setValue(avgMemUsage);
    alert.setType(avgMemUsage >= 90 ? "CRITICAL" : "WARNING");

    alertRepository.save(alert);
  }
}
