package me.bright.bright.commands;

import me.bright.bright.Bright;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

// Prefix: ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »"

public class FlyCommand implements CommandExecutor {

    private Bright plugin;
    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    public FlyCommand(Bright plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){ // If executor is a player
            Player player = (Player) sender; // Player variable
            if (args.length == 0){ // If no args are set
                if(player.hasPermission("Bright.fly")){ // Permission: Requires Bright.Fly
                    if (list_of_flying_players.contains(player)){ // If player is already flying (player is in the list)
                        list_of_flying_players.remove(player); // Remove the player from the list
                        player.setAllowFlight(true); // Disabled their flight
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("player-flyOff-msg"))); // Sends a message that their flight was disabled
                    }else if(!list_of_flying_players.contains(player)){ // If player is not in the array list (isn't flying)
                        list_of_flying_players.add(player); // Add their in the list
                        player.setAllowFlight(false); // Enabled their fly
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("player-flyOn-msg"))); // Sends a message that their flight was enabled
                    }
                }else if(args.length == 1) { // If there is one arg
                    Player target = Bukkit.getPlayer(args[0]); // Sets the arg as a variable
                    if (player.hasPermission("Bright.others")) { // Permission: Requires Bright.others
                        if (list_of_flying_players.contains(target)) { // If arg is in the list
                            list_of_flying_players.remove(target); // Remove arg from the list
                            target.setAllowFlight(false); // Disabled target's flight
                            player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " » " + ChatColor.RED + target + "already has their fly enabled, it's now disabled."); // Sends the player a message that they already had flight on
                            target.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + "Your fly was already enabled, " + player + "has disabled it for you."); // Sends the target a message that their flight was disabled by the executor
                        } else if (!list_of_flying_players.contains(target)) { // If player isn't in the list
                            list_of_flying_players.add(target); // Add player to the list
                            target.setAllowFlight(true); // Enable the target's flight
                            player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »" + ChatColor.GREEN + " Successfully enabled" + target + "'s fly."); // Sends the executor a message that they enabled the arg's flight
                            target.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + player + "has enabled your fly."); // Sends the targets that the executor has enabled their fly
                        }
                    }
                }
            }
        }

        return true;
    }
}