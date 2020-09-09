import java.io.*;

public class E10FluxPrintStream{
    public static void main(String [] args){
        try(PrintStream out = new PrintStream("Exemplu10.txt")){
            out.println("HELLO");            
        }catch(FileNotFoundException e){
            System.out.println("Eroare");
        }
    }
}