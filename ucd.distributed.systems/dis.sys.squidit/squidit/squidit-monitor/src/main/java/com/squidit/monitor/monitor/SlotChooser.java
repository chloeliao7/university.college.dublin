package com.squidit.monitor.monitor;
import java.util.*;


public class SlotChooser {
  public int getSlot(HashMap<Integer, Integer> totalServerObjects) {
    int smallestServerObjects = 0;
    int serverSlotUrlCounter = 0;
    smallestServerObjects = totalServerObjects.get(0);
    for (int i = 1; i < totalServerObjects.size() - 1; i++) {
      if (smallestServerObjects > totalServerObjects.get(i)) {
        smallestServerObjects = totalServerObjects.get(i);
        serverSlotUrlCounter = i;
      }
    }
    return serverSlotUrlCounter;
  }
}
