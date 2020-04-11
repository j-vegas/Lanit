import java.util.ArrayDeque;
import java.util.Deque;

public class Stack extends ItemContainer {

    private int maxItems;
    private Deque<Item> itemDeque = new ArrayDeque<Item>();

    public Stack(String nameItem, int maxItems) {
        super(nameItem);
        this.maxItems = maxItems;
        this.setItemContainer(itemDeque);
    }

    @Override
    public void addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (itemDeque.size() <= maxItems) {
            if (i.getProperties().contains("плоский")) {
                i.setItemAdded(true);
                itemDeque.add(i);
            } else {
                throw new ItemAlreadyPlacedException("Добавляются только плоские предметы!");
            }
        } else {
            throw new ItemStoreException("Нельзя положить больше " + maxItems + " предметов!");
        }
    }

    @Override
    public void getItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {

    }

    @Override
    public void removeItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (!itemDeque.isEmpty()) {
            i.setItemAdded(false);
            itemDeque.remove(i);
        } else {
            throw new ItemStoreException("Тут пусто!");
        }
    }

    @Override
    public void findItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {

    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxItems: " + this.maxItems
                + " | Items: " + this.itemDeque.size()
                + " | Inside: " + itemDeque;
    }
}