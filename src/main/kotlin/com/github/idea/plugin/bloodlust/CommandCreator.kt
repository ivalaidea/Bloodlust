package com.github.idea.plugin.bloodlust

import com.github.idea.plugin.bloodlust.Main.Companion.plugin
import com.github.idea.plugin.bloodlust.Main.Companion.walkSpeed
import com.github.syari.spigot.api.command.command
import com.github.syari.spigot.api.command.tab.CommandTabArgument.Companion.argument

object CommandCreator {
    fun register() {
        plugin.command("bloodlust") {
            aliases = listOf("bl", "blood-lust")
            tab {
                argument {
                    tab { addAll("start", "stop", "set") }
                }
                execute {
                    when (args.lowerOrNull(0)) {
                        "start" -> {
                            sender.send("速度上昇を有効化")
                            Main.isEnable = true
                        }
                        "stop" -> {
                            sender.send("速度上昇を無効化")
                            Main.isEnable = false
                        }
                        "set" -> {
                            walkSpeed = args.getOrNull(1)?.toDoubleOrNull() ?: 0.1
                            sender.send("速度を${walkSpeed}に設定しました")
                        }
                    }
                }
            }
        }
    }
}
