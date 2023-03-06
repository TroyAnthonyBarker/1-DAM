public class InvalidNameException extends Exception {
    private String msg;

    public InvalidNameException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidNameException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
