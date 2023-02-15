package io.asish.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import io.asish.models.*;




public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ClassLoader classLoader = Main.class.getClassLoader();
		
		List<Player> allPlayers=new ArrayList<Player>();
		
//		InputStream is = classLoader.getResourceAsStream("test.csv");
		BufferedReader r = new BufferedReader(new FileReader("/home/asish/Pictures/test.csv"));

		try {

//			InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8); //
//			BufferedReader br = new 	BufferedReader(isr);
			
			String line = r.readLine();
			line = r.readLine();
			 while (line != null) {
				String[] a = line.split(",");
				Player p=new Player();
				Batter bat=new Batter();
				Bowler bowl=new Bowler();
				Fielder field = new Fielder();
				p.setId(Integer.parseInt(a[0]));
				p.setTeamId(Integer.parseInt(a[1]));
				p.setType(PlayerType.getFromString(a[2]));
				p.setCap(false);
				p.setVC(false);
				p.setSel(false);
				
				p.setDidPlay(a[3]);
				
			
				
				
				bat.setBoundary(Integer.parseInt(a[8]));
				bat.setRunsScored(Integer.parseInt(a[6]));
				bat.setBowlsPlayed(Integer.parseInt(a[7]));
				bat.setSixes(Integer.parseInt(a[9]));
				bat.setDidBat(a[4]);	
				bat.setNotOut(a[19]);
				
				
				bowl.setBowlsBowled(Integer.parseInt(a[10]));
				bowl.setRunsConcede(Integer.parseInt(a[11]));
				bowl.setWkts(Integer.parseInt(a[12]));
				bowl.setWktsByBowledOrLBW(Integer.parseInt(a[13]));
				bowl.setMaidenOvers(Integer.parseInt(a[14]));
				bowl.setDidBowl(a[5]);
				
				field.setCatches(Integer.parseInt(a[15]));
				field.setStumping(Integer.parseInt(a[16]));
				field.setDirectRunout(Integer.parseInt(a[17]));
				field.setInDirectRunOut(Integer.parseInt(a[18]));
				
				p.setBat(bat);
				p.setBowl(bowl);
				p.setField(field);
				
				Point pt = new Point(p);
				
				p.setPt(pt);
				
//			    Collections.sort(p, new Comparator<Player>() {
//			        public int compare(Player o1, Player o2) {
//			            // my code
//			        }
//			    });

				
				
			
				
			    
				
				
				allPlayers.add(p);
				
//				System.out.println(p);
				
				line = r.readLine();
				
				
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(allPlayers, new Comparator<Player>() {
		    public int compare(Player a, Player b) {
		       
		    if(a.getPt().getTotalPoint()>b.getPt().getTotalPoint())
		return -1;
		return 1;
			
		    }
		});
		
		
		
		
		List<Player> topPlayers= selectTopPlayer(allPlayers);
		
		for(Player p: allPlayers) {
			double pnts=p.getPt().getTotalPoint();
			int id=p.getId();
			int tid=p.getTeamId();
			boolean iscap=p.isCap();
			boolean isVc=p.isVC();
			
			
			
				System.out.println(pnts+" "+id+" "+tid+" "+iscap+" "+isVc+" "+p.getType());
		
		
		
		
		
		
		}
		
		System.out.println();
		
		for(Player p:topPlayers) {
			
			double pnts=p.getPt().getTotalPoint();
			int id=p.getId();
			int tid=p.getTeamId();
			boolean iscap=p.isCap();
			boolean isVc=p.isVC();
			
			
			if(iscap)
				pnts=2*pnts;
			else if(isVc)
				pnts=1.5*pnts;
				System.out.println(pnts+" "+id+" "+tid+" "+iscap+" "+isVc+" "+p.getType());
			
			
			
			
			
		}
			
		
		
		
		
	}

	private static List<Player> selectTopPlayer(List<Player> allPlayers) {
		// TODO Auto-generated method stub
		
		List<Player> selected=new ArrayList<Player>();
		
		
		
		HashMap<PlayerType,Integer> minPt=new HashMap<PlayerType,Integer>();
		minPt.put(PlayerType.AllRounder, 1);
		minPt.put(PlayerType.Batter, 3);
		minPt.put(PlayerType.Bowler, 3);
		minPt.put(PlayerType.WicketKeeper, 1);
		
		HashMap<PlayerType,Integer> maxPt=new HashMap<PlayerType,Integer>();
		maxPt.put(PlayerType.AllRounder, 4);
		maxPt.put(PlayerType.Batter, 6);
		maxPt.put(PlayerType.Bowler, 6);
		maxPt.put(PlayerType.WicketKeeper, 4);
		
		
		
		HashMap<PlayerType,Integer> ptm=new HashMap<PlayerType,Integer>();
		
		HashMap<Integer,Integer> team=new HashMap<Integer,Integer>();
		
		team.put(1, 7);
		team.put(2, 7);
		
		ptm.put(PlayerType.AllRounder, 0);
		ptm.put(PlayerType.Batter, 0);
		ptm.put(PlayerType.Bowler, 0);
		ptm.put(PlayerType.WicketKeeper, 0);
		
	
		
		int tp=0;
		
		
		while(tp<2) {
			Player cap=allPlayers.get(tp);
			if(tp==0)
		cap.setCap(true);
			else if(tp==1)
				cap.setVC(true);
		int cnt=team.get(cap.getTeamId());
		team.put(cap.getTeamId(), cnt-1);
		
		int pt=ptm.get(cap.getType());
		
		ptm.put(cap.getType(), pt+1);
		
		cap.setSel(true);
				
		

		selected.add(cap);
		tp++;
		}
		
		int sel=2;
		
		while(sel<11&&tp<allPlayers.size())
		{
			Player p=allPlayers.get(tp);
			
			PlayerType pt=p.getType();
			int tid=p.getTeamId();
			
			if(ptm.get(pt)<minPt.get(pt)&&team.get(tid)>0)
			{
				sel++;
				p.setSel(true);
				int teamCnt=team.get(tid);
				team.put(tid, teamCnt-1);
				
				int pCnt=ptm.get(pt);
				ptm.put(pt, pCnt+1);
				
				selected.add(p);
				
			}
			tp++;
			
			
		}
		
		tp=0;
		
		while(sel<11&&tp<allPlayers.size())
		{
			Player p=allPlayers.get(tp);
			
			if(!p.isSel()) {
			
			PlayerType pt=p.getType();
			int tid=p.getTeamId();
			
			if(ptm.get(pt)<maxPt.get(pt)&&team.get(tid)>0)
			{
				sel++;
				p.setSel(true);
				int teamCnt=team.get(tid);
				team.put(tid, teamCnt-1);
				
				int pCnt=ptm.get(pt);
				ptm.put(pt, pCnt+1);
				
				selected.add(p);
				
			}
			}
			tp++;
			
			
		}
		
		return selected;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	


}




