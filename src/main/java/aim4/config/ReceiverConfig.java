package aim4.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.QueueConnectionFactory;

@Configuration
public class ReceiverConfig {
    private static Logger logger = LoggerFactory.getLogger(ReceiverConfig.class);

    @Autowired
    private Environment environment;

    @Bean("northConnectionFactory")
    public QueueConnectionFactory northConnectionFactory() {
        QueueConnectionFactory connectionFactory = null;
        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.NORTH + ".url", "");
        if ("".equals(URL)) {
            return connectionFactory;
        }
        connectionFactory = new ActiveMQConnectionFactory(URL);
        ((ActiveMQConnectionFactory) connectionFactory).setTrustAllPackages(true);
        return connectionFactory;
    }

    @Bean("northJmsTemplate")
    public JmsTemplate northJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(northConnectionFactory());
        jmsTemplate.setDefaultDestinationName(Constants.CardinalDirection.NORTH.toString());
        return jmsTemplate;
    }

    @Bean("northJmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> northJmsListenerContainerFactory(@Qualifier("northConnectionFactory") QueueConnectionFactory connectionFactory, ReceiveError error) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(error);
        return factory;
    }

//    @Bean("eastConnectionFactory")
//    public QueueConnectionFactory eastConnectionFactory() {
//        QueueConnectionFactory connectionFactory = null;
//        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.EAST + ".url", "");
//        if ("".equals(URL)) {
//            return connectionFactory;
//        }
//        connectionFactory = new ActiveMQConnectionFactory(URL);
//        return connectionFactory;
//    }
//
//    @Bean("eastJmsTemplate")
//    public JmsTemplate eastJmsTemplate(@Qualifier("eastJmsTemplate") QueueConnectionFactory factory) {
//        return new JmsTemplate(factory);
//    }
//
//    @Bean("southConnectionFactory")
//    public QueueConnectionFactory southConnectionFactory() {
//        QueueConnectionFactory connectionFactory = null;
//        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.SOUTH + ".url", "");
//        if ("".equals(URL)) {
//            return connectionFactory;
//        }
//        connectionFactory = new ActiveMQConnectionFactory(URL);
//        return connectionFactory;
//    }
//
//    @Bean("southJmsTemplate")
//    public JmsTemplate southJmsTemplate(@Qualifier("southJmsTemplate") QueueConnectionFactory factory) {
//        return new JmsTemplate(factory);
//    }
//
//    @Bean("westConnectionFactory")
//    public QueueConnectionFactory westConnectionFactory() {
//        QueueConnectionFactory connectionFactory = null;
//        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.WEST + ".url", "");
//        if ("".equals(URL)) {
//            return connectionFactory;
//        }
//        connectionFactory = new ActiveMQConnectionFactory(URL);
//        return connectionFactory;
//    }
//
//    @Bean("westJmsTemplate")
//    public JmsTemplate westJmsTemplate(@Qualifier("westJmsTemplate") QueueConnectionFactory factory) {
//        return new JmsTemplate(factory);
//    }
}
