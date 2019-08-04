package aim4.msg.i2i;

public class Leave extends I2IMessage {

    public Leave() {
    }

    public Leave(int imId, int vin) {
        super(imId, vin);
        messageType = Type.LEAVE;
    }

    @Override
    public String toString() {
        return "Leave{} " + super.toString();
    }
}
