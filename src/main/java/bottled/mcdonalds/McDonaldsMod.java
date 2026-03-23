package bottled.mcdonalds;

import bottled.mcdonalds.block.entity.ModBlockEntities;
import bottled.mcdonalds.screen.ModMenuTypes;
import bottled.mcdonalds.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import bottled.mcdonalds.block.ModBlocks;
import bottled.mcdonalds.item.ModItemGroups;
import bottled.mcdonalds.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McDonaldsMod implements ModInitializer {
    public static final String MOD_ID = "mcdonalds";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlockEntities.register();
        ModMenuTypes.register();
        ModItemGroups.registerItemGroups();
        ModOreGeneration.registerOreGeneration();
    }
}

