package net.ruben.mcdonalds.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ruben.mcdonalds.McdonaldsMod;
import net.ruben.mcdonalds.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MACCAS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(McdonaldsMod.MOD_ID, "maccas"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.maccas"))
                    .icon(() -> new ItemStack(ModItems.BIG_MAC)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BIG_MAC);
                        entries.add(ModItems.SMALL_FRIES);
                        entries.add(ModItems.MEDIUM_FRIES);
                        entries.add(ModItems.LARGE_FRIES);
                        entries.add(ModItems.SMALL_COKE);
                        entries.add(ModItems.MEDIUM_COKE);
                        entries.add(ModItems.LARGE_COKE);
                        entries.add(ModItems.MCNUGGET);
                        entries.add(ModItems.HASHBROWN);
                        entries.add(ModItems.APPLE_PIE);
                        entries.add(ModItems.MCIUM_PICKAXE);
                        entries.add(ModItems.RAW_MCIUM);
                        entries.add(ModItems.MCIUM_INGOT);


                        entries.add(ModBlocks.MCIUM_BLOCK);
                        entries.add(ModBlocks.RAW_MCIUM_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_MCIUM_ORE);
                        entries.add(ModBlocks.MCIUM_ORE);


                    }).build());


    public static void registerItemGroups() {
        McdonaldsMod.LOGGER.info("Registering Item Groups for " + McdonaldsMod.MOD_ID);
    }
}