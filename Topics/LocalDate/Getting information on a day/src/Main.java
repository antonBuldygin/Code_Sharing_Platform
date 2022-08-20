import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("-");
        LocalDate localDate = LocalDate.of(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]),Integer.parseInt(input[2]));
        int dayInYear = localDate.getDayOfYear();
        int dayInMonth = localDate.getDayOfMonth();
        System.out.println(dayInYear+" "+dayInMonth);


    }
}