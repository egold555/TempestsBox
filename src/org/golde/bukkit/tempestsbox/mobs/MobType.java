package org.golde.bukkit.tempestsbox.mobs;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum MobType {

	ANGRY_ZOMBIE(EntityType.ZOMBIE, 40, 6),
	AQUARIOUS(EntityType.ZOMBIE, 100, 6),
	ASSASSIN(EntityType.SKELETON, 50, 7),
	BLIGHT(EntityType.SKELETON, 2000, 8, Material.IRON_HOE, 19, 20),
	BLIGHT_SNIPER(EntityType.SKELETON, Mobs.ORIGIONAL_VALUE, Mobs.ORIGIONAL_VALUE),
	BLIGHT_TNT(EntityType.PRIMED_TNT, Mobs.ORIGIONAL_VALUE, 700),
	DUSKBLOOD(EntityType.ZOMBIE, 15, 12, Material.IRON_HOE, 1, 2),
	ENDERMENACE(EntityType.ENDERMAN, 60, 7),
	MAGE(EntityType.ZOMBIE, 150, 6, Material.IRON_HOE, 3, 4),
	MAGE_BAT_HELPER(EntityType.ZOMBIE, 150, Mobs.ORIGIONAL_VALUE),
	NETHERKNIGHT(EntityType.ZOMBIE, 50, Mobs.ORIGIONAL_VALUE, Material.IRON_HOE, 15, 16),
	OGRE(EntityType.ZOMBIE, 100, 10, Material.IRON_HOE, 5, 6),
	MAGRA(EntityType.ZOMBIE, 70, 7),
	TORGAN(EntityType.ZOMBIE, 40, 7),
	SKITTER(EntityType.ZOMBIE, Mobs.ORIGIONAL_VALUE, 8, Material.IRON_HOE, 17, 18),
	VAMPIRE(EntityType.ZOMBIE, Mobs.ORIGIONAL_VALUE, 4, Material.IRON_HOE, 11, 12),
	VAMPIRE_BAT(EntityType.BAT, Mobs.ORIGIONAL_VALUE, Mobs.ORIGIONAL_VALUE),
	WANDERER(EntityType.ZOMBIE, 100, 8),
	WISP(EntityType.BAT, Mobs.ORIGIONAL_VALUE, 8),
	YETI(EntityType.ZOMBIE, 50, 10, Material.IRON_HOE, 13, 14);

	private final EntityType entity;
	private final double health;
	private final double damage;
	private final Material material;
	private final short itemDamageStill;
	private final short itemDamageMoving;


	MobType(EntityType entity, double health, double damage, Material material, int itemDamageStill, int itemDamageMoving){
		this.entity = entity;
		this.health = health;
		this.damage = damage;
		this.material = material;
		this.itemDamageStill = (short) itemDamageStill;
		this.itemDamageMoving = (short) itemDamageMoving;
	}

	MobType(EntityType entity, double health, double damage){
		this.entity = entity;
		this.health = health;
		this.damage = damage;
		this.material = Material.AIR;
		this.itemDamageStill = 0;
		this.itemDamageMoving = 0;
	}

	public EntityType getEntity() {
		return entity;
	}

	public double getHealth(){
		return health;
	}

	public double getDamage(){
		return damage;
	}

	public ItemStack getItemStill(){
		return makeItem(itemDamageStill);
	}

	public ItemStack getItemMoving(){
		return makeItem(itemDamageMoving);
	}

	private ItemStack makeItem(short damage){
		ItemStack stack = new ItemStack(material, 1, damage);
		if(material != Material.AIR){
			ItemMeta im = stack.getItemMeta();
			im.spigot().setUnbreakable(true);
			stack.setItemMeta(im);
		}
		return stack;
	}

	public static MobType get(String name){
		for(MobType type:MobType.values()){
			if(type.name().equalsIgnoreCase(name)){
				return type;
			}
		}
		return null;
	}

}
