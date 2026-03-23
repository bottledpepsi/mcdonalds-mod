package bottled.mcdonalds.block.entity;

import bottled.mcdonalds.item.ModItems;
import bottled.mcdonalds.screen.FryerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.HashMap;
import java.util.Map;

public class FryerBlockEntity extends BaseContainerBlockEntity {

    public static final int SLOT_INPUT_0 = 0;
    public static final int SLOT_INPUT_1 = 1;
    public static final int SLOT_INPUT_2 = 2;
    public static final int SLOT_FUEL    = 3;
    public static final int SLOT_OUTPUT  = 4;
    public static final int NUM_SLOTS    = 5;
    public static final int COOKING_TIME = 200;

    private NonNullList<ItemStack> items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);

    int cookingProgress  = 0;
    int cookingTotalTime = COOKING_TIME;
    int fuelTime         = 0;
    int fuelTotalTime    = 0;

    final ContainerData dataAccess = new ContainerData() {
        @Override public int get(int i) {
            return switch (i) {
                case 0 -> cookingProgress;
                case 1 -> cookingTotalTime;
                case 2 -> fuelTime;
                case 3 -> fuelTotalTime;
                default -> 0;
            };
        }
        @Override public void set(int i, int v) {
            switch (i) {
                case 0 -> cookingProgress  = v;
                case 1 -> cookingTotalTime = v;
                case 2 -> fuelTime         = v;
                case 3 -> fuelTotalTime    = v;
            }
        }
        @Override public int getCount() { return 4; }
    };

    private static final Map<Item, ItemStack> RECIPES = new HashMap<>();
    static {
        RECIPES.put(Items.POTATO,  new ItemStack(ModItems.SMALL_FRIES));
        RECIPES.put(Items.CHICKEN, new ItemStack(ModItems.MCNUGGET, 8));
        RECIPES.put(Items.COD,     new ItemStack(ModItems.FILET_O_FISH));
        RECIPES.put(Items.SALMON,  new ItemStack(ModItems.FILET_O_FISH));
    }

    public FryerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FRYER, pos, state);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.mcdonalds.fryer");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new FryerMenu(id, inventory, this, dataAccess);
    }

    @Override
    public int getContainerSize() { return NUM_SLOTS; }

    @Override
    protected NonNullList<ItemStack> getItems() { return items; }

    @Override
    protected void setItems(NonNullList<ItemStack> items) { this.items = items; }

    @Override
    public boolean stillValid(Player player) {
        if (level == null) return false;
        return level.getBlockEntity(worldPosition) == this
                && player.distanceToSqr(worldPosition.getX() + 0.5,
                                        worldPosition.getY() + 0.5,
                                        worldPosition.getZ() + 0.5) <= 64.0;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, FryerBlockEntity entity) {
        boolean changed = false;

        if (entity.fuelTime > 0) {
            entity.fuelTime--;
            changed = true;
        }

        int activeSlot = -1;
        ItemStack activeResult = ItemStack.EMPTY;
        for (int i = 0; i < 3; i++) {
            ItemStack input = entity.items.get(i);
            if (input.isEmpty()) continue;
            ItemStack result = RECIPES.get(input.getItem());
            if (result == null) continue;
            ItemStack output = entity.items.get(SLOT_OUTPUT);
            boolean outputOk = output.isEmpty()
                    || (ItemStack.isSameItem(output, result)
                        && output.getCount() + result.getCount() <= output.getMaxStackSize());
            if (outputOk) { activeSlot = i; activeResult = result; break; }
        }

        if (activeSlot >= 0) {
            if (entity.fuelTime <= 0) {
                ItemStack fuel = entity.items.get(SLOT_FUEL);
                int burnTime = level.fuelValues().burnDuration(fuel);
                if (burnTime > 0) {
                    entity.fuelTotalTime = burnTime;
                    entity.fuelTime = burnTime;
                    fuel.shrink(1);
                    changed = true;
                }
            }
            if (entity.fuelTime > 0) {
                entity.cookingProgress++;
                changed = true;
                if (entity.cookingProgress >= entity.cookingTotalTime) {
                    entity.cookingProgress = 0;
                    entity.items.get(activeSlot).shrink(1);
                    ItemStack output = entity.items.get(SLOT_OUTPUT);
                    if (output.isEmpty()) entity.items.set(SLOT_OUTPUT, activeResult.copy());
                    else output.grow(activeResult.getCount());
                }
            } else if (entity.cookingProgress > 0) {
                entity.cookingProgress = Math.max(0, entity.cookingProgress - 2);
                changed = true;
            }
        } else if (entity.cookingProgress > 0) {
            entity.cookingProgress = Math.max(0, entity.cookingProgress - 2);
            changed = true;
        }

        if (changed) entity.setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, items);
        output.putInt("CookingProgress", cookingProgress);
        output.putInt("FuelTime",        fuelTime);
        output.putInt("FuelTotalTime",   fuelTotalTime);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(input, items);
        cookingProgress = input.getIntOr("CookingProgress", 0);
        fuelTime        = input.getIntOr("FuelTime", 0);
        fuelTotalTime   = input.getIntOr("FuelTotalTime", 0);
    }
}
