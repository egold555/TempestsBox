package org.golde.bukkit.tempestsbox;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

public class CommandRegistrator {

    protected final Plugin plugin;
    protected final CommandExecutor executor;

    public CommandRegistrator(Plugin plugin, CommandExecutor executor) {
        this.plugin = plugin;
        this.executor = executor;
    }

    public void register(String name, String[] aliases, String description, String usage, String[] perms, String permMessage) {
        getCommandMap().register(plugin.getDescription().getName(), new DynamicCommand(aliases, name, description, usage, perms, permMessage, executor, plugin, plugin));
    }
    
    

    public CommandMap getCommandMap() {
        Field map;
        try {
            map = SimplePluginManager.class.getDeclaredField("commandMap");
            map.setAccessible(true);
            return (CommandMap) map.get(plugin.getServer().getPluginManager());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class DynamicCommand extends org.bukkit.command.Command implements PluginIdentifiableCommand {

    public CommandExecutor owner;
    public Object registeredWith;
    public Plugin owningPlugin;
    public String[] permissions = new String[0];

    public DynamicCommand(String[] aliases, String name, String description, String usage, String[] perms, String permMessage, CommandExecutor owner, Object registeredWith, Plugin plugin) {
        super(name, description, usage, Arrays.asList(aliases));
        this.owner = owner;
        this.owningPlugin = plugin;
        this.registeredWith = registeredWith;
        if (perms.length > 0)
            setPermissions(perms);
        if (!StringUtils.isEmpty(permMessage))
            setPermissionMessage(ChatColor.RED + permMessage);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return owner.onCommand(sender, this, label, args);
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
        super.setPermission(StringUtils.join(permissions, ";"));
    }

    @Override
    public Plugin getPlugin() {
        return owningPlugin;
    }
}

