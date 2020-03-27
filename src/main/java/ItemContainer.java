import java.util.Collection;

public abstract class ItemContainer extends Item implements Iterable <Item> {

    private Collection <Item> itemCollection;

    public ItemContainer(String nameItem) {super(nameItem);}

    public ItemContainer(String nameItem, double weightItem) {
        super(nameItem, weightItem);
    }

    public ItemContainer(String nameItem, String... properties) {
        super(nameItem, properties);
    }

    public ItemContainer(String nameItem, double weightItem, String... properties) {
        super(nameItem, weightItem, properties);
    }

    public String addItem() {
        return "addItem";
    }

    public String pullItem() {
        return "pullItem";
    }

}
