import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LocalDateTime localDateTime = LocalDateTime.parse(input);
        LocalDateTime localDateTime1 = localDateTime.plusHours(11);
        LocalDate localDate = localDateTime1.toLocalDate();
        System.out.println(localDate);
    }
}