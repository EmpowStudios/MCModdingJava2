package com.empow.tutorialmod.objects.fluids;

import com.empow.tutorialmod.events.RegistryEvents;
import com.empow.tutorialmod.lists.BlockList;
import com.empow.tutorialmod.lists.FluidList;
import com.empow.tutorialmod.lists.ItemList;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public class FluidOil extends FlowingFluid {

	@Override
	public Fluid getFlowing() {
		return FluidList.flowing_oil;
	}

	public static int getLegacyLevel(FluidState state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fluid getSource() {
		return FluidList.oil;
	}

	@Override
	protected boolean canConvertToSource() {
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getSlopeFindDistance(IWorldReader p_185698_1_) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	protected int getDropOff(IWorldReader p_204528_1_) {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Item getBucket() {
		// TODO Auto-generated method stub
		return ItemList.oil_bucket;
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, IBlockReader world, BlockPos pos, Fluid fluid,
			Direction direction) {
		// TODO Auto-generated method stub
		return direction == Direction.DOWN && !fluid.is(FluidList.Tags.OIL);
	}

	@Override
	public int getTickDelay(IWorldReader p_205569_1_) {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	protected float getExplosionResistance() {
		// TODO Auto-generated method stub
		return 100.0f;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState state) {
		// TODO Auto-generated method stub
		return BlockList.oil.defaultBlockState().cycle(FlowingFluidBlock.LEVEL);
	}

	@Override
	public boolean isSource(FluidState p_207193_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAmount(FluidState p_207192_1_) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isSame(Fluid fluid) {
		// TODO Auto-generated method stub
		return fluid == FluidList.oil || fluid == FluidList.flowing_oil;
	}
	
	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(RegistryEvents.location("block/oil_still"), RegistryEvents.location("block/oil_still"))
		.translationKey("block.empowtutorial.oil").build(this);
	}
	
	public static class Flowing extends FluidOil {
		
		@Override
		protected void createFluidStateDefinition(Builder<Fluid, FluidState> builder) {
			// TODO Auto-generated method stub
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}
		
		@Override
		public boolean isSource(FluidState state) {
			// TODO Auto-generated method stub
			return false;
		}
		public static int getLegacyLevel(FluidState state) {
			return state.getValue(FluidOil.LEVEL);
		}
		
	}
	
	public static class Source extends FluidOil {
		@Override
		public boolean isSource(FluidState state) {
			// TODO Auto-generated method stub
			return true;
		}
		
		public static int getLegacyLevel(FluidState state) {
			return 8;
		}
		
	}

	
}
