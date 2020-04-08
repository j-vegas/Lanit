
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItem {

    @Test
    @DisplayName("Test - Bricks add to Bag")
    public void test1() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====1=====");
        Brick a = new Brick(2.0, "плоский");
        Brick b = new Brick(2.0, "плоский");

        Bag d = new Bag(5.0, 0.1);

        d.addItem(a);
        d.addItem(b);

        System.out.println(d.getInfo());
        assertEquals(d.getWeightItem(), 4.1, 0);

    }

    @Test
    @DisplayName("Test - Bricks add to Box")
    public void test2() throws ItemStoreException, ItemAlreadyPlacedException {
        System.out.println("=====2=====");
        Brick a = new Brick(2.0, "плоский");
        Brick b = new Brick(2.0, "плоский");

        Box e = new Box(10, 0.5);

        e.addItem(a);
        e.addItem(b);

        System.out.println(e.getInfo());
        assertEquals(e.getWeightItem(), 4.5, 0);

    }


    @Test(expected = ItemStoreException.class)
    @DisplayName("Test - More Bricks add to Bag")
    public void test3() throws ItemStoreException, ItemAlreadyPlacedException {
        System.out.println("=====3=====");
        Brick a = new Brick(2.0, "плоский");
        Brick b = new Brick(2.0, "плоский");
        Brick c = new Brick(2.0, "плоский");

        Bag d = new Bag(5.0, 0.1);

        d.addItem(a);
        d.addItem(b);
        d.addItem(c);

        System.out.println(d.getInfo());
        assertEquals(d.getWeightItem(), 6.1, 0);

    }

    @Test(expected = ItemStoreException.class)
    @DisplayName("Test - More Bricks add to Box")
    public void test4() throws ItemStoreException, ItemAlreadyPlacedException {
        System.out.println("=====4=====");
        Brick a = new Brick(4.0, "плоский");
        Brick b = new Brick(4.0, "плоский");
        Brick c = new Brick(4.0, "плоский");

        Box d = new Box(10.0, 0.5);

        d.addItem(a);
        d.addItem(b);
        d.addItem(c);

        System.out.println(d.getInfo());
        assertEquals(d.getWeightItem(), 6.1, 0);

    }

    @Test(expected = ItemStoreException.class)
    @DisplayName("Test - Bricks add to Stack")
    public void test5() throws ItemStoreException, ItemAlreadyPlacedException {
        System.out.println("=====5=====");
        Brick a = new Brick(4.0, "плоский");
        Brick b = new Brick(4.0, "плоский");
        Brick c = new Brick(4.0, "плоский");

        Stack d = new Stack(5);

        d.addItem(a);
        d.addItem(b);
        d.addItem(c);

        System.out.println(d.getInfo());

    }
}
