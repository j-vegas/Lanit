
public class Box extends Bag {

    public Box(String nameItem, double maxWeight, double weightItem, String... properties) {
        super(nameItem, maxWeight, weightItem, "плоский");
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.getMaxWeight()
                + " | TotalWeight: " + this.getAllWeight()
                + " | Properties: " + this.getProperties()
                + " | Inside: " + this.getItemArrayList();
    }
}