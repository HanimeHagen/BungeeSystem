package de.hanimehagen.bungeesystem.command;

import de.hanimehagen.bungeesystem.Data;
import de.hanimehagen.bungeesystem.punishment.PunishmentType;
import de.hanimehagen.bungeesystem.util.MethodUtil;
import de.hanimehagen.bungeesystem.util.PunishmentUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;


public class UnbanCommand extends Command {

    public UnbanCommand(String name, String permission) {
        super("unban", "system.unban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission("system.unban")) {
            if(args.length == 1) {
                PunishmentUtil.unpunishName(sender, args[0], PunishmentType.MUTE, "Punishment.Mute", "Punishment.NotMuted");
            } else if(args.length == 2) {
                if(args[0].equals("id")) {
                    PunishmentUtil.unpunishId(sender, args[1], PunishmentType.MUTE, "Punishment.UnmuteId", "Punishment.CantFindMuteId");
                } else {
                    sender.sendMessage(new TextComponent(MethodUtil.format(Data.PREFIX + Data.CORRECT_USE.replace("%cmd%", "/unmute <player> | /unmute id <muteid>"))));
                }
            } else {
                sender.sendMessage(new TextComponent(MethodUtil.format(Data.PREFIX + Data.CORRECT_USE.replace("%cmd%", "/unmute <player> | /unmute id <muteid>"))));
            }
        } else {
            sender.sendMessage(new TextComponent(MethodUtil.format(Data.PREFIX + Data.NO_PERMS)));
        }
    }
}