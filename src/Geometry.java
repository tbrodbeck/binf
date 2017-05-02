//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public abstract class Geometry {
    private int dimension;

    public Geometry(int dimension) {
        if(dimension < 2) {
            throw new RuntimeException("dimension is < 2");
        } else {
            this.dimension = dimension;
        }
    }

    public int dimensions() {
        return this.dimension;
    }

    public abstract double volume();

    public abstract Geometry encapsulate(Geometry var1);
}
