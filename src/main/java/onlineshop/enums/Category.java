package onlineshop.enums;

import onlineshop.PlantMee;

/**
 * Representing various categories of plants in the online shop.
 * Each category has a label that describes it.
 * The categories can be converted from a string label to the corresponding enum constant.
 *
 * @see PlantMee
 */
public enum Category {
    BLUMEN("Blumen"),
    ROSEN("Rosen"),
    KRAEUTER("Kräuter"),
    GEMUESE("Gemüse"),
    ZIMMERPFLANZEN("Zimmerpflanzen Indoor"),
    PALMEN("Palmen"),
    KAKTEEN("Kakteen"),
    BONSAI("Bonsai"),
    OBSTBAEUME("Obstbäume, Outdoor"),
    OBSTSTRAEUCHER("Obststräucher"),
    SUKKULENTEN("Sukkulenten"),
    TEICHPFLANZEN("Teichpflanzen"),
    BALKONPFLANZEN("Balkonpflanzen");

    public final String label;

    Category(String label) {
        this.label = label;
    }

    /**
     * Converts a string label to the corresponding Category enum constant.
     *
     * @param label the label of the category as a string
     * @return the corresponding Category enum constant, or null if no match is found
     */
    public static Category fromString(String label) {
        final String labelUpperCase = label.toUpperCase();
        for(Category category : Category.values()) {
            if(category.toString().contains(labelUpperCase)) {
                return category;
            }
        }
        return null;
    }
}
