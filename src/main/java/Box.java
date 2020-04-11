import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box extends Bag {

    public Box(String nameItem, double maxWeight, double weightItem, String... properties) {
        super(nameItem, maxWeight, weightItem);
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.getMaxWeight()
                + " | TotalWeight: " + this.getAllWeight()
                + " | Inside: " + this.getItemArrayList();
    }
}