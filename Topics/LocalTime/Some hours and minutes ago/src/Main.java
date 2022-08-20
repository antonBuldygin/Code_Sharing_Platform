import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String time = scanner.nextLine();
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        LocalTime localTime = LocalTime.parse(time);
        localTime= localTime.minusHours(hour);
        localTime= localTime.minusMinutes(minute);
        System.out.println(localTime);

    }
}