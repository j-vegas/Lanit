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

    public ItemContainer(String nameItem, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
    }

    public void setItemContainer(Collection<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }

    public Collection<Item> getItemContainer() {
        return itemContainer;
    }

    public Iterator<Item> iterator() {
        return itemContainer.iterator();
    }

    // Добавление предмета, переопределяется в классах Bag, Box, Stack
    public abstract void addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

    // Получение предмета, переопределяется в классах Bag, Box, Stack
    public abstract void getItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

    // Удаление предмета, переопределяется в классах Bag, Box, Stack
    public abstract void removeItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

    //Поиск предмета, переопределяется в классах Bag, Box, Stack
    public abstract void findItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

}

