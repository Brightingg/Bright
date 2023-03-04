package me.bright.bright.commands;

import me.bright.bright.Bright;
import me.bright.bright.utils.MainUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    private Bright plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("Bright.broadcast")){
                if (args.length == 0) {
                    p.sendMessage((ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("notEnoughArgs"))));
                }else if(args.length == 1){
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', args[0]));
                }
            }else{
                p.sendMessage(new MainUtils().configFormat("noPerms"));
            }
        }

        return true;
    }
}
