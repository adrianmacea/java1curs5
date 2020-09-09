public class E08TryCatchReturn{
    public static void main(String [] args){
        System.out.println(m());    
    }
    
    public static int m(){
        try{
            int x = Integer.parseInt("123");
            return x;
            }catch(NumberFormatException e){
            System.out.println("Eroare Number Format");
        }finally{
            System.out.println("Finally");
        }
        
        return -1;
    }
}
