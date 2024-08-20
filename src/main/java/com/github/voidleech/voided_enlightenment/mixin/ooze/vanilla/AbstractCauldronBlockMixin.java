package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.procedures.IsOozeRainProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractCauldronBlock.class)
public class AbstractCauldronBlockMixin extends Block {
    public AbstractCauldronBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    // Cauldrons are weird. This is necessary.
    // Even though they seem to use the tick method to handle dripstone dripping
    // My extra ticking behaviour is never called without this *shrug*
    @Inject(method = "<init>", at = @At("TAIL"))
    void ve$enableRandomTicks(CallbackInfo ci){
        this.isRandomlyTicking = true;

        // Adjust this.properties in case another mod needs this.properties to be accurate
        this.properties.isRandomlyTicking = true;
        // Remake state definition s.t. property changes are reflected in-game
        StateDefinition.Builder<Block, BlockState> builder = new StateDefinition.Builder<>(this);
        this.createBlockStateDefinition(builder);
        this.stateDefinition = builder.create(Block::defaultBlockState, BlockState::new);
        this.registerDefaultState(this.stateDefinition.any());
    }

    @WrapMethod(method = "tick")
    private void ve$fillWithOoze(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource, Operation<Void> original){
        if (level.dimension() == Level.END && IsOozeRainProcedure.execute(level) && randomSource.nextFloat() < 0.05){
            level.setBlock(pos, EnlightenedEndModBlocks.OOZE_CAULDRON_1.get().defaultBlockState(), Block.UPDATE_ALL);
            return; // We've replaced the block
        }
        original.call(state, level, pos, randomSource);
    }
}
