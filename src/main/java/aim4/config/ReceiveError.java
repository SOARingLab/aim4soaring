package aim4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class ReceiveError implements ErrorHandler {
    private static Logger logger = LoggerFactory.getLogger(ReceiveError.class);

    @Override
    public void handleError(Throwable t) {
        logger.error("Error in listener", t);
    }
}
