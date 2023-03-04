package me.bright.bright.commands;

import me.bright.bright.Bright;
import me.bright.bright.utils.MainUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CoreCommands implements CommandExecutor {

    private Bright plugin;
    Plugin plugin1 = Bright.getPlugin(Bright.class);

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                aboutPlugin(p);
            }if(args.length == 1){
                if(args[0].equals("reload")){
                    plugin1.reloadConfig();
                    p.sendMessage(new MainUtils().configFormat("reloadMessage"));
                }else if(args[0].equals("about")){
                    aboutPlugin(p);
                }else if(args[0].equals("info")){
                    aboutPlugin(p);
                }else if(args[0].equals("info")){
                    aboutPlugin(p);
                }
            }
        }

        return true;
    }

    public static void aboutPlugin(Player p){
        p.sendMessage(new MainUtils().configFormat("aboutPlugin1"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin2"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin3"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin4"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin5"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin6"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin7"));
        p.sendMessage(new MainUtils().configFormat("aboutPlugin8"));
    }

}
