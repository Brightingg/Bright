package me.bright.bright.utils;

import me.bright.bright.Bright;
import org.bukkit.ChatColor;

public class MainUtils {

    private Bright plugin;


    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix")) + ChatColor.RESET;
    }

    public String noPerms() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("noPerms")) + ChatColor.RESET;
    }

    public static String msg(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public String configFormat(String msg){
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(msg)) + ChatColor.RESET;
    }

}
