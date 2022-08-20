import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LocalDateTime localDateTime = LocalDateTime.parse(input);
         input = scanner.nextLine();
        LocalDateTime localDateTime1 = LocalDateTime.parse(input);



        System.out.println(  localDateTime.until(localDateTime1, ChronoUnit.HOURS));

    }
}