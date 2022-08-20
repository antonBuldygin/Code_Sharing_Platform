import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Instant> instantList = createInstantList(scanner);

        long result = getMaxMinusMin(instantList); 

        System.out.println(result);
    }  

    public static List<Instant> createInstantList(Scanner scanner) {
        List<Instant> instantList = new ArrayList<>();
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));

        return instantList;
    }

    private static long getMaxMinusMin(List<Instant> instantList) {
//        System.out.println(instantList.toString());
        Collections.sort(instantList);
//        System.out.println(instantList.toString());
        return instantList.get(0).until(instantList.get(instantList.size()-1), ChronoUnit.SECONDS);
    }
}