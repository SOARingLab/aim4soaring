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
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setTrustAllPackages(true);
        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.NORTH + ".url", "");
        if ("".equals(URL)) {
            return connectionFactory;
        }
        connectionFactory.setBrokerURL(URL);
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
    public JmsListenerContainerFactory<?> northJmsListenerContainerFactory(
            @Qualifier("northConnectionFactory") QueueConnectionFactory connectionFactory, ReceiveError error) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(error);
        return factory;
    }

    @Bean("eastConnectionFactory")
    public QueueConnectionFactory eastConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setTrustAllPackages(true);
        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.EAST + ".url", "");
        if ("".equals(URL)) {
            return connectionFactory;
        }
        connectionFactory.setBrokerURL(URL);
        return connectionFactory;
    }

    @Bean("eastJmsTemplate")
    public JmsTemplate eastJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(eastConnectionFactory());
        jmsTemplate.setDefaultDestinationName(Constants.CardinalDirection.EAST.toString());
        return jmsTemplate;
    }

    @Bean("eastJmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> eastJmsListenerContainerFactory(
            @Qualifier("eastConnectionFactory") QueueConnectionFactory connectionFactory, ReceiveError error) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(error);
        return factory;
    }

    @Bean("southConnectionFactory")
    public QueueConnectionFactory southConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setTrustAllPackages(true);
        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.SOUTH + ".url", "");
        if ("".equals(URL)) {
            return connectionFactory;
        }
        connectionFactory.setBrokerURL(URL);
        return connectionFactory;
    }

    @Bean("southJmsTemplate")
    public JmsTemplate southJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(southConnectionFactory());
        jmsTemplate.setDefaultDestinationName(Constants.CardinalDirection.SOUTH.toString());
        return jmsTemplate;
    }

    @Bean("southJmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> southJmsListenerContainerFactory(
            @Qualifier("southConnectionFactory") QueueConnectionFactory connectionFactory, ReceiveError error) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(error);
        return factory;
    }

    @Bean("westConnectionFactory")
    public QueueConnectionFactory westConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setTrustAllPackages(true);
        String URL = environment.getProperty("mq.receive." + Constants.CardinalDirection.WEST + ".url", "");
        if ("".equals(URL)) {
            return connectionFactory;
        }
        connectionFactory.setBrokerURL(URL);
        return connectionFactory;
    }

    @Bean("westJmsTemplate")
    public JmsTemplate westJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(westConnectionFactory());
        return jmsTemplate;
    }

    @Bean("westJmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> westJmsListenerContainerFactory(
            @Qualifier("westConnectionFactory") QueueConnectionFactory connectionFactory, ReceiveError error) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(error);
        return factory;
    }

}
