package onlineshop.enums;

// TODO: add JavaDoc like in {@link PlantMee}
public enum PaymentMethod {
    CREDITCARD   ("Credit card"),
    PAYPAL       ("Paypal"),
    BANK_TRANSFER("Direct bank transfer"),
    CHECK        ("Check payments");

    public final String label;

    PaymentMethod(String label) {
        this.label = label;
    }
}
