import java.util.Random;

public class Bag extends ItemContainer {

    private double maxWeight;
    private double allWeight;

    public Bag(String nameItem, double maxWeight, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
        this.maxWeight = maxWeight;
        this.setItemArrayList(getItemArrayList());
    }

    @Override
    public Item addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (!this.equals(i)) {
            if (!i.isItemAdded()) {
                if (maxWeight > this.getAllWeight() + i.getWeightItem()) {
                    getItemArrayList().add(i);
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
    public Item getItem() throws ItemStoreException {
        if (!getItemArrayList().isEmpty()) {

            Random random = new Random();
            setItemAdded(false);
            return getItemArrayList().remove(random.nextInt(getItemArrayList().size()));

        } else {
            throw new ItemStoreException("Такого предмета тут нет!");
        }

    }

    //Получение предмета по имени
    public Item getItemByName(String nameItem) throws ItemStoreException {
        Integer index = searchItemByName(nameItem);
        if (index == null) throw new ItemStoreException("Такого предмета тут нет!");
        return getItemByIndex(index);
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    //Получение общего веса
    public double getAllWeight() {
        double allWeight = super.getWeightItem();
        for (Item i : getItemArrayList()) {
            allWeight += i.getWeightItem();
        }
        return allWeight;
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxWeight: " + this.maxWeight
                + " | TotalWeight: " + this.getAllWeight()
                + " | Inside: " + getItemArrayList();
    }
}

