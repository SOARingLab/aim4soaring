package aim4.msg.i2i;

import aim4.config.ComingMessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    ComingMessageQueue comingMessageQueue;

    @Autowired
    boolean hasNorthNeighbour;
    @Autowired
    boolean hasSouthNeighbour;
    @Autowired
    boolean hasWestNeighbour;
    @Autowired
    boolean hasEastNeighbour;

    @JmsListener(destination = "SOUTH", containerFactory = "northJmsListenerContainerFactory")
    public void receiveNorth(Leave message) {
        if (hasNorthNeighbour) {
            comingMessageQueue.insertMessage(message);
            logger.warn("received message from NORTH ={}", message);
        }
    }

    @JmsListener(destination = "WEST", containerFactory = "eastJmsListenerContainerFactory")
    public void receiveEast(Leave message) {
        if (hasEastNeighbour) {
            comingMessageQueue.insertMessage(message);
            logger.warn("received message from EAST ={}", message);
        }
    }

    @JmsListener(destination = "NORTH", containerFactory = "southJmsListenerContainerFactory")
    public void receiveSouth(Leave message) {
        if (hasSouthNeighbour) {
            comingMessageQueue.insertMessage(message);
            logger.warn("received message from SOUTH ={}", message);
        }
    }

    @JmsListener(destination = "EAST", containerFactory = "westJmsListenerContainerFactory")
    public void receiveWest(Leave message) {
        if (hasWestNeighbour) {
            comingMessageQueue.insertMessage(message);
            logger.warn("received message from WEST ={}", message);
        }
    }
}
