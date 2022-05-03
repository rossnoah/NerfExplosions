package com.notablenoah.nerfexplosions

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin


var multiplier = 0.5
 var plugin: Plugin? = null

class NerfExplosions : JavaPlugin(),Listener {
    override fun onEnable() {
        plugin = this

        (plugin as NerfExplosions).saveDefaultConfig()
        multiplier = (plugin as NerfExplosions).config.getDouble("multiplier")
        Bukkit.getLogger().info("[NerfExplosions] Multiplier is at $multiplier")
        Bukkit.getPluginManager().registerEvents(this,this)
        getCommand("NerfExplosionsReload")!!.setExecutor(ReloadCommand())
    }

    @EventHandler
    fun onCrystal(e: EntityDamageEvent){
            if(e.entity is Player){
            if(e.cause== EntityDamageEvent.DamageCause.ENTITY_EXPLOSION||
                    e.cause==EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
                e.damage*= multiplier


            }
        }
    }


    companion object{
        fun updateMultiplier(){
            plugin?.reloadConfig()
               multiplier = (plugin as NerfExplosions).config.getDouble("multiplier")
            Bukkit.getLogger().info("[NerfExplosions] Multiplier is at $multiplier")

        }

    }

}