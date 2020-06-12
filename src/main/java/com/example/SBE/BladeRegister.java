package com.example.SBE;

import com.example.SBE.blade.nihil.AkaSakura;
import com.example.SBE.blade.nihil.Nihil;
import com.example.SBE.blade.nihil.NihilBx;
import com.example.SBE.recipe.AkaSakuraRecipe;
import com.example.SBE.recipe.NihilBxRecipe;
import com.example.SBE.recipe.NihilRecipe;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;


public class BladeRegister {
    private static List<Blade> bladeList = new LinkedList<>();
    private static List<Recipe> bladeRecipeList = new LinkedList<>();

    @SubscribeEvent
    public void initBlade(LoadEvent.InitEvent event) {
        bladeList.add(new Nihil());
        bladeList.add(new NihilBx());
        bladeList.add(new AkaSakura());
        registerBlades();
    }

    @SubscribeEvent
    public void initBladeRecipe(LoadEvent.PostInitEvent event) {
        bladeRecipeList.add(new NihilRecipe());
        bladeRecipeList.add(new NihilBxRecipe());
        bladeRecipeList.add(new AkaSakuraRecipe());
        registerBladeRecipes();
    }

    private void registerBlades() {
        bladeList.forEach(BladeRegister::createBlade);
    }

    private void registerBladeRecipes() {
        bladeRecipeList.forEach(BladeRegister::createBladeRecipe);
    }

    private static void createBlade(Blade blade) {
        ItemStack customBlade = new ItemStack(SlashBlade.bladeNamed, 1, 0);
        NBTTagCompound tag = new NBTTagCompound();
        customBlade.setTagCompound(tag);
        ItemSlashBladeNamed.CurrentItemName.set(tag, blade.getName());
        ItemSlashBladeNamed.CustomMaxDamage.set(tag, blade.getMaxDamage());
        ItemSlashBladeNamed.IsDefaultBewitched.set(tag, blade.isDefaultBewitched());
        ItemSlashBlade.setBaseAttackModifier(tag, blade.getBaseAttackModifier());
        ItemSlashBlade.TextureName.set(tag, blade.getTexture());
        ItemSlashBlade.ModelName.set(tag, blade.getModel());
        ItemSlashBlade.SpecialAttackType.set(tag, blade.getSpecialAttackType());
        ItemSlashBlade.StandbyRenderType.set(tag, blade.getStandbyRenderType());
        for (EnchantmentEffect enchantment : blade.getEnchantmentEffects()) {
            customBlade.addEnchantment(enchantment.getEnchantmentType(), enchantment.getLevel());
        }
        SlashBlade.registerCustomItemStack(blade.getName(), customBlade);
        ItemSlashBladeNamed.NamedBlades.add(blade.getName());
    }

    private static void createBladeRecipe(Recipe recipe) {
        ItemStack newBlade = recipe.getNewBlade();
        ItemStack reqMainBlade = recipe.getPreviousBlade();
        String[] share = recipe.getShare();
        Map<ItemStack, RecipePos> requiredStatefulBlades = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ItemStack currItem = recipe.getItemMap().get(recipe.getShare()[i].charAt(j));
                if (currItem.getItem() instanceof ItemSlashBlade)
                    requiredStatefulBlades.put(currItem, new RecipePos(i, j));
            }
        }
        List<Object> recipeParameters = new ArrayList<>(Arrays.asList(share));
        Set<Map.Entry<Character, ItemStack>> itemEntrySet = recipe.itemMap.entrySet();
        itemEntrySet.forEach(itemEntry -> {
            recipeParameters.add(itemEntry.getKey());
            recipeParameters.add(itemEntry.getValue());
        });
        SlashBlade.addRecipe(newBlade.getUnlocalizedName(), new BladeRecipe(new ResourceLocation("flammpfeil.slashblade", newBlade.getUnlocalizedName()), newBlade, reqMainBlade, requiredStatefulBlades, recipeParameters.toArray()));
    }
}
