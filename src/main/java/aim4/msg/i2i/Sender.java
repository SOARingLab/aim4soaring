package aim4.msg.i2i;

import aim4.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

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
        if ((hasEastNeighbour && direction == Constants.Direction.EAST)
                || (hasWestNeighbour && direction == Constants.Direction.WEST)
                || (hasNorthNeighbour && direction == Constants.Direction.NORTH)
                || (hasSouthNeighbour && direction == Constants.Direction.SOUTH)) {
            logger.info("sending destination = {}, message={}", direction, message);
            jmsTemplate.convertAndSend(direction.toString(), message);
        }
    }
}
