import io.qameta.allure.Step;

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

    public void setItemContainer(Collection<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }

    // Добавление предмета
    @Step("Добавление предмета")
    public boolean addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (!i.isItemAdded()) {
            i.setItemAdded(true);
            return itemContainer.add(i);
        } else {
            throw new ItemAlreadyPlacedException("Предмет уже есть в одном из контейнеров, выбери другой!");
        }
    }

    // Удаление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item removeI() throws Exception;

    //Получаем общий вес контейнера
    public double getAllWeightItem() {
        double allWeight = 0;
        allWeight += super.getWeightItem();
        Iterator<Item> i = itemContainer.iterator();
        while (i.hasNext()) {
            Item item = i.next();
            allWeight += item.getWeightItem();
        }
        return allWeight;
    }

    @Override
    public Iterator<Item> iterator() {
        return itemContainer.iterator();
    }
}

