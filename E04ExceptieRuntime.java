import java.util.*;

public class E04ExceptieRuntime{
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Nr.");
        int nr = s.nextInt();
        m(nr);
    }
    
    public static void m(int nr){
        if(nr > 10){
            throw new MyRuntimeException();
        }
        
        System.out.println("Valoare scrisa: "+nr);
    }
}