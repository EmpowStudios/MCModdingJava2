package com.empow.tutorialmod.lists;

import com.empow.tutorialmod.Main;
import com.empow.tutorialmod.objects.items.SpecialItem;

import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {
	/*
	 * You can change tutorial_sword to be any name. No space, use underscore (_)
	 * between words Example: awesome_sword, sword_better_than_netherite To add more
	 * items there should be a comma (,) between each item
	 */
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

	public static Item tutorial_item,

			tutorial_block, tutorial_slab, tutorial_stairs, tutorial_wall,

			unobtanium_ore, unobtainium_shard, obtainium_nugget, obtainium_ingot, obtainium_block,

			tutorial_sword, tutorial_axe, tutorial_pickaxe, tutorial_hoe, tutorial_shovel, tutorial_armor_helmet,
			tutorial_armor_chestplate, tutorial_armor_leggings, tutorial_armor_boots,
	
			oil_bucket;
	
	/*
	 * Once you named your sword please save file before moving on.
	 */
}
