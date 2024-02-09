package lesson4.quiz2.q11;

import java.time.LocalDate;
import java.time.Period;

public class Q11 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2000-01-01");
        Period period = Period.ofYears(-3000);
        System.out.println(date.plus(period));
    }
}
