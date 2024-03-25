package net.ruben.mcdonalds.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BIG_MAC = new FoodComponent.Builder().hunger(8).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0), 0.5f).build();
    public static final FoodComponent SMALL_FRIES = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
    public static final FoodComponent MCNUGGET = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).snack().build();
    public static final FoodComponent CASH_REGISTER = new FoodComponent.Builder().hunger(1).saturationModifier(0f).build();
    public static final FoodComponent HASHBROWN = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build();
    public static final FoodComponent LARGE_COKE = new FoodComponent.Builder().hunger(1).saturationModifier(0f).build();
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();


}
