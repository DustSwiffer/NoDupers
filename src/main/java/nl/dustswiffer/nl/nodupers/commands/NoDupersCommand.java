package nl.dustswiffer.nl.nodupers.commands;

import nl.dustswiffer.nl.nodupers.NoDupers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoDupersCommand implements CommandExecutor {

    private final NoDupers plugin;

    public NoDupersCommand(NoDupers plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String labels, String[] args) {
        sender.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "No"+ChatColor.DARK_GREEN.toString() + ChatColor.BOLD.toString() + "Dupers");
        sender.sendMessage("Made to smell for stinkies who loves to dupe glitch money.");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GREEN.toString() + "Author: " + ChatColor.WHITE.toString() + "DustSwiffer");
        sender.sendMessage(ChatColor.GREEN.toString() + "Discord: " + ChatColor.WHITE.toString() + "DustSwiffer#1234");
        sender.sendMessage(ChatColor.GREEN.toString() + "GitHub: " + ChatColor.WHITE.toString() + ChatColor.UNDERLINE.toString() + "https://github.com/dustswiffer");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GREEN.toString() + "Message: " + ChatColor.WHITE.toString() + "This plugin is custom made for EquestriWorlds.net");
        return true;
    }
}
