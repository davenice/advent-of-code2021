package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day6 {

    static class LanternFish {
        int timer;

        public LanternFish tick() {
            if (timer == 0) {
                timer = 6;
                return LanternFish.spawn();
            }
            timer--;
            return null;
        }

        private LanternFish(int initialTimer) {
            timer = initialTimer;
        }

        public static LanternFish spawn() {
            return new LanternFish(8);
        }

        public static LanternFish spawn(int timer) {
            return new LanternFish(timer);
        }

        @Override
        public String toString() {
            return Integer.toString(timer);
        }
    }

    public int run(String filename, int days) throws IOException {
        String[] fish = parseFile(filename);
        List<LanternFish> fishes = new ArrayList<>();
        for (String string : fish) {
            fishes.add(LanternFish.spawn(Integer.parseInt(string)));
        }
        for(int day = 0; day < days; day++) {
            List<LanternFish> newFishes = new ArrayList<>();
            for (LanternFish lanternFish : fishes) {
                LanternFish spawn = lanternFish.tick();
                if (spawn != null) newFishes.add(spawn);
            }
            fishes.addAll(newFishes);
        }
        return fishes.size();
    }
    
    public String[] parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        String line = reader.readLine();
        String[] fish = line.split(",");
        return fish;
    }

}
