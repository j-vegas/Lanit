import org.junit.Test;

public class TestItem {

    @Test
    public void test1() {
        try {
            Brick brick1 = new Brick(2.0, "плоский");
            Brick brick2 = new Brick(2.0, "плоский");

            Bag bag1 = new Bag(5.0, 0.1);

            bag1.addItem(brick1);
            bag1.addItem(brick2);
            System.out.println(bag1.getAllWeightItems());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            Brick brick1 = new Brick(2.0, "плоский");
            Brick brick2 = new Brick(2.0, "плоский");
            Brick brick3 = new Brick(2.0, "плоский");

            Bag bag1 = new Bag(5.0, 0.1);

            bag1.addItem(brick1);
            bag1.addItem(brick2);
            bag1.addItem(brick3);
            System.out.println(bag1.getAllWeightItems());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
