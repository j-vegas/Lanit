import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItem {

    @Test
    @DisplayName("First Test - Bricks add to Bag")
    public void test1() {
        try {
            Brick a = new Brick(2.0, "плоский");
            Brick b = new Brick(2.0, "плоский");
            Brick c = new Brick(2.0, "плоский");

            Bag d = new Bag(5.0, 0.1);
            //Box e = new Box(10, 0.5);

            d.addItem(a);
            d.addItem(b);
            //System.out.println(d.getWeightItem());

            assertEquals(d.getWeightItem(), 4.1, 0);

            //e.addItem(c);
            //assertEquals(e.getWeightItem(), 2.5, 0);

            //e.addItem(d);
            //assertEquals(e.getWeightItem(), 6.5, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("First Test - Bricks add to Box")
    public void test2() throws Exception {

        Brick a = new Brick(2.0, "плоский");

        Box e = new Box(10, 0.5);

        e.addItem(a);
        assertEquals(e.getWeightItem(), 2.5, 0);

    }

    @Test
    @DisplayName("First Test - Bag add to Box")
    public void test3() {

        try {
            Brick a = new Brick(2.0, "плоский");
            Brick b = new Brick(2.0, "плоский");
            Brick c = new Brick(2.0, "плоский");

            Bag d = new Bag(5.0, 0.1);
            Box e = new Box(10, 0.5);

            d.addItem(a);
            d.addItem(b);

            e.addItem(c);

            e.addItem(d);
            assertEquals(e.getWeightItem(), 6.5, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
