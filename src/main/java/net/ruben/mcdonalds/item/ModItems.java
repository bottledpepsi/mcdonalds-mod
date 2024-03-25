package net.ruben.mcdonalds.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruben.mcdonalds.McdonaldsMod;

public class ModItems {
    public static final Item BIG_MAC = new Item(new Item.Settings().food(ModFoodComponents.BIG_MAC));
    public static final Item SMALL_FRIES = new Item(new Item.Settings().food(ModFoodComponents.SMALL_FRIES));
    public static final Item MCNUGGET = new Item(new Item.Settings().food(ModFoodComponents.MCNUGGET));
    public static final Item CASH_REGISTER = new Item(new Item.Settings().food(ModFoodComponents.CASH_REGISTER));
    public static final Item HASHBROWN = new Item(new Item.Settings().food(ModFoodComponents.HASHBROWN));
    public static final Item LARGE_COKE = new LargeCokeItem(new Item.Settings().food(ModFoodComponents.LARGE_COKE));
    public static final Item APPLE_PIE = new Item(new Item.Settings().food(ModFoodComponents.APPLE_PIE));

    public static void registerModItems() {
        McdonaldsMod.LOGGER.info("Registering Mod Items for " + McdonaldsMod.MOD_ID);

        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "big_mac"), BIG_MAC);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "small_fries"), SMALL_FRIES);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "mcnugget"), MCNUGGET);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "cash_register"), CASH_REGISTER);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "hashbrown"), HASHBROWN);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "large_coke"), LARGE_COKE);
        Registry.register(Registries.ITEM, new Identifier(McdonaldsMod.MOD_ID, "apple_pie"), APPLE_PIE);



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries) -> {
            entries.add(BIG_MAC);
            entries.add(SMALL_FRIES);
            entries.add(MCNUGGET);
            entries.add(CASH_REGISTER);
            entries.add(HASHBROWN);
            entries.add(LARGE_COKE);
            entries.add(APPLE_PIE);


        });
    }
}