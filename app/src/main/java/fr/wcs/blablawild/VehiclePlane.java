package fr.wcs.blablawild;

/**
 * Created by wilder on 13/03/18.
 */

public class VehiclePlane extends VehicleAbstract {

    int speed;


    public VehiclePlane(String brand, String model, int speed) {
        this.setBrand(brand);
        this.setModel(model);
        this.speed = speed;
    }


    @Override
    public String getDescription() {
        return getBrand() + ", " + getModel() + ", " + speed;
    }
}
