package net.crsimple.nyahlib.api.construction;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public interface ConstructionInstance<T extends Construction> {
    T type();
    BlockPos controller();
    World world();

    void onAssemble();
    void onDisassemble();

    UUID id();
}
