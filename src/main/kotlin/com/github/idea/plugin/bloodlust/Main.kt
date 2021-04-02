package com.github.idea.plugin.bloodlust

import com.github.syari.spigot.api.scheduler.runTaskTimer
import org.bukkit.attribute.Attribute
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        internal lateinit var plugin: JavaPlugin
        var isEnable = false
        var walkSpeed = 0.1
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        CommandCreator.register()
        runTaskTimer(1 * 20, async = true) {
            if (isEnable) {
                walkSpeed += 0.001
                server.onlinePlayers.forEach {
                    it.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue = walkSpeed
                }
            }
        }
    }
}
