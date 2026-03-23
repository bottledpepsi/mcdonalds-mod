package bottled.mcdonalds.block.entity;

import bottled.mcdonalds.McDonaldsMod;
import bottled.mcdonalds.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static BlockEntityType<FryerBlockEntity> FRYER;

    public static void register() {
        FRYER = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "fryer"),
                FabricBlockEntityTypeBuilder.create(FryerBlockEntity::new, ModBlocks.FRYER).build()
        );
        McDonaldsMod.LOGGER.info("Registering block entities for " + McDonaldsMod.MOD_ID);
    }
}
