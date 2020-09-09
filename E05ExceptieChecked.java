import java.util.*;

public class E05ExceptieChecked{
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Nr.");
        int nr = s.nextInt();
        try{
            m(nr);
        }catch(MyException e){
            System.out.println(e.getMessage()); //mesajul exceptiei este cel pe care noi l-am setat prin super
        }
    }
    
    public static void m(int nr) throws MyException{
        if(nr > 10){
            throw new MyException();
        }
        
        System.out.println("Valoare scrisa: "+nr);
    }
}
