import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner input = new Scanner(System.in);

        String time = input.nextLine();

        LocalTime localTime = LocalTime.parse(time);
        localTime= localTime.withSecond(0);
        System.out.println(localTime);
    }
}