public class E06TryFinally{
    public static void main (String [] args){
        try{
            int x = Integer.parseInt("123");
            System.out.println(x);
        }finally{
            System.out.println("FINALLY");
        }
    }
}