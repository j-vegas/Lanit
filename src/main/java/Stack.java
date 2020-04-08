import java.util.ArrayDeque;
import java.util.Deque;

public class Stack extends ItemContainer {
    private static String name = "Stack (Стопка)";
    private int maxItems;
    private Deque<Item> itemDeque = new ArrayDeque<Item>();

    public Stack(int maxItems) {
        super(name);
        this.maxItems = maxItems;
        this.setItemContainer(itemDeque);
    }

    @Override
    String getInfo() {
        return this.getNameItem() +  " Inside: " + itemDeque;
    }

    @Override
    public boolean addItem(Item i) throws ItemStoreException, ItemAlreadyPlacedException {
        if (itemDeque.size() < maxItems) {
            if (i.getProperties().contains("плоский")) {
                maxItems += 1;
                return super.addItem(i);
            } else {
                throw new ItemStoreException("Нельзя положить больше \" + maxItems + \" предмета(ов)");
            }
        } else {
            throw new ItemAlreadyPlacedException("Добавляются только плоские предметы!");
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