package Model.Exceptions;

public class NoMoneyEx extends Exception{
    @Override
    public String getMessage() {
        return "Zbyt mało środków na koncie. Transakcja nie została dokonana.";
    }
}
