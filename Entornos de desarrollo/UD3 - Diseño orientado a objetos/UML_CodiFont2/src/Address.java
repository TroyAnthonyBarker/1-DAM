public class Address {
    private String street;
    private String city;
    private int postalCode;
    private Person person;
    private State state;

    public Address(String street, String city, int postalCode, Person person, State state) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.person = person;
        this.state = state;
    }
    public Address(String street, String city, int postalCode, State state) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.person = new Person();
    }
}
