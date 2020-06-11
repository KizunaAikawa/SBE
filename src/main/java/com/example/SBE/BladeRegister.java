package com.example.SBE;

import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;


public class BladeRegister {

    @SubscribeEvent
    public void register(LoadEvent.InitEvent event) {
        Blade nihil = new Blade();
        nihil.setName("flammpfeil.slashblade.named.nihil");
        nihil.setMaxDamage(45);
        nihil.setDefaultBewitched(true);
        nihil.setBaseAttackModifier(10.0F);
        nihil.setTexture("named/sange/white");
        nihil.setModel("named/sange/white");
        nihil.setSpecialAttackType(2);
        nihil.setStandbyRenderType(1);
        List<EnchantmentEffect> enchantmentEffects = new ArrayList<>();
        enchantmentEffects.add(new EnchantmentEffect(Enchantments.UNBREAKING, 10));
        enchantmentEffects.add(new EnchantmentEffect(Enchantments.SHARPNESS, 10));
        nihil.setEnchantmentEffects(enchantmentEffects);
        nihil.setDefaultBewitched(true);
        createBlade(nihil);
    }

    @SubscribeEvent
    public void recipeRegister(LoadEvent.PostInitEvent event) {
        Blade nihil = new Blade();
        nihil.setName("flammpfeil.slashblade.named.nihil");
        Recipe recipe = new Recipe();
        ItemStack sphere = SlashBlade.findItemStack("flammpfeil.slashblade", "sphere_bladesoul", 1);
        ItemStack ingot = SlashBlade.findItemStack("flammpfeil.slashblade", "ingot_bladesoul", 1);
        ItemStack previousBlade = new ItemStack(SlashBlade.weapon);
        Map<Character, ItemStack> nihiItemMap = new HashMap<>();
        nihiItemMap.put('S', sphere);
        nihiItemMap.put('I', ingot);
        nihiItemMap.put('B', previousBlade);
        String[] share = {"SIS", "IBI", "SIS"};
        recipe.setItemMap(nihiItemMap);
        recipe.setShare(share);
        recipe.setPreviousBlade(previousBlade);
        nihil.setRecipe(recipe);
        createBladeRecipe(nihil);
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
