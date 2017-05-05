/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 04.05.17
 */
public class StudentTest {
    public static void main(String[] args) {

        boolean f = false;

        Student s = new Student( "Pablo", 1 );
        Student s2 = new Student( "Paolo", 2 );
        Student s3 = new Student( "Pablo", 3 );
        Student s4 = new Student( "Olga", 1 );
        Student s5 = new Student( "Pablo", 1 );

        if (s.equals( s2 ))
            f = true;
        if (!(s.equals( s ) ))
            f = true;
        if (s2.equals( s3 ))
            f = true;
        if (s3.equals( s ))
            f = true;
        if (s2.equals( s ))
            f = true;
        if (s.equals( s4 ))
            f = true;
        if (s2.equals( s4 ))
            f = true;
        if (s4.equals( s ))
            f = true;
        if (s5.equals( s ))
            f= true;

        if (f)
            System.out.println("Fehler!");

    }
}
