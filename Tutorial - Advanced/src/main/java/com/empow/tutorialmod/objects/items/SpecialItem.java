package com.empow.tutorialmod.objects.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
public class SpecialItem extends SwordItem{

	
	public SpecialItem(IItemTier tier, int attack, float speed, Properties properties) {
		super(tier, attack, speed, properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.appendHoverText(stack, world, tooltip, flagIn);
//		tooltip.add(new StringTextComponent("Test"));
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_CONTROL)) {
			tooltip.add(new StringTextComponent("Advanced Tooltip"));
		}
		else {
			tooltip.add(new TranslationTextComponent("tooltip.empow_tutorial.hold_shift"));
		}
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		//new EffectInstance(effect, ticks, level)
		if(entity instanceof MobEntity) {
			entity.setSecondsOnFire(5);
			player.addEffect(new EffectInstance(Effects.GLOWING, 100, 5));
			((MobEntity) entity).addEffect(new EffectInstance(Effects.LEVITATION, 100, 2));
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}
