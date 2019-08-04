package aim4.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.QueueConnectionFactory;

@Configuration
public class SenderConfig {
    private static Logger logger = LoggerFactory.getLogger(SenderConfig.class);

    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public QueueConnectionFactory connectionFactory() {
        String URL = environment.getProperty("mq.send.url", "");
        logger.info("senderConnectionFactory: {}", URL);
        return new ActiveMQConnectionFactory(URL);
    }

    @Bean
    @Primary
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }
}
