package bottled.mcdonalds.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodComponents {

    public static final Consumable BIG_MAC_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SLOWNESS, 200, 0), 0.5f))
            .consumeSeconds(3)
            .build();

    // Drink sound
    public static final Consumable COKE_CONSUMABLE = Consumables.defaultFood()
            .sound(SoundEvents.GENERIC_DRINK)
            .hasConsumeParticles(false)
            .build();

    // McFlurry: brain freeze = Slowness II, sugar rush = Regeneration I // Gulpy sound
    public static final Consumable MCFLURRY_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SLOWNESS, 100, 1), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0f))
            .sound(SoundEvents.HONEY_DRINK)
            .build();

    // McRib: Strength II for 10 seconds (200 ticks)
    public static final Consumable MCRIB_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.STRENGTH, 200, 1), 1.0f))
            .build();

    // Filet-O-Fish: Water Breathing 30s (600t) + Dolphins Grace 10s (200t)
    public static final Consumable FILET_O_FISH_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0), 1.0f))
            .build();

    public static final Consumable MCNUGGET_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.75F)
            .build();

    public static final FoodProperties BIG_MAC       = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build();
    public static final FoodProperties SMALL_FRIES   = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodProperties MEDIUM_FRIES  = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build();
    public static final FoodProperties LARGE_FRIES   = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodProperties MCNUGGET      = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().build();
    public static final FoodProperties HASHBROWN     = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build();
    public static final FoodProperties SMALL_COKE    = new FoodProperties.Builder().nutrition(0).saturationModifier(0.1f).alwaysEdible().build();
    public static final FoodProperties MEDIUM_COKE   = new FoodProperties.Builder().nutrition(0).saturationModifier(0.2f).alwaysEdible().build();
    public static final FoodProperties LARGE_COKE    = new FoodProperties.Builder().nutrition(0).saturationModifier(0.3f).alwaysEdible().build();
    public static final FoodProperties APPLE_PIE     = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodProperties MCFLURRY      = new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).build();
    public static final FoodProperties MCRIB         = new FoodProperties.Builder().nutrition(9).saturationModifier(0.6f).build();
    public static final FoodProperties FILET_O_FISH  = new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).build();
}
