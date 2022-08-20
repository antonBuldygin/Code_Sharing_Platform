import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(input);
        int nHours = scanner.nextInt();
        int mMinutes = scanner.nextInt();
        localDateTime = localDateTime.minusHours(nHours).plusMinutes(mMinutes);
        System.out.println(localDateTime);

    }
}