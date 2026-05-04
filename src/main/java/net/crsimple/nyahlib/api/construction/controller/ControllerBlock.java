package net.crsimple.nyahlib.api.construction.controller;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class ControllerBlock extends BlockWithEntity {
    protected ControllerBlock(Settings settings) {
        super(settings);
    }

//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
//        if (!(world.getBlockEntity(pos) instanceof ControllerBlockEntity controller)) return;
//        ModMain.LOGGER.info("Assembling");
//        controller.assemble(world,pos);
//    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

//    @Override
//    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        return world.isClient?null:checkType(type,getBlockEntityType(),ControllerBlockEntity::tick);
//    }

    public abstract BlockEntityType<? extends BlockEntity> getBlockEntityType();
}
