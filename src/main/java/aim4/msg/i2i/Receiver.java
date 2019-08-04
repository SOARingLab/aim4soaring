package aim4.msg.i2i;

import aim4.config.Constants;
import aim4.config.WaitQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    WaitQueue waitQueue;

    @JmsListener(destination = "NORTH", containerFactory = "northJmsListenerContainerFactory")
    public void receiveNorth(Leave message) {
        logger.info("received message='{}' from NORTH", message);
        waitQueue.get(Constants.Direction.NORTH).add(message);
    }

    @JmsListener(destination = "EAST", containerFactory = "eastJmsListenerContainerFactory")
    public void receiveEast(Leave message) {
        waitQueue.get(Constants.Direction.EAST).add(message);
        logger.info("received message='{}' from EAST", message);
    }

    @JmsListener(destination = "SOUTH", containerFactory = "southJmsListenerContainerFactory")
    public void receiveSouth(Leave message) {
        waitQueue.get(Constants.Direction.SOUTH).add(message);
        logger.info("received message='{}' from SOUTH", message);
    }

    @JmsListener(destination = "WEST", containerFactory = "westJmsListenerContainerFactory")
    public void receiveWest(Leave message) {
        waitQueue.get(Constants.Direction.WEST).add(message);
        logger.info("received message='{}' from WEST", message);
    }
}
