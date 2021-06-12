package com.empow.tutorialmod.lists;

import com.empow.tutorialmod.events.RegistryEvents;
import com.empow.tutorialmod.objects.fluids.FluidOil;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;

public class FluidList {
	public static FluidOil.Source oil;
	public static FluidOil.Flowing flowing_oil;
	
	
	public static class Tags{
		public static final ITag<Fluid> OIL = FluidTags.createOptional(RegistryEvents.location("oil"));
	}
}
