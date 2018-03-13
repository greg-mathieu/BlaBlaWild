package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleCar extends VehicleAbstract {

    int kilometers;


    public VehicleCar(String brand, String model, int kilometers) {
        this.setBrand(brand);
        this.setModel(model);
        this.kilometers = kilometers;
    }


    @Override
    public String getDescription() {
        return getBrand() + ", " + getModel() + ", " + kilometers;
    }
}
