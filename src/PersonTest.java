/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 04.05.17
 */
public class PersonTest {
    public static void main(String[] args) {

        boolean f = false;

        Person p = new Person( "Pablo" );
        Person p2 = new Person( "Olga" );
        Person p3 = new Person( "Ole" );
        Person p4 = new Person( "Pablo" );

        if (p.equals( p2 ))
            f = true;
        if (!(p.equals( p ) ))
            f = true;
        if (p2.equals( p3 ))
            f = true;
        if (p3.equals( p ))
            f = true;
        if (p2.equals( p ))
            f = true;
        if (p.equals( p4 ))
            f = true;

        if (f)
            System.out.println("Fehler!");

    }
}
