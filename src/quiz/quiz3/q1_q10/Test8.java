package quiz.quiz3.q1_q10;

public class Test8 {
    public static void main(String[] args) {
        int score = 30; //Line n1
        char grade = 'F'; //Line n2
        //if (50 <= score < 60) //Line n3 exam q
        if (50 <= score) //Line n3 corrected
        grade = 'D';
        //else if (60 <= score < 70) //Line n4 exam q
        else if (60 <= score) //Line n4 corrected
            grade = 'C';
        //else if (70 <= score < 80) //Line n5 exam q
        else if (70 <= score ) //Line n5 corrected
            grade = 'B';
        //else if (score > = 80) // exam q
        else if (score >  80) //corrected
            grade = 'A';
            System.out.println(grade);
    }
}
// 8. Consider below code of Test.java file,  What is the result of compiling and executing Test class?
// answer : Compilation error