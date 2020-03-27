public class Brick extends Item {
    private static String name = "кирпич";

    public Brick() {
        super(name);
    }
    public Brick(String ... properties) {
        super(name, properties);
    }
    public Brick(double weightItem, String ... properties) {
        super(name, weightItem, properties);
    }

    @Override
    String getInfo() {
        return this.getNameItem() + " " + this.getWeightItem() + " " + this.getProperties();
    }
}
