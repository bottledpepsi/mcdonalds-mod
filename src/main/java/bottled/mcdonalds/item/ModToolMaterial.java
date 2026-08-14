package bottled.mcdonalds.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;


public class ModToolMaterial {
    // Shared stats for all Mcium tools. Named here instead of passing unlabeled
    // positional args to the ToolMaterial constructor.
    // Mining level is expressed via the "incorrect for X tool" tag rather than a
    // numeric arg in this ToolMaterial constructor; Mcium sits above Netherite.
    public static final TagKey<Block> MCIUM_MINING_LEVEL = BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    public static final float MCIUM_MINING_SPEED        = 15f;
    public static final float MCIUM_ATTACK_DAMAGE_BONUS = 3.5f;
    public static final int   MCIUM_ENCHANTABILITY      = 56;

    public static final ToolMaterial MCIUM_PICKAXE = new ToolMaterial(
            MCIUM_MINING_LEVEL, 1650,
            MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
            ItemTags.IRON_TOOL_MATERIALS);

    public static final ToolMaterial MCIUM_SWORD = new ToolMaterial(
            MCIUM_MINING_LEVEL, 1320,
            MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
            ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_AXE = new ToolMaterial(
            MCIUM_MINING_LEVEL, 1560,
            MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
            ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_SHOVEL = new ToolMaterial(
            MCIUM_MINING_LEVEL, 1790,
            MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
            ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_HOE = new ToolMaterial(
            MCIUM_MINING_LEVEL, 1130,
            MCIUM_MINING_SPEED, MCIUM_ATTACK_DAMAGE_BONUS, MCIUM_ENCHANTABILITY,
            ItemTags.IRON_TOOL_MATERIALS);
}
