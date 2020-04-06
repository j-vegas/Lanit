import java.util.Collection;
import java.util.Iterator;


public abstract class ItemContainer extends Item implements Iterable<Item> {

    private Collection<Item> itemContainer;

    public ItemContainer(String nameItem) {
        super(nameItem);
    }

    public ItemContainer(String nameItem, double weightItem) {
        super(nameItem, weightItem);
    }

    public ItemContainer(String nameItem, String... properties) {
        super(nameItem, properties);
    }

    public ItemContainer(String nameItem, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
    }

    // Добавление предмета
    public boolean addItem(Item i) throws Exception {
        if (i.isItemAdded()) {
            throw new ItemAlreadyPlacedException("Предмет уже есть в одном из контейнеров, выбери другой!");
        } else {
            i.setItemAdded(true);
            return itemContainer.add(i);
        }
    }

    // Удаление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item removeI() throws Exception;

    public Iterator<Item> iterator() {
        return itemContainer.iterator();
    }

    public void getItems() {
        if (itemContainer.isEmpty()) {
            itemContainer.clear();
        }
        System.out.println(itemContainer);
    }

    //Получаем размер контейнера
    public int getSize() {
        System.out.println("Колличество предметов: " + itemContainer.size());
        return 0;
    }

    //Получаем общий вес контейнера
    public double getAllWeightItems() {
        double allWeight = 0;
        //allWeight = allWeight + getWeightItem();
        allWeight += super.getWeightItem();

        Iterator<Item> i = itemContainer.iterator();
        while (i.hasNext()) {
            Item item = i.next();
            allWeight += item.getWeightItem();
        }
        //System.out.println(itemContainer);
        System.out.println("Общий вес: " + getNameItem() + " " + allWeight);
        return allWeight;
    }

    public void setItemContainer(Collection<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }
}
