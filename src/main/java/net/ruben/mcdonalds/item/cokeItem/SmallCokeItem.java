package net.ruben.mcdonalds.item.cokeItem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SmallCokeItem extends Item {
    public SmallCokeItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60, 0));
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

        }
        return stack;
    }
}