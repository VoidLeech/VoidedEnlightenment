package com.github.voidleech.voided_enlightenment.recipe;

import com.github.voidleech.voided_enlightenment.registry.VEItemsFD;
import com.github.voidleech.voided_enlightenment.registry.VERecipeSerializersFD;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class KnifeUpgradeRecipe extends CustomRecipe {
    public KnifeUpgradeRecipe(ResourceLocation pId, CraftingBookCategory pCategory) {
        super(pId, pCategory);
    }

    @Override
    public boolean matches(CraftingContainer craftingContainer, Level level) {
        int count = 0;
        for (int i = 0; i < craftingContainer.getContainerSize(); i++){
            if (craftingContainer.getItem(i).getItem() == EnlightenedEndModItems.ADAMANTITE_KNIFE.get()){
                count++;
            }
        }
        return count == 1;
    }

    @Override
    public ItemStack assemble(CraftingContainer craftingContainer, RegistryAccess registryAccess) {
        ItemStack old = ItemStack.EMPTY;
        for (int i = 0; i < craftingContainer.getContainerSize(); i++){
            old = craftingContainer.getItem(i);
            if (old.getItem() == EnlightenedEndModItems.ADAMANTITE_KNIFE.get()){
                break;
            }
        }
        CompoundTag tag = old.getOrCreateTag();
        CompoundTag cap = tag.getCompound("ForgeCaps");
        ItemStack result = new ItemStack(VEItemsFD.ADAMANTITE_KNIFE.get(), 1, cap);
        result.setTag(tag);
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return i * i1 > 0;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return VERecipeSerializersFD.KNIFE_UPGRADE.get();
    }
}
