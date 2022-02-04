package com.weather.api.weatherconnectorservice.config.kafka.consumer;

import com.weather.api.weatherconnectorservice.models.Location;
import com.weather.api.weatherconnectorservice.service.LocationProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@EnableKafka
@Slf4j
public class LocationConnectorConsumerConfig {

    private final String bootstrapAddress;

    private final String groupId;

    @Autowired
    public LocationConnectorConsumerConfig(final LocationProcessorService locationProcessorService,
                                           @Value("${spring.kafka.consumer.bootstrap-servers}") final String bootstrapAddress,
                                           @Value("${spring.kafka.consume.group-id}") final String groupId) {
        this.bootstrapAddress = bootstrapAddress;
        this.groupId = groupId;
    }

    @Bean
    public ConsumerFactory<UUID, Location> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                IntegerDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                LocationDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    //TODO configure the ConcurrentKafkaListenerContainerFactory
    private RetryTemplate retryTemplate() {
        final FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(1000);
        final RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(simpleRetryPolicy());
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        return retryTemplate;
    }

    private RetryPolicy simpleRetryPolicy() {
        final Map<Class<? extends Throwable>, Boolean> exceptionsMap = new HashMap<>();
        exceptionsMap.put(IllegalArgumentException.class, false);
        exceptionsMap.put(RecoverableDataAccessException.class, true);
        return new SimpleRetryPolicy(3, exceptionsMap, true);
    }

}
