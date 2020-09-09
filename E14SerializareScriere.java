/**
 * scriem instanta unui obiect (Pisica) intr-un fisier
 */

import java.io.*;

public class E14SerializareScriere{
    public static void main(String [] args){
        try{
            //creez o instanta de ObjectOutputStream care cheama motorul de serializare
            //si scrie direct o reprezentare a unei instante printr-un flux
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Exemplu14Pisica.txt")
            );
            
            Pisica p = new Pisica("Tom", "birmanez");
            //folosind comportamentul writeObject al clasei java.io.ObjectOutputStream scriu instanta prin flux
            //writeObject = Write the specified object to the ObjectOutputStream.
            out.writeObject(p);
            out.close();
        }catch(Exception e){
            System.out.println("Eroare la scriere");
        }
    }
}