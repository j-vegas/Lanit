import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Bag extends ItemContainer {

    private double maxWeight;
    private double allWeight;
    private List<Item> itemArrayList = new ArrayList<Item>();

    public Bag(String nameItem, double maxWeight, double weightItem) {
        super(nameItem, weightItem);
        this.maxWeight = maxWeight;
        this.setItemContainer(itemArrayList);
    }

    public Bag(String nameItem, double maxWeight, double weightItem, String... properties) {
        super(nameItem, weightItem);
        this.maxWeight = maxWeight;
        this.setItemContainer(itemArrayList);
    }

    @Override
    public void addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
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
    }

    @Override
    public void getItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (itemArrayList.contains(i)) {
            int index = itemArrayList.indexOf(i);
            System.out.println("Предмет " + i + " в " + getNameItem());
        } else {
            throw new ItemStoreException("Такого предмета тут нет!");
        }
    }

    @Override
    public void removeItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (!itemArrayList.isEmpty()) {
            Random random = new Random();
            itemArrayList.remove(random.nextInt(itemArrayList.size()));
        } else {
            throw new ItemStoreException("Тут удалять нечего!");
        }
    }

    @Override
    public void findItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (itemArrayList.contains(i)) {
            int index = itemArrayList.indexOf(i);
            itemArrayList.get(index);
            System.out.println(i + " находится в " + getNameItem());
        } else if (itemArrayList.size() == 0) {
            System.out.println("В " + getNameItem() + " ничего нет!");
        } else if (!itemArrayList.contains(i)) {
            System.out.println("Такого предмета тут нет!");
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public List<Item> getItemArrayList() {
        return itemArrayList;
    }

    //Получение общего веса
    public double getAllWeight() {
       /* allWeight += super.getWeightItem();
        Iterator<Item> i = super.getItemContainer().iterator();
        while (i.hasNext()) {
            Item item = i.next();
            allWeight += item.getWeightItem();
        }*/
        return allWeight + getWeightItem();
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.maxWeight
                + " | TotalWeight: " + this.getAllWeight()
                + " | Inside: " + itemArrayList;
    }
}

