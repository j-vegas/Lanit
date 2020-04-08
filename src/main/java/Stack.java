import java.util.ArrayDeque;
import java.util.Deque;

public class Stack extends ItemContainer {
    private static String name = "Stack (Стопка)";
    private int maxItems;
    private Deque<Item> itemDeque = new ArrayDeque<Item>();

    public Stack(int maxItems) {
        super(name, maxItems);
        this.setItemContainer(itemDeque);
    }

    @Override
    public boolean addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (i.getProperties().contains("плоский")) {
            if (itemDeque.size() < maxItems) {
                maxItems += 1;
                return addItem(i);
            } else {
                throw new ItemStoreException("Добавляются только плоские предметы!");
            }
        } else {
            throw new ItemAlreadyPlacedException("Нельзя положить больше " + maxItems + " предмета(ов)");
        }
    }

    @Override
    public Item removeI() throws ItemStoreException, ItemAlreadyPlacedException {
        if (!itemDeque.isEmpty()) {
            maxItems -= 1;
            return itemDeque.removeLast();
        } else {
            throw new ItemStoreException("Тут пусто!");
        }
    }
}