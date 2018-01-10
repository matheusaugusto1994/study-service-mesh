package com.pfonseca.erp.healthcheck;

import org.apache.log4j.Logger;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

	private Logger logger = Logger.getLogger(MyHealthIndicator.class);
	
	
    @Override
    public Health health() {
    	
    	logger.info("health test");
    	
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().withDetail("Teste", "OK").build();
        
    }

	private int check() {
		return 0;
	}

}
