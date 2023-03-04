package me.bright.bright.commands.spawn;

import me.bright.bright.Bright;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Prefix: ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »"


public class SetSpawnCommand implements CommandExecutor {

    private final Bright plugin; // Helps with Constructor

    public SetSpawnCommand(Bright plugin) {
        this.plugin = plugin;
    } // Constructor

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender; // If executor is a player


            Location location = player.getLocation(); // Gets player location

            // Saving the location object
            plugin.getConfig().set("spawn", location); // Sets the spawn in config using the location variable

            plugin.saveConfig();

            player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »" + ChatColor.GREEN + " Spawn location was successfully set to your location."); // Sends the player a message

        }else{
            System.out.println("You must be in the server to execute this command!"); // Tells the console executor to get on the server
        }



        return true;
    }
}