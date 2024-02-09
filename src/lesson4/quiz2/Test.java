package lesson4.quiz2;

//soalan 13 23 37 38

//Q4
import java.util.function.Predicate;

//Q7, Q9, Q14
import java.util.ArrayList;
import java.util.List;

//Q8, Q11
import java.time.LocalDate;
import java.time.Period;

// Q13
import java.io.FileNotFoundException;
import java.io.IOException;

//Q14
import java.util.Iterator;
import java.util.function.Predicate;

//Q15
import java.util.ListIterator;

//Q34
import java.time.LocalDate;
import java.time.Month;

/* 
//Q13
abstract class Super {
    public abstract void m1() throws IOException;
}

class Sub extends Super {
    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}

//Q14
class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return name;
    }
}


//Q18
class Student {
    String name;
    int age;

    Student() {
        Student("James", 25);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


//27
class Parent {
    public String toString() {
        return "Inner";
    }
}
class Child extends Parent {
    public String toString() {
        return super.toString().concat("Peace!");
    }
}
*/

public class Test {

    /*
     * // Q21
     * private static void add(double d1, double d2) {
     * System.out.println("double version: " + (d1 + d2));
     * }
     * private static void add(Double d1, Double d2) {
     * System.out.println("Double version: " + (d1 + d2));
     * }
     * 
     * 
     * //Q33
     * List List1 = new ArrayList<String>(); //Line 5
     * List<String> list2 = new ArrayList(); //Line 6
     * List<> List 3 = new ArrayList<String>(); //Line 7
     * List<String> list 4 = new ArrayList<String>(); //Line 8
     * List<String> list5 = new ArrayList<>(); //Line 9
     */

    public static void main(String[] args) {

        System.out.println(args[1]);

        /*
         * //Q1
         * String str1 = "";
         * boolean b1 = str1.isEmpty();
         * System.out.println(b1);
         * str1.trim();
         * b1 = str1.isEmpty();
         * System.out.println(b1);
         * 
         * //Q2
         * byte var = 10;
         * switch (var) {
         * case 10:
         * System.out.println("TEN");
         * break;
         * default:
         * System.out.println("DEFAULT");
         * }
         * 
         * //Q3
         * Boolean b1 = new Boolean("tRuE");
         * Boolean b2 = new Boolean("fAlSe");
         * Boolean b3 = new Boolean("abc");
         * Boolean b4 = null;
         * System.out.println(b1 + ":" + b2 + ":" + b3 + ":" + b4);
         * /*
         * 
         * // Q4
         * String[] arr = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
         * processStringArray(arr, p -> !false);
         * 
         * 
         * // Q6
         * m1(null);
         * 
         * 
         * // Q7
         * List<String> list = new ArrayList<>();
         * list.add("X");
         * list.add("Y");
         * list.add("X");
         * list.add("Y");
         * list.add("Z");
         * list.remove(new String("Y"));
         * System.out.println(list);
         * 
         * 
         * //Q8
         * LocalDate newYear = LocalDate.of(2018, 1, 1);
         * LocalDate eventDate = LocalDate.of(2018, 1, 1);
         * boolean flag1 = newYear.isAfter(eventDate);
         * boolean flag2 = newYear.isBefore(eventDate);
         * System.out.println(flag1 + ":" + flag2);
         * 
         * 
         * // Q9
         * ArrayList<Integer> original = new ArrayList<>();
         * original.add(new Integer(10));
         * ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
         * Integer i1 = cloned.get(0);
         * ++i1;
         * System.out.println(cloned);
         * 
         * 
         * // Q10
         * System.out.println("Output is " + (10 != 5));
         * 
         * 
         * // Q11
         * LocalDate date = LocalDate.parse("2000-01-01");
         * Period period = Period.ofYears(-3000);
         * System.out.println(date.plus(period));
         * 
         * // Q12
         * String fruit = "mango";
         * switch (fruit) {
         * case "Apple":
         * System.out.println("APPLE");
         * case "Mango":
         * System.out.println("MANGO");
         * case "Banana":
         * System.out.println("BANANA");
         * break;
         * default:
         * System.out.println("ANY FRUIT WILL DO");
         * }
         * 
         * 
         * // Q13
         * Super s = new Sub();
         * try {
         * s.m1();
         * } catch (IOException e) {
         * System.out.println("A");
         * } catch (FileNotFoundException e) {
         * System.out.print("B");
         * } finally {
         * System.out.print("C");
         * }
         * 
         * //Q14
         * List<Employee> list = new ArrayList<>();
         * list.add(new Employee("James", 25, 15000));
         * list.add(new Employee("Lucky", 23, 12000));
         * list.add(new Employee("Bill", 27, 10000));
         * list.add(new Employee("Jack", 19, 5000));
         * list.add(new Employee("Lia", 20, 8000));
         * process(list, e -> e.getAge() > 20);
         * 
         * // Q15
         * List<String> dryFruits = new ArrayList<>();
         * dryFruits.add("Walnut");
         * dryFruits.add("Apricot");
         * dryFruits.add("Almond");
         * dryFruits.add("Date");
         * 
         * ListIterator<String> iterator = dryFruits.listIterator();
         * while (iterator.hasNext()) {
         * if (iterator.next().startsWith("A")) {
         * iterator.remove();
         * }
         * }
         * 
         * System.out.println(dryFruits);
         * 
         * 
         * // Q17
         * StringBuilder sb = new StringBuilder("Java");
         * String s1 = sb.toString();
         * String s2 = "Java";
         * System.out.println(s1 == s2);
         * 
         * 
         * // Q18
         * Student s = new Student();
         * System.out.println(s.name + ":" + s.age);
         * 
         * // Q20
         * int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
         * String str = process(arr, 3, 8);
         * System.out.println(str);
         * 
         * 
         * // Q21
         * add(10.0, null);
         * 
         * 
         * // Q22
         * final String fName = "James";
         * String lName = "Gosling";
         * String name1 = fName + lName;
         * String name2 = fName + "Gosling";
         * String name3 = "James" + "Gosling";
         * System.out.println(name1 == name2);
         * System.out.println(name2 == name3);
         * 
         * 
         * // Q28
         * A obj = new A();
         * System.out.println(obj.i1);
         * System.out.println(obj.i2);
         * System.out.println(obj.i3);
         * System.out.println(obj.i4);
         * 
         * 
         * //Q31
         * char c = 'Z';
         * long l = 100_001;
         * int i = 9_2;
         * float f = 2.02f;
         * double d = 10_0.35d;
         * l = c + i;
         * f = c * l * i * f;
         * f = l + i + c;
         * i = (int) d;
         * f = (long) d;
         * System.out.println("success");
         * 
         * 
         * //Q31
         * List<StringBuilder> days = new ArrayList<>();
         * days.add(new StringBuilder("Sunday"));
         * days.add(new StringBuilder("mon"));
         * days.add(new StringBuilder("tues"));
         * if (days.contains(new StringBuilder("Sunday"))) {
         * days.add(new StringBuilder("Wednesday"));
         * }
         * System.out.print(days.size());
         * 
         * //Q39
         * String s1 = "0cA";
         * String s2 = "oCa";
         * System.out.println(s1.equals(s2));
         * 
         * 
         * // Q34
         * 
         * List<LocalDate> dates = new ArrayList<>();
         * dates.add(LocalDate.parse("2018-07-11"));
         * dates.add(LocalDate.parse("1919-10-25"));
         * dates.add(LocalDate.of(2020, 4, 8));
         * dates.add(LocalDate.of(1980, Month.DECEMBER, 31));
         * dates.removeIf(x -> x.getYear() < 2000);
         * System.out.println(dates);
         * 
         * 
         * // 35
         * String[][] fruits = { { "apple", "mango" }, { "orange", "grape" } };
         * for (int i = 0; i < fruits.length; i++) {
         * for (int j = 0; j < fruits[i].length; j++)
         * System.out.print(fruits[i][j] + " ");
         * }
         * for (int i = 1; i < fruits.length; i++) {
         * for (int j = 1; j < fruits[i].length; j++)
         * System.out.print(fruits[i][j] + " ");
         * }
         * for (int i = 1; i < fruits.length; i++) {
         * for (int j = 0; j < fruits[i].length; j++)
         * System.out.print(fruits[i][j] + " ");
         * }
         * for (String [] arr : fruits)
         * for(String fruit : arr)
         * System.out.print(fruit + "");
         * }
         * 
         * 
         * // Q36
         * Period period = Period.of(2, 1, 0).ofYears(10).ofMonths(5).ofDays(2);
         * System.out.println(period);
         */

    } // main class

    /*
     * //Q4
     * private static void processStringArray(String[] arr, Predicate<String>
     * predicate) {
     * for (String str : arr) {
     * if (predicate.test(str)) {
     * System.out.println(str);
     * }
     * }
     * }
     * 
     * 
     * // Q6
     * static void m1(CharSequence s) {
     * System.out.println("CharSequence");
     * }
     * 
     * static void m1(String s) {
     * System.out.println("String");
     * }
     * 
     * static void m1(Object s) {
     * System.out.print("Object");
     * }
     * 
     * 
     * //Q14
     * private static void process(List<Employee> list, Predicate<Employee>
     * predicate) {
     * Iterator<Employee> iterator = list.iterator();
     * while (iterator.hasNext()) {
     * Employee e = iterator.next();
     * if (predicate.test(e)) {
     * System.out.println(e);
     * }
     * }
     * }
     * 
     */

}
