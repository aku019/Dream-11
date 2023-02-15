package io.asish.models;

public class Point {
	int batPoint;
	int bowlPoint;
	int fieldPoint;
	int otherPoint;
	int economyPoint;
	int srPoint;
	
	
	public double getTotalPoint() {
		return batPoint+bowlPoint+fieldPoint+otherPoint+economyPoint+srPoint;
	}
	public int getBatPoint() {
		return batPoint;
	}
	public Point(Player P) {
		setBatPoint(P);
		
		setBowlPoint(P);
		
		setFieldPoint(P);
		
		setOtherPoint(P);
		
		setEconomyPoint(P);
		
		setSrPoint(P);
		
		
		
		
		
		
	}
	public void setBatPoint(Player P) {
		int pts=0;
		Batter bat = P.getBat();
		
		if(!P.isDidPlay()||!bat.isDidBat()) {
			this.batPoint=0;
			return;
		}
		
		if(!bat.isNotOut()&&!P.getType().equals(PlayerType.Bowler)) {
			this.batPoint=0;
		return;
	}
		
		pts+=bat.getRunsScored();
		pts+=bat.getBoundary();
		pts+=bat.getSixes()*2;
		if(bat.getRunsScored()>=30)
			pts+=4;
		else if(bat.getRunsScored()>=50)
			pts+=8;
		else if(bat.getRunsScored()>=100)
			pts+=16;
		
		this.batPoint=pts;
		
		
		
		
//		this.batPoint = batPoint;
	}
	public int getBowlPoint() {
		return bowlPoint;
	}
	public void setBowlPoint(Player P) {
		int pts=0;
		if(!P.isDidPlay()) {
			this.bowlPoint =0;
			return;
		}
			
		Bowler bowl=P.getBowl();
		
		pts+=bowl.getWkts()*25;
		
		pts+=bowl.getMaidenOvers()*12;
		
		pts+=bowl.getWktsByBowledOrLBW()*8;
		
		if(bowl.getWkts()==3)
			pts+=4;
		else if(bowl.getWkts()==4)
			pts+=8;
		else if(bowl.getWkts()>=5)
			pts+=16;
		
		
		this.bowlPoint = pts;
	}
	public int getFieldPoint() {
		return fieldPoint;
	}
	public void setFieldPoint(Player P) {
		int pts=0;
		Fielder f=P.getField();
		
		if(f.getCatches()>=3)
			pts+=4;
		pts+=f.getCatches()*8;
		
		pts+=f.getStumping()*12;
		
		pts+=f.getDirectRunout()*12;
		
		pts+=f.getInDirectRunOut()*6;
		
		this.fieldPoint = pts;
	}
	public int getOtherPoint() {
		
		return otherPoint;
	}
	public void setOtherPoint(Player P) {
		
		if(P.didPlay)
		this.otherPoint = 4;
		else
			this.otherPoint = 0;
	}
	public int getEconomyPoint() {
		return economyPoint;
	}
	public void setEconomyPoint(Player P) {
		int pts=0;
		if(!P.isDidPlay()) {
			this.economyPoint = pts;
			return;
		}
		
		Bowler bowl = P.getBowl();
		
		if(bowl.getBowlsBowled()<12)
		{	this.economyPoint = pts;
		return;
		}
		
		double eco=((double)bowl.runsConcede/(double)bowl.bowlsBowled)*6;
		
		if(eco<5)
			pts+=6;
		else if(eco<6&&eco>=5)
			pts+=4;
		else if(eco<=7&&eco>=6)
			pts+=2;
		else if(eco>=10&&eco<=11)
			pts+=-2;
		else if(eco>11&&eco<=12)
			pts+=-4;
		else if(eco>12)
			pts+=-6;
		this.economyPoint = pts;
	}
	public int getSrPoint() {
		return srPoint;
	}
	public void setSrPoint(Player P) {
		int pts=0;
		Batter bat=P.getBat();
		
		if(!P.isDidPlay()||bat.bowlsPlayed<10)
		{
			this.srPoint=0;
			return;
		}
		
		double sr=((double)bat.getRunsScored()/(double)bat.getBowlsPlayed())*100;
		
		if(sr>170)
			pts+=6;
		else if(sr<170&&sr>150)
			pts+=4;
		else if(sr>=130&&sr<=150)
			pts+=2;
		else if(sr>=60&&sr<=70)
			pts+=-2;
		else if(sr>=50&&sr<60)
			pts+=-4;
		else if(sr<50)
			pts+=-6;
		
		
		
		
		
		
		
		this.srPoint = pts;
	}

}
