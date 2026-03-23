package bottled.mcdonalds.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import bottled.mcdonalds.McDonaldsMod;

public class ModOreGeneration {
    public static void registerOreGeneration() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(
                        Registries.PLACED_FEATURE,
                        Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "mcium_ore")
                )
        );
    }
}
