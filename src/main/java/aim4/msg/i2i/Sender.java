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

    @Autowired
    boolean hasNorthNeighbour;
    @Autowired
    boolean hasSouthNeighbour;
    @Autowired
    boolean hasWestNeighbour;
    @Autowired
    boolean hasEastNeighbour;

    public void send(Constants.Direction direction, Leave message) {
        LOGGER.info("sending message='{}' to destination='{}'", message, direction);
        if ((hasEastNeighbour && direction == Constants.Direction.EAST)
                || (hasWestNeighbour && direction == Constants.Direction.WEST)
                || (hasNorthNeighbour && direction == Constants.Direction.NORTH)
                || (hasSouthNeighbour && direction == Constants.Direction.SOUTH)) {
            jmsTemplate.convertAndSend(direction.toString(), message);
        }
    }
}
