/**
 * Realizam o aplicatie care sa poata sa primeasca doua comenzi din consola, de forma:
 * 1. "Generare N NumeFisier.txt" (N trebuie sa fie un numar)   
 *      programul va genera N numere aleatoare pe care le va scrie intru-un fisier cu numele indicat
 *      comanda este "generare" si are 2 parametrii: N si numele fisierului (vor fi stabiliti de catre utilizator)
 * 2. "Exit" 
 *      aplicatia se inchide cu un mesaj in consola
 *      
 * Consideram ca datele de input sunt corecte nu mai facem Catch pentru comenzi. 
 */

import java.io.*;
import java.util.Random;

public class E11Fluxuri{
    public static void main (String [] args){
        try{
            //declar un flux de citire din consola
            //stim deja ca vor fi exceptii propagabile pe care compilatorul ne obliga sa le tratam
            //folosim un try-catch general pt a simplifica
            BufferedReader cons = new BufferedReader(
                new InputStreamReader(System.in)
            );
            //declar un PrintStream (flux de scriere HL intr-un fisier), dar nu il instantiez deocamdata 
            //pentru ca nu stiu inca in ce fisier trebuie sa scriu
            PrintStream out = null;
            //creez o instanta de java.util.Random, de care vom avea nevoie pentru valoarile aleatoare
            Random r = new Random();
            //declar un String in care voi citi comenzile
            String cmd = null;
            //nu stim de cate ori doreste utilizatorul sa genereze fisiere cu numere, asadar vom folosi o bucla infinita
            //vom citi comenzile din aceasta bucla infinita si o vom inchide doar cand comanda scrisa este "exit"
            //ca sa inchid in interior bucla folosesc comanda break
            while(true){
                //afisam un mesaj pentru asteptarea scrierii comenzii
                System.out.print("Comanda");
                //citim comanda folosind comportamentul readLine al clasei java.io.BufferedReader
                //readLine - used to read a single line of text from the console
                cmd = cons.readLine();
                //comenzile pot avea mai multe cuvinte in general
                //trebuie sa obtin fiecare cuvant separat al comenzii cu ajutorul
                //comportamentului split al clasei String care primeste ca parametru o expresie regulata (regex - regulated expresion)
                //care spune in functie de ce trebuie separate cuvintele
                // "\\s+" separa dupa unu SAU mai multe spatii 
                //      (indiferent cate spatii sunt intre cuvinte le elimina si ia doar cuvintele si le transforma intr-un vector)
                //      rezulta ca pentru forma comenzii noastre "Generare N NumeFisier.txt" vom avea:
                //      v[0] este comanda genereaza, v[1] este parametrul N si v[2] este parametrul numele fisierului (scris fara spatii)
                // "\\s" ar fi separat dupa UN SINGUR spatiu 
                // "\\s*" ar inseamna minim 0 si maxim oricate spatii - adica imparte in litere
                String [] v = cmd.split("\\s+");
                //apoi pun conditia:
                //daca numele comenzii este exit - adica daca in v[0] este exit,
                //inchide bucla prin apelul lui break cu afisarea unui mesaj in consola
                //equals este o metoda din clasa java.lang.String - Compares this string to the specified object.
                //equalsIgnoreCase - face acelasi lucru dar ignoring case 
                if("exit".equalsIgnoreCase(v[0])){
                    System.out.print("Se inchide...");
                    break;
                }
                //similar, daca comanda data este "generare"
                //trebuie sa transformam primul parametru din zona de memorie v[1] in valoare numerica intreaga
                if("generare".equalsIgnoreCase(v[0])){
                    int x = Integer.parseInt(v[1]);
                    //instantiez fluxul HL de scriere intr-un fisier, in momentul in care s-a dat comanda generare
                    //pe baza parametrului v[2] (calea catre fisier)
                    out = new PrintStream(v[2]);
                    //parcurg x iteratii, de la i pana la x
                    //scriu pe o linie separata in consola o valoare numerica aleatoare in intervalul inchis [0,999]
                    //Pentru valoarea aleatoare folosim comportamentul nextInt() al clasei java.util.Random
                    //care produce valori pseudoaleatoare de tipul int in intervalul dat
                    for(int i=0;i<x;i++){
                        out.println(r.nextInt(1000));
                    }
                    //afisez in consola un mesaj de confirmare
                    System.out.println("Fisierul a fost creat.");
                    //dupa ce am terminat afisarea inchid fluxul HL de scriere catre fisier
                    //folosind metoda close a clasei java.io.Reader
                    //close - Closes the stream and releases any system resources associated with it.
                    //un nou flux va fi deschis la urmatorul apel al comenzii "generare"
                    out.close();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            //getMessage este un comportament al clasei java.lang.Throwable, parinte pentru clasa Exception
            //getMessage Returns the detail message string of this Throwable instance (which may be null).
        }
    }
}