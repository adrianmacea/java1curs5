import java.util.*;

public class E02ScannerCitireNumere{
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Primul numar, X: ");
        String nr1 = s.nextLine();
        double x = Double.parseDouble(nr1);
        //am transformat sirul de caractere citit din consola in valoare numerica
        
        System.out.print("Al doilea numar, Y: ");
        String nr2 = s.nextLine();
        double y = Double.parseDouble(nr2);
        
        System.out.println("X + Y = "+(x+y));        
    }
}