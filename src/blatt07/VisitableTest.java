package blatt07;

/**
 * Testen Sie Ihre Implementierung durch mindestens eine
 * Visitor-Implementierung und lassen Sie das Testprogramm prüfen,
 * ob auch wirklich alle Elemente durchlaufen wurden.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 08.06.17
 */
public class VisitableTest {
    public static void main(String[] args) {

        MyList<Integer> l = new MyList<Integer>();
        l.add( 5 );
        l.add( 6 );
        l.add( 6 );
        l.add( 6 );
        l.add( 100 );

        System.out.println("Visitor der die ganze Liste durchläuft:");
        Visitor<Integer> v1 = new Visitor<Integer>() {
            /**
             * Called by the method {@link Visitable#accept(Visitor)} for every element it
             * visits. The visiting can be stopped by returning <code>false</code>.
             *
             * @param o the element that has just been visited by
             *          {@link Visitable#accept(Visitor)}
             * @return <code>true</code> if the visit should be continued until every
             * element in a {@link Visitable} has been visited once, else
             * <code>false</code>
             */
            @Override
            public boolean visit(Integer o) {
                System.out.println(o);
                return true;
            }
        };

        l.accept( v1 );

        System.out.println();
        System.out.println("Visitor der nur das erste Element anschaut:");
        Visitor<Integer> v2 = new Visitor<Integer>() {
            /**
             * Called by the method {@link Visitable#accept(Visitor)} for every element it
             * visits. The visiting can be stopped by returning <code>false</code>.
             *
             * @param o the element that has just been visited by
             *          {@link Visitable#accept(Visitor)}
             * @return <code>true</code> if the visit should be continued until every
             * element in a {@link Visitable} has been visited once, else
             * <code>false</code>
             */
            @Override
            public boolean visit(Integer o) {
                System.out.println(o);
                return false;
            }
        };
        l.accept( v2 );

        System.out.println();
        System.out.println("Test fertig");
    }
}
