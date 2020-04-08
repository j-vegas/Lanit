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

    public Collection<Item> getItemContainer() {
        return itemContainer;
    }

    public void setItemContainer(Collection<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }

    // Добавление предмета
    public boolean addItem(Item i) throws ItemAlreadyPlacedException, ItemStoreException {
        if (i.isItemAdded()) {
            throw new ItemAlreadyPlacedException("Предмет уже есть в одном из контейнеров, выбери другой!");
        } else {
            i.setItemAdded(true);
            return itemContainer.add(i);
        }
    }

    // Удаление предмета, переопределяется в классах Bag, Box, Stack
    public abstract Item removeI() throws Exception;

    public void getItems() {
        if (itemContainer.isEmpty()) {
            return;
        }
        System.out.println(itemContainer);
    }

    //Получаем размер контейнера
    public int getSize() {
        System.out.println("Колличество предметов: " + itemContainer.size());
        return itemContainer.size();
    }

    //Получаем общий вес контейнера
    @Override
    public double getWeightItem() {
        double allWeight = 0;
        //allWeight = allWeight + getWeightItem();
        allWeight += super.getWeightItem();

        Iterator<Item> i = itemContainer.iterator();
        while (i.hasNext()) {
            Item item = i.next();
            allWeight += item.getWeightItem();
        }
        //System.out.println(itemContainer);
        //System.out.println(this.getSize());
        //System.out.println("Общий вес: " + this.getNameItem() + " " + allWeight);
        return allWeight;
    }

    @Override
    public Iterator<Item> iterator() {
        return itemContainer.iterator();
    }

   /* @Override
    public String toString(){
        return this.getNameItem() + " Макс вес: " + ;*/




}

