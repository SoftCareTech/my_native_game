package gamesupport;

public class Player{
	public boolean win = false;
	 public String name;
	 public  boolean play=false;
	 public  boolean played=false;
	 public Card card[] = new Card[3];
	 public Card op_card[] = new Card[3];
	public Player(String s){
		name=s;
	card[0] = new Card();
	card[1] = new Card();
	card[2] = new Card();
	
	op_card[0] = new Card();
	op_card[1] = new Card();
	op_card[2] = new Card();}
	
}