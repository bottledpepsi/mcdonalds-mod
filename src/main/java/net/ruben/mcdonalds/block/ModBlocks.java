package net.ruben.mcdonalds.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ruben.mcdonalds.McdonaldsMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block MCIUM_BLOCK = registerBlock("mcium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_MCIUM_BLOCK = registerBlock("raw_mcium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)));

    public static final Block MCIUM_ORE = registerBlock("mcium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(2f)));
    public static final Block DEEPSLATE_MCIUM_ORE = registerBlock("deepslate_mcium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4f)));
    public static final Block NETHER_MCIUM_ORE = registerBlock("nether_mcium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.GILDED_BLACKSTONE).strength(1.5f)));
    public static final Block END_STONE_MCIUM_ORE = registerBlock("end_stone_mcium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 7), FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f)));

    public static final Block MCIUM_STAIRS = registerBlock("mcium_stairs",
            new StairsBlock(ModBlocks.MCIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MCIUM_SLAB = registerBlock("mcium_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MCIUM_BUTTON = registerBlock("mcium_button",
            new ButtonBlock(BlockSetType.IRON, 10, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block MCIUM_PRESSURE_PLATE = registerBlock("mcium_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block MCIUM_DOOR = registerBlock("mcium_door",
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block MCIUM_TRAPDOOR = registerBlock("mcium_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(McdonaldsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        McdonaldsMod.LOGGER.info("Registering ModBlocks for " + McdonaldsMod.MOD_ID);
    }
}