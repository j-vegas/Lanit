public abstract class Bag extends ItemContainer {
    private static String name = "мешок";
    private double maxWeight;

    public Bag(double maxWeight) {
        super(name, maxWeight);
    }

}

