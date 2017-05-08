/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 04.05.17
 */
public class PersonTest {
    public static void main(String[] args) {
        //Methoden der Klasse Person testen
        Person p = new Person( "Pablo" );
        Person p2 = new Person( "Olga" );
        Person p3 = new Person( "Pablo" );
        Person p4 = new Person( "Pablo" );

        //equals() von Person testen
        if(p.equals(p2))
            System.out.println("equals für Person true für Personen mit anderem Namen");
        if(!p.equals(p3))
            System.out.println("equals für Person false bei Personen mit gleichem Namen");
        if (p.equals(p4) != p4.equals(p))
            System.out.println("equals für Person nicht symetrisch");
        if (!(p.equals(p)))
            System.out.println("equals für Person nicht reflexiv");
        if(p.equals(p3) && p.equals(p4) && !(p3.equals(p4)))
            System.out.println("equals für Person nicht transitiv");
        if(p.equals(p3) != p.equals(p3))
            System.out.println("equals für Person nicht konsistent");
        if(p.equals(null))
            System.out.println("equals für Person bei null nicht false");
        //hashCode() von Person testen
        if(p.hashCode() != p.hashCode())
            System.out.println("Unterschiedlicher Hashcode für gleiche Person");
        if(p.hashCode() != p4.hashCode())
            System.out.println("Unterschiedlicher Hashcode für inhaltlich gleiche Personen");


        //Methoden von Student prüfen
        Student s = new Student("Pablo", 1);
        Student s2 = new Student("Olga", 1);
        Student s3 = new Student("Pablo", 1);
        Student s4 = new Student("Pablo", 1);
        Student s5 = new Student("Olga", 2);

        //equals() von Student prüfen
        if(s.equals(s5))
            System.out.println("equals für Student true für Personen mit anderem Namen und anderer MatNr");
        if(s.equals(s2))
            System.out.println("equals für Student true für Personen mit anderer MatNr und gleichem Namen");
        if(!s.equals(s3))
            System.out.println("equals für Person false bei Personen mit gleichem Namen und gleicher MatNr");
        if (s.equals(s4) != s4.equals(s))
            System.out.println("equals für Student nicht symetrisch");
        if (!(s.equals(s)))
            System.out.println("equals für Student nicht reflexiv");
        if(s.equals(s3) && s.equals(s4) && !(s3.equals(s4)))
            System.out.println("equals für Student nicht transitiv");
        if(s.equals(s3) != s.equals(s3))
            System.out.println("equals für Student nicht konsistent");
        if(s.equals(null))
            System.out.println("equals für Student bei null nicht false");
        //hashCode() von Student prüfen
        if(s.hashCode() != s.hashCode())
            System.out.println("Unterschiedlicher Hashcode für gleiche Studenten");
        if(s.hashCode() != s4.hashCode())
            System.out.println("Unterschiedlicher Hashcode für inhaltlich gleiche Studenten");

        //equals() von Student und Person prüfen
        if(s.equals(p) != p.equals(s))
            System.out.println("equals ist nicht symetrisch für Student & Person");
        if(p.equals(p3) && p.equals(s) && !p3.equals(s))
            System.out.println("equals nicht transitiv für Student & Person");
        if(p.equals(p3) && p.equals(s) && !s.equals(p3))
            System.out.println("equals nicht transitiv für Student & Person");
        if(s.equals(p3) && s.equals(p) && !p.equals(p3))
            System.out.println("equals nicht transitiv für Student & Person");
        if(s.equals(p3) && s.equals(p) && !p3.equals(p))
            System.out.println("equals nicht transitiv für Student & Person");
    }

//Lösungsvorschläge: Equals sollte die Methode hashCode() zum Vergleichen benutzen und nicht den Namen / Namen und MatNr
// da Studenten und Personen generell andere hashCodes erzeugen
}
