package quiz.quiz3.q31_q40.q43;

public class Test {
    public static void main(String[] args) {
        Buyable[] arr = new Buyable[2];
        for (Buyable b : arr) {
            System.out.println(b.salePercentage); // Line n1
            System.out.println(b.salePercentage); // Line n2
        }
        Book[] books = new Book[2];
        for (Book b : books) {
            System.out.println(b.salePercentage); // Line n3
            System.out.println(b.salePercentage); // Line n4
        }
    }
}
// 43. Consider below codes of 3 java files, Which of the following statements
// are correct?
// There is a compilation error at Line n4
// There is a compilation error at Line n2
