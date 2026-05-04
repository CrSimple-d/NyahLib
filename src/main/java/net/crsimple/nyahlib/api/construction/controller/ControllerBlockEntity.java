package net.crsimple.nyahlib.api.construction.controller;

import net.crsimple.nyahlib.api.construction.Construction;
import net.crsimple.nyahlib.api.construction.ConstructionInstance;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class ControllerBlockEntity extends BlockEntity {
    public final Construction type;
//    protected ConstructionInstance<? extends Construction> instance;
//    private int ticks;
//
    public ControllerBlockEntity(Construction construction, BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.type = construction;
    }
//
//    protected ConstructionInstance<? extends Construction> assemble(World world, BlockPos controller) {
//        return ConstructionManager.assemble(type, world, controller);
//    }
//    public void disassemble() {
//        if (isAssembled()) {
//            ConstructionManager.disassemble(instance);
//            this.instance = null;
//        }
//    }
//
//    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
//        if (blockEntity instanceof ControllerBlockEntity c) {
//            c.tick();
//        }
//    }
//
//    @Override
//    public void markRemoved() {
//        super.markRemoved();
//        this.disassemble();
//        ConstructionManager.sendStopRenderPacket(world,pos);
//    }
//
//    protected void tick() {
//        if (!(world.getBlockEntity(pos) instanceof ControllerBlockEntity)) {
//            ConstructionManager.sendStopRenderPacket(world,pos);
//            return;
//        }
//
//        if (ticks % 20 == 0) {
//            if (ConstructionManager.validate(type, world, pos).result()) {
//                if (!isAssembled()) {
//                    this.instance = this.assemble(world,pos);
//                }
//            } else if (isAssembled()) {
//                this.disassemble();
//            }
//            this.ticks = 0;
//        }
//        this.ticks += 1;
//    }
//
//    public boolean isAssembled() {
//        return instance != null;
//    }
//
//    public @Nullable ConstructionInstance<? extends Construction> getInstance() {
//        return instance;
//    }
}
