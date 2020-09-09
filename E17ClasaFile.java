/**
 * v[0]     v[1]
 * exit
 * cd       folder
 * cf       fisier
 * list     folder
 * remove   fisier
 */

import java.io.*;

public class E17ClasaFile{
    public static void main(String [] args){
        try{
            BufferedReader cons = new BufferedReader(
                new InputStreamReader(System.in)
            );
            
            String cmd = null;
            
            while(true){
                System.out.print("Comanda: ");
                cmd = cons.readLine();
                String [] v = cmd.split("\\s+");
                
                if("exit".equalsIgnoreCase(v[0])){
                    System.out.println("Se inchide...");
                    break;
                }
                
                if("cd".equalsIgnoreCase(v[0])){
                    File f = new File(v[1]);
                    boolean b = f.mkdir();
                    
                    if(b){
                        System.out.println("Folderul "+v[1]+" a fost creat.");
                    }else{
                        System.out.println("Folderul "+v[1]+" exista deja.");
                    }                                        
                }
                
                if("cf".equalsIgnoreCase(v[0])){
                    File f = new File(v[1]);
                    boolean b = f.createNewFile();
                    
                    if(b){
                        System.out.println("Fisierul "+v[1]+" a fost creat.");
                    }else{
                        System.out.println("Fisierul "+v[1]+" exista deja.");
                    }                                        
                }
                
                if("list".equalsIgnoreCase(v[0])){
                    File f = new File(v[1]);
                    String [] nume = f.list();
                    for(String x:nume){
                        System.out.println("\t"+x);
                    }
                }
                
                if("remove".equalsIgnoreCase(v[0])){
                    File f = new File(v[1]);
                    boolean b = f.delete(); //delete stie sa stearga si foldere, dar sterge doar foldere goale
                    
                    if(b){
                        System.out.println("Fisierul "+v[1]+" a fost sters.");
                    }else{
                        System.out.println("Fisierul "+v[1]+" nu a putut fi sters.");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}