public abstract class Stack extends ItemContainer{
    private static String name = "стопка";
    private int maxItems;

    public Stack(int maxItems) {
        super(name, maxItems);
    }

    public String addItemUp() {
        return "addItemUp";
    }

    public String pullItemUp() {
        return "pullItemUp";
    }

}