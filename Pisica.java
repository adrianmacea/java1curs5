import java.io.Serializable;

public class Pisica implements Serializable{
    String nume;
    transient String rasa;
    
    public Pisica(String nume, String rasa){
        this.nume = nume;
        this.rasa = rasa;
    }
}