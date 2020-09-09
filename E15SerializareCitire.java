/**
 * citim instanta unui obiect (Pisica) dintr-un fisier 
 * si o transformam la loc in obiect
 */

import java.io.*;

public class E15SerializareCitire{
    public static void main(String [] args){
        try{
            //creez un flux de citire ObjectinputStream
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Exemplu14Pisica.txt")
            );
            
            //citesc obiectul Pisica folosind metoda readObject a clasei java.io.ObjectInputStream
            //eu trebuie sa stiu ce fel de obiect se afla acolo pentru a reconverti pisica la obiectul corespunzator
            //readObject imi intoarce un obiect, dar nu stie ce fel de obiect, 
            //asdar eu trebuie sa stiu si sa specific ca e vorba despre o instanta de Pisica, daca specific alta clasa imi da eroare
            //si pun referinta de Pisica in zona de memorie p
            Pisica p = (Pisica) in.readObject();
            
            System.out.println(p.nume+" "+p.rasa);
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}