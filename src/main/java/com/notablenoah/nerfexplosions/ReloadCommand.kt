package com.notablenoah.nerfexplosions

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ReloadCommand:CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        NerfExplosions.updateMultiplier()
        sender.sendMessage("[NerfExplosions] Multiplier is now set to ${multiplier*100}% damage")
        return true
    }
}