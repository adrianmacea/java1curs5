import java.util.*;

//scopul exercitiului este de a citi din terminal un sir e caractere pe care 
//tot in terminal il voi afisa inversat
public class E01ScannerCitireSir
{
    public static void main (String [] args){
        //Declar instanta clasei scanner. 
        //O facem cu unul dintre constructorii clasei, aici cel care 
        //primeste ca parametru un flux de citire low level. 
        //Folosim fluxul low level pentru citire din consola "in" din clasa System.
        //Astfel am creat utilitarul cu identificatorul "s" care imi permite sa citesc din consola.
        Scanner s = new Scanner(System.in);
        
        //mai intai afisam un sir de caractere cu care sa lucram
        //utilizatorul va introduce sirul in terminal
        System.out.print("Scrie sirul aici: ");
        
        //pentru a citi din consola un sir de caractere folosesc comportamentul nextLine
        //al acestei instante de utilitar Scanner
        String sir = s.nextLine();
        
        //Declar o instanta de StringBuilder care primeste ca parametru "sir" declarat mai sus.
        StringBuilder sb = new StringBuilder(sir);
        
        //Inversez sirul de caractere apeland comportamentul reverse.
        sb.reverse();
        
        //Afisez in consola sirul inversat.
        //Este suficient sa concatenez direct cu instanta de StringBuilder "sb" 
        //desi nu este sir de caractere, pt ca se va apela automat metoda toString a acestei instante.
        //toString din clasa Object e suprascrisa cand spunem cum sa fie transformata o instanta in sir de caractere
        //StringBuilder are deja declarat toString, iar ceea ce face aici este doar sa afiseze 
        //sirul de caractere continut de StringBuilder
        System.out.println("Sirul inversat este: "+sb);
    }
}