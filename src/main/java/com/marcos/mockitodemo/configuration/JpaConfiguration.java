package com.marcos.mockitodemo.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.marcos.mockitodemo.repository"})
@EntityScan(basePackages = {"com.marcos.mockitodemo.entity"})
public class JpaConfiguration {
}
