package com.empow.tutorialmod.world.gen;

import com.empow.tutorialmod.lists.BlockList;

import net.minecraft.block.BlockState;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class TutorialGeneration {

	public static void addOres(final BiomeLoadingEvent event) {
		setupOreGeneration(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				BlockList.unobtainium_ore.defaultBlockState(), 20, 5, 80, 10);
	}

	private static void setupOreGeneration(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize,
			int minHeight, int maxHeight, int amount) {
		event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.configured(new OreFeatureConfig(rule, state, veinSize))
						.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.squared().count(amount));
	}
}
