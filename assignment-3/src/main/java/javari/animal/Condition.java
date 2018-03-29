package javari.animal;

public enum Condition {

    HEALTHY, SICK;
    private static final String HEALTHY_STR = "healthy";
    private static final String SICK_STR = "not healthy";

    public static Condition parseCondition(String str) {
        if (str.equalsIgnoreCase(HEALTHY_STR)) {
            return Condition.HEALTHY;
        } else if (str.equalsIgnoreCase(SICK_STR)) {
            return Condition.SICK;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
