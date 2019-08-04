package aim4.msg.i2i;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "NORTH", containerFactory = "northJmsListenerContainerFactory")
    public void receiveNorth(Leave message) {
        LOGGER.info("received message='{}'", message);
    }

    @JmsListener(destination = "EAST", containerFactory = "eastJmsListenerContainerFactory")
    public void receiveEast(Leave message) {
        LOGGER.info("received message='{}'", message);
    }

    @JmsListener(destination = "SOUTH", containerFactory = "southJmsListenerContainerFactory")
    public void receiveSouth(Leave message) {
        LOGGER.info("received message='{}'", message);
    }

    @JmsListener(destination = "WEST", containerFactory = "westJmsListenerContainerFactory")
    public void receiveWest(Leave message) {
        LOGGER.info("received message='{}'", message);
    }
}
