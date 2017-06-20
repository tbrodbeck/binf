package blatt08;

/**
 * Bei den jährlich stattﬁndenden Hungerspielen treten 24 Tribute aus den 12 Distrikten des ﬁktiven Landes Panem in
 * einer künstlichen Arena gegeneinander an. Bei der 75. Durchführung der Hungerspiele ist die kreisrunde Arena
 * analog zu einer Uhr in zwölf gleich große Bereiche unterteilt. Die Mitte der Arena habe die Position (0,0) und
 * die Arena einen Durchmesser von 3 Meilen. Je nach Uhrzeit wird ein Bereich aktiv und in ihm werden tödliche
 * Fallen freigeschaltet. Beispielsweise ist von 12 bis 1 Uhr der Bereich im Winkel von 0 ◦ bis 30 ◦ aktiv, wobei
 * 0 ◦ die Linie von der Mitte bis zur Position (0,1.5) anzeigt. Ein Tribut wird fast sicher umkommen, wenn er sich
 * in einem aktiven Bereich aufhält oder die Arena verlässt.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 15.06.17
 */
public class Arena {

    /**
     * Schreiben sie eine Java-Klasse Arena, die die Methode int getArea(double x, double y) enthält und zurück
     * gibt, in welchem der zwölf Bereiche sich ein Tribut mit der Position (x,y) beﬁndet. Wenn sich der Tribut
     * außerhalb der Arena beﬁndet, soll die Methode −1 zurück geben. Die Methoden in der Klasse java.lang.Math
     * können dafür nützlich sein.
     *
     * @param x - Koordinate
     * @param y - Koordinate
     * @return int entsprechender Distrikt, der Arena
     */
    public int getArea(double x, double y) {

        double res;

        // when outside
        if ( Math.sqrt( Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2) ) > 3)
            return -1;

        // when x or y = 0
        if ( x == 0 ) {
            if ( y > 0 )
                return 1;
            if ( y < 0 )
                return 7;
        }

        if (y == 0) {
            if (x > 0)
                return 3;
            if (x < 0)
                return 9;
        }

        // position: right
        if ( y > 0 ) {
            // top
            if (x > 0) {
                res = Math.atan2( y, x);
                if (res < Math.PI/6)
                    return 3;
                if (res < Math.PI*2/6)
                    return 2;
                if (res < Math.PI*3/6)
                    return 1;
            }
            // bottom
            if (x < 0) {
                res = Math.atan2( y, -x);
                if (res < Math.PI/6)
                    return 10;
                if (res < Math.PI*2/6)
                    return 11;
                if (res < Math.PI*3/6)
                    return 12;
            }
        }
        // left
        if ( y < 0 ) {
            // top
            if (x > 0) {
                res = Math.atan2( -y, x);
                if (res < Math.PI/6)
                    return 4;
                if (res < Math.PI*2/6)
                    return 5;
                if (res < Math.PI*3/6)
                    return 6;
            }
            //bottom
            if (x < 0) {
                res = Math.atan2( -y, -x);
                if (res < Math.PI/6)
                    return 9;
                if (res < Math.PI*2/6)
                    return 8;
                if (res < Math.PI*3/6)
                    return 7;
            }
        }

        // when x = y = 0
        return -1;
    }
}
