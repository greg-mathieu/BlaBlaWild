package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleBoat extends VehicleAbstract {

    int hours;


    public VehicleBoat(String brand, String model, int hours) {
        this.setBrand(brand);
        this.setModel(model);
        this.hours = hours;
    }


    @Override
    public String getDescription() {
        return getBrand() + ", " + getModel() + ", " + hours;
    }
}
