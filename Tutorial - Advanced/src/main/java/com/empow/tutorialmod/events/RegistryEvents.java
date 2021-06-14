package com.empow.tutorialmod.events;

import java.util.function.ToIntFunction;

import org.apache.logging.log4j.Logger;

import com.empow.tutorialmod.Main;
import com.empow.tutorialmod.lists.ArmorList;
import com.empow.tutorialmod.lists.BlockList;
import com.empow.tutorialmod.lists.FluidList;
import com.empow.tutorialmod.lists.ItemList;
import com.empow.tutorialmod.lists.ToolList;
import com.empow.tutorialmod.objects.blocks.CustomOreBlock;
import com.empow.tutorialmod.objects.fluids.FluidOil;
import com.empow.tutorialmod.objects.fluids.FluidOil.Flowing;
import com.empow.tutorialmod.objects.fluids.FluidOil.Source;
import com.empow.tutorialmod.objects.items.CustomFuelItem;
import com.empow.tutorialmod.objects.items.SpecialItem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
	public static final Logger LOGGER = Main.LOGGER;
	public static final String MOD_ID = Main.MOD_ID;

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				/*
				 * Reference of Item created in ItemList.java To add more items to registry,
				 * copy the code:
				 * 
				 */
				ItemList.tutorial_item = new Item(new Item.Properties().tab(ItemGroup.TAB_MISC))
						.setRegistryName(location("tutorial_item")),
				ItemList.unobtainium_shard = new Item(new Item.Properties().tab(ItemGroup.TAB_MISC))
						.setRegistryName(location("unobtainium_shard")),
				ItemList.obtainium_nugget = new Item(new Item.Properties().tab(ItemGroup.TAB_MISC))
						.setRegistryName(location("obtainium_nugget")),
				ItemList.obtainium_ingot = new Item(new Item.Properties().tab(ItemGroup.TAB_MISC))
						.setRegistryName(location("obtainium_ingot")),
				ItemList.tutorial_block = new BlockItem(BlockList.tutorial_block,
						new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
								.setRegistryName(BlockList.tutorial_block.getRegistryName()),
				ItemList.tutorial_slab = new BlockItem(BlockList.tutorial_slab,
						new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
								.setRegistryName(BlockList.tutorial_slab.getRegistryName()),
				ItemList.tutorial_stairs = new BlockItem(BlockList.tutorial_stairs,
						new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
								.setRegistryName(BlockList.tutorial_stairs.getRegistryName()),
				ItemList.tutorial_wall = new BlockItem(BlockList.tutorial_wall,
						new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
								.setRegistryName(BlockList.tutorial_wall.getRegistryName()),

				ItemList.unobtanium_ore = new BlockItem(BlockList.unobtainium_ore,
						new Item.Properties().tab(ItemGroup.TAB_DECORATIONS))
								.setRegistryName(BlockList.unobtainium_ore.getRegistryName()),

				ItemList.obtainium_block = new BlockItem(BlockList.obtainium_block,
						new Item.Properties().tab(ItemGroup.TAB_DECORATIONS))
								.setRegistryName(BlockList.obtainium_block.getRegistryName()),

				ItemList.blazing_sword = new SpecialItem(ToolList.EXAMPLE_SWORD, 5, -1.4f,
						new Item.Properties().tab(ItemGroup.TAB_COMBAT)).setRegistryName(location("blazing_sword")),

				ItemList.concentrated_coal = new CustomFuelItem(new Item.Properties().tab(ItemGroup.TAB_MISC))
						.setRegistryName(location("concentrated_coal")),

				ItemList.tutorial_axe = new AxeItem(ToolList.EXAMPLE_TOOL, 6, -2.5f,
						new Item.Properties().tab(ItemGroup.TAB_TOOLS).addToolType(ToolType.AXE, 4))
								.setRegistryName(location("tutorial_axe")),
				ItemList.tutorial_armor_chestplate = new ArmorItem(ArmorList.EXAMPLE_ARMOR, EquipmentSlotType.CHEST,
						new Item.Properties().tab(ItemGroup.TAB_COMBAT))
								.setRegistryName(location("tutorial_armor_chestplate"))
//				ItemList.oil_bucket = new BucketItem(FluidList.oil,
//						new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1))
//								.setRegistryName(location("oil_bucket"))

		);
	}

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				/*
				 * Reference of Block created in BlockList.java To add more items to registry,
				 * copy the code:
				 * 
				 */
				BlockList.tutorial_block = new Block(Block.Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE)
						.strength(2.0f).sound(SoundType.STONE)).setRegistryName(location("tutorial_block")),
				BlockList.tutorial_slab = new SlabBlock(Block.Properties.copy(BlockList.tutorial_block))
						.setRegistryName(location("tutorial_slab")),
				BlockList.tutorial_stairs = new StairsBlock(BlockList.tutorial_block.defaultBlockState(),
						Block.Properties.copy(BlockList.tutorial_block)).setRegistryName(location("tutorial_stairs")),
				BlockList.tutorial_wall = new WallBlock(Block.Properties.copy(BlockList.tutorial_block))
						.setRegistryName(location("tutorial_wall")),
				BlockList.unobtainium_ore = new CustomOreBlock(Block.Properties.copy(Blocks.ANCIENT_DEBRIS)
						.lightLevel((BlockState lightLevel) -> 10).harvestTool(ToolType.PICKAXE).harvestLevel(5))
								.setRegistryName(location("unobtainium_ore")),
				BlockList.obtainium_block = new CustomOreBlock(Block.Properties.copy(Blocks.NETHERITE_BLOCK)
						.lightLevel((BlockState lightLevel) -> 10).harvestTool(ToolType.PICKAXE).harvestLevel(5))
								.setRegistryName(location("obtainium_block"))

//				BlockList.oil = new FlowingFluidBlock(FluidList.oil, Block.Properties.of(Material.WATER).noDrops())
//						.setRegistryName(FluidList.oil.getRegistryName())

		);
	}

	@SubscribeEvent
	public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
		event.getRegistry().registerAll(

//				FluidList.oil = (Source) new FluidOil.Source().setRegistryName(location("oil")),
//				FluidList.flowing_oil = (Flowing) new FluidOil.Flowing().setRegistryName(location("flowing_oil"))

		);
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MOD_ID, name);
	}
}
