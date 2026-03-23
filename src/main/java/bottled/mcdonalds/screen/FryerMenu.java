package bottled.mcdonalds.screen;

import bottled.mcdonalds.block.entity.FryerBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FryerMenu extends AbstractContainerMenu {

    private final Container container;
    private final ContainerData data;

    // ── Server-side constructor (opened from block entity) ────────────────────
    public FryerMenu(int id, Inventory playerInventory, Container container, ContainerData data) {
        super(ModMenuTypes.FRYER, id);
        this.container = container;
        this.data = data;
        checkContainerSize(container, FryerBlockEntity.NUM_SLOTS);

        // 3 input slots — row across the top
        addSlot(new Slot(container, FryerBlockEntity.SLOT_INPUT_0, 35, 17));
        addSlot(new Slot(container, FryerBlockEntity.SLOT_INPUT_1, 53, 17));
        addSlot(new Slot(container, FryerBlockEntity.SLOT_INPUT_2, 71, 17));

        // Fuel slot
        addSlot(new Slot(container, FryerBlockEntity.SLOT_FUEL, 53, 53));

        // Output slot — cannot place items manually
        addSlot(new Slot(container, FryerBlockEntity.SLOT_OUTPUT, 116, 35) {
            @Override public boolean mayPlace(ItemStack stack) { return false; }
        });

        // Player inventory (3 rows × 9 columns)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        // Player hotbar
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

        addDataSlots(data);
    }

    // ── Client-side constructor (called by MenuType factory via network) ───────
    public FryerMenu(int id, Inventory playerInventory) {
        this(id, playerInventory,
                new SimpleContainer(FryerBlockEntity.NUM_SLOTS),
                new SimpleContainerData(4));
    }

    // ── Data accessors for the screen ─────────────────────────────────────────
    public int getCookingProgress()  { return data.get(0); }
    public int getCookingTotalTime() { return data.get(1); }
    public int getFuelTime()         { return data.get(2); }
    public int getFuelTotalTime()    { return data.get(3); }
    public boolean isBurning()       { return data.get(2) > 0; }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }

    // ── Shift-click logic ─────────────────────────────────────────────────────
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (!slot.hasItem()) return result;

        ItemStack stack = slot.getItem();
        result = stack.copy();

        if (index == FryerBlockEntity.SLOT_OUTPUT) {
            // Output → player inventory
            if (!moveItemStackTo(stack, 5, 41, true)) return ItemStack.EMPTY;
            slot.onQuickCraft(stack, result);
        } else if (index >= 5) {
            // Player inventory → fryer input/fuel slots
            if (!moveItemStackTo(stack, 0, 4, false)) return ItemStack.EMPTY;
        } else {
            // Fryer slots → player inventory
            if (!moveItemStackTo(stack, 5, 41, false)) return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
        else slot.setChanged();

        if (stack.getCount() == result.getCount()) return ItemStack.EMPTY;
        slot.onTake(player, stack);
        return result;
    }
}
