import java.util.Arrays;
import java.util.HashSet;
import java.util.Date;

public abstract class Item {
    private String nameItem;
    private double weightItem;
    private static double defaultWeightItem = 1.0;
    private HashSet<String> properties = new HashSet<String>();
    private Date date = new Date();
    private boolean itemAdded = false;

    public Item(String nameItem) {
        this.nameItem = nameItem;
        this.weightItem = defaultWeightItem;
    }

    public Item(String nameItem, double weightItem) {
        this(nameItem);
        this.weightItem = weightItem;
    }

    public Item(String nameItem, String ... properties) {
        this(nameItem);
        this.properties.addAll(Arrays.asList(properties));
    }

    public Item(String nameItem, double weightItem, String... properties) {
        this(nameItem, properties);
        this.weightItem = weightItem;
    }

    String getInfo() {
        return "Default";
    }

    @Override
    public String toString() {
        return nameItem + " (" + date.toString() + ")";
    }

    public String getNameItem() {
        return nameItem;
    }

    public double getWeightItem() {
        return weightItem;
    }

    public HashSet<String> getProperties() {
        return properties;
    }

}
