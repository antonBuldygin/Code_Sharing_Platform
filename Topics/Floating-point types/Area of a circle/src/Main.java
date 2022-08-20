import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String input = scanner.nextLine();
        Function<String, Integer> function = Integer::parseInt;
        Integer radius = function.apply(input);
        System.out.println(radius*radius*Math.PI);

    }
}