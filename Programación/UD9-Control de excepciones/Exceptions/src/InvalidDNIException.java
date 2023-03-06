public class InvalidDNIException extends Exception{

    private String msg;

    public InvalidDNIException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidDNIException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
