package aim4.msg.i2i;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class LeaveMessageConverter implements MessageConverter {

    private static final Logger logger = LoggerFactory.getLogger(LeaveMessageConverter.class);

    private ObjectMapper mapper;

    public LeaveMessageConverter() {
        mapper = new ObjectMapper();
    }

    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        Leave leave = (Leave) o;
        String payload = "";

        try {
            payload = mapper.writeValueAsString(leave);

        } catch (JsonProcessingException e) {
            logger.error("error converting from leave: ", e);
        }

        TextMessage message = session.createTextMessage();
        message.setText(payload);

        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();

        Leave leave = null;
        try {
            leave = mapper.readValue(payload, Leave.class);
        } catch (Exception e) {
            logger.error("error converting to leave", e);
        }

        logger.info("inbound json: {}", payload);
        logger.info("leave message: {}", leave);
        return leave;
    }
}
