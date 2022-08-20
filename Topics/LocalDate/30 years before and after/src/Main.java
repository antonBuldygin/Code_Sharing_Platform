import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] date = input.split("-");
        LocalDate localDate = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        LocalDate localDateBefore = localDate.minusYears(30);
        LocalDate localDateAfter= localDate.plusYears(30);
        System.out.println(localDateBefore);
        System.out.println(localDateAfter);
    }
}