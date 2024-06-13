package onlineshop.enums;

// TODO: add JavaDoc like in {@link PlantMee}
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
