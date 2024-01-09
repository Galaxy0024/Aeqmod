package com.aequitas.aeqmod.utils;

import com.google.gson.*;

public class HandleGuildsJson {
    private static String guildsJson = "[\n" +
            "  { name: 'Avicia', prefix: 'AVO' },\n" +
            "  { name: 'KongoBoys', prefix: 'DUDE' },\n" +
            "  { name: 'Aequitas', prefix: 'Aeq' },\n" +
            "  { name: 'Titans Valor', prefix: 'ANO' },\n" +
            "  { name: 'Empire of Sindria', prefix: 'ESI' },\n" +
            "  { name: 'The Aquarium', prefix: 'TAq' },\n" +
            "  { name: 'Paladins United', prefix: 'PUN' },\n" +
            "  { name: 'Sins of Seedia', prefix: 'SDU' },\n" +
            "  { name: 'The Clowns', prefix: 'MALD' },\n" +
            "  { name: 'Idiot Co', prefix: 'ICo' },\n" +
            "  { name: 'Nefarious Ravens', prefix: 'NFR' },\n" +
            "  { name: 'TerraLune', prefix: 'UTL' },\n" +
            "  { name: 'The Simple Ones', prefix: 'ILQ' },\n" +
            "  { name: 'Profession Heaven', prefix: 'PROF' },\n" +
            "  { name: 'busted moments', prefix: 'fuy' },\n" +
            "  { name: 'Ira Sin of Wrath', prefix: 'Wath' },\n" +
            "  { name: 'Era Meliora', prefix: 'MELI' },\n" +
            "  { name: 'Gopniks', prefix: 'GKS' },\n" +
            "  { name: 'Emorians', prefix: 'ERN' },\n" +
            "  { name: 'Nerfuria', prefix: 'Nia' },\n" +
            "  { name: 'ShadowFall', prefix: 'Shy' },\n" +
            "  { name: 'TheNoLifes', prefix: 'TNL' },\n" +
            "  { name: 'HackForums', prefix: 'Hax' },\n" +
            "  { name: 'Wynn Legacy', prefix: 'WNLY' },\n" +
            "  { name: 'Kingdom Foxes', prefix: 'Fox' },\n" +
            "  { name: 'IceBlue Team', prefix: 'IBT' },\n" +
            "  { name: 'Lux Nova', prefix: 'LXA' },\n" +
            "  { name: 'ChinaNumberOne', prefix: 'CNM' },\n" +
            "  { name: 'Anime Lovers', prefix: 'Zamn' },\n" +
            "  { name: 'The Mage Legacy', prefix: 'Mag' },\n" +
            "  { name: 'Guardian of Wynn', prefix: 'GsW' },\n" +
            "  { name: 'Eden', prefix: 'EDN' },\n" +
            "  { name: 'The Broken Gasmask', prefix: 'TBGM' },\n" +
            "  { name: 'The Fats', prefix: 'FATS' },\n" +
            "  { name: 'Gabameno', prefix: 'GBE' },\n" +
            "  { name: 'Germany', prefix: 'DEU' },\n" +
            "  { name: 'TruthSworD', prefix: 'Tsd' },\n" +
            "  { name: 'Imperial', prefix: 'Imp' },\n" +
            "  { name: 'Achte Shadow', prefix: 'ASh' },\n" +
            "  { name: 'Wheres The Finish', prefix: 'WFN' },\n" +
            "  { name: 'ForsakenLaws', prefix: 'FKL' },\n" +
            "  { name: 'LittleBunny Land', prefix: 'LBL' },\n" +
            "  { name: 'Refugium', prefix: 'Refu' },\n" +
            "  { name: 'LaMafiaDeRagni', prefix: 'LMDR' },\n" +
            "  { name: 'Blacklisted', prefix: 'BLA' },\n" +
            "  { name: 'Fantasy', prefix: 'Fux' },\n" +
            "  { name: 'Discoverers', prefix: 'DVS' },\n" +
            "  { name: 'Nuggets', prefix: 'Nugs' },\n" +
            "  { name: 'Gang of Fools', prefix: 'FOOL' },\n" +
            "  { name: 'Wrath Of Poseidon', prefix: 'Oce' },\n" +
            "  { name: 'DiamondDeities', prefix: 'DDT' },\n" +
            "  { name: 'Atlas Inc', prefix: 'AIn' },\n" +
            "  { name: 'Jasmine Dragon', prefix: 'LEAF' },\n" +
            "  { name: 'The Forest', prefix: 'Wood' },\n" +
            "  { name: 'BRIS', prefix: 'BRIS' },\n" +
            "  { name: 'Phantom Hearts', prefix: 'Phi' },\n" +
            "  { name: 'The Dark Phoenix', prefix: 'TNI' },\n" +
            "  { name: 'TVietNam', prefix: 'VNP' },\n" +
            "  { name: 'Roses', prefix: 'oxo' },\n" +
            "  { name: 'Ower Sponge', prefix: 'OWP' },\n" +
            "  { name: 'Alternate Accounts', prefix: 'Alts' },\n" +
            "  { name: 'Avaritia', prefix: 'AVTA' },\n" +
            "  { name: 'Opus Maximus', prefix: 'OpM' },\n" +
            "  { name: 'Forever Twilight', prefix: 'FXX' },\n" +
            "  { name: 'WrathOfTheFallen', prefix: 'WFa' },\n" +
            "  { name: 'Luminosity', prefix: 'Lmi' },\n" +
            "  { name: 'Ultra Violet', prefix: 'Rays' },\n" +
            "  { name: 'Germany Elite', prefix: 'GMY' },\n" +
            "  { name: 'Fuzzy Spiders', prefix: 'cxz' },\n" +
            "  { name: 'Winds of Nigh', prefix: 'WNi' },\n" +
            "  { name: 'TheButteryWarriors', prefix: 'TBUH' },\n" +
            "  { name: 'JavaScript Object Notation', prefix: 'JSON' },\n" +
            "  { name: 'Revival', prefix: 'VIVA' },\n" +
            "  { name: 'Sequoia', prefix: 'SEQ' },\n" +
            "  { name: 'Minerva', prefix: 'Min' },\n" +
            "  { name: 'Spectral Cabbage', prefix: 'SPC' },\n" +
            "  { name: 'GlowOfDust', prefix: 'MDM' },\n" +
            "  { name: 'The Hive', prefix: 'THI' },\n" +
            "  { name: 'SICA Team', prefix: 'FEU' },\n" +
            "  { name: 'Astrum Pantheon', prefix: 'Apa' },\n" +
            "  { name: 'Heartbreakers', prefix: 'Love' },\n" +
            "  { name: 'Realm of uz', prefix: 'UZB' },\n" +
            "  { name: 'UltimateXeons', prefix: 'UXs' },\n" +
            "  { name: 'Last Order', prefix: 'IPS' },\n" +
            "  { name: 'Jake', prefix: 'Jake' },\n" +
            "  { name: 'Crystal Iris', prefix: 'Cona' },\n" +
            "  { name: 'Forgotten Library', prefix: 'FGL' },\n" +
            "  { name: 'Vindicator', prefix: 'VMZ' },\n" +
            "  { name: 'Solis Crudelia', prefix: 'LxT' },\n" +
            "  { name: 'Breadskate', prefix: 'BSE' },\n" +
            "  { name: 'Skyborn', prefix: 'kyn' },\n" +
            "  { name: 'La League Des Baguettes', prefix: 'Pain' },\n" +
            "  { name: 'Tartarus Wrath', prefix: 'Fate' },\n" +
            "  { name: 'Calvish', prefix: 'bean' },\n" +
            "  { name: 'Wynn Theory', prefix: 'WTh' },\n" +
            "  { name: 'WynnFairyTail', prefix: 'WFT' },\n" +
            "  { name: 'BuildCraftia', prefix: 'BCr' },\n" +
            "  { name: 'Roselia', prefix: 'RZL' },\n" +
            "  { name: 'RedLotus', prefix: 'OUS' },\n" +
            "  { name: 'Woodpeckers', prefix: 'Ped' }\n" +
            "]";

    private static JsonArray jsonArray;

    public static void setJsonArray() {
        JsonParser parser = new JsonParser();
        jsonArray = parser.parse(guildsJson).getAsJsonArray();
    }

    public static String getValueFromJson(String key) {
        System.out.println(key);
        for (JsonElement element : jsonArray) {
            JsonObject obj = element.getAsJsonObject();
            if (obj.has("name") && obj.get("name").getAsString().equals(key)) {
                return obj.get("prefix").getAsString();
            }
        }
        return key;
    }
}
