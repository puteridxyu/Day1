package lesson2.operators.exec;

public class Exec3 {
    public static void main(String[] args) {
        String str = "qwertyuiopasdfghjklzxcvbnm";
        String search = "qwerty";

        System.out.println(str);
        System.out.println(str.concat(str));
        str = str.concat(str);
        System.out.println(str);
        System.out.println(str.charAt(5));
        System.out.println(str.length());
        if (str.contains(search)) {
            System.out.printf("Contain %s", search);
        } else {
            System.out.println("Does not contain qwerty");
        }

    }
}
