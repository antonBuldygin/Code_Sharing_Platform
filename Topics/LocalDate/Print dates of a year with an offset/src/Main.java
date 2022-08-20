import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");
        int offset = scanner.nextInt();

        LocalDate localDate = LocalDate.of(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));


        int year = localDate.getYear();

        while (year == Integer.parseInt(input[0])) {
            System.out.println(localDate);
            localDate = localDate.plusDays(offset);
            year = localDate.getYear();
        }

        // put your code here
    }
}