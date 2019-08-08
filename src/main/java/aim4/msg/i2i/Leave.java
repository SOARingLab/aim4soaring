package aim4.msg.i2i;

import aim4.config.Constants;
import aim4.vehicle.VehicleSpec;

public class Leave extends I2IMessage {

    public Leave() {
    }

    private VehicleSpec vehicleSpec;
    private Double estimateArriveTime;
    private Constants.Direction directionFrom;

    public Leave(int imId, int vin) {
        super(imId, vin);
        messageType = Type.LEAVE;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "vehicleSpec=" + vehicleSpec.getName() +
                ", estimateArriveTime=" + estimateArriveTime +
                ", directionFrom=" + directionFrom +
                "} " + super.toString();
    }

    public Constants.Direction getDirectionFrom() {
        return directionFrom;
    }

    public void setDirectionFrom(Constants.Direction directionFrom) {
        this.directionFrom = directionFrom;
    }

    public Double getEstimateArriveTime() {
        return estimateArriveTime;
    }

    public void setEstimateArriveTime(Double estimateArriveTime) {
        this.estimateArriveTime = estimateArriveTime;
    }

    public VehicleSpec getVehicleSpec() {
        return vehicleSpec;
    }

    public void setVehicleSpec(VehicleSpec vehicleSpec) {
        this.vehicleSpec = vehicleSpec;
    }

}
