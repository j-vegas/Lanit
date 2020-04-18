public abstract class ItemContainer extends Item {

    public ItemContainer(String nameItem) {
        super(nameItem);
    }

    public ItemContainer(String nameItem, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
    }

    // Добавление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

    // Получение предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item getItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException;

}

