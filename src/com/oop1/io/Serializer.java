package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.entity.*;
import com.oop1.items.*;
import com.oop1.map.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Serializer {

    // Serializing functions
    private static String serializeMap(GameState state){
        Map map = state.getMap().get(0);
        String str = map.toString();
        System.out.println(str);

        return str;
    }

    private static String serializeDecals(GameState state){
        Map map = state.getMap().get(0);
        StringBuilder str = new StringBuilder();
        Tile[][] tiles = map.getTiles();
        for(int row = 0; row < tiles.length; ++row){
            for(int col = 0; col < tiles[row].length; ++col){
                if(tiles[row][col].hasDecal()) {
                    str.append(tiles[row][col].getDecal().toString());
                    str.append(";");
                    str.append(row);
                    str.append(",");
                    str.append(col);
                    str.append("%\n");
                }
            }
        }
        str.append("\n");
        return str.toString();
    }

    private static String serializeItems(GameState state){
        Map map = state.getMap().get(0);
        StringBuilder str = new StringBuilder();
        StringBuilder takeableStr = new StringBuilder();
        Tile[][] tiles = map.getTiles();
        for(int row = 0; row < tiles.length; ++row){
            for(int col = 0; col < tiles[row].length; ++col){
                if(tiles[row][col].hasItem()) {
                    if(tiles[row][col].getItem().toString().equals("takeableItem")){
                        TakeableItem item = ((TakeableItem)tiles[row][col].getItem());
                        StatModifier sm = item.getStatModifiers().get(0);
                        takeableStr.append(row);
                        takeableStr.append(",");
                        takeableStr.append(col);
                        takeableStr.append(";");
                        takeableStr.append(sm.getStrengthModifier());
                        takeableStr.append(";");
                        takeableStr.append(sm.getAgilityModifier());
                        takeableStr.append(";");
                        takeableStr.append(sm.getIntellectModifier());
                        takeableStr.append(";");
                        takeableStr.append(sm.getHardinessModifier());
                        takeableStr.append(";");
                        takeableStr.append(sm.getMovementModifier());
                        takeableStr.append("%\n");
                    }
                    else {
                        str.append(tiles[row][col].getItem().toString());
                        str.append(";");
                        str.append(row);
                        str.append(",");
                        str.append(col);
                        str.append("%\n");
                    }
                }
            }
        }
        str.append("!Takeable items on map!\n");
        str.append(takeableStr.toString());
        return str.toString();
    }


    // Deserializing functions
    private static Map deserializeMap(String mapData){
        int numRows = 0, numCols = 0;
        char[] mapCharArray = mapData.toCharArray();
        for(char c : mapCharArray){
            if(c == '%')
                ++numRows;
        }
        numCols = mapData.indexOf("%");
        Tile[][] tiles = new Tile[numRows][numCols];
        int i = 0, j = 0;
        for(char c : mapCharArray){
            if(c == 'G')
                tiles[i][j++] = new Tile(TerrainType.GRASS);
            else if(c == 'W')
                tiles[i][j++] = new Tile(TerrainType.WATER);
            else if(c == 'M')
                tiles[i][j++] = new Tile(TerrainType.MOUNTAIN);
            else if(c == '%'){
                ++i;
                j = 0;
            }
        }
        Map mapReturn = new Map();
        mapReturn.setTiles(tiles);
        return mapReturn;
    }

    private static void deserializeDecals(String decalData, Map map){
        String[] decals = decalData.split("%");
        for(String str : decals){
            Decal decal;
            String decalType = str.substring(0, str.indexOf(';'));
            int x = Integer.parseInt(str.substring(str.indexOf(';')+1, str.indexOf(',')));
            int y = Integer.parseInt(str.substring(str.indexOf(',')+1));
            //if(decalType == "RED_CROSS")
            //    decal = Decal.RED_CROSS;
            //else if(decalType == "GOLD_STAR")
            //    decal = Decal.GOLD_STAR;
            //else
            //    decal = Decal.SKULL_AND_CROSSBONES;
            //map.getTileAtCoordinates(x, y).setDecal(decal);
        }
    }

    private static void deserializeItems(String itemData, Map map){
        String[] items = itemData.split("%");
        for(String str : items){
            Item item;
            String itemType = str.substring(0, str.indexOf(';'));
            int x = Integer.parseInt(str.substring(str.indexOf(';')+1, str.indexOf(',')));
            int y = Integer.parseInt(str.substring(str.indexOf(',')+1));
            if(itemType.equals("oneShot"))
                item = new OneShotItem(map.getTileAtCoordinates(x, y));
            else if(itemType.equals("interactive"))
                item = new InteractiveItem();
            else
                item = new Obstacle();
            map.getTileAtCoordinates(x, y).setItem(item);
        }
    }

    private static void deserializeTakeableItems(String itemData, Map map){
        String[] items = itemData.split("%");
        for(String str : items){
            String[] itemStats = str.split(";");
            int x = Integer.parseInt(itemStats[0].substring(0, str.indexOf(',')));
            int y = Integer.parseInt(itemStats[0].substring(str.indexOf(',')+1));
            TakeableItem item = new TakeableItem(map.getTileAtCoordinates(x,y));
            int strength = Integer.parseInt(itemStats[1]);
            int agility = Integer.parseInt(itemStats[2]);
            int intellect = Integer.parseInt(itemStats[3]);
            int hardiness = Integer.parseInt(itemStats[4]);
            int movementSpeed = Integer.parseInt(itemStats[5]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            item.addStatModifier(statMod);
            map.getTileAtCoordinates(x, y).setItem(item);
        }
    }

    private static void deserializeAreaEffects(String effectData, Map map){
        String[] effects = effectData.split("%");
        for(String str : effects){
            AreaEffect effect;
            int damageAmount = 10;
            String effectType = str.substring(0, str.indexOf(';'));
            str = str.substring(str.indexOf(';')+1);
            String[] locations = str.split(",");
            Set<Tile> tiles = new HashSet<>();
            int x, y;
            for(int i = 0; i < locations.length; ++i){
                x = Integer.parseInt(locations[i]);
                ++i;
                if(locations[i].contains("-")){
                    damageAmount = Integer.parseInt(locations[i].substring(locations[i].indexOf("-")+1));
                    y = Integer.parseInt(locations[i].substring(0, locations[i].indexOf("-")));
                }
                else
                    y = Integer.parseInt(locations[i]);

                Tile t = map.getTileAtCoordinates(x, y);
                tiles.add(t);
            }
            if(effectType.equals("healDamage"))
                effect = new HealDamage(tiles, damageAmount);
            else if(effectType.equals("takeDamage"))
                effect = new TakeDamage(tiles, damageAmount);
            else if(effectType.equals("levelUp"))
                effect = new LevelUp(tiles);
            else
                effect = new InstantDeath(tiles);
            map.addAreaEffect(effect);
        }
    }

    private static List<Entity> deserializeEntity(String entityData, Map map){
        List<Entity> entityList = new ArrayList<>();
        String[] entities = entityData.split("%");
        for(String str : entities){
            Entity entity = new Entity();
            String[] stats = str.split(";");
            entity.setOrientation(Integer.parseInt(stats[0]));

            int x = Integer.parseInt(stats[1].substring(0, stats[1].indexOf(',')));
            int y = Integer.parseInt(stats[1].substring(stats[1].indexOf(',')+1));
            entity.setLocation(map.getTileAtCoordinates(x,y));

            Stats.StatsBuilder sb = new Stats.StatsBuilder();
            if(stats[2].equals("SMASHER"))
                sb.occupation(new Smasher());
            else if(stats[2].equals("SUMMONER"))
                sb.occupation(new Summoner());
            else
                sb.occupation(new Sneak());

            sb.strength(Integer.parseInt(stats[3]));
            sb.agility(Integer.parseInt(stats[4]));
            sb.intellect(Integer.parseInt(stats[5]));
            sb.hardiness(Integer.parseInt(stats[6]));
            sb.movementSpeed(Double.parseDouble(stats[7]));
            sb.currentMana(Integer.parseInt(stats[8]));
            sb.currentLife(Integer.parseInt(stats[9]));
            sb.livesLeft(Integer.parseInt(stats[10]));
            sb.experience(Integer.parseInt(stats[11]));
            entity.setBaseStats(sb.build());

            entityList.add(entity);
        }

        return entityList;
    }

    private static void deserializeInventory(String inventory, List<Entity> entityList){
        String[] items = inventory.split("%");
        Inventory newInventory = new Inventory();
        for(String str : items){
            TakeableItem item = new TakeableItem(new Tile(TerrainType.GRASS));
            String[] itemStats = str.split(";");
            int strength = Integer.parseInt(itemStats[0]);
            int agility = Integer.parseInt(itemStats[1]);
            int intellect = Integer.parseInt(itemStats[2]);
            int hardiness = Integer.parseInt(itemStats[3]);
            int movementSpeed = Integer.parseInt(itemStats[4]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            item.addStatModifier(statMod);
            newInventory.addItem(item);
        }
        entityList.get(0).setInventory(newInventory);
    }

    private static void deserializeEquipment(String inventory, List<Entity> entityList){
        String[] items = inventory.split("%");
        for(String str : items){
            TakeableItem item = new TakeableItem(new Tile(TerrainType.GRASS));
            String[] itemStats = str.split(";");
            int strength = Integer.parseInt(itemStats[0]);
            int agility = Integer.parseInt(itemStats[1]);
            int intellect = Integer.parseInt(itemStats[2]);
            int hardiness = Integer.parseInt(itemStats[3]);
            int movementSpeed = Integer.parseInt(itemStats[4]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            item.addStatModifier(statMod);
            entityList.get(0).getInventory().equipItem(item);
        }
    }

    public static String serialize(GameState state) {
        StringBuilder retString = new StringBuilder();

        retString.append("!Map!\n");
        retString.append(serializeMap(state));
        retString.append("!Decals!\n");
        retString.append(serializeDecals(state));
        retString.append("!Items on map!\n");
        retString.append(serializeItems(state));
        retString.append("!Area effects!\n");
        //retString.append(serializeAreaEffects(state));
        retString.append("!Entities!\n");

        retString.append("!Items in inventory!\n");

        retString.append("!Items in equipment!\n");

        return retString.toString();
    }

    public static GameState deserialize(String loadData) {
        Map loadedMap;
        List<Entity> entityList = new ArrayList<>();
        List<Map> mapList = new ArrayList<>();

        // Split up the map, decals, items, area effects, entities, and inventory
        String[] data = loadData.split("!");

        // Deal with the map data (map, decals, items, areaEffects)
        loadedMap = deserializeMap(data[2]);
        deserializeDecals(data[4], loadedMap);
        deserializeItems(data[6], loadedMap);
        deserializeTakeableItems(data[8], loadedMap);
        deserializeAreaEffects(data[10], loadedMap);
        mapList.add(loadedMap);

        // Deal with entity data
        entityList = deserializeEntity(data[12], loadedMap);
        deserializeInventory(data[14], entityList);
        deserializeEquipment(data[16], entityList);

        GameState gs = new GameState();
        gs.setMap(mapList);
        gs.setEntities(entityList);

        return gs;
    }
}
