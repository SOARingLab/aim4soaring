package aim4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ComingMessageQueueConfig {
    private static Logger logger = LoggerFactory.getLogger(ComingMessageQueueConfig.class);

    @Autowired
    Environment environment;

    @Bean
    public double northDistance() {
        return Integer.parseInt(environment.getProperty("mq.receive.NORTH.distance", "1000"));
    }

    @Bean
    public double southDistance() {
        return Integer.parseInt(environment.getProperty("mq.receive.SOUTH.distance", "1000"));
    }

    @Bean
    public double westDistance() {
        return Integer.parseInt(environment.getProperty("mq.receive.WEST.distance", "1000"));
    }

    @Bean
    public double eastDistance() {
        return Integer.parseInt(environment.getProperty("mq.receive.EAST.distance", "1000"));
    }

    @Bean
    public boolean hasNorthNeighbour() {
        return !"".equals(environment.getProperty("mq.receive.NORTH.url", ""));
    }

    @Bean
    public boolean hasEastNeighbour() {
        return !"".equals(environment.getProperty("mq.receive.EAST.url", ""));
    }

    @Bean
    public boolean hasSouthNeighbour() {
        return !"".equals(environment.getProperty("mq.receive.SOUTH.url", ""));
    }

    @Bean
    public boolean hasWestNeighbour() {
        return !"".equals(environment.getProperty("mq.receive.WEST.url", ""));
    }

    @Bean("leaveMessageQueue")
    ComingMessageQueue leaveMessageQueue() {
        return new ComingMessageQueue();
    }
}
