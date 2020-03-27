public class Main {

    public static void main(String[] args) {
        System.out.println("My name is Brick!");
        Brick brick = new Brick(5.5,"свойство1", "свойство2", "свойство3");

        System.out.println(brick.toString());
        System.out.println(brick.getInfo());

    }
}
