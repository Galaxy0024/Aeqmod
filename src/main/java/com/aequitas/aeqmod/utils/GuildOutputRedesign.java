package com.aequitas.aeqmod.utils;

import net.minecraft.util.text.TextFormatting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GuildOutputRedesign {
    public static void execute(List<String> resourcesLore) {
        HashMap<String, Integer> productions = new HashMap<>();
        HashMap<String, Integer> costs = new HashMap<>();
        HashMap<String, Double> differences = new HashMap<>();

        String[] resourceTypes = { "Emeralds", "Ore", "Wood", "Fish", "Crops" };

        int overallCostIndex = -1;
        for (String resourceLoreLine : resourcesLore) {
            String[] words = resourceLoreLine.split(" ");
            if (resourceLoreLine.contains("Overall Cost (per hour)"))
                overallCostIndex = resourcesLore.indexOf(resourceLoreLine);
            for (String resourceType : resourceTypes) {
                if (resourceLoreLine.contains(String.format("%s per Hour", resourceType ))) {
                    String resourceCount = TextFormatting.getTextWithoutFormattingCodes(words[Arrays.asList(words).indexOf(resourceType) - 1]);
                    if (resourceCount == null)
                        return;
                    productions.put(resourceType, Integer.parseInt(resourceCount));
                }
            }
        }
        if (overallCostIndex == -1)
            return;
        try {
            for (int j = 1; j <= resourceTypes.length; j++) {
                String resourceType = resourceTypes[j - 1];
                String resourceTypeCost = TextFormatting.getTextWithoutFormattingCodes(resourcesLore.get(overallCostIndex + j).split(" ")[Math.min(j, 2)]);
                if (resourceTypeCost == null)
                    return;
                costs.put(resourceType, Integer.parseInt(resourceTypeCost));
                double resourceDifference = (productions.get(resourceType) - costs.get(resourceType)) / 100.0D;
                differences.put(resourceType, Math.floor(resourceDifference) / 10.0D);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 1; i <= resourceTypes.length; i++) {
            String resourceType = resourceTypes[i - 1];
            if (differences.get(resourceType) >= 0.0D) {
                resourcesLore.set(overallCostIndex + i, resourcesLore.get(overallCostIndex + i) + TextFormatting.DARK_GREEN + " (+" + differences.get(resourceType) + "k)");
            } else {
                resourcesLore.set(overallCostIndex + i, resourcesLore.get(overallCostIndex + i) + TextFormatting.RED + " (" + differences.get(resourceType) + "k)");
            }
        }
    }
}
