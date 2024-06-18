package onlineshop.enums;


/**
 * Representing gender categories for users.
 *
 * <p>This enum includes three categories: MALE, FEMALE, and OTHER.
 * Each category has an associated label that can be used for display purposes.</p>
 *
 * <p>Example usage:
 * <pre>
 *     Gender gender = Gender.MALE;
 *     System.out.println(gender.label);  // Output: Male
 * </pre>
 * </p>
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    /** The label associated with the gender category. */
    public final String label;

    /**
     * Constructor for the Gender enum.
     *
     * @param label the label associated with the gender category.
     */
    Gender(String label) {
        this.label = label;
    }
}
