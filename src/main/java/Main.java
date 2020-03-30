import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("My name is Brick!");
        Brick brick = new Brick(2.0, "плоский");
        Brick brick1 = new Brick(2.0, "плоский");
        Brick brick2 = new Brick(2.0, "плоский");

        System.out.println(brick.toString());
        System.out.println(brick.getNameItem());
        System.out.println(brick.getWeightItem());
        System.out.println(brick.getProperties());
        System.out.println(brick.getInfo());

        System.out.println(brick1.toString());
        System.out.println(brick1.getNameItem());
        System.out.println(brick1.getWeightItem());
        System.out.println(brick1.getProperties());
        System.out.println(brick1.getInfo());

        System.out.println(brick2.toString());
        System.out.println(brick2.getNameItem());
        System.out.println(brick2.getWeightItem());
        System.out.println(brick2.getProperties());
        System.out.println(brick2.getInfo());

        System.out.println("My name is Bag!");
        Bag bag = new Bag(5.0, 0.1) {
            @Override
            public Item removeItem() throws Exception {
                return null;
            }

            @Override
            public Iterator<Item> iterator() {
                return null;
            }
        };

        System.out.println(bag.toString());
        System.out.println(bag.getNameItem());
        System.out.println(bag.getWeightItem());
        System.out.println(bag.getProperties());
        System.out.println(bag.getInfo());

    }
}
