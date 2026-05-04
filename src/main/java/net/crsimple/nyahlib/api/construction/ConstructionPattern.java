package net.crsimple.nyahlib.api.construction;

public interface ConstructionPattern {
    Layer[] layers();

    default Layer getLayer(int i) {
        return layers()[i];
    }
}
