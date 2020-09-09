import java.io.*;

public class E09FluxBufferedReader{
    public static void main(String [] args){
        try{
            // declar instanta de flux high level
            BufferedReader in = new BufferedReader(
            //pt ca e un flux HL buffered nu se creaza direct pe baza fluxului LL ci are nevoie de un intermediar,
            //o instanta de tip reader, de aceea vom folosi clasa InputStreamReader si
            //vom crea instanta fluxului HL pe baza propriului flux LL FileInputStream care primeste ca parametru calea catre un fisier
            //am ales un fisier din acelasi folder, deci calea e direct numele fisierului
            //constructorul ne arunca un FileNotFoundException propagabil pe care trebuie sa il tartam cu un try-catch
                new InputStreamReader(
                    new FileInputStream("E01ScannerCitireSir.java")
                )
            );
            
            //cum citesc din fisier? Raspuns: linie cu linie pana nu mai am ce citi
            
            //declar o variabila line
            String line = null;
            
            //citeste din flux si pune in variabila line ceea ce ai citit (operatorul de atribuire) atata timp cat ce citesti nu este null
            //si afiseaza in consola ce ai citit
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            
            //inchidem fluxul dupa ce nu-l mai folosim
            //fiind un flux catre un fisier nu mai este administrat de catre sistemul d eoperare ci de catre aplicatie
            //daca nu incidem fluxul nu vom mai putea modifica/sterge fisierul respectiv, pt ca SO il va considera folosit in continuare
            in.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }
}
