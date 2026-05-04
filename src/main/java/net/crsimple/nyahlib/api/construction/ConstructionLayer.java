package net.crsimple.nyahlib.api.construction;

public interface ConstructionLayer extends Layer {
    <K,V> PatternWithKeys<K,V> patternWithKeys();

    @SuppressWarnings("unchecked")
    @Override default <T> Pattern<T> pattern() {
        return (Pattern<T>) patternWithKeys();
    }
}
