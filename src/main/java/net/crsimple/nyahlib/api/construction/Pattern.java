package net.crsimple.nyahlib.api.construction;

public abstract class Pattern<T> {
    protected final T[][] pattern;

    protected Pattern(T[][] pattern) {
        this.pattern = pattern;
    }


}
