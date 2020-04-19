import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ItemContainer extends Item {

    private List<Item> itemArrayList = new ArrayList<Item>();

    public ItemContainer(String nameItem) {
        super(nameItem);
    }

    public ItemContainer(String nameItem, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
    }

    // Добавление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

    // Получение предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item getItem() throws ItemAlreadyPlacedException, ItemStoreException;

    public Item getItemByIndex(int index) {
        Item item = itemArrayList.get(index);
        itemArrayList.remove(index);
        item.setItemAdded(false);
        return item;
    }

    public Integer searchItemByName(String nameItem) {
        Iterator iterator = itemArrayList.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (nameItem.equals(item.getNameItem()))
                return itemArrayList.indexOf(item);
        }
        return null;
    }

    public List<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(List<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }
}

