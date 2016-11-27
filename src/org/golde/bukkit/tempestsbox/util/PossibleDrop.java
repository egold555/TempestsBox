package org.golde.bukkit.tempestsbox.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

// Represents a possible item to be dropped by a mob.
public class PossibleDrop {
	public final ItemStack itemStack;
	public final int min, max;
	public final int weight;
	public final double minDamage, maxDamage;
	
	public PossibleDrop(int weight, ItemStack itemStack)
	{
		this.weight = weight;
		this.itemStack = itemStack;
		this.minDamage = this.maxDamage = 1.0;
		this.min = this.max = 1;
	}

	public PossibleDrop(int weight, ItemStack itemStack, int min, int max)
	{
		this.weight = weight;
		this.itemStack = itemStack;
		this.minDamage = this.maxDamage = 1.0;
		this.min = min;
		this.max = max;
	}

	public PossibleDrop(int weight, ItemStack itemStack, int min, int max, double minDamage, double maxDamage)
	{
		this.weight = weight;
		this.itemStack = itemStack;
		this.min = min;
		this.max = max;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}
	
	public PossibleDrop(int weight, Material material)
	{
		this.weight = weight;
		this.itemStack = new ItemStack(material, 1);
		this.minDamage = this.maxDamage = 1.0;
		this.min = this.max = 1;
	}

	public PossibleDrop(int weight, Material material, int min, int max)
	{
		this.weight = weight;
		this.itemStack = new ItemStack(material, 1);
		this.minDamage = this.maxDamage = 1.0;
		this.min = min;
		this.max = max;
	}

	public PossibleDrop(int weight, Material material, int min, int max, double minDamage, double maxDamage)
	{
		this.weight = weight;
		this.itemStack = new ItemStack(material, 1);
		this.min = min;
		this.max = max;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}

}
