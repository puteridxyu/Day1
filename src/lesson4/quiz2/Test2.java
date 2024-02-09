package lesson4.quiz2;

import java.util.ArrayList;
import java.util.List;
/* 

public class Test2 {
    public static void main(String[] args) {

    }
}

//Q43
class Point {
    static int x;
    int y, z;

    public String toString() {
        return "Point(" + x + ", " + y + "," + z + ")";
    }
}

public class Test2 {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 17;
        p1.y = 35;
        p1.z = -1;

        Point p2 = new Point();
        p2.x = 19;
        ;
        p2.y = 40;
        p2.z = 0;

        System.out.println(p1);
        System.out.println(p2);
    }

}


//Q45
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(27);
        list.add(27);

        list.add(new Integer(27));
        list.add(new Integer(27));

        System.out.println(list.get(0) == list.get(1));
        System.out.println(list.get(2) == list.get(3));
    }
}


//Q45
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(100);
        list.add(200);
        list.add(100);
        list.add(200);
        list.remove(new Integer(100));

        System.out.println(list);
    }
}
*/

//Q46

class Parent {
    int i = 10;

    Parent(int i) {
        super();
        this.i = i;
    }
}

class Child extends Parent {
    int j = 20;

    Child(int j) {
        super(0);
        this.j = j;
    }

    Child(int i, int j) {
        super(i);
        this.j = j;

    }
}

public class Test2 {
    public static void main(String[] args) {
        Child child = new Child(1000, 2000);
        System.out.println(child.i + ":" + child.j);
    }
}
