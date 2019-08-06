package aim4.msg.i2i;

import java.util.HashMap;
import java.util.Map;

public class Leave extends I2IMessage {

    public Leave() {
    }

    public Map<String, Object> properties;

    public Leave(int imId, int vin) {
        super(imId, vin);
        messageType = Type.LEAVE;
        properties = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Leave{} " + super.toString();
    }
}
