package javari.animal;

public enum Gender {

    MALE, FEMALE;
    private static final String MALE_STR = "male";
    private static final String FEMALE_STR = "female";

    public static Gender parseGender(String str) {
        if (str.equalsIgnoreCase(MALE_STR)) {
            return Gender.MALE;
        } else if (str.equalsIgnoreCase(FEMALE_STR)) {
            return Gender.FEMALE;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
