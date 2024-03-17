package io.eeaters.io.eeaters.unity.delivery.sample.config.property;

import io.eeaters.delivery.core.Account;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "unity.delivery")
@Data
public class DeliveryAccountPropertySource {

    private Map<String, Account> account;



}
