package org.golde.bukkit.tempestsbox;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.bukkit.tempestsbox.mobs.MobType;
import org.golde.bukkit.tempestsbox.mobs.Mobs;

public class Main extends JavaPlugin{

	CommandRegistrator registrator;
	
	public Logger logger;
	public Mobs mobs;
	String[] blank = {};
	private static Main main;
	@Override
	public void onEnable(){
		main = this;
		logger = getLogger();
		mobs = new Mobs(this);
		
		getServer().getPluginManager().registerEvents(mobs, this);
		registrator = new CommandRegistrator(this,  this);
		for(MobType type:MobType.values()){
			registrator.register(type.name(), blank, "Just a test", type.name(), blank, "");
		}
	}
	
	public static Main getPlugin(){
		return main;
	}
	
	@Override 
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("test")){
			//p.getInventory().addItem(Items.wandMage());
			//p.getInventory().addItem(Items.wandSkitter());
			//p.getInventory().addItem(Items.wandBlight1());
			//p.getInventory().addItem(Items.wandBlight2());
			//p.getInventory().addItem(Items.wandBlight3());
			p.getInventory().addItem(Items.orcMead());
			p.getInventory().addItem(Items.relicBright());
			p.getInventory().addItem(Items.relicDark());
			p.getInventory().addItem(Items.brownBoots());
			p.getInventory().addItem(Items.flippers());
			p.getInventory().addItem(Items.vampireFang());
			return true;
		}
		
		
		mobs.spawn(p.getLocation(), MobType.get(cmd.getName()));
		return true;
	}
	
}
