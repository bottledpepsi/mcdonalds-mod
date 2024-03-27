package net.ruben.mcdonalds.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruben.mcdonalds.McdonaldsMod;
import net.ruben.mcdonalds.item.cokeItem.LargeCokeItem;
import net.ruben.mcdonalds.item.cokeItem.MediumCokeItem;
import net.ruben.mcdonalds.item.cokeItem.SmallCokeItem;

public class ModItems {
    public static final Item BIG_MAC = registerItem("big_mac", new Item(new FabricItemSettings().food(ModFoodComponents.BIG_MAC)));
    public static final Item SMALL_FRIES = registerItem("small_fries", new Item(new FabricItemSettings().food(ModFoodComponents.SMALL_FRIES)));
    public static final Item MEDIUM_FRIES = registerItem("medium_fries", new Item(new FabricItemSettings().food(ModFoodComponents.MEDIUM_FRIES)));
    public static final Item LARGE_FRIES = registerItem("large_fries", new Item(new FabricItemSettings().food(ModFoodComponents.LARGE_FRIES)));
    public static final Item MCNUGGET = registerItem("mcnugget", new Item(new FabricItemSettings().food(ModFoodComponents.MCNUGGET)));
    public static final Item HASHBROWN = registerItem("hashbrown", new Item(new FabricItemSettings().food(ModFoodComponents.HASHBROWN)));
    public static final Item SMALL_COKE = registerItem("small_coke", new SmallCokeItem(new FabricItemSettings().food(ModFoodComponents.SMALL_COKE)));
    public static final Item MEDIUM_COKE = registerItem("medium_coke", new MediumCokeItem(new FabricItemSettings().food(ModFoodComponents.MEDIUM_COKE)));
    public static final Item LARGE_COKE = registerItem("large_coke", new LargeCokeItem(new FabricItemSettings().food(ModFoodComponents.LARGE_COKE)));
    public static final Item APPLE_PIE = registerItem("apple_pie", new Item(new FabricItemSettings().food(ModFoodComponents.APPLE_PIE)));
    public static final Item MCIUM_PICKAXE = registerItem("mcium_pickaxe", new PickaxeItem(ModToolMaterial.MCIUM_INGOT, 1, 0.1f, new FabricItemSettings()));
    public static final Item RAW_MCIUM = registerItem("raw_mcium", new Item(new FabricItemSettings()));
    public static final Item MCIUM_INGOT = registerItem("mcium_ingot", new Item(new FabricItemSettings()));

    public static void registerModItems() {
        McdonaldsMod.LOGGER.info("Registering Mod Items for " + McdonaldsMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries) -> {

        });
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, name), item);
    }
}
