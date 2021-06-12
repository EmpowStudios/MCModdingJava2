package com.empow.tutorialmod.lists;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorList implements IArmorMaterial {
	EXAMPLE_ARMOR("blazing", 10, new int[] { 4, 7, 9, 4 }, 1, SoundEvents.ARMOR_EQUIP_GENERIC, 4f, 0.2f,
			() -> Ingredient.of(ItemList.tutorial_item));

	private static final int[] baseDurability = { 128, 144, 160, 112 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] armorVal;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Ingredient repairIngredient;

	ArmorList(String name, int durabilityMultiplier, int[] armorVal, int enchantability, SoundEvent equipSound,
			float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.armorVal = armorVal;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient.get();
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType arg0) {
		// TODO Auto-generated method stub
		return this.armorVal[arg0.getIndex()];
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType arg0) {
		// TODO Auto-generated method stub
		return baseDurability[arg0.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		// TODO Auto-generated method stub
		return this.equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		// TODO Auto-generated method stub
		return this.knockbackResistance;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return this.repairIngredient;
	}

	@Override
	public float getToughness() {
		// TODO Auto-generated method stub
		return this.toughness;
	}

}
