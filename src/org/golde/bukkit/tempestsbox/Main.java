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
		mobs.spawn(p.getLocation(), MobType.get(cmd.getName()));
		return true;
	}
	
}
