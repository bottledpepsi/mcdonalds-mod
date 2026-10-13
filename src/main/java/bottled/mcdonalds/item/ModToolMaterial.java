package bottled.mcdonalds.item;

import bottled.mcdonalds.McDonaldsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;


public class ModToolMaterial {
    // Shared stats for all Mcium tools.
    // Mining level is expressed via the "incorrect for X tool" tag rather than a
    // numeric arg in the ToolMaterial constructor. Mcium tools can mine everything
    // Netherite tools can. The Mcium ores/blocks themselves require a diamond tool
    // (see data/minecraft/tags/block/needs_diamond_tool.json).
    public static final TagKey<Block> MCIUM_MINING_LEVEL = BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    public static final float MCIUM_MINING_SPEED = 15f;
    public static final float MCIUM_ATTACK_DAMAGE_BONUS = 3.5f;
    public static final int MCIUM_ENCHANTABILITY = 56;

    // Items accepted for repairing Mcium tools (see data/mcdonalds/tags/item/mcium_tool_materials.json).
    public static final TagKey<Item> MCIUM_REPAIR_MATERIALS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(McDonaldsMod.MOD_ID, "mcium_tool_materials"));

    public static final ToolMaterial MCIUM_PICKAXE = material(1650);
    public static final ToolMaterial MCIUM_SWORD = material(1320);
    public static final ToolMaterial MCIUM_AXE = material(1560);
    public static final ToolMaterial MCIUM_SHOVEL = material(1790);
    public static final ToolMaterial MCIUM_HOE = material(1130);

    private static ToolMaterial material(int durability) {
        return new ToolMaterial(
                MCIUM_MINING_LEVEL, durability,
                MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
                MCIUM_REPAIR_MATERIALS);
    }
}
