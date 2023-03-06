public class InvalidFNacimientoException extends Exception {

    private String msg;

    public InvalidFNacimientoException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidFNacimientoException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
