package gamesupport;

import java.awt.Graphics;

public class	Card 
{
	public PointXY point	;
	int piority=0;
	int tar=0;
	Card(){ 
		point = new PointXY();
	
	}
	public int posi=0;



public int point(int mx,int my){
	/// point 1
			if((mx >= 200 && mx <= 200 + 50)&&( my>=40&& my <=40+50))
		    { 
				return 1  ;}
			else /// point 2
				if((mx >= 475&& mx <= 475 + 50)&&( my>=40&& my <=40+50))
		    {   				
					return  2 ;}
			 else /// point 3
				if((mx >= 800-50&& mx <= 800)&&( my>=40&& my <=40+50))
		    {   
					return 3   ;}			
			else
			/// point 4
			if((mx >= 200 && mx <= 200 + 50)&&( my>=40+300-25&& my <=40+300-25+50))
		    {   
				return 4  ;}			
			else /// point 5
				if((mx >= 475&& mx <= 455 + 50)&&( my>=40+300-25&& my <=40+300-25+50))
		    {   
					return   5;
				}
			 else /// point 6
				if((mx >= 800-50&& mx <= 800)&&(my>=40+300-25&& my <=40+300-25+50))
		    {   
					return   6;}
				else	/// point 7
					if((mx >= 200 && mx <= 200 + 50)&&( my>=40+600-50&& my <=40+600))
				    {   
					return   7;
						}
					else /// point 8
						if((mx >= 475&& mx <= 475 + 50)&&(my>=40+600-50&& my <=40+600))
				    {   
							return   8;
						}
					 else /// point 9
						if((mx >= 800-50&& mx <= 800)&&(my>=40+600-50&& my <=40+600))
				    {  
							return   9;		
				    }
			else{
				
			return   0;}
}
public void draw(Graphics g, PointXY po, int posi){	
	//g.fillOval(po.x,po.y, 30, 30);
	switch(posi){
case 1:g.fillOval(po.x,po.y, 30, 30);	break;
case 2 :g.fillOval(po.x-15,po.y, 30, 30);break;
case 3:g.fillOval(po.x-30,po.y, 30, 30);break;
case 4:g.fillOval(po.x,po.y-15, 30, 30);break;
case 5:g.fillOval(po.x-15,po.y-15, 30, 30);break;
case 6:g.fillOval(po.x-30,po.y-15, 30, 30);break;
case 7:g.fillOval(po.x,po.y-30, 30, 30);break;
case 8:g.fillOval(po.x-15,po.y-30, 30, 30);break;
case 9:g.fillOval(po.x-30,po.y-30, 30, 30);break;
default :g.fillOval(po.x,po.y, 30, 30);break;
}


	
}
		boolean correct_target(int posi ,int target){
		
			boolean result=false;
		
		
		if(posi==1) {
			if (target==2 ||target==5 ||target==4){
				result= true;}}
		if(posi==2){
			if (target==1 ||target==5||target==3){
				result= true;}}
		if(posi==3){
			if (target== 2||target==5||target==6){			
			result= true;}}
		if(posi==4){if (target== 1||target==5||target==7){			
			result= true;}
		}
		if(posi==5){
		result= true;
		System.out.println(result+"  correct target");}
		if(posi==6){if (target== 3||target==5||target==9){			
		result = true;}
		}
		if(posi==7){ if (target== 4||target==5||target==8){
		result= true;}
		}
		if(posi==8){if (target== 7||target==5||target==9){
		result= true;}
		}
		if(posi==9){if (target== 6||target==5||target==8){
		result= true;}
		}
		if(posi==0){
		result=true;}
		System.out.println(result+"  correct target");
		if(result==false)
		System.out.println(" not correct target");
		return result; }
	
	public String move(Player player,int n,int target){
		if(player.play){
		if(correct_target(player.card[n].posi,target)){
		
			
		if(target>0&&n>-1){	
			PointXY target_p = new PointXY();
		    target_p.point( target);
		    player.card[n].point.x =target_p.x;
		    player.card[n].point.y=target_p.y;
		    player.card[n].posi= target;
		   player.played=true;
		    return "YOU HAVE PLAYED "+player.name;}
		
		}
		else
			return "WRONG TARGET "+player.name;}
		else
			return "NOT  YOUR TURN "+player.name;
		return " Replay  ";
			
		}
	
	
	public void moving(Player player, int n, int  x,int y){
		player.card[n].point.x =x;
		player.card[n].point.y=y;
		}
	 	 
	}	