package io.asish.models;

public class Player {
	
	
	
	
	boolean didPlay;
	boolean isCap;
	boolean isVC;
	boolean isSel;
	
	public boolean isSel() {
		return isSel;
	}

	public void setSel(boolean isSel) {
		this.isSel = isSel;
	}

	public boolean isCap() {
		return isCap;
	}

	public void setCap(boolean isCap) {
		this.isCap = isCap;
	}

	public boolean isVC() {
		return isVC;
	}

	public void setVC(boolean isVC) {
		this.isVC = isVC;
	}



	Batter bat;
	Bowler bowl;
	Fielder field;
	
	int id;
	int teamId;
	
	Point pt;
	
	PlayerType type;

	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}


	
	

	

	public boolean isDidPlay() {
		return didPlay;
	}

	public void setDidPlay(String didPlay) {
		didPlay.toLowerCase();
		if(didPlay.contains("yes"))
		this.didPlay = true;
		else
			this.didPlay = false;
			
	}

	public Batter getBat() {
		return bat;
	}

	public void setBat(Batter bat) {
		this.bat = bat;
	}

	public Bowler getBowl() {
		return bowl;
	}

	public void setBowl(Bowler bowl) {
		this.bowl = bowl;
	}

	public Fielder getField() {
		return field;
	}

	public void setField(Fielder field) {
		this.field = field;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

}
