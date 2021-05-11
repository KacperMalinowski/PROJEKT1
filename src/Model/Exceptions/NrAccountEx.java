package Model.Exceptions;

public class NrAccountEx extends Exception {
    @Override
    public String getMessage() {
        return "Nie rozpoznano podanego numeru konta.";
    }
}
