package io.asish.models;

public class Bowler {
	
	int bowlsBowled;
	int runsConcede;
	int wkts;
	int WktsByBowledOrLBW;
	int maidenOvers;
	boolean didBowl;
	public boolean isDidBowl() {
		return didBowl;
	}
	public void setDidBowl(String didBowl) {
		didBowl.toLowerCase();
		if(didBowl.contains("yes"))
		this.didBowl = true;
		else
			this.didBowl = false;
	}
	public int getBowlsBowled() {
		return bowlsBowled;
	}
	public void setBowlsBowled(int bowlsBowled) {
		this.bowlsBowled = bowlsBowled;
	}
	public int getRunsConcede() {
		return runsConcede;
	}
	public void setRunsConcede(int runsConcede) {
		this.runsConcede = runsConcede;
	}
	public int getWkts() {
		return wkts;
	}
	public void setWkts(int wkts) {
		this.wkts = wkts;
	}
	public int getWktsByBowledOrLBW() {
		return WktsByBowledOrLBW;
	}
	public void setWktsByBowledOrLBW(int wktsByBowledOrLBW) {
		WktsByBowledOrLBW = wktsByBowledOrLBW;
	}
	public int getMaidenOvers() {
		return maidenOvers;
	}
	public void setMaidenOvers(int maidenOvers) {
		this.maidenOvers = maidenOvers;
	}

}
