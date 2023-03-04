package me.bright.bright.listeners;

import me.bright.bright.Bright;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerJoinEvent;

// Prefix: ChatColor.WHITE + "" + ChatColor.BOLD + "Bright" + ChatColor.DARK_GRAY + " »"
public class JoinLeaveListener implements Listener {

    private Bright plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e){ // When the player joins

        Player p = e.getPlayer(); // Gets the player and sets them as a variable

        if(p.hasPlayedBefore()){ // If they played before
            e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GRAY + p.getDisplayName()); // Send a message
        }else{ // If they haven't played before
            e.setJoinMessage((ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("joinMessage"))) + ChatColor.DARK_AQUA + p + (ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("joinMessage-2")))); // Sends a message
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){ // When they leave

        Player player = e.getPlayer(); // Gets the player and sets them as a variable

        e.setQuitMessage(player.getDisplayName() + ""); // Send nothing

    }



}