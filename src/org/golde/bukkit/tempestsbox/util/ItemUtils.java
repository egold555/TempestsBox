package org.golde.bukkit.tempestsbox.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTBase;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagDouble;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagLong;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

@SuppressWarnings("deprecation")
public class ItemUtils {
	public static Random random = new Random();
	
	public static ItemStack colorLeatherArmor(ItemStack leatherArmor, int r, int g, int b){
		ItemStack armor = new ItemStack(leatherArmor);
		LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
		Color color = Color.fromRGB(r, g, b);
		meta.setColor(color);
		armor.setItemMeta(meta);
		return armor;
	}

	public static ItemStack colorLeatherArmor(ItemStack leatherArmor, int rgb){
		ItemStack armor = new ItemStack(leatherArmor);
		LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
		Color color = Color.fromRGB(rgb);
		meta.setColor(color);
		armor.setItemMeta(meta);
		return armor;
	}

	public static ItemStack itemFlag(Material material, ItemFlag flag){
		ItemStack is = new ItemStack(material);
		ItemMeta ism = is.getItemMeta();
		ism.addItemFlags(flag);
		is.setItemMeta(ism);
		return is;
	}

	public static ItemStack getSkull(String id) { //f5612dc7b86d71afc1197301c15fd979e9f39e7b1f41d8f1ebdf8115576e2e
		id = "http://textures.minecraft.net/texture/" + id;
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", id).getBytes());
		profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
		Field profileField = null;
		try {
			profileField = skullMeta.getClass().getDeclaredField("profile");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		assert profileField != null;
		profileField.setAccessible(true);
		try {
			profileField.set(skullMeta, profile);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		skull.setItemMeta(skullMeta);
		return skull;
	}

	public static ItemStack glow(ItemStack item) {
		net.minecraft.server.v1_11_R1.ItemStack asNMSCopy = org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asNMSCopy(item);
		net.minecraft.server.v1_11_R1.NBTTagCompound tagCompound = null;
		if (!asNMSCopy.hasTag()) {
			tagCompound = new net.minecraft.server.v1_11_R1.NBTTagCompound();
			asNMSCopy.setTag(tagCompound);
		}
		if (tagCompound == null) tagCompound = asNMSCopy.getTag();
		net.minecraft.server.v1_11_R1.NBTTagList enchantmen = new net.minecraft.server.v1_11_R1.NBTTagList();
		tagCompound.set("ench", enchantmen);
		asNMSCopy.setTag(tagCompound);
		return org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asCraftMirror(asNMSCopy);
	}

	public static ItemStack writeAttributeNBT(ItemStack item, 
			double amount, 
			String attributeName,
			String name,
			int operation,
			String slot,
			long uuidLeast,
			long uuidMost){
		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers; 
		
		NBTBase modifiersBase = compound.get("AttributeModifiers");
		if (modifiersBase != null && modifiersBase instanceof NBTTagList) {
			modifiers = (NBTTagList)modifiersBase;
		}
		else {
			modifiers = new NBTTagList();
		}
		
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString(attributeName));
		damage.set("Name", new NBTTagString(name));
		damage.set("Amount", new NBTTagDouble(amount));
		damage.set("Operation", new NBTTagInt(operation));
		damage.set("UUIDLeast", new NBTTagLong(uuidLeast));
		damage.set("UUIDMost", new NBTTagLong(uuidMost));
		damage.set("Slot", new NBTTagString(slot));
		modifiers.add(damage);
		compound.set("AttributeModifiers", modifiers);
		nmsStack.setTag(compound);
		item = CraftItemStack.asBukkitCopy(nmsStack);
		return item;
	}
	
	public static ItemStack makeCustomPotion(PotionEffect effect){
		PotionEffect[] effects = {effect};
		return makeCustomPotion(effects);
	}
	
	public static ItemStack makeCustomPotion(PotionEffect[] effects){
		ItemStack item = new ItemStack(Material.POTION);
		PotionMeta meta= (PotionMeta)item.getItemMeta();
		for(PotionEffect pe:effects){
			meta.addCustomEffect(pe, true);
		}
		item.setItemMeta(meta);
		Potion po = new Potion(1);
		po.apply(item);
		return item;
	}

	public static List<ItemStack> getDrops(int number, PossibleDrop... drops)
	{
		return getDrops(number, number, drops);
	}
	
	public static List<ItemStack> getDrops(int minNumber, int maxNumber, PossibleDrop... drops)
	{
		List<ItemStack> result = new ArrayList<ItemStack>();
		
		int numDrops = minNumber + random.nextInt(maxNumber - minNumber + 1); 
		for (int i = 0; i < numDrops; ++i) {
			ItemStack is = getOneDrop(drops);
			if (is.getAmount() > 0)
				result.add(is);
		}
		
		return result;
	}
	
	private static ItemStack getOneDrop(PossibleDrop... drops) 
	{
		int totalWeight = 0;
		for (PossibleDrop d: drops) {
			totalWeight += d.weight;
		}
		
		int roll = random.nextInt(totalWeight);
		PossibleDrop chosen = null;
		for (PossibleDrop d: drops) {
			roll -= d.weight;
			if (roll < 0) {
				chosen = d;
				break;
			}
		}	
		
		ItemStack itemStack = chosen.itemStack.clone();
		if (chosen.minDamage < 1.0) {
			double damage = chosen.minDamage + (random.nextDouble() * (chosen.maxDamage + chosen.minDamage));
			short maxDurability = itemStack.getType().getMaxDurability();
			itemStack.setDurability((short) Math.floor((1.0-damage) * maxDurability));
		}
		
		int amount = chosen.min + random.nextInt(chosen.max - chosen.min + 1);
		itemStack.setAmount(amount);
		
		return itemStack;
	}
	
}
