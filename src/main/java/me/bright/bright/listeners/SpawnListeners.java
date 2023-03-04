package me.bright.bright.listeners;

import me.bright.bright.Bright;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final Bright plugin; // Helps Constructor

    public SpawnListeners(Bright plugin) {
        this.plugin = plugin;
    } // Constructor

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){ // When the player joins

        Player player = e.getPlayer(); // Gets the player as a variable

        if (!player.hasPlayedBefore()){ // If they player hasn't played before the exclamation represents the opposite of the condition
            Location location = plugin.getConfig().getLocation("spawn"); // Grabs the location from the config and sets it as a variable

            if (location != null){ // If the location is set

                player.teleport(location); // Teleports the player to the location that is set in config

            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){ // When the player respawns

        // When a player dies, respawn them at the spawn location if it is set.
        Location location = plugin.getConfig().getLocation("spawn"); // Grabs the location from the config and sets it as a variable
        if (location != null){ // If location is set
            e.setRespawnLocation(location);
        }

    }
}