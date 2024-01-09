package com.aequitas.aeqmod.events;

import com.aequitas.aeqmod.utils.HandleGuildsJson;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArmorStandDetectorEvent {
    // Define the specific string that must match the name of the armor stand
    private static final String TARGET_NAME = "Leaderboard";

    Pattern originalPattern = Pattern.compile("^(\\u00A7[0-9a-zA-F]+\\u00A7*[0-9a-zA-F]*\\d+\\u00A7[0-9a-rA-F]\\u00A7[0-9a-fA-F] - \\u00A7[0-9a-fA-F])([a-zA-Z\\s]+)\\u00A7[0-9a-fA-F]+ \\((\\d+) SR\\)$");
    Pattern modifiedPattern = Pattern.compile("^(\\u00A7[0-9a-zA-F]+\\u00A7*[0-9a-zA-F]*\\d+\\u00A7[0-9a-rA-F]\\u00A7[0-9a-fA-F] - \\u00A7[0-9a-fA-F])([a-zA-Z\\s]+)\\u00A7[0-9a-fA-F]+ \\((\\d+) SR\\) \\u00A7[0-9a-fA-F]+\\+[a-zA-Z0-9\\.]+$");

    public static boolean isBetween(BlockPos playerPos, BlockPos coord1, BlockPos coord2) {
        int xMin = Math.min(coord1.getX(), coord2.getX());
        int xMax = Math.max(coord1.getX(), coord2.getX());
        int yMin = Math.min(coord1.getY(), coord2.getY());
        int yMax = Math.max(coord1.getY(), coord2.getY());
        int zMin = Math.min(coord1.getZ(), coord2.getZ());
        int zMax = Math.max(coord1.getZ(), coord2.getZ());

        return xMin <= playerPos.getX() && playerPos.getX() <= xMax
                && yMin <= playerPos.getY() && playerPos.getY() <= yMax
                && zMin <= playerPos.getZ() && playerPos.getZ() <= zMax;
    }

    public static String formatNumber(int num) {
        if (num < 1000) {
            return Integer.toString(num);
        } else if (num < 1000000) {
            return String.format("%.2fk", num / 1000.0);
        } else {
            return String.format("%.2fm", num / 1000000.0);
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        BlockPos playerPos = player.getPosition();
        World playerWorld = player.world;
        int previousSR = -1;

        //If player is not in Guild hall, return
        if(!isBetween(
                playerPos,
                new BlockPos(-313, 47, -4966),
                new BlockPos(-289, 60, -4986))
        ) {
            return;
        }

        // Get a list of all armor stands at the player's position
        List<EntityArmorStand> nearbyArmorStands = playerWorld.getEntitiesWithinAABB(EntityArmorStand.class, new AxisAlignedBB(playerPos.add(15, 15, 15), playerPos.add(-15, -15, -15)));

        // Loop through the nearby armor stands
        for (EntityArmorStand armorStand : nearbyArmorStands) {
            // Check if the name of the armor stand matches the target name
            if (armorStand.getName().contains(TARGET_NAME)) {
                BlockPos armorStandPos = armorStand.getPosition();
                // Get a list of all armor stands below the target armor stand
                List<EntityArmorStand> belowArmorStands = playerWorld.getEntitiesWithinAABB(EntityArmorStand.class, new AxisAlignedBB(armorStandPos.add(1, 0, 1), armorStandPos.add(-1, -5, -1)));

                // Change the names of all armor stands below the target
                for (EntityArmorStand belowArmorStand : belowArmorStands) {
                    String armorStandName = belowArmorStand.getCustomNameTag();

                    Matcher matcher = originalPattern.matcher(armorStandName).matches() ? originalPattern.matcher(armorStandName) : modifiedPattern.matcher(armorStandName);
                    if(matcher.matches()) {
                        String guildName = matcher.group(2);
                        int guildSR = Integer.parseInt(matcher.group(3));
                        if(previousSR != -1) {
                            int srLead = guildSR - previousSR;
                            belowArmorStand.setCustomNameTag(matcher.group(1) + HandleGuildsJson.getValueFromJson(TextFormatting.getTextWithoutFormattingCodes(guildName)) + "\u00A7d (" + guildSR + " SR) \u00A79+" + formatNumber(srLead));
                        } else {
                            belowArmorStand.setCustomNameTag(matcher.group(1) + HandleGuildsJson.getValueFromJson(TextFormatting.getTextWithoutFormattingCodes(guildName)) + "\u00A7d (" + guildSR + " SR)");
                        }

                        previousSR = guildSR;
                    }
                }
            }
        }
    }
}
