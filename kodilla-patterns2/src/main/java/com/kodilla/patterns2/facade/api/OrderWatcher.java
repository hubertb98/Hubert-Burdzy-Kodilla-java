package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) throws Throwable {
        LOGGER.info("Class: " + object.getClass().getName() + ", method: " +
                object.getClass().getMethod("processOrder", OrderDto.class, Long.class) +
                ", args #1 - orderDto: " + order.toString() + " #2 - userId:" + userId);
    }
}
