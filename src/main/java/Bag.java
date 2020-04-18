import java.util.ArrayList;
import java.util.List;

public class Bag extends ItemContainer {

    private double maxWeight;
    private double allWeight;
    private List<Item> itemArrayList = new ArrayList<Item>();

    public Bag(String nameItem, double maxWeight, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
        this.maxWeight = maxWeight;
        this.setItemArrayList(itemArrayList);
    }

    @Override
    public Item addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (!this.equals(i)) {
            if (!i.isItemAdded()) {
                if (maxWeight > this.getAllWeight() + i.getWeightItem()) {
                    itemArrayList.add(i);
                    i.setItemAdded(true);
                    allWeight += i.getWeightItem();
                } else {
                    throw new ItemStoreException("Превышен максимальный вес в - " + this.getMaxWeight());
                }
            } else {
                throw new ItemAlreadyPlacedException(this.getNameItem() + " уже где то находится!");
            }
        } else {
            throw new ItemAlreadyPlacedException(this.getNameItem() + " - сам в себя не складывается!");
        }
        return i;
    }

    @Override
    public Item getItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (itemArrayList.contains(i)) {
            int index = itemArrayList.indexOf(i);
            itemArrayList.remove(index);
            i.setItemAdded(false);
        } else {
            throw new ItemStoreException("Такого предмета тут нет!");
        }
        return i;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public List<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(List<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    //Получение общего веса
    public double getAllWeight() {
        double allWeight = super.getWeightItem();
        for (Item i : itemArrayList) {
            allWeight += i.getWeightItem();
        }
        return allWeight;
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.maxWeight
                + " | TotalWeight: " + this.getAllWeight()
                + " | Inside: " + itemArrayList;
    }
}

