package org.golde.bukkit.tempestsbox.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.block.Block;

public class MathUtils {

	private static Random r = new Random();

	public static List<Block> removeRandom(List<Block> l){
		List<Block> nl = new ArrayList<Block>();
		for(int i = 0; i < l.size(); i++){
			if(r.nextBoolean()){
				nl.add(l.get(i));
			}
		}
		return nl;
	}
	
	public static int hoursToTicks(int hours){return hours*60*60*20;}
	public static int minToTicks(int min){return min*60*20;}
	public static int secondsToTicks(int seconds){return seconds*20;}

}
