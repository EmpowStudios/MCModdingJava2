package com.empow.tutorialmod.lists;

import java.util.function.Supplier;
//import com.empow.tutorialmod.events.RegistryEvents;
import net.minecraft.item.IItemTier;
//import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public enum ToolList implements IItemTier {
	
	EXAMPLE_SWORD(4, 3000, 12f, 2f, 17, () -> Ingredient.of(ItemList.tutorial_item)),
	EXAMPLE_TOOL(4, 2100, 10f, 1.8f, 17, () -> Ingredient.of(ItemList.tutorial_item)); 

	
	
	
	
	/*
	 *PLEASE DO NOT EDIT OR CHANGE ANYTHING BELOW THIS LINE
	 * UNLESS YOU KNOW WHAT YOU'RE DOING
	 */
	
	
	private final int level; //Harvest Level
	private final int maxUses; //Durability
	private final float speed; //Efficiency
	private final float attackDamage; //Attack Damage
	private final int enchantability; //Enchanting
	private final Ingredient repairMaterial; //Items for repairing
	
	ToolList(int level, int maxUses, float speed, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.level = level;
		this.maxUses = maxUses;
		this.speed = speed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial.get();
	}
	
	@Override
	public float getAttackDamageBonus() {
		// TODO Auto-generated method stub
		return this.attackDamage;
	}
	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}
	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return this.repairMaterial;
	}
	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	@Override
	public int getUses() {
		// TODO Auto-generated method stub
		return this.maxUses;
	}

	
}