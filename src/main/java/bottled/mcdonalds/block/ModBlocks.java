package bottled.mcdonalds.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import bottled.mcdonalds.McDonaldsMod;

import java.util.function.Function;

public class ModBlocks {

    public static final Block MCIUM_BLOCK = registerBlock("mcium_block",
            p -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .sound(SoundType.METAL).strength(55f, 1200f).setId(p)));

    public static final Block RAW_MCIUM_BLOCK = registerBlock("raw_mcium_block",
            p -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)
                    .sound(SoundType.STONE).strength(55f, 1200f).setId(p)));

    public static final Block MCIUM_ORE = registerBlock("mcium_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                            .strength(55f, 1200f).setId(p)));

    public static final Block DEEPSLATE_MCIUM_ORE = registerBlock("deepslate_mcium_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                            .strength(55f, 1200f).setId(p)));

    private static Block registerBlock(String name, Function<ResourceKey<Block>, Block> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        ResourceKey<Item> itemKey   = ResourceKey.create(Registries.ITEM, id);

        Block block = factory.apply(blockKey);
        Registry.register(BuiltInRegistries.ITEM, id,
                new BlockItem(block, new Item.Properties().setId(itemKey)));
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static void registerModBlocks() {
        McDonaldsMod.LOGGER.info("Registering blocks for " + McDonaldsMod.MOD_ID);
    }
}
