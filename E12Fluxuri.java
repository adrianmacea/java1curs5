/**
 * Realizam o aplicatie similara cu E11.
 * Aplicatia poate sa primeasca doua comenzi din consola, de forma:
 * 1. "Suma NumeFisier.txt"   
 *      comanda este "suma" si are 1 parametru: numele fisierului (va fi stabilit de catre utilizator)
 *      fisierul trebuie sa existe si sa contina o lista de numere intregi pe randuri separate
 *      (folosim fisierul creat cu aplicatia E11)
 *      aplicatia face suma acestor numere si o afiseaza in consola
 * 2. "Exit" 
 *      aplicatia se inchide cu un mesaj in consola
 *      
 * Consideram ca datele de input sunt corecte nu mai facem Catch pentru comenzi. 
 */

import java.io.*;
import java.util.*;

public class E12Fluxuri{
    public static void main(String [] args){
        //scriem tratarea exceptiilor
        try{
            //declaram un flux HL de citire din consola creat direct pe baza lui System.in
            BufferedReader cons = new BufferedReader(
                new InputStreamReader(System.in)
            );
            //declaram o zona de memorie pentru un flux catre fisier (deocamdata nu avem calea il punem null)
            BufferedReader in = null;
            //similar, citesc comenzi 
            String cmd = null;
            //nu stiu cate comenzi se vor da in consola, declar o bucla infinita pe care o voi inchide la interior cu break
            while(true){
                //afisam un mesaj pentru asteptarea scrierii comenzii
                System.out.print("Comanda: ");
                //citim comanda folosind comportamentul readLine al clasei java.io.BufferedReader
                cmd = cons.readLine();
                //separam comanda in cuvinte si le punem in zonele de memorie ale unui array folosind 
                //metoda split a clasei String care primeste ca parametru o expresie regulata (REGEX)
                //rezulta v[0] numele comenzii si v[1] parametrul, calea catre fisier
                String [] v = cmd.split("\\s+");
                
                if("exit".equalsIgnoreCase(v[0])){
                    System.out.println("Se inchide...");
                    break;
                }
                
                if("suma".equalsIgnoreCase(v[0])){
                    //instantiem fluxul in pe baza fisierului primit
                    in = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(v[1]) //creez un flux LL de citire din fisier care are ca parametru adresa fisierului
                        )
                    );
                    
                    String nr = null;
                    //declar o varabila in care sa formez suma, initial cu valoarea zero
                    int suma = 0;
                    while((nr = in.readLine()) != null){ //citim din flux fiecare valoare numerica, pana la null
                        try{
                            suma += Integer.parseInt(nr); //adun la suma transformarea in valoare intreaga a numarului citit
                        }catch(NumberFormatException e){
                            suma += 0; //ne asiguram ca in cazul in care avem o linie goala in fisier nu se intampla nimic
                        }
                    }
                    //inchidem fluxul
                    in.close();
                    //afisam in consola suma
                    System.out.println("SUMA: "+suma);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            //in timpul dezvoltarii programatorii folosesc metoda print.StackTrace a clasei java.lang.Throwable
            //rolul ei este de a arunca exceptia si de a afisa locul din care a venit ea 
            //nu se foloseste dupa ce versiunea a fost lansata, dar pe parcursul dezvoltarii este utila pt identificarea rapida a locului cu problema
        }
    }
}