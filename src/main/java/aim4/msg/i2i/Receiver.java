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

    @JmsListener(destination = "SOUTH", containerFactory = "northJmsListenerContainerFactory")
    public void receiveNorth(Leave message) {
        comingMessageQueue.insertMessage(message);
        logger.warn("received NORTH message={}", message);
    }

    @JmsListener(destination = "WEST", containerFactory = "eastJmsListenerContainerFactory")
    public void receiveEast(Leave message) {
        comingMessageQueue.insertMessage(message);
        logger.warn("received EAST message={}", message);
    }

    @JmsListener(destination = "NORTH", containerFactory = "southJmsListenerContainerFactory")
    public void receiveSouth(Leave message) {
        comingMessageQueue.insertMessage(message);
        logger.warn("received SOUTH message={}", message);
    }

    @JmsListener(destination = "EAST", containerFactory = "westJmsListenerContainerFactory")
    public void receiveWest(Leave message) {
        comingMessageQueue.insertMessage(message);
        logger.warn("received WEST message={}", message);
    }
}
