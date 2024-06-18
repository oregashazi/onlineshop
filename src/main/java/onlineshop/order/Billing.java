package onlineshop.order;

import onlineshop.enums.PaymentMethod;

// TODO: add JavaDoc like in {@link PlantMee}
public class Billing {
    private String firstName;
    private String lastName;
    // this is optional
    private String company;
    private String country;
    private String street;
    private String city;
    // this is optional
    private String state;
    private String zipCode;
    // this is optional
    private String phoneNumber;
    private String email;
    private String notes;
    PaymentMethod paymentMethod;

    public Billing(String firstName, String lastName, PaymentMethod paymentMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.paymentMethod = paymentMethod;
    }

    // TODO: generate Getters/Setters
    // TODO: create getter for combined address


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

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
