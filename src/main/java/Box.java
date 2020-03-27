public abstract class Box extends ItemContainer {
    private static String name = "коробка";
    private double maxWeight;

    public Box(double maxWeight) {
        super(name, maxWeight);
    }
}