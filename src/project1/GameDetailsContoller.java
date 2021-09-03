package project1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
public class GameDetailsContoller {
	String filePath = "GameDetails";
	static TreeSet gamePoints=new TreeSet();
	/* Reads CSV file from specified File location STARTS */
	public static void readCsv(String filePath) {
		BufferedReader reader = null;
		try {
			List<GameDetails> users = new ArrayList<GameDetails>();
	        String line = "";
	        reader = new BufferedReader(new FileReader(filePath));
	        reader.readLine();
	        while((line = reader.readLine()) != null) {
	        	String[] fields = line.split(",");
	        	if(fields.length > 0) {
	        		GameDetails user = new GameDetails();
	                user.setGame_id(Integer.parseInt(fields[0]));
	                user.setPlayer_id(Integer.parseInt(fields[1]));
	                user.setPlayed_date(fields[2]);
	                user.setPoints(Integer.parseInt(fields[3]));
	                gamePoints.add(user.getPoints());
	                users.add(user);
	        	}
	        }
	        //Iterate each user details and print 
	        for(GameDetails u: users) {
	        	System.out.printf("[Game_id=%d, PLayer_id=%d, Played_date=%s, Points=%d]\n", u.getGame_id(), u.getPlayer_id(), u.getPlayed_date(),u.getPoints());
	        }
	       
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				reader.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}  
		      
	}
	/* Reads CSV file from specified File location END */
	/*Generates Game details who have played in month of august excluding Tuesdays START*/
	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	public String createRandomDate(int startYear, int endYear) {
		ArrayList<Integer>tuesday=new ArrayList();
	    tuesday.add(3);
	    tuesday.add(10);
	    tuesday.add(17);
	    tuesday.add(24);
	    tuesday.add(31);
	    int day=0;
	    for(int i=0;i<50;i++)
	        {
	    	day = createRandomIntBetween(1,31);
	        if(!tuesday.contains(day))
	     	break;
	        }
	    int month = createRandomIntBetween(8,8);
	    int year = 2021;
	    return String.valueOf(LocalDate.of(year, month, day));
	}
	/*Generates Game details who have played in month of august excluding Tuesdays END*/
	/* Write CSV file for specified File location START */
	public void writeToCsv(List<GameDetails> users)
	{
		FileWriter fileWriter = null;
	    try {
	    	fileWriter = new FileWriter(filePath);
	        fileWriter.append("Game_id, Player_id, Played_date, Points\n");
	        for(GameDetails u: users) {
	        	fileWriter.append(String.valueOf(u.getGame_id()));
	            fileWriter.append(",");
	            fileWriter.append(String.valueOf(u.getPlayer_id()));
	            fileWriter.append(",");
	            fileWriter.append(String.valueOf(u.getPlayed_date()));
	            fileWriter.append(",");
	            fileWriter.append(String.valueOf(u.getPoints()));
	            fileWriter.append("\n");
	        } 
	           
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    finally {
	    	try {
	    		fileWriter.flush();
	            fileWriter.close();
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    readCsv(filePath);
	}
	/* Write CSV file for specified File location END */
	/* Game Details Operations START*/
	public void gameDetailsOperations(List<GameDetails> users) throws ParseException
	{
		Collections.sort(users, new NameComparator());//
	    System.out.println("=====The Top 5 Players are:===== "); 
	    getTopFivePlayers(users);
	    System.out.println("=====The Bottom 5 Players are:===== "); 
	    getBottomFivePlayers(users);
	    getGameWithPoints(users,false);
	    List filteredUsers= getUsersByDate(users,"2021-08-01","2021-08-07");
	    System.out.println("===============1 to 7th  August date range users ===============");
	    getGameWithPoints(filteredUsers,true);
	    filteredUsers= getUsersByDate(users,"2021-08-01","2021-08-14");
	    System.out.println("=========== 1 to 14 August date range users ===========");
	    getGameWithPoints(filteredUsers,true);
	}
	private void getGameWithPoints(List<GameDetails> users,boolean isByDate ) 
	{
		int  countOfGameId1=0;
		int countOfGameId2=0;
		int countOfGameId3=0;
		int countOfGameId4=0;
		int countOfGameId5=0;
		int count=0;
		Map gameDetails=new LinkedHashMap();
	    for(GameDetails user:users)
	    {
	    switch (user.getGame_id()) 
	    {
	    case 1: {
	    	if(countOfGameId1<4 && gameDetails.containsKey(user.getGame_id())) 
	    	{
	    		int points=(int) gameDetails.get(user.getGame_id());
				gameDetails.put(user.getGame_id(), points+user.getPoints());
				countOfGameId1=countOfGameId1+1;
				if(isByDate)
				{
					System.out.println(user);
				}
				break;
	    	}
	    }
		case 2: {
			if(countOfGameId2<4 && gameDetails.containsKey(user.getGame_id())) 
			{
				int points=(int) gameDetails.get(user.getGame_id());
				gameDetails.put(user.getGame_id(), points+user.getPoints());
				countOfGameId2=countOfGameId2+1;
				if(isByDate)
				{
					System.out.println(user);
				}
				break;
			}
		}
	    case 3: {
	    	if(countOfGameId3<4 && gameDetails.containsKey(user.getGame_id())) 
	    	{
	    		int points=(int) gameDetails.get(user.getGame_id());
				gameDetails.put(user.getGame_id(), points+user.getPoints());
				countOfGameId3=countOfGameId3+1;
				if(isByDate)
				{
					System.out.println(user);
				}
				break;
	    	}
	    }
		case 4: {
			if(countOfGameId4<4 && gameDetails.containsKey(user.getGame_id())) 
			{
				int points=(int) gameDetails.get(user.getGame_id());
				gameDetails.put(user.getGame_id(), points+user.getPoints());
				countOfGameId4=countOfGameId4+1;
				if(isByDate)
				{
					System.out.println(user);
				}
			    break;
			}
					
		}
		case 5: {
			if(countOfGameId5<4 && gameDetails.containsKey(user.getGame_id())) 
			{
				int points=(int) gameDetails.get(user.getGame_id());
				gameDetails.put(user.getGame_id(), points+user.getPoints());
				countOfGameId5=countOfGameId5+1;
				if(isByDate)
				{
					System.out.println(user);
				}
				break;
			}
		}
		default:{
			if(!gameDetails.containsKey(user.getGame_id())) 
			{
				gameDetails.put(user.getGame_id(), user.getPoints());
			    if(isByDate)
			    {
			    	System.out.println(user);
			    }
			}
		}
	    } 
	    }
	    if(!isByDate) {
	    	System.out.println("The Top 5 Players Total Points");
	    	System.out.println(gameDetails);
	    }
	    else
	    {
	    	System.out.println("The Top 5 Players Total Points with date range");
		    System.out.println(gameDetails); 
	    }
	}
	/* Game Details Operations END*/
	/*To Generate Bottom Five Players Details START*/
	public void getBottomFivePlayers(List<GameDetails> users)
	{
		for(int i=users.size()-1;i>=users.size()-5;i--)
		{
			System.out.println(users.get(i));
		}
	}
	/*To Generate Bottom Five Players Details END*/
	/*To Generate Top Five Players Details START*/
	public void getTopFivePlayers(List<GameDetails> users)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(users.get(i));
		}
	}
	/*To Generate Bottom Five Players Details END*/
	/*To Sort Game Details START*/
	class NameComparator implements Comparator<GameDetails> 
	{
		public int compare(GameDetails o1, GameDetails o2)
		{
			if (o1.getPoints() == o2.getPoints()) 
			{
				return 0;
			}
			else if (o1.getPoints() < o2.getPoints()) 
			{
				return 1;
			}
	    	else 
	    	{
	    		return -1;
	    	}
		}
	    	 
	}
	/*To Sort Game Details END*/
    /*To Generate Game Details In The Specified Range START*/
	public ArrayList getUsersByDate(List<GameDetails> users,String minVal,String maxval) throws ParseException
	{
		String dateMin=minVal;
	    String dateMax=maxval;
	    Date dateMinValue=new SimpleDateFormat("yyyy-MM-dd").parse(dateMin);  
	    Date dateMaxValue=new SimpleDateFormat("yyyy-MM-dd").parse(dateMax);
	    ArrayList filteredUsers=new ArrayList();
	    for(GameDetails user:users)
	    {
	    	Date userdateValue=new SimpleDateFormat("yyyy-MM-dd").parse(user.getPlayed_date());
	    	if((userdateValue.after(dateMinValue) || userdateValue.equals(dateMinValue)) && (userdateValue.before(dateMaxValue) || userdateValue.equals(dateMaxValue)))
	    	{
	    		filteredUsers.add(user);
	    	}
	    }
	    return filteredUsers;
	}
	/*To Generate Game Details In The Specified Range END*/
}

