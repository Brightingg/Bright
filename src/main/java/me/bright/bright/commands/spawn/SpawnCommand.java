package me.bright.bright.commands.spawn;

import me.bright.bright.Bright;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    // Prefix: ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »"

    private final Bright plugin; // Helps Constructor

    public SpawnCommand(Bright plugin) {
        this.plugin = plugin;
    } // Constructor

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender; // If executor is a player

            Location location = plugin.getConfig().getLocation("spawn"); // Gets the location of the spawn point from the config.yml file

            if (location != null) { // If the location is set

                player.teleport(location); // Teleport the player to the set location

                player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »" + ChatColor.GREEN + " You have successfully been telelported to spawn!"); // Sends a message to the player letting them know they got teleported

            }else { // If location equals null, aka the spawn isn't yet set
                player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »" + ChatColor.RED + " There is no spawn set. Use /setspawn to set it to your current location!"); // Tells the player that a spawn has not yet been set!
            }



        }



        return true;
    }
}