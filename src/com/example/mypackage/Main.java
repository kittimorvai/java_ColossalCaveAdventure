package com.example.mypackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map <Integer,Location> locations = new HashMap<>();

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<String, Integer> tempExit = new HashMap<>();
	locations.put(0, new Location(0, "Im sitting in front of my computer learning Java", tempExit));

	//location 1 - end of the road
        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("N", 5);
        tempExit.put("S", 4);
        tempExit.put("E", 3);
        locations.put(1, new Location(1, "You are standing at the end of the road next to a small brick building", tempExit));

    // location 2  - top of the hill
        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        tempExit.put("S", 4);
        tempExit.put("E", 1);
        locations.put(2, new Location(2, "You are at the top of the hill", tempExit));

    //location 3 - inside a building
        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

    //location 4 - valley
        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

    //location 5 - forest
        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));


        int loc = 1;            //value is 1 cause we always start from the first location (the end of the road)
	while (true) {
        System.out.println(locations.get(loc).getDescription());
        if (loc == 0) {
            break;
        }
        Map<String, Integer> exits = locations.get(loc).getExits();
        System.out.println("Available exits are: ");
        for (String exit : exits.keySet()) {
            System.out.print(exit + ", ");
        }
        System.out.println();
        String direction = scanner.nextLine().toLowerCase();
        String[] splitInstruction = direction.split(" ");
        String directionFound;

        label:
        for (String i : splitInstruction) {
            switch (i) {
                case "east":
                    directionFound = "E";
                    if (exits.containsKey(directionFound)) {
                        loc = exits.get(directionFound);
                    } else {
                        System.out.println("You cannot go in that direction.");
                    }
                    break;
                case "south":
                    directionFound = "S";
                    if (exits.containsKey(directionFound)) {
                        loc = exits.get(directionFound);
                    } else {
                        System.out.println("You cannot go in that direction.");
                    }
                    break;
                case "west":
                    directionFound = "W";
                    if (exits.containsKey(directionFound)) {
                        loc = exits.get(directionFound);
                    } else {
                        System.out.println("You cannot go in that direction.");
                    }
                    break;
                case "north":
                    directionFound = "N";
                    if (exits.containsKey(directionFound)) {
                        loc = exits.get(directionFound);
                    } else {
                        System.out.println("You cannot go in that direction.");
                    }
                    break;
                case "quit":
                case "q":
                    directionFound = "Q";
                    System.out.println("Quitting game.");
                    loc = exits.get(directionFound);
                    break label;
            }
        }
    }
    }
}
