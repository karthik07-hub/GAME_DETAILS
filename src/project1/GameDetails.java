package project1;
public class GameDetails {
     private int Game_id;
     private int Player_id;
     private String Played_date;
     private int Points;
     
	public int getGame_id() {
		return Game_id;
	}
	public void setGame_id(int game_id) {
		Game_id = game_id;
	}
	public int getPlayer_id() {
		return Player_id;
	}
	@Override
	public String toString() {
		return "GameDetails [Game_id=" + Game_id + ", Player_id=" + Player_id + ", Played_date=" + Played_date
				+ ", Points=" + Points + "]";
	}
	public void setPlayer_id(int player_id) {
		Player_id = player_id;
	}
	public String getPlayed_date() {
		return Played_date;
	}
	public void setPlayed_date(String date) {
		Played_date = date;
	}
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}
     
 	
}