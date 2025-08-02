/*
 * Copyright (c) XZot1K $year. All rights reserved.
 */

package xzot1k.plugins.sp.core.packets.particles.versions;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import xzot1k.plugins.sp.SimplePortals;
import xzot1k.plugins.sp.core.packets.particles.ParticleHandler;

public class PH_Latest implements ParticleHandler {
    @Override
    public void displayParticle(Player player, Location location, float offsetX, float offsetY, float offsetZ, int speed, String enumParticle, int amount) {
        if (enumParticle == null || enumParticle.trim().isEmpty() 
                || enumParticle.equalsIgnoreCase("none") || enumParticle.equalsIgnoreCase("off")) {
            return;
        }
        Particle particle = Particle.valueOf(enumParticle);
        if (!SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_8") && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_9")
                && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_10") && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_11")
                && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_12") && (particle.name().equals("REDSTONE") || particle.name().equals("DUST")))
            player.spawnParticle(particle, location, amount, offsetX, offsetY, offsetZ, new Particle.DustOptions(Color.fromBGR(255, 0, 0), 1));
        else player.spawnParticle(particle, location, amount, offsetX, offsetY, offsetZ, 0);
    }

    @Override
    public void broadcastParticle(Location location, float offsetX, float offsetY, float offsetZ, int speed, String enumParticle, int amount) {
        if (enumParticle == null || enumParticle.trim().isEmpty() 
                || enumParticle.equalsIgnoreCase("none") || enumParticle.equalsIgnoreCase("off")) {
            return;
        }
        Particle particle = Particle.valueOf(enumParticle);
        if (!SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_8") && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_9")
                && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_10") && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_11")
                && !SimplePortals.getPluginInstance().getServerVersion().startsWith("v1_12") && (particle.name().equals("REDSTONE") || particle.name().equals("DUST")))
            location.getWorld().spawnParticle(particle, location, amount, offsetX, offsetY, offsetZ, new Particle.DustOptions(Color.fromBGR(255, 0, 0), 1));
        else location.getWorld().spawnParticle(particle, location, amount, offsetX, offsetY, offsetZ, 0);
    }

}