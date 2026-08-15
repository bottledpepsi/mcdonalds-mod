package bottled.mcdonalds.item.cokeItem;

import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;

/**
 * A drinkable Coke item that grants Speed for a configurable duration and amplifier.
 * Replaces the previous SmallCokeItem/MediumCokeItem/LargeCokeItem duplicates.
 */
public class CokeItem extends Item {
    private final int effectDuration;
    private final int effectAmplifier;

    public CokeItem(Item.Properties properties, int effectDuration, int effectAmplifier) {
        super(properties);
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        if (user instanceof Player player) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            }
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, effectDuration, effectAmplifier));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return stack;
    }
}
