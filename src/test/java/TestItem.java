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
    Box bx2 = new Box("Коробка1", 10.0, 0.5);
    Bag bg1 = new Bag("Мешок1", 5.0, 0.1);
    Stack st1 = new Stack("Стопка1", 5);

    @Epic("Создание")
    @Story("Создание предметов")
    @DisplayName("Создаем кипрпич")
    @Test
    public void test01() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====01=====");
        Brick a = new Brick("Кирпич1", 2.0, "плоский");
        Brick b = new Brick("Кирпич2", 2.0, "плоский", "квадратный");

        System.out.println(a.toString());
        System.out.println(b.toString());
    }

    @Epic("Создание")
    @Story("Создание контейнеров")
    @DisplayName("Создаем коробку, мешок")
    @Test
    public void test02() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====02=====");
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
    public void test03() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====03=====");
        bg1.addItem(br1);
        bg1.addItem(br2);

        System.out.println(bg1.toString());
        assertEquals(bg1.getAllWeight(), 4.1, 0);

    }

    @Epic("Добавление")
    @Story("Добавление предметов в коробку")
    @DisplayName("Добавляем кирпичи в коробку")
    @Test
    public void test04() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====04=====");
        bx1.addItem(br1);
        bx1.addItem(br2);

        System.out.println(bx1.toString());
        assertEquals(bx1.getAllWeight(), 4.5, 0);
    }

    @Epic("Добавление")
    @Story("Добавление предметов в стопку")
    @DisplayName("Добавляем кирпич в стопку")
    @Test
    public void test05() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====05=====");
        st1.addItem(br1);
        st1.addItem(br2);

        System.out.println(st1.toString());
    }

    @Epic("Исключение")
    @Story("Проверка исключений")
    @DisplayName("Добавляем коробку в коробку")
    @Test(expected = ItemAlreadyPlacedException.class)
    public void test06() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====06=====");

        bx1.addItem(bx1);

        System.out.println(bx1.toString());

    }

    @Epic("Исключение")
    @Story("Проверка исключений")
    @DisplayName("Добавляем в мешок больше нормы")
    @Test(expected = ItemStoreException.class)
    public void test07() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====07=====");

        bg1.addItem(br1);
        bg1.addItem(br2);
        bg1.addItem(br3);
        bg1.addItem(br4);

        System.out.println(bg1.toString());

    }

    @Epic("Исключение")
    @Story("Проверка исключений")
    @DisplayName("Добавляем одну и туже коробку в стопку")
    @Test(expected = ItemAlreadyPlacedException.class)
    public void test8() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====08=====");
        st1.addItem(bx1);
        st1.addItem(bx1);

        System.out.println(st1.toString());
    }

    @Epic("Удаление")
    @Story("Удаление предметов из мешка")
    @DisplayName("Удаляем предмет из мешка")
    @Test
    public void test09() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====09=====");
        bg1.addItem(br1);
        bg1.addItem(br2);
        System.out.println(bg1.toString());

        bg1.getItem(br1);
        System.out.println(bg1.toString());
    }

    @Epic("Удаление")
    @Story("Удаление предметов из стопку")
    @DisplayName("Удаляем коробку в стопку")
    @Test
    public void test10() throws ItemStoreException, ItemAlreadyPlacedException {

        System.out.println("=====10=====");
        st1.addItem(bx1);
        st1.addItem(bx2);

        st1.getItem(bx2);

        System.out.println(st1.toString());
    }
}