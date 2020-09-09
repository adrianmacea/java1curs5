public class E07TryCatch{
    public static void main(String [] args){
        try{
            int x = Integer.parseInt("abc");
            System.out.println(x);
        }catch(NullPointerException e){
            System.out.println("Eroare Null Pointer");
        }catch(NumberFormatException e){
            System.out.println("Eroare Number Format");
        }catch(Exception e){
            System.out.println("Eroare Generala");
        }finally{
            System.out.println("Finally");
        }
    }
}