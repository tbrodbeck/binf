/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 04.05.17
 */
public class PersonTest {
    public static void main(String[] args) {

        Person p = new Person( "Pablo" );
        Person p2 = new Person( "Olga" );
        Person p3 = new Person( "Ole" );
        Person p4 = new Person( "Pablo" );

        if (p.equals( p2 ))
            System.out.println("Fehler_1");
        if (!(p.equals( p ) ))
            System.out.println("Fehler_2");
        if (p2.equals( p3 ))
            System.out.println("Fehler_3");
        if (p3.equals( p ))
            System.out.println("Fehler_4");
        if (p2.equals( p ))
            System.out.println("Fehler_5");
        if (p.equals( p4 ))
            System.out.println("Fehler_6");

    }
}
