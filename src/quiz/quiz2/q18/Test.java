package quiz.quiz2.q18;

class Student {
    String name;
    int age;

    Student() {
        // Student("James", 25);
        this("James", 25); // Use 'this' to call the other constructor
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.name + ":" + s.age);
    }
}
