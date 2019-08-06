package aim4.msg.i2i;

import aim4.config.Constants;

import java.io.Serializable;

public abstract class I2IMessage implements Serializable {
    public enum Type {
        LEAVE
    }
    /**
     * The ID number of the Intersection Manager to which this message is
     * being sent.
     */
    private int imId;
    /**
     * The ID number of the Vehicle sending this message
     */
    private int vin;

    /////////////////////////////////
    // PROTECTED FIELDS
    /////////////////////////////////

    /**
     * The type of this message.
     */
    protected Type messageType;

    /**
     * The size, in bits, of this message.
     */
    protected int size = Constants.ENUM_SIZE + 2 * Constants.INTEGER_SIZE;

    public I2IMessage() {
    }

    public I2IMessage(int imId, int vin) {
        this.vin = vin;
        this.imId = imId;
    }

    @Override
    public String toString() {
        return "I2IMessage{" +
                "imId=" + imId +
                ", vin=" + vin +
                ", messageType=" + messageType +
                ", size=" + size +
                '}';
    }

    public int getImId() {
        return imId;
    }

    public int getVin() {
        return vin;
    }

    public Type getMessageType() {
        return messageType;
    }

    public int getSize() {
        return size;
    }

    public void setImId(int imId) {
        this.imId = imId;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setMessageType(Type messageType) {
        this.messageType = messageType;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
