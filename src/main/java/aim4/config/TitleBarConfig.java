package aim4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class TitleBarConfig {
    @Autowired
    Environment environment;

    @Bean
    String titleBarString() {
        return environment.getProperty("spring.profiles.active", "node-center");
    }
}
