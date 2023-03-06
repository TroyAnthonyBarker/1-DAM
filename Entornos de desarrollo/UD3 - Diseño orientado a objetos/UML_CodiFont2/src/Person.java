public class Person {
    private String name;
    private int phoneNumber;
    private String eMail;
    private Address livesAt;
    private AddressBook addressBook;

    public Person() {
    }

    public Person(String name, int phoneNumber, String eMail, Address livesAt, AddressBook addressBook) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.livesAt = livesAt;
        this.addressBook = addressBook;
    }

    public void purchaseParkingPass() {
        // To do
    }
}