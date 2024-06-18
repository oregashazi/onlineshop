package onlineshop.order;

import onlineshop.enums.PaymentMethod;

/**
 * This class represents billing information for an order in the online shop.
 * It includes details such as the customer's name, address, contact information, and payment method.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class Billing {
    private String firstName;
    private String lastName;
    private String company;
    private String country;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String notes;
    PaymentMethod paymentMethod;

    /**
     * Constructor to create a Billing object with mandatory fields.
     *
     * @param firstName      the first name of the customer
     * @param lastName       the last name of the customer
     * @param paymentMethod  the payment method chosen by the customer
     */
    public Billing(String firstName, String lastName, PaymentMethod paymentMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters

    /**
     * Gets the first name of the customer.
     *
     * @return the first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer.
     *
     * @return the last name of the customer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the company name, if provided.
     *
     * @return the company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company name.
     *
     * @param company the company name to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country name.
     *
     * @param country the country name to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the street address.
     *
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     *
     * @param street the street address to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name.
     *
     * @param city the city name to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state name, if provided.
     *
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state name.
     *
     * @param state the state name to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode the zip code to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the phone number, if provided.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the additional notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the additional notes.
     *
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets the payment method.
     *
     * @return the payment method
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     *
     * @param paymentMethod the payment method to set
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returns the combined address as a single string.
     *
     * @return the combined address
     */
    public String getCombinedAddress() {
        StringBuilder address = new StringBuilder();
        if (company != null && !company.isEmpty()) {
            address.append(company).append(", ");
        }
        address.append(street).append(", ");
        if (state != null && !state.isEmpty()) {
            address.append(state).append(", ");
        }
        address.append(city).append(", ").append(country).append(", ").append(zipCode);
        return address.toString();
    }
}
