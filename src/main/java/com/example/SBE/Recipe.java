package com.example.SBE;

import net.minecraft.item.ItemStack;

import java.util.Map;

public class Recipe {
    Map<Character, ItemStack> itemMap;
    String[] share;
    ItemStack previousBlade;


    public Map<Character, ItemStack> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Character, ItemStack> itemMap) {
        this.itemMap = itemMap;
    }

    public String[] getShare() {
        return share;
    }

    public void setShare(String[] share) {
        this.share = share;
    }

    public ItemStack getPreviousBlade() {
        return previousBlade;
    }

    public void setPreviousBlade(ItemStack previousBlade) {
        this.previousBlade = previousBlade;
    }
}
