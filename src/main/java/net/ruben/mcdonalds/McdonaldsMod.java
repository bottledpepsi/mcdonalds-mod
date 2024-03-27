package net.ruben.mcdonalds;

import net.fabricmc.api.ModInitializer;
import net.ruben.mcdonalds.item.ModItems;
import net.ruben.mcdonalds.block.ModBlocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McdonaldsMod implements ModInitializer {
    public static final String MOD_ID = "mcdonalds";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();


    }

}
