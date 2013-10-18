package com.cyrus.sandbox.attributes;

// Should be used to represent velocity
public class Vector {
    private Vertex origin = new Vertex();
    private Vertex heading = new Vertex();

    public Vector(Vertex origin, Vertex heading) {
        this.origin = origin;
        this.heading = heading;
    }

    public Vector() {}

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getHeading() {
        return heading;
    }

    public void setHeading(Vertex heading) {
        this.heading = heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (heading != null ? !heading.equals(vector.heading) : vector.heading != null)
            return false;
        if (origin != null ? !origin.equals(vector.origin) : vector.origin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        return result;
    }
}
