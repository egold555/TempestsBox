package org.golde.bukkit.tempestsbox.util;

import java.lang.reflect.Field;
import java.util.UUID;

import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import me.dpohvar.powernbt.api.NBTManager;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class ItemUtils {

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
	
	static NBTManager manager = PowerNBT.getApi();
	public static void writeAttributeNBT(ItemStack item, String tag, Object value){
		NBTCompound nbt = manager.read(item);
		nbt.put(tag, value);
		manager.write(item, nbt);
	}
	
}