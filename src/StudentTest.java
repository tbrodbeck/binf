/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 04.05.17
 */
public class StudentTest {
    public static void main(String[] args) {

        int f = 1;

        Student s = new Student( "Pablo", 1 );
        Student s2 = new Student( "Paolo", 2 );
        Student s3 = new Student( "Pablo", 3 );
        Student s4 = new Student( "Olga", 1 );
        Student s5 = new Student( "Pablo", 1 );
        
        if (s.equals( s2 ))
            System.out.println("Fehler_1");
        if (!(s.equals( s ) ))
            System.out.println("Fehler_2");
        if (s2.equals( s3 ))
            System.out.println("Fehler_3");
        if (s3.equals( s ))
            System.out.println("Fehler_4");
        if (s2.equals( s ))
            System.out.println("Fehler_5");
        if (s.equals( s4 ))
            System.out.println("Fehler_6");
        if (s2.equals( s4 ))
            System.out.println("Fehler_7");
        if (s4.equals( s ))
            System.out.println("Fehler_8");
        if (s5.equals( s ))
            System.out.println("Fehler_9");

    }
}
