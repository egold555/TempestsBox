package org.golde.bukkit.tempestsbox;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.golde.bukkit.tempestsbox.mobs.NBTTags;
import org.golde.bukkit.tempestsbox.util.ItemUtils;

public class Items {

	public static ItemStack head_aquarious(){return ItemUtils.getSkull("fd9944fb5eb8639b28e78dc38d579d88fb380ca5789c81f55384112d227e3");}
	public static ItemStack head_assassin(){return ItemUtils.getSkull("2f661c9284d60e0433ec9d3d1cf8a3c81beb80eb964dd68b47895c5db9b4c");}
	public static ItemStack head_wanderer(){return ItemUtils.getSkull("68d2183640218ab330ac56d2aab7e29a9790a545f691619e38578ea4a69ae0b6");}
	public static ItemStack head_torgan(){return ItemUtils.getSkull("f3ec1becf0112da877ee9da42723e2433b3cce32a6ddb8771ea71caa85b5a4");}
	public static ItemStack head_magra(){return ItemUtils.getSkull("9a57327baa14a3c126a4277d301f7522d2251a31aa69adebbbf191fdb8f5");}
	public static ItemStack head_angryZombie(){return ItemUtils.getSkull("7bc9d88162f874b46770132f599b72a20fb22824ef09ec7d35850498b4016");}
	
	@SuppressWarnings("deprecation")
	public static ItemStack blightBone(){
		ItemStack item = new ItemStack(Material.BROWN_MUSHROOM);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName("Blight Bone");
		im.addEnchant(Enchantment.getById(19), 5, true);
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack wand_mage(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 1);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				2D, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				"mainhand", 
				-4885884885878255694L, 
				61439903582761209L);
		
		return item;
	}
	
	/*public static ItemStack wand_(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 0);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		
		return item;
	}
	
	public static ItemStack wand_(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 0);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		
		return item;
	}
	
	public static ItemStack wand_(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 0);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		
		return item;
	}
	
	public static ItemStack wand_(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 0);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		
		return item;
	}*/
}
