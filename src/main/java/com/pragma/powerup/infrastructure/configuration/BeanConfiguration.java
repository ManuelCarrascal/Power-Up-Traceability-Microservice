package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IOrderTraceabilityServicePort;
import com.pragma.powerup.domain.spi.IOrderTraceabilityPersistencePort;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.domain.usecase.OrderTraceabilityUseCase;
import com.pragma.powerup.infrastructure.out.feign.IUserFeignClient;
import com.pragma.powerup.infrastructure.out.jpa.adapter.OrderTraceabilityJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IOrderEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IOrderTraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IOrderTraceabilityRepository orderTraceabilityRepository;
    private final IOrderEntityMapper orderEntityMapper;
    private final IUserFeignClient userFeignClient;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userFeignClient);
    }

    @Bean
    public IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort() {
        return new OrderTraceabilityJpaAdapter(orderEntityMapper, orderTraceabilityRepository);
    }

    @Bean
    public IOrderTraceabilityServicePort orderTraceabilityServicePort() {
        return new OrderTraceabilityUseCase(orderTraceabilityPersistencePort(), userPersistencePort());
    }
}