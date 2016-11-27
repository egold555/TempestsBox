package org.golde.bukkit.tempestsbox;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.golde.bukkit.tempestsbox.mobs.NBTTags;
import org.golde.bukkit.tempestsbox.util.ItemUtils;
import org.golde.bukkit.tempestsbox.util.MathUtils;

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
	
	public static ItemStack wandMage(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 1);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		im.setDisplayName("Mage Wand");
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				2D, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-8233369823848316590L, 
				3719552739384051249L);
		
		return item;
	}
	
	public static ItemStack wandSkitter(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 3);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 3, true);
		im.setDisplayName("Skitter Wand");
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				2D, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND,  
				-7424410760657711634L, 
				-7554250765841379690L);
		return item;
	}
	
	@Deprecated
	public static ItemStack wandBlight1(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 4);
		ItemMeta im = item.getItemMeta();
		im.addEnchant(Enchantment.KNOCKBACK, 5, true);
		im.setDisplayName("Blight Wand");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				9.338134765625, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6863519381320161937L, 
				-15344109554744767L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				-0.456188201904297, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				2, 
				NBTTags.SLOT_MAIN_HAND, 
				-6121861343960198676L, 
				789026046482597736L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				0.952083230018616, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6840173344109694555L, 
				-1342092685219313642L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				6.59788608551025, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-5798861740502849041L, 
				7189376148689210832L);
		
		return item;
	}
	
	@Deprecated
	public static ItemStack wandBlight2(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 4);
		ItemMeta im = item.getItemMeta();
		im.addEnchant(Enchantment.KNOCKBACK, 5, true);
		im.setDisplayName("Blight Wand");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				8.34257221221924, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-4817179725424735413L, 
				-5407007825425644159L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				-0.364152073860168, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				2, 
				NBTTags.SLOT_MAIN_HAND, 
				-6177780671878384993L, 
				-7499709849060425303L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				0.926301121711731, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6840173344109694555L, 
				-1342092685219313642L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				6.59788608551025, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-9189159932500084036L, 
				-370325273706083728L);
		
		return item;
	}
	
	@Deprecated
	public static ItemStack wandBlight3(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 4);
		ItemMeta im = item.getItemMeta();
		im.addEnchant(Enchantment.KNOCKBACK, 5, true);
		im.setDisplayName("Blight Wand");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				11.103645324707, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-5754112898655651906L, 
				-1178534629162532382L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				-0.303770184516907, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				2, 
				NBTTags.SLOT_MAIN_HAND, 
				-7861519196039510101L, 
				-4810131425312289736L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				0.841692209243774, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				NBTTags.ATTRIBUTE_KNOCKBACK_RESTANCE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6949682300619456212L, 
				-2014357608905225868L);
		
		item = ItemUtils.writeAttributeNBT(item, 
				7.43396949768066, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				NBTTags.ATTRIBUTE_PROTECTION, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-8791250682516921177L, 
				-1647189113784939636L);
		
		return item;
	}
	
	public static ItemStack vampireFang(){
		ItemStack item = new ItemStack(Material.GOLD_AXE, 1 ,(short) 2);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("Vampire Fang");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		item = ItemUtils.writeAttributeNBT(item, 
				2, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-4885884885878255694L, 
				-61439903582761209L);
		
		return item;
	}
	
	public static ItemStack relicDark(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 ,(short) 25);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Dark Relic");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack relicBright(){
		ItemStack item = new ItemStack(Material.IRON_HOE, 1 ,(short) 250);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Bright Relic");
		im.spigot().setUnbreakable(true);
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack flippers(){
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		item = ItemUtils.colorLeatherArmor(item, 1668457);
		ItemMeta im = item.getItemMeta();
		im.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
		im.setDisplayName("Flippers");
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack brownBoots(){
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		item = ItemUtils.colorLeatherArmor(item, 3997696);
		ItemMeta im = item.getItemMeta();
		im.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack orcMead(){
		PotionEffect[] pe = {
				new PotionEffect(PotionEffectType.SPEED, MathUtils.secondsToTicks(20), 2),
				new PotionEffect(PotionEffectType.INCREASE_DAMAGE, MathUtils.secondsToTicks(20), 2),
				new PotionEffect(PotionEffectType.SATURATION, MathUtils.secondsToTicks(20), 2),
				new PotionEffect(PotionEffectType.BLINDNESS, MathUtils.secondsToTicks(10), 0),
				new PotionEffect(PotionEffectType.POISON, MathUtils.secondsToTicks(10), 1)
				};
		ItemStack item = ItemUtils.makeCustomPotion(pe);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("Orc Mead");
		item.setItemMeta(im);
		return item;
	}
	
	public static ItemStack wispDiamond(){
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("Wisp Diamond");
		item.setItemMeta(im);
		return item;
	}
	
	@Deprecated
	public static ItemStack katana(){
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("Katana");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				0.15, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				NBTTags.ATTRIBUTE_MOVEMENT_SPEED, 
				1, 
				NBTTags.SLOT_OFF_HAND, 
				174155, 
				993339);
		
		item = ItemUtils.writeAttributeNBT(item, 
				4, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				643498, 
				30196);
		
		item = ItemUtils.writeAttributeNBT(item, 
				0.2, 
				NBTTags.ATTRIBUTE_ATTACK_SPEED, 
				NBTTags.ATTRIBUTE_ATTACK_SPEED, 
				1, 
				NBTTags.SLOT_OFF_HAND, 
				294643, 
				640820);
		
		return item;
	}
	
	public ItemStack staffRepulsion(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)1);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Repulsion Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				4.76908826828003, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-7268148700984049992L, 
				873468059985200988L);
		
		return item;
	}
	
	public ItemStack staffRelativity(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)2);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Relativity Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				5.86029815673828, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6622644245015526825L, 
				-7107110087656518591L);
		
		return item;
	}
	
	public ItemStack staffExtraction(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)3);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Extraction Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				3.91275143623352, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6825689840052597693L, 
				2036444835052800580L);
		
		return item;
	}
	
	public ItemStack staffRefridgerant(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)4);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Refridgerant Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				5.90391111373901, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-5466201557445651511L, 
				8706464538726122459L);
		
		return item;
	}
	
	public ItemStack staffInfallable(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)5);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Infallable Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				5.0511326789856, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-7639740538895544017L, 
				-4141365518932688531L);
		
		return item;
	}
	
	public ItemStack staffShatter(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)6);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Shatter Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				3.19736242294312, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6528426823256113489L, 
				2119715465862398788L);
		
		return item;
	}
	
	public ItemStack staffCaptive(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)8);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Captive Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				5.64130020141602, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-5094780472695154922L, 
				8255462528374230522L);
		
		return item;
	}
	
	public ItemStack staffTime(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)7);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Time Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				4.77075624465942, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-6864184254004407158L, 
				-8145269752995430086L);
		
		return item;
	}
	
	public ItemStack staffEther(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)9);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Ether Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				4.58659934997559, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-7205726013286240523L, 
				4320244184064281863L);
		
		return item;
	}
	
	public ItemStack staffHarvest(){
		ItemStack item = new ItemStack(Material.CARROT_STICK, 1 , (byte)10);
		ItemMeta im = item.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(ChatColor.GREEN + "Harvest Staff");
		item.setItemMeta(im);
		
		item = ItemUtils.writeAttributeNBT(item, 
				5.63074064254761, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				NBTTags.ATTRIBUTE_ATTACK_DAMAGE, 
				0, 
				NBTTags.SLOT_MAIN_HAND, 
				-9069099229034361723L, 
				7631145280157338093L);
		
		return item;
	}
}
