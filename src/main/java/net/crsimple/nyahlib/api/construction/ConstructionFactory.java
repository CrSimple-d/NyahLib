package net.crsimple.nyahlib.api.construction;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ConstructionFactory<T extends Construction> {
    ConstructionInstance<T> create(T construction, World world, BlockPos pos);
}
