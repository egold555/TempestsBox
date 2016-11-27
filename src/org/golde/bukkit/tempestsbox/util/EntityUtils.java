package org.golde.bukkit.tempestsbox.util;

import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import me.dpohvar.powernbt.api.NBTManager;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityUtils {
	
	static NBTManager manager = PowerNBT.getApi();
	
	public static void setNBT(LivingEntity le, String tag, Object value){
		NBTCompound nbt = manager.read(le);
		nbt.put(tag, value);
		manager.write(le, nbt);
	}
	
	public static void spawnParticle(Entity e, Particle pe, int amount){
		WorldUtils.spawnParticleEffect(e.getLocation(), pe, amount);
	}
	
	public static void addNeverEndingPotion(LivingEntity le, PotionEffectType pet, int amp){
		le.addPotionEffect(new PotionEffect(pet, Integer.MAX_VALUE, amp, false, false));
	}
	
	public static void addNeverEndingPotion(LivingEntity le, PotionEffectType pet){
		addNeverEndingPotion(le, pet, 1);
	}
	
}
