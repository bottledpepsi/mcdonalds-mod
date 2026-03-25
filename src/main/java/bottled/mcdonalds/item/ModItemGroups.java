package bottled.mcdonalds.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStackTemplate;
import bottled.mcdonalds.McDonaldsMod;
import bottled.mcdonalds.block.ModBlocks;

public class ModItemGroups {
    public static final CreativeModeTab MCDONALDS_GROUP = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                    Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "mcdonalds")),
            FabricCreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.mcdonalds"))
                    .icon(() -> new ItemStackTemplate(ModItems.BIG_MAC).create())
                    .displayItems((params, output) -> {
                        // Food
                        output.accept(ModItems.BIG_MAC);
                        output.accept(ModItems.MCNUGGET);
                        output.accept(ModItems.HASHBROWN);
                        output.accept(ModItems.SMALL_FRIES);
                        output.accept(ModItems.MEDIUM_FRIES);
                        output.accept(ModItems.LARGE_FRIES);
                        output.accept(ModItems.SMALL_COKE);
                        output.accept(ModItems.MEDIUM_COKE);
                        output.accept(ModItems.LARGE_COKE);
                        output.accept(ModItems.APPLE_PIE);
                        output.accept(ModItems.MCFLURRY);
                        output.accept(ModItems.MCRIB);
                        output.accept(ModItems.FILET_O_FISH);
                        // Materials
                        output.accept(ModItems.RAW_MCIUM);
                        output.accept(ModItems.MCIUM_INGOT);
                        // Crafting intermediates
                        output.accept(ModItems.POTATO_CUTTER);
                        output.accept(ModItems.RAW_FRIES);
                        output.accept(ModItems.FRIED_POTATOES);
                        output.accept(ModItems.RAW_NUGGET);
                        output.accept(ModItems.RAW_FILET);
                        output.accept(ModItems.RAW_PIE);
                        output.accept(ModBlocks.MCIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MCIUM_ORE);
                        output.accept(ModBlocks.RAW_MCIUM_BLOCK);
                        output.accept(ModBlocks.MCIUM_BLOCK);
                        // Tools
                        output.accept(ModItems.MCIUM_PICKAXE);
                        output.accept(ModItems.MCIUM_SHOVEL);
                        output.accept(ModItems.MCIUM_AXE);
                        output.accept(ModItems.MCIUM_HOE);
                        output.accept(ModItems.MCIUM_SWORD);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        McDonaldsMod.LOGGER.info("Registering item groups for " + McDonaldsMod.MOD_ID);
    }
}
