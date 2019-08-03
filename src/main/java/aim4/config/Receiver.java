package aim4.config;

import aim4.msg.i2i.Leave;
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

//    @JmsListener(destination = "EAST", containerFactory = "eastConnectionFactory")
//    public void receiveEast(Leave message) {
//        LOGGER.info("received message='{}'", message);
//    }
//
//    @JmsListener(destination = "SOUTH", containerFactory = "southConnectionFactory")
//    public void receiveSouth(Leave message) {
//        LOGGER.info("received message='{}'", message);
//    }
//
//    @JmsListener(destination = "WEST", containerFactory = "westConnectionFactory")
//    public void receiveWest(Leave message) {
//        LOGGER.info("received message='{}'", message);
//    }
}
