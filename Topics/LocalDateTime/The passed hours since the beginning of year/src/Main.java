import java.time.LocalDate;
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

        LocalTime localTime = localDateTime.toLocalTime();
        LocalDateTime beginingOfTheYear = localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);

        System.out.println( - localDateTime.until(beginingOfTheYear, ChronoUnit.HOURS));

    }
}