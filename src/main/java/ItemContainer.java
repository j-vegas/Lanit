import java.util.Collection;


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
            throw new ItemAlreadyPlacedException("Предмет уже есть в другом контейнере!");
        } else {
            i.setItemAdded(true);
            return itemContainer.add(i);
        }
    }

    // Удаление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item removeItem() throws Exception;

    public void setItemContainer(Collection<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }
}
