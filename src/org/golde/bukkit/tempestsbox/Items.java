package org.golde.bukkit.tempestsbox;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.golde.bukkit.tempestsbox.util.ItemUtils;

public class Items {

	public static ItemStack aquariousHead(){return ItemUtils.getSkull("fd9944fb5eb8639b28e78dc38d579d88fb380ca5789c81f55384112d227e3");}
	public static ItemStack assassinHead(){return ItemUtils.getSkull("2f661c9284d60e0433ec9d3d1cf8a3c81beb80eb964dd68b47895c5db9b4c");}
	public static ItemStack wandererHead(){return ItemUtils.getSkull("68d2183640218ab330ac56d2aab7e29a9790a545f691619e38578ea4a69ae0b6");}
	public static ItemStack torganHead(){return ItemUtils.getSkull("f3ec1becf0112da877ee9da42723e2433b3cce32a6ddb8771ea71caa85b5a4");}
	public static ItemStack magraHead(){return ItemUtils.getSkull("9a57327baa14a3c126a4277d301f7522d2251a31aa69adebbbf191fdb8f5");}
	public static ItemStack angryZombieHead(){return ItemUtils.getSkull("7bc9d88162f874b46770132f599b72a20fb22824ef09ec7d35850498b4016");}
	
	public static ItemStack blightBone(){
		ItemStack item = new ItemStack(Material.BROWN_MUSHROOM);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName("Blight Bone");
		im.addEnchant(Enchantment.getById(19), 5, true);
		item.setItemMeta(im);
		return item;
	}
}
