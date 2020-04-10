import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

public abstract class Item {
    private String nameItem;
    private double weightItem;
    private static double defaultWeightItem = 1.0;
    private boolean itemAdded = false;
    private Set<String> properties = new HashSet<String>();
    //private static int itemStartNumber = 1;
    //public int itemNumber;
    //private Date date = new Date();
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:S");

    public Item(String nameItem) {
        this.nameItem = nameItem;
        this.weightItem = defaultWeightItem;
        //this.itemNumber = itemStartNumber;
        //itemStartNumber++;
    }

    public Item(String nameItem, double weightItem) {
        this(nameItem);
        this.weightItem = weightItem;
    }

    public Item(String nameItem, String... properties) {
        this(nameItem);
        this.properties.addAll(Arrays.asList(properties));
    }

    public Item(String nameItem, double weightItem, String... properties) {
        this(nameItem, properties);
        this.weightItem = weightItem;
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
