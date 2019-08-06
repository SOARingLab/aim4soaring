package aim4.msg.i2i;

import aim4.vehicle.VehicleSpec;

public class Leave extends I2IMessage {

    public Leave() {
    }

    private String vehicleSpecName;
    private VehicleSpec vehicleSpec;

    public Leave(int imId, int vin) {
        super(imId, vin);
        messageType = Type.LEAVE;
        vehicleSpecName = "COUPE";
    }

    public VehicleSpec getVehicleSpec() {
        return vehicleSpec;
    }

    public void setVehicleSpec(VehicleSpec vehicleSpec) {
        this.vehicleSpec = vehicleSpec;
    }

    public String getVehicleSpecName() {
        return vehicleSpecName;
    }

    public void setVehicleSpecName(String vehicleSpecName) {
        this.vehicleSpecName = vehicleSpecName;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "vehicleSpecName='" + vehicleSpecName + '\'' +
                ", vehicleSpec=" + vehicleSpec +
                "} " + super.toString();
    }
}
