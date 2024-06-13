package onlineshop.enums;

// TODO: add JavaDoc like in {@link PlantMee}
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String label;

    Gender(String label) {
        this.label = label;
    }
}
