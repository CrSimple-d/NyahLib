package net.crsimple.nyahlib.api.construction;

import net.crsimple.nyahlib.api.construction.controller.ControllerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;

public interface BlockPredicate {
//    BlockResult test(World w, BlockPos pos);
//
//    static BlockPredicate any() {
//        return ((w, pos) -> BlockResult.isNotMissing(!w.getBlockState(pos).isAir()));
//    }
//    static BlockPredicate anyIncludeAir() {
//        return (w, pos) -> BlockResult.SUCCESS;
//    }
//    static BlockPredicate air() {
//        return ((w, pos) -> BlockResult.isNotMissing(w.getBlockState(pos).isAir()));
//    }
//    static BlockPredicate block(Block block) {
//        return ((w, pos) -> {
//            BlockState state = w.getBlockState(pos);
//            return BlockResult.isNotWrong(state,state.isOf(block));
//        });
//    }
//    static BlockPredicate tag(TagKey<Block> tag) {
//        return ((w, pos) -> {
//            BlockState state = w.getBlockState(pos);
//            return BlockResult.isNotWrong(state,state.isIn(tag));
//        });
//    }
//    static BlockPredicate blocks(Block... blocks) {
//        return ((w, pos) -> {
//            BlockState state = w.getBlockState(pos);
//            return BlockResult.isNotWrong(state,Arrays.stream(blocks).anyMatch(state::isOf));
//        });
//    }
//    @SafeVarargs
//    static BlockPredicate tags(TagKey<Block>... tags) {
//        return ((w, pos) -> {
//            BlockState state = w.getBlockState(pos);
//            return BlockResult.isNotWrong(state,Arrays.stream(tags).anyMatch(state::isIn));
//        });
//    }
//    static BlockPredicate controller(ControllerBlock b) {
//        return new ControllerBlockPredicate(b);
//    }
//
//    class ControllerBlockPredicate implements BlockPredicate {
//        private final ControllerBlock controller;
//
//        public ControllerBlockPredicate(ControllerBlock controller) {
//            this.controller = controller;
//        }
//
//        @Override
//        public BlockResult test(World w, BlockPos pos) {
//            return BlockPredicate.block(controller).test(w, pos);
//        }
//    }
}
