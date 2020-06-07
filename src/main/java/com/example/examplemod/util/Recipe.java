package com.example.examplemod.util;

import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.TagPropertyAccessor;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Recipe extends ShapedOreRecipe {
    private ItemStack requiredStateBlade;

    public Recipe(ResourceLocation group, ItemStack result, ItemStack requiredStateBlade, Object... recipe) {
        super(group, result, recipe);
        this.requiredStateBlade = ItemStack.EMPTY;
        this.requiredStateBlade = requiredStateBlade;
    }

    public boolean matches(InventoryCrafting inv, World world) {
        boolean result = super.matches(inv, world);
        if (result && !this.requiredStateBlade.isEmpty()) {
            this.requiredStateBlade.setItemDamage(32767);
            for (int x = 0; x < inv.getSizeInventory(); x++) {
                ItemStack blade = inv.getStackInSlot(x);
                if (!blade.isEmpty() && blade.getItem() instanceof ItemSlashBlade && blade.hasTagCompound()) {
                    //附魔等级检查
                    Set<Map.Entry<Enchantment, Integer>> oldEnchantments = EnchantmentHelper.getEnchantments(this.requiredStateBlade).entrySet();
                    for (Map.Entry<Enchantment, Integer> enchantmentEffect : oldEnchantments) {
                        int level = EnchantmentHelper.getEnchantmentLevel(enchantmentEffect.getKey(), blade);
                        if (level < enchantmentEffect.getValue()) {
                            return false;
                        }
                    }
                    //NBTTags检查
                    if (!blade.getUnlocalizedName().equals(this.requiredStateBlade.getUnlocalizedName())) {
                        return false;
                    }
                    NBTTagCompound reqTag = ItemSlashBlade.getItemTagCompound(this.requiredStateBlade);
                    NBTTagCompound srcTag = ItemSlashBlade.getItemTagCompound(blade);
                    if (0 < this.tagValueCompare(ItemSlashBlade.ProudSoul, reqTag, srcTag)) {
                        return false;
                    }
                    if (0 < this.tagValueCompare(ItemSlashBlade.KillCount, reqTag, srcTag)) {
                        return false;
                    }
                    if (0 < this.tagValueCompare(ItemSlashBlade.RepairCount, reqTag, srcTag)) {
                        return false;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public ItemStack getCraftingResult(InventoryCrafting var1) {
        ItemStack newBlade = super.getCraftingResult(var1);
        for (int x = 0; x < var1.getSizeInventory(); x++) {
            ItemStack srcBlade = var1.getStackInSlot(x);
            if (!srcBlade.isEmpty() && srcBlade.getItem() instanceof ItemSlashBlade && srcBlade.hasTagCompound()) {
                NBTTagCompound oldTag = srcBlade.getTagCompound();
                oldTag = oldTag.copy();
                NBTTagCompound newTag = ItemSlashBlade.getItemTagCompound(newBlade);
                if (ItemSlashBladeNamed.CurrentItemName.exists(newTag)) {
                    String key = ItemSlashBladeNamed.CurrentItemName.get(newTag);
                    ItemStack tmp = SlashBlade.getCustomBlade(key);
                    if (!tmp.isEmpty()) {
                        newBlade = tmp;
                    }
                }
                //还原附魔
                Map<Enchantment, Integer> newItemEnchants = EnchantmentHelper.getEnchantments(newBlade);
                Map<Enchantment, Integer> oldItemEnchants = EnchantmentHelper.getEnchantments(srcBlade);
                Iterator var9 = oldItemEnchants.keySet().iterator();
                Set<Map.Entry<Enchantment, Integer>> oldEnchantments = EnchantmentHelper.getEnchantments(srcBlade).entrySet();
                for (Map.Entry<Enchantment, Integer> enchantmentEffect : oldEnchantments) {
                    Enchantment enchantment = enchantmentEffect.getKey();
                    int destLevel = newItemEnchants.containsKey(enchantment) ? enchantmentEffect.getValue() : 0;
                    int srcLevel = oldItemEnchants.get(enchantment);
                    srcLevel = Math.max(srcLevel, destLevel);
                    srcLevel = Math.min(srcLevel, enchantment.getMaxLevel());
                    boolean isApplicable = enchantment.canApply(newBlade);
                    if (isApplicable) {
                        for (Enchantment newBladeEnchantment : newItemEnchants.keySet()) {
                            if (newBladeEnchantment != enchantment && !enchantment.isCompatibleWith(newBladeEnchantment)) {
                                isApplicable = false;
                                break;
                            }
                        }
                        if (isApplicable) {
                            newItemEnchants.put(enchantment, srcLevel);
                        }
                    }
                }
                EnchantmentHelper.setEnchantments(newItemEnchants, newBlade);
                //还原NBTTags
                newTag = ItemSlashBlade.getItemTagCompound(newBlade);
                ItemSlashBlade.KillCount.set(newTag, ItemSlashBlade.KillCount.get(oldTag));
                ItemSlashBlade.ProudSoul.set(newTag, ItemSlashBlade.ProudSoul.get(oldTag));
                ItemSlashBlade.RepairCount.set(newTag, ItemSlashBlade.RepairCount.get(oldTag));
                if (oldTag.hasUniqueId("Owner")) {
                    newTag.setUniqueId("Owner", oldTag.getUniqueId("Owner"));
                }
                if (oldTag.hasKey("adjustX")) {
                    newTag.setFloat("adjustX", oldTag.getFloat("adjustX"));
                }
                if (oldTag.hasKey("adjustY")) {
                    newTag.setFloat("adjustY", oldTag.getFloat("adjustY"));
                }
                if (oldTag.hasKey("adjustZ")) {
                    newTag.setFloat("adjustZ", oldTag.getFloat("adjustZ"));
                }
            }
        }
        return newBlade;
    }

    private int tagValueCompare(TagPropertyAccessor<Integer> targetTag, NBTTagCompound reqTag, NBTTagCompound srcTag) {
        return targetTag.get(reqTag).compareTo(targetTag.get(srcTag));
    }
}
