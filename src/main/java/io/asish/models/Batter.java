package io.asish.models;

public class Batter {
	
	int bowlsPlayed;
	int runsScored;
	int boundary;
	int sixes;
	boolean isNotOut;
	boolean didBat;
	public boolean isNotOut() {
		return isNotOut;
	}
	public void setNotOut(String isNotOut) {
		isNotOut.toLowerCase();
		
		if(isNotOut.contains("yes"))
			this.isNotOut = true;
			else
				this.isNotOut = false;;
	}
	public int getBoundary() {
		return boundary;
	}
	public void setBoundary(int boundary) {
		this.boundary = boundary;
	}
	public int getSixes() {
		return sixes;
	}
	public boolean isDidBat() {
		return didBat;
	}
	public void setDidBat(String didBat) {
		didBat.toLowerCase();
		
		if(didBat.contains("yes"))
			this.didBat = true;
			else
				this.didBat = false;
		
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getBowlsPlayed() {
		return bowlsPlayed;
	}
	public void setBowlsPlayed(int bowlsPlayed) {
		this.bowlsPlayed = bowlsPlayed;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

}
