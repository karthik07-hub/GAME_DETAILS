package project1;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	public static void main( String args[] ) throws ParseException {
    GameDetailsContoller controller=new GameDetailsContoller();
    int min = 1;
    int max = 5;
    int playermin = 75;
    int playermax = 125;
    int playerPointsMin = 75;
    int playerPointsMax = 200;
    List<GameDetails> users = new ArrayList<GameDetails>();
    for(int i=0;i<50;i++) 
    {
    	GameDetails user = new GameDetails();
	    int Game_id = (int)Math.floor(Math.random()*(max-min+1)+min);
	    int Player_id = (int)Math.floor(Math.random()*(playermax-playermin+1)+playermin);
		int Points = (int)Math.floor(Math.random()*(playerPointsMax-playerPointsMin+1)+playerPointsMin);
		String randomDate = controller.createRandomDate(2021,2021);;
		user.setGame_id(Game_id);
		user.setPlayer_id(Player_id);
		user.setPlayed_date(randomDate);
		user.setPoints(Points);
		users.add(user);
		 
    }
    controller.writeToCsv(users);
    controller.gameDetailsOperations(users);
	}
}	

    
      
          
     
    
