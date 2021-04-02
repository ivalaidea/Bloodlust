package com.github.idea.plugin.bloodlust

import com.github.syari.spigot.api.string.toColor
import org.bukkit.command.CommandSender

fun CommandSender.send(message: String) {
    sendMessage("&b[Bloodlust] &r$message".toColor())
}
