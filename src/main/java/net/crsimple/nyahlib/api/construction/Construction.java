package net.crsimple.nyahlib.api.construction;

public interface Construction {
    ConstructionPattern pattern();
    <T extends Construction> ConstructionFactory<T> factory();

    default void init() {
        //LibMain.LOGGER.info("Initializing Construction {}",id().toString());
    }
}
