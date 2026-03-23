package bottled.mcdonalds.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;


public class ModToolMaterial {
    public static final ToolMaterial MCIUM_PICKAXE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1650, 15f, 3.5f, 56, ItemTags.IRON_TOOL_MATERIALS);

    public static final ToolMaterial MCIUM_SWORD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1320, 15f, 3.5f, 56, ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_AXE    = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1560, 15f, 3.5f, 56, ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_SHOVEL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1790, 15f, 3.5f, 56, ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial MCIUM_HOE    = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1130, 15f, 3.5f, 56, ItemTags.IRON_TOOL_MATERIALS);
}
