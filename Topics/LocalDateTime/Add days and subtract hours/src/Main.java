import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s");

        LocalDateTime localDateTime = LocalDateTime.parse(input[0]);
        LocalDateTime localDateTime1 = localDateTime.plusDays(Integer.parseInt(input[1])).minusHours(Integer.parseInt(input[2]));
        System.out.println(localDateTime1);
    }
}