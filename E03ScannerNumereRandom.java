import java.util.*;

public class E03ScannerNumereRandom{
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        System.out.print("Nr: ");
        int nr = s.nextInt();
        //alternativ: int nr = Integer.parseInt(s.nextLine());
        for(int i=0; i<nr; i++){
            System.out.println(r.nextInt(1000));
        }              
    }
}
