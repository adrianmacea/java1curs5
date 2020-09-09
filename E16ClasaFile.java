import java.io.*;

public class E16ClasaFile{
    public static void main(String [] args){
        try{
            File f1 = new File("Exemplu16");                       
            f1.mkdir(); // comportamentul pentru creat un director gol
            
            File f2 = new File("Exemplu16/test.txt");
            f2.createNewFile(); //comportamentul pentru creat fisier
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}