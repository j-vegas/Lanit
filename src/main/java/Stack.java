import java.util.ArrayDeque;
import java.util.Deque;

public class Stack extends ItemContainer {

    private int maxItems;

    public void setItemDeque(Deque<Item> itemDeque) {
        this.itemDeque = itemDeque;
    }

    private Deque<Item> itemDeque = new ArrayDeque<Item>();

    public Stack(String nameItem, int maxItems) {
        super(nameItem);
        this.maxItems = maxItems;
        this.setItemDeque(itemDeque);
    }

    @Override
    public Item addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (!i.isItemAdded()) {
            if (itemDeque.size() < maxItems) {
                if (i.getProperties().contains("плоский")) {
                    i.setItemAdded(true);
                    itemDeque.addLast(i);
                } else {
                    throw new ItemAlreadyPlacedException("Добавляются только плоские предметы!");
                }
            } else {
                throw new ItemStoreException("Нельзя положить больше " + maxItems + " предметов!");
            }
        } else {
            throw new ItemAlreadyPlacedException("Этот предмет уже тут есть!");
        }
        return i;
    }

    @Override
    public Item getItem() {
        Item item = itemDeque.pollLast();
        item.setItemAdded(false);
        return item;
    }

    @Override
    public String toString() {
        return "ItemContainer: " + this.getNameItem()
                + " | MaxItems: " + this.maxItems
                + " | Items: " + this.itemDeque.size()
                + " | Inside: " + itemDeque;
    }
}