package aim4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class VinConfig {
    @Autowired
    Environment environment;

    @Bean Integer vinStart(){
        return Integer.parseInt(environment.getProperty("sim.vin_start", "1000"));
    }
}
