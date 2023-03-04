package me.bright.bright.commands;

import me.bright.bright.Bright;
import me.bright.bright.utils.MainUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

    private Bright plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("Bright.ClearChat")){
                for (int x = 0; x < 1001; x++){
                    Bukkit.broadcastMessage("");
                }
                Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("chatClearMessage"))));
            }else{

            }
        }

        return true;
    }
}
