/**
 * Copyright (C) 2018, Justin Nguyen
 */
package com.justin.memaggregator;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes.StringSerde;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.messaging.handler.annotation.SendTo;

import com.justin.memaggregator.dto.MemAggregationDto;

/**
 * @author tuan3.nguyen@gmail.com
 */
@EnableBinding(KafkaStreamsProcessor.class)
public class StreamConfig {
  private static final Serde<MemAggregationDto> aggregatedSerde =
      new JsonSerde<>(MemAggregationDto.class);
  private static final Serde<String> keySerde = new StringSerde();

  @StreamListener("input")
  @SendTo("output")
  public KStream<String, MemAggregationDto> process(final KStream<String, String> input) {
    return input.map(new MemKeyValueMap()).groupByKey().aggregate(new MemInitializer(),
        new MemAggregator(), Materialized.with(keySerde, aggregatedSerde)).toStream();
  }
}
