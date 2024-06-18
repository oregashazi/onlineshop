package onlineshop.enums;

/**
 * Represents various payment methods available in the online shop.
 * Each payment method is associated with a label for display purposes.
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * PaymentMethod paymentMethod = PaymentMethod.CREDITCARD;
 * System.out.println(paymentMethod.label);  // Output: Credit card
 * }
 * </pre>
 * </p>
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */

public enum PaymentMethod {
    CREDITCARD   ("Credit card"),
    PAYPAL       ("Paypal"),
    BANK_TRANSFER("Direct bank transfer"),
    CHECK        ("Check payments");

    /** The label associated with the payment method for display purposes. */
    public final String label;

    /**
     * Constructor to associate a label with a payment method.
     *
     * @param label the label to be associated with the payment method
     */
    PaymentMethod(String label) {
        this.label = label;
    }
}
