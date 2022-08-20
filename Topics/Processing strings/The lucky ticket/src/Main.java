import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] digit = input.split("");

        if (Integer.parseInt(digit[0]) +Integer.parseInt(digit[1]) + Integer.parseInt(digit[2]) ==
                Integer.parseInt(digit[3]) + Integer.parseInt(digit[4]) + Integer.parseInt(digit[5])) {

            System.out.println("Lucky");
        }
        else {System.out.println("Regular");}
                }
}