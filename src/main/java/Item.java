import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Item {
    private String nameItem;
    private double weightItem;
    private static double defaultWeightItem = 1.0;
    private boolean itemAdded = false;
    private Set<String> properties = new HashSet<String>();

    public Item(String nameItem) {
        this.nameItem = nameItem;
        this.weightItem = defaultWeightItem;
    }

    public Item(String nameItem, double weightItem) {
        this(nameItem);
        this.weightItem = weightItem;
    }

    public Item(String nameItem, double weightItem, String... properties) {
        this(nameItem);
        this.weightItem = weightItem;
        this.properties.addAll(Arrays.asList(properties));
    }

    public String getNameItem() {
        return nameItem;
    }

    public double getWeightItem() {
        return weightItem;
    }

    public Set<String> getProperties() {
        return properties;
    }

    public boolean isItemAdded() {
        return itemAdded;
    }

    public void setItemAdded(boolean itemAdded) {
        this.itemAdded = itemAdded;
    }

    public String toString() {
        return "NameItem: " + nameItem
                + " | WeightItem: " + weightItem
                + " | Properties: " + getProperties();
    }
}
