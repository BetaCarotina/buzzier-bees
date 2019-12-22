package com.bagel.buzzierbees.common.items;

import net.minecraft.item.Food;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{
	public static Item WAX;
	public static Item CRYSTALLIZED_HONEY;
	public static Item BEE_SOUP;
	public static Item CLOVER_HONEY_BOTTLE;
	public static Item FOUR_LEAF_CLOVER;

	public static Food CRYSTALLIZED_HONEY_FOOD;
	public static Food BEE_SOUP_FOOD;
	public static Food CLOVER_HONEY_BOTTLE_FOOD;
	
	static {
		CRYSTALLIZED_HONEY_FOOD = (new Food.Builder()).hunger(1).saturation(1.5F).fastToEat().setAlwaysEdible().effect(new EffectInstance(Effects.SPEED, 160, 1), 0.8F).build();
		BEE_SOUP_FOOD = (new Food.Builder()).hunger(8).saturation(0.6F).setAlwaysEdible().effect(new EffectInstance(Effects.SLOWNESS, 240, 2), 0.5F).build();
		CLOVER_HONEY_BOTTLE_FOOD = (new Food.Builder()).hunger(6).saturation(2.4F).setAlwaysEdible().effect(new EffectInstance(Effects.INSTANT_HEALTH, 20, 1), 1F).build();

	}
	
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
	{
    	CRYSTALLIZED_HONEY = registerItem(new Item(new Item.Properties().food(CRYSTALLIZED_HONEY_FOOD).group(ItemGroup.FOOD)), "crystallized_honey");
        WAX = registerItem(new Item(new Item.Properties().group(ItemGroup.MATERIALS)), "wax");
    	BEE_SOUP = registerItem(new BeeSoupItem(new Item.Properties().maxStackSize(1).food(BEE_SOUP_FOOD).group(ItemGroup.FOOD)), "bee_soup");
    	CLOVER_HONEY_BOTTLE = registerItem(new HoneyBottleItem(new Item.Properties().maxStackSize(16).food(CLOVER_HONEY_BOTTLE_FOOD).group(ItemGroup.FOOD)), "clover_honey_bottle");
		FOUR_LEAF_CLOVER = registerItem(new Item(new Item.Properties().group(ItemGroup.BREWING)), "four_leaf_clover");

	}
	
    public static Item registerItem(Item item, String name)
    {
    	item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}