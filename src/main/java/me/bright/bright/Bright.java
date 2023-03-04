package me.bright.bright;

import me.bright.bright.commands.BroadcastCommand;
import me.bright.bright.commands.ClearChatCommand;
import me.bright.bright.commands.CoreCommands;
import me.bright.bright.commands.FlyCommand;
import me.bright.bright.commands.spawn.SetSpawnCommand;
import me.bright.bright.commands.spawn.SpawnCommand;
import me.bright.bright.listeners.JoinLeaveListener;
import me.bright.bright.listeners.SpawnListeners;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

// Prefix: ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »"
// p.sendMessage((ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"))))

public final class Bright extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Bright | Bright plugin successfully enabled."); // Enable message

        // Registering Events & Listeners
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this); // Register Join Leave Listener
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this); // Register Spawn Listener

        // Linking Config
        getConfig().options().copyDefaults(); // Getting the config
        saveDefaultConfig(); // Saving the config

        // Registering Commands
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this)); // Registering the set spawn command
        getCommand("spawn").setExecutor(new SpawnCommand(this)); // Registering the spawn command
        getCommand("fly").setExecutor(new FlyCommand(this)); // Registering the fly command
        getCommand("broadcast").setExecutor(new BroadcastCommand()); // Registering the broadcast command
        getCommand("bc").setExecutor(new BroadcastCommand()); // Registering the broadcast command
        getCommand("clearchat").setExecutor(new ClearChatCommand()); // Registering the clear chat command
        getCommand("cc").setExecutor(new ClearChatCommand()); // Registering the clear chat command
        getCommand("bright").setExecutor(new CoreCommands()); // Registering all core commands


    }

}