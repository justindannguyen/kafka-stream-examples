/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.memaggregator.dto.InputDto;

/**
 * @author tuan3.nguyen@gmail.com
 */
public class MemKeyValueMap implements KeyValueMapper<String, String, KeyValue<String, String>> {
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");

  public MemKeyValueMap() {
    objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Override
  public KeyValue<String, String> apply(final String key, final String value) {
    try {
      final InputDto inputDto = objectMapper.readValue(value, InputDto.class);
      final Long date = inputDto.getDate();
      final Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(date);
      calendar.set(Calendar.MILLISECOND, 0);
      calendar.set(Calendar.SECOND, 0);
      inputDto.setDate(calendar.getTimeInMillis());
      return KeyValue.<String, String>pair(df.format(calendar.getTime()),
          objectMapper.writeValueAsString(inputDto));
    } catch (final IOException ex) {
      throw new RuntimeException("Can't map the new keyvalue", ex);
    }
  }

}
