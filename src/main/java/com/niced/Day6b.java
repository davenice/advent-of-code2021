package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Day6b {

    static class LanternFishSimulator {
        // a mechanism to allow changing the age assigned to each count
        Map<Object, Long> keyToCount = new HashMap<>();
        Map<Object, Integer> keyToAge = new HashMap<>();

        static long simulateAndGetCount(int initialAge, int daysToSimulate) {
            LanternFishSimulator simulator = new LanternFishSimulator();
            simulator.addFishOfAge(initialAge);
            for (int i = 0; i < daysToSimulate; i++) {
                simulator.tick();
            }
            return simulator.countAllFish();
        }

        private long countAllFish() {
            return keyToCount.values().stream().collect(Collectors.summingLong(e -> Long.valueOf(e)));
        }

        private LanternFishSimulator() {}

        private void tick() {
            // find all ages and take one away
            for (Entry<Object, Integer> entry : keyToAge.entrySet()) {
                keyToAge.put(entry.getKey(), entry.getValue()-1);
            }

            // check for fish with age -1, reset to 6, add another fish with age 8
            Object zeroKey = findKeyForAge(-1);
            if (zeroKey != null) {
                long zeroCount = keyToCount.get(zeroKey);
                Object sixKey = findKeyForAge(6);
                if (sixKey != null) {
                    // if there's already a set of sixes, add the zeroes on
                    keyToCount.put(sixKey, keyToCount.get(sixKey) + zeroCount);
                } else {
                    sixKey = new Object();
                    keyToAge.put(sixKey, 6);
                    keyToCount.put(sixKey, zeroCount);
                }
                // change zeroes into 8s
                keyToAge.put(zeroKey, 8);
            }

        }

        private Object findKeyForAge(int age) {
            Set<Entry<Object, Integer>> entrySet = keyToAge.entrySet();
            for (Entry<Object,Integer> entry : entrySet) {
                if(entry.getValue().equals(age)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        private Object addFishOfAge(int age) {
            Set<Entry<Object, Integer>> entrySet = keyToAge.entrySet();
            for (Entry<Object,Integer> entry : entrySet) {
                if(entry.getValue().equals(age)) {
                    Object key = entry.getKey();
                    if(keyToCount.containsKey(key)) {
                        long count = keyToCount.get(key);
                        keyToCount.put(key, count+1);
                        return key;
                    }
                }
            }
            Object key = new Object();
            keyToAge.put(key, age);
            keyToCount.put(key, 1L);
            return key;
        }

    }

    Map<Integer, Long> spawnMap = new HashMap<>();
    private void populateSpawnMap(int maxInitialAgeToMap, int daysToMapFor) {
        for (int i=1; i<=maxInitialAgeToMap; i++) {
            spawnMap.put(i, LanternFishSimulator.simulateAndGetCount(i, daysToMapFor));
        }
    }

    /* a different approach from the first part of day 6.
     * ... each of the fishes are independent, so go through modelling
     * the options in turn in a spawn map - final count with initial
     * age 1, final count with initial age 2 etc.
     * ... to speed up when modelling a large number of days, i switched
     * from modelling fish as objects in a list, to just tracking the number
     * of fish at each age. to do this i change leave the counts as they 
     * are and just increment the age each tick.
     */ 
    public long run(String filename, int days) throws IOException {
        populateSpawnMap(5, days);

        String[] fish = parseFile(filename);
        long count = 0;
        for (String string : fish) {
            int x = Integer.parseInt(string);
            count += spawnMap.get(x);
        }
        return count;
    }
    
    public String[] parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        String line = reader.readLine();
        String[] fish = line.split(",");
        return fish;
    }

}
