package aim4.msg.i2i;

import aim4.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Constants.Direction direction, Leave message) {
        LOGGER.info("sending message='{}' to destination='{}'", message, direction);
        jmsTemplate.convertAndSend(direction.toString(), message);
    }
}
