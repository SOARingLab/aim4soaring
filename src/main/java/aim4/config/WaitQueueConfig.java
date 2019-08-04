package aim4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
public class WaitQueueConfig {
    private static Logger logger = LoggerFactory.getLogger(WaitQueueConfig.class);

    @Autowired
    Environment environment;

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

    @Bean("waitQueue")
    WaitQueue waitQueue() {
        WaitQueue waitQueue = new WaitQueue();
        waitQueue.put(Constants.Direction.NORTH, new ArrayList<>());
        waitQueue.put(Constants.Direction.EAST, new ArrayList<>());
        waitQueue.put(Constants.Direction.SOUTH, new ArrayList<>());
        waitQueue.put(Constants.Direction.WEST, new ArrayList<>());
        logger.info("waitQueue: {}", waitQueue);
        return waitQueue;
    }
}
