import java.util.ArrayList;
import java.util.Random;

public class Bag extends ItemContainer {
    private static String name = "Bag (мешок)";
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
        if (maxWeight > this.getWeightItem() + i.getWeightItem()) {
            return super.addItem(i);
        } else {
            throw new ItemStoreException("Больше предметов чем надо!");
        }
    }

    @Override
    public Item removeI() throws Exception {
        if (itemArrayList.isEmpty()) {
            throw new ItemStoreException("Ничего нет!");
        } else {
            Random random = new Random();
            return itemArrayList.remove(random.nextInt(itemArrayList.size()));
        }
    }

    /*public String toString() {
        return this.nameItem + " №" + this.itemNumber + " [Time: " + this.dateFormat.format(this.date) + "]";
    }*/

    String getInfo() {
        return this.getNameItem() + " maxWeight(" + this.maxWeight + ") weight(" + this.getWeightItem() + ") " + this.getProperties();
    }
}

