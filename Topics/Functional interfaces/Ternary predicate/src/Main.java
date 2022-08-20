class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT =
            ((a, b, c) -> {
                if (a != b && b != c && a != c) {
                    return true;
                } else {
                    return false;
                }
            });// Write a lambda expression here

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
        // Write a method here
    }
}