package com.experis.anagram;

import java.util.ArrayList;

public class MultiAnagram {
    private ArrayList<String> worlds;

    public MultiAnagram(ArrayList<String> worlds) {
        this.worlds = worlds;
    }

    public ArrayList<ArrayList<String>> find() {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int index = 0;

        while (worlds.size() != 0) {

            String world = getAndRemoveWorld();
            ArrayList<String> anagramResult = getAnagramResultWorld(world);
            addToResult(result, world, anagramResult);
        }
        return result;
    }

    private ArrayList<String> getAnagramResultWorld(String world) {
        Anagram anagram = new Anagram(world, worlds);
        ArrayList<String> anagramResult = (ArrayList<String>) anagram.anagram();
        return anagramResult;
    }

    private String getAndRemoveWorld() {
        String world = worlds.get(0);
        worlds.remove(0);
        return world;
    }

    private void addToResult(ArrayList<ArrayList<String>> result, String world, ArrayList<String> anagramResult) {
        if (anagramResult.size() != 0) {
            worlds.removeAll(anagramResult);
            anagramResult.add(0, world);
            result.add(anagramResult);
        }
    }
}
