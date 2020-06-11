package com.example.SBE;

import com.example.SBE.blade.Nihil;
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
    private static List<Blade> bladeList = new ArrayList<>();

    @SubscribeEvent
    public void initBladeList(ScanBladeEvent event) {
        bladeList.add(new Nihil());
    }

    @SubscribeEvent
    public void register(LoadEvent.InitEvent event) {
        bladeList.forEach(BladeRegister::createBlade);
    }

    @SubscribeEvent
    public void recipeRegister(LoadEvent.PostInitEvent event) {
        bladeList.forEach(BladeRegister::createBladeRecipe);
    }

    public static void createBlade(Blade blade) {
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

    public static void createBladeRecipe(Blade blade) {
        Recipe recipe = blade.getRecipe();
        ItemStack newBlade = SlashBlade.getCustomBlade(blade.getName());
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
        SlashBlade.addRecipe(blade.getName(), new BladeRecipe(new ResourceLocation("flammpfeil.slashblade", blade.getName()), newBlade, reqMainBlade, requiredStatefulBlades, recipeParameters.toArray()));
    }
}
