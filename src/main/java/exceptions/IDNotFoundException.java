package exceptions;

public class IDNotFoundException extends Exception{

    public IDNotFoundException(int id){
        super(String.format("nu exista ID-ul : %d", id));
    }
}
