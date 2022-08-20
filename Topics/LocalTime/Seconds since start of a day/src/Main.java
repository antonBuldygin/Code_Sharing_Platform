import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LocalTime localTime = LocalTime.ofSecondOfDay(Long.valueOf(input));
        System.out.println(localTime);
    }
}