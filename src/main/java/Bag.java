import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag extends ItemContainer {
    private static String name = "Bag";
    private double maxWeight;
    private List<Item> itemArrayList = new ArrayList<Item>();

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
    public boolean addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (maxWeight > this.getAllWeightItem() + i.getWeightItem()) {
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

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.maxWeight
                + " | TotalWeight: " + this.getAllWeightItem()
                + " | Inside: " + itemArrayList;
    }
}

