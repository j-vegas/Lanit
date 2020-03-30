import java.util.ArrayList;

public abstract class Bag extends ItemContainer {
    private static String name = "Мешок";
    private double maxWeight;
    private ArrayList<Item> itemArrayList = new ArrayList<Item>();

    public Bag(double maxWeight) {
        super(name);
        this.maxWeight = maxWeight;
        this.setItemContainer(itemArrayList);
    }

    public Bag(double maxWeight, double weightItem) {
        super(name, weightItem);
        this.maxWeight = maxWeight;
        this.setItemContainer(itemArrayList);
    }


    @Override
    public boolean addItem(Item i) throws Exception {
        return super.addItem(i);
    }

    /*public String toString() {
        return this.nameItem + " №" + this.itemNumber + " [Time: " + this.dateFormat.format(this.date) + "]";
    }*/

    String getInfo() {
        return this.getNameItem() + " maxWeight(" + this.maxWeight + ") weight(" + this.getWeightItem() + ") " + this.getProperties();
    }

}

