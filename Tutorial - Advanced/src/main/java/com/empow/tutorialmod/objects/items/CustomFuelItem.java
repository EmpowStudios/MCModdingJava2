package com.empow.tutorialmod.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomFuelItem extends Item{
	
	public CustomFuelItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 14400;
	}
}
