package aim4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class NodeNameConfig {
    private static Logger logger = LoggerFactory.getLogger(NodeNameConfig.class);

    @Autowired
    Environment environment;

    @Bean
    int nodeId() {
        int nodeId = Integer.parseInt(environment.getProperty("node.id", "1000"));
        logger.info("Node id: {}", nodeId);
        return nodeId;
    }

    @Bean
    String nodeName() {
        String nodeName = environment.getProperty("node.name", "node-default");
        logger.info("Node name: {}", nodeName);
        return nodeName;
    }
}
