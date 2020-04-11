
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItem {

    Brick br1 = new Brick("Кирпич1", 2.0, "плоский");
    Brick br2 = new Brick("Кирпич2", 2.0, "плоский");
    Brick br3 = new Brick("Кирпич3", 2.0, "плоский");
    Brick br4 = new Brick("Кирпич4", 2.0, "широкий");

    Box bx1 = new Box("Коробка1", 10.0, 0.5);
    Box bx2 = new Box("Коробка2", 10.0, 0.5, "плоский");

    Bag bg1 = new Bag("Мешок1", 5.0, 0.1);
    Bag bg2 = new Bag("Мешок2", 5.0, 0.1);

    Stack st1 = new Stack("Стопка1", 5);

    @Epic("Создание")
    @Story("Создание предметов")
    @DisplayName("Создаем кипрпич")
    @Test
    public void test1() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====1=====");
        Brick a = new Brick("Кирпич1", 2.0, "плоский");
        Brick b = new Brick("Кирпич2", 2.0, "плоский", "квадратный");

        System.out.println(a.toString());
        System.out.println(b.toString());
    }

    @Epic("Создание")
    @Story("Создание контейнеров")
    @DisplayName("Создаем коробку, мешок")
    @Test
    public void test2() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====2=====");
        Box a = new Box("Коробка", 10.0, 0.5);
        Bag b = new Bag("Мешок", 5.0, 0.1);
        Stack c = new Stack("Стопка", 5);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }

    @Epic("Добавление")
    @Story("Добавление предметов в мешок")
    @DisplayName("Добавляем кирпичи в мешок")
    @Test
    public void test3() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====3=====");
        bg1.addItem(br1);
        bg1.addItem(br2);

        System.out.println(bg1.toString());
        assertEquals(bg1.getAllWeight(), 4.1, 0);

    }

    @Epic("Добавление")
    @Story("Добавление предметов в коробку")
    @DisplayName("Добавляем кирпичи в коробку")
    @Test
    public void test4() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====4=====");
        bx1.addItem(br1);

        System.out.println(bx1.toString());
        assertEquals(bx1.getAllWeight(), 2.5, 0);
    }

    @Epic("Добавление")
    @Story("Добавление предметов в стопку")
    @DisplayName("Добавляем кирпич в стопку")
    @Test
    public void test5() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====5=====");
        st1.addItem(br1);
        st1.addItem(br2);

        System.out.println(st1.toString());
    }

    @Epic("Добавление")
    @Story("Добавление предметов в коробку")
    @DisplayName("Добавляем мешок в коробку")
    @Test
    public void test6() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====6=====");

        bg1.addItem(br1);
        bg1.addItem(br2);

        bx1.addItem(bg1);

        System.out.println(bx1.toString());
        //assertEquals(bx1.getAllWeight(), 4.6, 0);
    }

    @Epic("Исключение")
    @Story("Проверка исключений")
    @DisplayName("Добавляем в мешок больше нормы")
    @Test(expected = ItemStoreException.class)
    public void test7() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====7=====");

        bg1.addItem(br1);
        bg1.addItem(br2);
        bg1.addItem(br3);
        bg1.addItem(br4);

        System.out.println(bg1.toString());

    }

    @Epic("Исключение")
    @Story("Проверка исключений")
    @DisplayName("Добавляем в мешок больше нормы")
    @Test(expected = ItemAlreadyPlacedException.class)
    public void test8() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====8=====");

        bg1.addItem(bg1);

        System.out.println(bg1.toString());

    }
}
