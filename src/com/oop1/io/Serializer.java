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
            if(decalType == "RED_CROSS")
                decal = Decal.RED_CROSS;
            else if(decalType == "GOLD_STAR")
                decal = Decal.GOLD_STAR;
            else
                decal = Decal.SKULL_AND_CROSSBONES;
            map.getTileAtCoordinates(x, y).setDecal(decal);
        }
    }

    private static void deserializeItems(String itemData, Map map){
        String[] items = itemData.split("%");
        for(String str : items){
            Item item;
            String itemType = str.substring(0, str.indexOf(';'));
            int x = Integer.parseInt(str.substring(str.indexOf(';')+1, str.indexOf(',')));
            int y = Integer.parseInt(str.substring(str.indexOf(',')+1));
            if(itemType == "oneShot")
                item = new OneShotItem();
            else if(itemType == "takeable")
                item = new TakeableItem();
            else
                item = new Obstacle();
            map.getTileAtCoordinates(x, y).setItem(item);
        }
    }

    private static void deserializeTakeableItems(String itemData, Map map){
        String[] items = itemData.split("%");
        for(String str : items){
            Item item = new TakeableItem();
            String[] itemStats = str.split(";");
            int x = Integer.parseInt(itemStats[0].substring(0, str.indexOf(',')));
            int y = Integer.parseInt(itemStats[0].substring(str.indexOf(',')+1));
            String itemName = itemStats[1];
            int strength = Integer.parseInt(itemStats[2]);
            int agility = Integer.parseInt(itemStats[3]);
            int intellect = Integer.parseInt(itemStats[4]);
            int hardiness = Integer.parseInt(itemStats[5]);
            int movementSpeed = Integer.parseInt(itemStats[6]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            //item.addSetModifier(statMod);
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
            Set<Tile> tiles= new HashSet<Tile>();
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
            if(effectType == "healDamage")
                effect = new HealDamage(tiles, damageAmount);
            else if(effectType == "takeDamage")
                effect = new TakeDamage(tiles, damageAmount);
            else if(effectType == "levelUp")
                effect = new LevelUp(tiles);
            else
                effect = new InstantDeath(tiles);
            map.addAreaEffect(effect);
        }
    }

    private static List<Entity> deserializeEntity(String entityData, Map map){
        List<Entity> entityList = new ArrayList<Entity>();
        String[] entities = entityData.split("%");
        for(String str : entities){
            Entity entity = new Entity();
            String[] stats = str.split(";");
            entity.setOrientation(Integer.parseInt(stats[0]));

            int x = Integer.parseInt(stats[1].substring(0, stats[1].indexOf(',')));
            int y = Integer.parseInt(stats[1].substring(stats[1].indexOf(',')+1));
            entity.setLocation(map.getTileAtCoordinates(x,y));

            Occupation o;
            Stats.StatsBuilder sb = new Stats.StatsBuilder();
            if(stats[2] == "SMASHER")
                sb.occupation(new Smasher());
            else if(stats[2] == "SUMMONER")
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
            //sb.livesLeft(Integer.parseInt(stats[10]));
            sb.experience(Integer.parseInt(stats[11]));
            entity.setBaseStats(sb.build());

            entityList.add(entity);
        }

        return entityList;
    }

    private static void deserializeInventory(String inventory, List<Entity> entityList){
        String[] items = inventory.split("%");
        Inventory newInventory = new Inventory();
        int i = 0;
        for(String str : items){
            Item item = new TakeableItem();
            String[] itemStats = str.split(";");
            String itemName = itemStats[0];
            int strength = Integer.parseInt(itemStats[1]);
            int agility = Integer.parseInt(itemStats[2]);
            int intellect = Integer.parseInt(itemStats[3]);
            int hardiness = Integer.parseInt(itemStats[4]);
            int movementSpeed = Integer.parseInt(itemStats[5]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            // Needs this method
            //item.addStatModifier(statMod);
            newInventory.addItem(item);
        }
        entityList.get(0).setInventory(newInventory);
    }

    private static void deserializeEquipment(String inventory, List<Entity> entityList){
        String[] items = inventory.split("%");
        int i = 0;
        for(String str : items){
            Item item = new TakeableItem();
            String[] itemStats = str.split(";");
            String itemName = itemStats[0];
            int strength = Integer.parseInt(itemStats[1]);
            int agility = Integer.parseInt(itemStats[2]);
            int intellect = Integer.parseInt(itemStats[3]);
            int hardiness = Integer.parseInt(itemStats[4]);
            int movementSpeed = Integer.parseInt(itemStats[5]);
            StatModifier statMod = new StatModifier(strength, agility, intellect, hardiness,movementSpeed);

            // Needs this method
            //item.addStatModifier(statMod);
            entityList.get(0).getInventory().equipItem(item);
        }
    }

    public String serialize(GameState state) {
        // TODO: implement this
        return "";
    }

    public static GameState deserialize(String loadData) {
        // TODO: implement this
        // Objects that go into the GameState
        Map loadedMap;
        List<Entity> entityList = new ArrayList<Entity>();

        // Split up the map, decals, items, area effects, entities, and inventory
        String[] data = loadData.split("!");

        // Deal with the map data (map, decals, items, areaEffects)
        loadedMap = deserializeMap(data[1]);
        deserializeDecals(data[2], loadedMap);
        deserializeItems(data[3], loadedMap);
        deserializeTakeableItems(data[4], loadedMap);
        deserializeAreaEffects(data[5], loadedMap);

        // Deal with entity data
        entityList = deserializeEntity(data[6], loadedMap);
        deserializeInventory(data[7], entityList);
        deserializeEquipment(data[8], entityList);



        return new GameState();
    }
}
