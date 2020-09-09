import java.io.*;

public class E08FluxBufferedReader{
    public static void main(String [] args){
        // declar instanta de flux high level
        BufferedReader cons = new BufferedReader(
        //pt ca e un flux HL buffered nu se creaza direct pe baza fluxului LL ci are nevoie de un intermediar,
        //o instanta de tip reader, de aceea vom folosi clasa InputStreamReader
        //vom crea pe baza fluxului LL System.in instanta fluxului HL
            new InputStreamReader(System.in)
        );
        
        try{
            System.out.print("Sir: ");
            
            //cand vom incerca sa citim folosind comportamentul readLine al fluxului de tip BufferedReader
            //vom vedea ca acesta propaga o exceptie checked numita IOException
            //suntem obligati sa tratam aceasta exceptie cu un try-catch
            String line = cons.readLine();
            
            //creez un StringBuilder pe baza sirului citit
            StringBuilder sb = new StringBuilder(line);
            
            //inversez sirul de caractere cu comportamentul reverse
            sb.reverse();
            
            //afisez sirul de caractere inversat
            System.out.println("Sirul inversat: "+sb);
        }catch(IOException e){
            System.out.println("Conexiune intrerupta");
        }
    }
}