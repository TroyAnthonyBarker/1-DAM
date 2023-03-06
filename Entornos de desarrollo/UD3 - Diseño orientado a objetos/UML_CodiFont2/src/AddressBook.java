import java.util.ArrayList;

public class AddressBook {
    private int code;
    private ArrayList<Person> people;

    public AddressBook(int code, ArrayList<Person> people) {
        this.code = code;
        this.people = people;
    }

    public AddressBook(int code) {
        this.code = code;
        this.people = new ArrayList<Person>();
    }
}
