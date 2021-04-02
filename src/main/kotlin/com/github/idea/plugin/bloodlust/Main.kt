package com.github.idea.plugin.bloodlust

import com.github.syari.spigot.api.scheduler.runTaskTimer
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        internal lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }

    var walkSpeed = 0.1f

    override fun onEnable() {
        runTaskTimer(1 * 20, async = true) {
            walkSpeed += 0.001f
            server.onlinePlayers.forEach {
                it.walkSpeed = walkSpeed
            }
        }
    }
}
