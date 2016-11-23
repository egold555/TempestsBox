package org.golde.bukkit.tempestsbox.mobs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import net.minecraft.server.v1_11_R1.Block;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEnderman;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftZombie;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.golde.bukkit.tempestsbox.Items;
import org.golde.bukkit.tempestsbox.Main;
import org.golde.bukkit.tempestsbox.util.EntityUtils;
import org.golde.bukkit.tempestsbox.util.ItemUtils;
import org.golde.bukkit.tempestsbox.util.MathUtils;
import org.golde.bukkit.tempestsbox.util.WorldUtils;


//https://www.youtube.com/watch?v=9cAiIO940v4

public class Mobs implements Listener {

	@SuppressWarnings("unused")
	private Main main;

	public Mobs(Main main){
		new BukkitRunnable(){
			public void run(){
				timer();
			}
		}.runTaskTimer(main, 0, 1);
		this.main = main;
	}

	private HashSet<Entity> allMobs = new HashSet<Entity>();
	public static final double ORIGIONAL_VALUE = -100;
	public Entity spawn(Location loc, MobType mob){

		Entity e = (Entity)loc.getWorld().spawnEntity(loc, mob.getEntity());
		Main.getPlugin().logger.info("Spawning Mob: " + mob.name());
		e.setCustomName(mob.name());
		e.setCustomNameVisible(false);
		e.setSilent(true);
		if(e instanceof LivingEntity){
			LivingEntity le = (LivingEntity)e;

			EntityEquipment eq = le.getEquipment();
			le.setCanPickupItems(false);

			if(mob != MobType.BLIGHT_SNIPER 
					&& mob != MobType.BLIGHT_TNT
					&& mob != MobType.MAGE_BAT_HELPER){
				le.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
			}

			if(mob.getHealth() != ORIGIONAL_VALUE){
				le.setMaxHealth(mob.getHealth());
				le.setHealth(mob.getHealth());
			}
			eq.setHelmet(mob.getItemStill());
			eq.setHelmetDropChance(0);

			if(e instanceof Zombie){
				CraftZombie z = (CraftZombie) le;
				z.getHandle().setBaby(false);
			}
			if(e instanceof Enderman){
				CraftEnderman c = (CraftEnderman)le;
				c.setCarriedMaterial(new ItemStack(Material.ICE).getData());
			}

			if(mob == MobType.AQUARIOUS){
				eq.setHelmet(Items.aquariousHead());
				eq.setChestplate(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_CHESTPLATE), 7039557));
				eq.setLeggings(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), 7039557));
				eq.setBoots(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_BOOTS), 5057290));
			}

			if(mob == MobType.ASSASSIN){
				eq.setHelmet(Items.assassinHead());
				eq.setChestplate(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_CHESTPLATE), 5855063));
				eq.setLeggings(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), 5526612));
				//eq.setBoots(Items.featherBoots());
			}

			if(mob == MobType.TORGAN){
				eq.setHelmet(Items.torganHead());
				eq.setChestplate(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_CHESTPLATE), 1321760));
				eq.setLeggings(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), 1321760));
				eq.setBoots(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_BOOTS), 0));
			}

			if(mob == MobType.MAGRA){
				eq.setHelmet(Items.magraHead());
				//eq.setChestplate(Items.magraChestplate());
				eq.setLeggings(ItemUtils.colorLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), 1321760));
				//eq.setBoots(Items.magraBoots());
			}

			if(mob == MobType.BLIGHT){
				//eq.setItemInMainHand(new ItemStack(Material.BROWN_MUSHROOM));
				eq.setItemInOffHand(Items.blightBone());
				eq.setItemInOffHandDropChance(100);
				eq.setItemInMainHand(new ItemStack(Material.BROWN_MUSHROOM));
			}

			if(mob == MobType.VAMPIRE){
				eq.setChestplate(new ItemStack(Material.ELYTRA));
				eq.setChestplateDropChance(0);
			}

			if(mob == MobType.BLIGHT_SNIPER){
				eq.setHelmet(new ItemStack(Material.SKULL_ITEM, 1, (short) 4));
				eq.setItemInMainHand(new ItemStack(Material.BOW));
				EntityUtils.setNBT(le, NBTTags.NO_GRAVITY, 1);
			}



		}
		allMobs.add(e);
		return e;
	}

	@SuppressWarnings("deprecation")
	private void timer(){
		for(Entity entity:allMobs.toArray(new Entity[0])){
			particles(entity);
			MobType type = getType(entity);
			if(type == MobType.BLIGHT){
				for(Entity e:entity.getNearbyEntities(10, 3, 10)){
					if(e instanceof TNTPrimed && !isOurMob(e)){
						Location l = e.getLocation();
						e.remove();
						spawn(l, MobType.BLIGHT_TNT);
					}
				}
			}
			if(entity instanceof LivingEntity){
				LivingEntity le = (LivingEntity)entity;
				if(type == MobType.VAMPIRE){
					EntityUtils.setNBT(le, NBTTags.GLIDE, 1);
				}

				if(type.getItemMoving().getTypeId() == 0 || type.getItemStill().getTypeId() == 0){
					return;
				}
				if(isMoving(le)){
					le.getEquipment().setHelmet(type.getItemMoving());
				}else{
					le.getEquipment().setHelmet(type.getItemStill());
				}
				le.getEquipment().setHelmetDropChance(0);
			}
		}

	}

	private void particles(Entity entity){
		MobType type = getType(entity);
		Location l = entity.getLocation();
		if(type == MobType.BLIGHT_TNT){
			WorldUtils.spawnParticleEffect(l, Particle.LAVA, 2);
			WorldUtils.spawnParticleEffect(l, Particle.FIREWORKS_SPARK, 2);
		}
	}

	HashMap<LivingEntity, Location> lastLocation = new HashMap<LivingEntity, Location>();
	public boolean isMoving(LivingEntity le){
		boolean is = true;
		Location last = lastLocation.get(le);
		if(last != null && last.equals(le.getLocation())){is = false;}
		lastLocation.put(le, le.getLocation());
		return is;
	}

	public boolean isOurMob(Entity le){
		if(allMobs.contains(le)){
			return true;
		}
		return false;
	}

	public MobType getType(Entity le){
		for(MobType type:MobType.values()){
			if(isOurMob(le) && le.getCustomName().equalsIgnoreCase(type.name())){
				return type;
			}
		}
		return null;
	}

	@EventHandler
	public void mobDeath(EntityDeathEvent e){

		if(!isOurMob(e.getEntity())){
			return;
		}

		LivingEntity le = e.getEntity();
		allMobs.remove(le);
		List<ItemStack> drops = e.getDrops();

		if(getType(le) == MobType.OGRE){
			drops.clear();drops.add(new ItemStack(Material.DIAMOND));
		}
	}

	@EventHandler
	public void onEntityDamageByEntity (EntityDamageByEntityEvent e) {
		Bukkit.broadcastMessage("PUNCH");
		if (e.getEntity() instanceof Player 
				&& e.getDamager() instanceof LivingEntity 
				&& isOurMob(e.getDamager())) {
			double damage = getType(e.getDamager()).getDamage();
			if(damage != ORIGIONAL_VALUE){
				e.setDamage(damage);
				Bukkit.broadcastMessage(e.getEntity().getName() + " took " + damage + " from " + e.getDamager().getCustomName());
			}
		}
		
		if(e.getCause() == DamageCause.ENTITY_EXPLOSION 
				&& isOurMob(e.getDamager())  
				&& getType(e.getEntity()) != null && getType(e.getEntity()) == MobType.BLIGHT){
			e.setDamage(MobType.BLIGHT_TNT.getDamage());
		}
		
	}

	@EventHandler
	public void explodeEvent(EntityExplodeEvent e){
		if(e.getEntityType() == EntityType.PRIMED_TNT && isOurMob(e.getEntity())){
			TNTPrimed tnt = (TNTPrimed)e.getEntity();
			e.blockList().clear();
			tnt.getWorld().createExplosion(tnt.getLocation(), 1);
			allMobs.remove(tnt);
		}
	}
}

