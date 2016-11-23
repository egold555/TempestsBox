package org.golde.bukkit.tempestsbox.util;

import org.bukkit.Location;
import org.bukkit.Particle;

public class WorldUtils {

	public static void spawnParticleEffect(Location l, Particle pe, int amount){
		l.getWorld().spawnParticle(pe, l.getX(), l.getY(), l.getZ(), amount);
	}
	
}
