public class InvalidAgeException extends Exception {
    private String msg;

    public InvalidAgeException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidAgeException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
