import lesson1.*;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World." + args[0] + "" + args[1]);
        // lesson1();
        lesson2();
    }

    public static void lesson2() {
        int numberOfVessels = 15;
        int[] dimension = { 2, 4, 7 };
        IntegerHandler integerHandler = new IntegerHandler(numberOfVessels, dimension);
        int volume = integerHandler.getTotalVolume();
        String msg = integerHandler.toString();
        System.out.println(msg);
        System.out.println(volume);
    }

    public static void lesson1() {
        StringHandler stringHandler = new StringHandler("my class");
        System.out.println(stringHandler.toString());
        stringHandler.setStr("my new class");
        System.out.println(stringHandler.toString());
    }
}
