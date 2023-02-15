package io.asish.models;



public enum PlayerType {
	
	WicketKeeper,Batter,Bowler,AllRounder;
	
	
	public static PlayerType getFromString(String s) {
		
		s.toLowerCase();
		
		
		
		if(s.contains("wicket")||s.contains("wk"))
			return WicketKeeper;
		if(s.contains("all"))
		return AllRounder;
		
		if(s.contains("bat"))
			return Batter;
		
		return Bowler;
	}
	

}
