package net.crsimple.nyahlib.api.construction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ConstructionPatternImpl implements ConstructionPattern {
    private final ConstructionLayer[] layers;

    private <T> ConstructionPatternImpl(Builder<T> builder) {
        this.layers = (ConstructionLayer[]) builder.layers.toArray(Layer[]::new);
    }

    @Override
    public Layer[] layers() {
        return layers;
    }

    public static <T> ConstructionPatternImpl.Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private final List<Layer> layers;

        public Builder() {
            this.layers = new ArrayList<>();
        }

//        public Builder<T> layer(UnaryOperator<ConstructionLayerPattern.Builder<T,BlockPredicate>> builder) {
//            this.layers.add(builder.apply(ConstructionLayerPattern.builder(6)).build());
//            return this;
//        }
    }
}
