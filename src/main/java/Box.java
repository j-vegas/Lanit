import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box extends ItemContainer {
    private static String name = "Box";
    private double maxWeight;
    private List<Item> itemArrayList = new ArrayList<Item>();

    public Box(double maxWeight) {
        super(name, maxWeight);
    }

    public Box(double maxWeight, double weightItem) {
        super(name, weightItem, "плоский");
        this.setItemContainer(itemArrayList);
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (maxWeight > this.getWeightItem() + i.getWeightItem()) {

            return super.addItem(i);
        } else {
            throw new ItemStoreException("Вес превышен!");
        }
    }

    @Override
    public Item removeI() throws Exception {
        if (itemArrayList.isEmpty()) {
            throw new ItemStoreException("Пусто");
        } else {
            Random random = new Random();
            int in = random.nextInt(itemArrayList.size());
            Item i = itemArrayList.remove(in);
            i.setItemAdded(true);
            return i;
        }
    }

    @Override
    String getInfo() {
        return this.getNameItem() + ": maxWeight(" + this.maxWeight + ") weight(" + this.getWeightItem() + ") " + "Inside: " + itemArrayList;
    }
}