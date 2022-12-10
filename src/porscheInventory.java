import java.text.DecimalFormat;

public class porscheInventory implements Comparable<porscheInventory> {

    DecimalFormat formatter1 = new DecimalFormat("##,###,###.###");


    private final String vehicleName;
    private final int vehiclePrice;
    private final int vehicleInventory;


    public porscheInventory(String item, int price, int inventory) {
        super();
        this.vehicleName = item;
        this.vehiclePrice = price;
        this.vehicleInventory = inventory;
    }


    @Override
    public String toString() {
        return "(NAME: " + vehicleName + ", PRICE: $" + formatter1.format(vehiclePrice) + ", UNITS: " + vehicleInventory + ") | ";
    }

    @Override
    public int compareTo(porscheInventory inv) {
        if (this.vehicleInventory > inv.vehicleInventory) {
            return 1;
        } else if (this.vehicleInventory < inv.vehicleInventory) {
            return -1;
        } else {
            return 0;
        }
    }
}
