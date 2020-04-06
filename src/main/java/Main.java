import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("My name is Brick!");
        Brick brick1 = new Brick(2.0, "плоский");
        Brick brick2 = new Brick(2.0, "плоский");
        Brick brick3 = new Brick(2.0, "плоский");

        System.out.println(brick1.toString());
        System.out.println(brick1.getNameItem());
        System.out.println(brick1.getWeightItem());
        System.out.println(brick1.getProperties());
        System.out.println(brick1.getInfo());

        /*System.out.println(brick2.toString());
        System.out.println(brick2.getNameItem());
        System.out.println(brick2.getWeightItem());
        System.out.println(brick2.getProperties());
        System.out.println(brick2.getInfo());*/

        System.out.println("My name is Bag!");
        Bag bag1 = new Bag(5.0, 0.1) {

            @Override
            public Iterator<Item> iterator() {
                return null;
            }
        };
        Bag bag2 = new Bag(0.2, 0.1);

        System.out.println(bag1.toString());
        System.out.println(bag1.getNameItem());
        System.out.println(bag1.getWeightItem());
        System.out.println(bag1.getProperties());
        System.out.println(bag1.getInfo());

        try {
            bag1.addItem(brick1);
            bag1.addItem(brick2);
            bag1.addItem(brick3);
            bag1.getItems();
            bag1.getSize();
            bag1.getAllWeightItems();

            bag1.removeI();
            bag1.getItems();
            bag1.getSize();
            bag1.getAllWeightItems();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
