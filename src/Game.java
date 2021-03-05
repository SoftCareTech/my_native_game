import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gamesupport.AutoPlayer;
import gamesupport.Player;


 
	
public  class Game extends Applet implements KeyListener,MouseListener,
MouseMotionListener ,ImageObserver//,WindowListener
{
	
	public static void main(String[] args) {
		System.out.print("mm");
		new Game();
	}
	control starter = new control();
	
	Thread main = Thread.currentThread();
	 switch_player player;
	 thread1 product ;
	 thread4 back_g_music = new thread4();

Label pl,nam1,nam2;
TextField name1,name2;


Player player1=new Player("RAPHAEL");
 
AutoPlayer player2=new AutoPlayer();


String card_owner="",card_owner_click="";
String msg = " ",Raph="RAPHAEL RAYMOND PRODUCT     ";
//int y,x,l,t,w,h,cy=0,cx=0,
Image back,back1,back2;
// var
boolean comp_play =true;
boolean start=false;
int ix,iy;//intial value to return to after dragged
 int x,y;
int card_num ;
String point=" ",msg2=" STARTED ",winer="non";
int pointx,pointy,h_pointx=0,h_pointy=0,dim=0;

void starting(){
	
	
	setSize(1000,680);
	setBackground(Color.cyan);
	setForeground(Color.red);
	
		//product = new thread1();
		//player = new switch_player();
	//back = getImage("DEXATI20150726202947.png");
	player1.card[0].point.setxy(30, 30);
	player1.card[1].point.setxy(30, 70);
	player1.card[2].point.setxy(30, 110);
	player2.card[0].point.setxy(850, 30);
	player2.card[1].point.setxy(850, 70);
	player2.card[2].point.setxy(850, 110);
	
	player1.card[0].posi=0;
	player1.card[1].posi=0;
	player1.card[2].posi=0;
	player2.card[0].posi=0;
	player2.card[1].posi=0;
	player2.card[2].posi=0;
	
	player1.play=true;
	player1.played=false;
	if(player2.win||player1.win){
		player1.win=false;
		player2.win=false;
			msg2="restarted";
		player = new switch_player();
	
	}
	
	
	
	repaint();
}


//method


public void init() {    ////initialization;
	main.setName(" The main applete Thread");
	setName("RAPH-RAY GAME1" );
	setSize(1000,680);
	setBackground(Color.cyan);
	setForeground(Color.red);
	
		product = new thread1();
		player = new switch_player();
		back = getImage("as.jpg");
		back1 = getImage("RAPH-RAY3.jpg");
		back2 = getImage("ICON3.png");
	player1.card[0].point.setxy(30, 30);
	player1.card[1].point.setxy(30, 70);
	player1.card[2].point.setxy(30, 110);
	player2.card[0].point.setxy(850, 30);
	player2.card[1].point.setxy(850, 70);
	player2.card[2].point.setxy(850, 110);
//	x=3; y=10;
	//h=50;w=50;
	//l=0;t=5;
	
	addMouseMotionListener(this);
	addMouseListener(this);
	addkeybordlistenner(this);
	
}//end initialization''




private void addkeybordlistenner(Game game) {
	
}
public void stop( ){
	System.out.println(" end   of Game  ");
	msg2 = "game exited ";
	repaint();
	start();
	try {
		Thread.sleep(1);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}


boolean side_correct(int s1,int s2){
	if(s1==1&&s2==9)return true;
	if(s1==2&&s2==8)return true;
	if(s1==3&&s2==7)return true;
	if(s1==4&&s2==6)return true;
	//if(s1==5&&s2==9)return true;
	if(s1==6&&s2==4)return true;
	if(s1==7&&s2==3)return true;
	if(s1==8&&s2==2)return true;
	if(s1==9&&s2==1)return true;
return false;	
}


void winer(){
	int posi =5,cc ,s1=0,s2=0;
	
	for(int i= 0; i<3;i++){
		if (player1.card[i].posi== posi){
			cc=i;
			if(cc==0){ s1=1;s2=2;}
			if(cc==1){s1=0;s2=2;}
			if(cc==2){s1=0;s2=1;}
			if ( side_correct(player1.card[s1].posi,player1.card[s2].posi)) {player1.win=true;}
		}else
		if (player2.card[i].posi== posi){
			cc=i;
			if(cc==0){ s1=1;s2=2;}
			if(cc==1){s1=0;s2=2;}
			if(cc==2){s1=0;s2=1;}
			if ( side_correct(player2.card[s1].posi,player2.card[s2].posi)) {player2.win=true;}
		}
		}
}


boolean card_exist(int posi){
	for(int i= 0; i<3;i++){
		if (player1.card[i].posi== posi){
			card_owner = player1.name;
			card_owner_click= player1.name;
			return true;}
		if (player2.card[i].posi== posi){
			card_owner=player2.name;
			card_owner_click= player2.name;
			return true;}
		
	}
	//card_owner_click= " ";
	card_owner="";
	return false;
}
boolean card_exist(int x,int y){
	for(int i= 0; i<3;i++){
		
		if ((player1.card[i].point.x <=x &&player1.card[i].point.x+30>=x)&&
				(player1.card[i].point.y <=y &&player1.card[i].point.y+30>=y)){
			card_owner = player1.name;
			System.out.println(player1.card[i].point.y+"  "+player1.card[i].point.x);
			//cy=player1.card[i].point.y;
				//	cx=player1.card[i].point.x;
			card_owner_click= player1.name;
			return true;}
		if ((player2.card[i].point.x <=x &&player2.card[i].point.x+30>=x)&&
				(player2.card[i].point.y <=y &&player2.card[i].point.y+30>=y)){
			card_owner=player2.name;
			card_owner_click= player2.name;
		//	cy=player2.card[i].point.y;
			//cx=player2.card[i].point.x;
			return true;}
		
	}
	//
	//card_owner_click= " ";
	card_owner="";
	return false;
}

int which_card(int posi){
	for(int i= 0; i<3;i++){
		if (player1.card[i].point(player1.card[i].point.x,player1.card[i].point.y)== posi){
			card_owner=player1.name;card_owner_click=player1.name;
			return i
			;}
		if (player2.card[i].point(player2.card[i].point.x,player2.card[i].point.y)== posi){
			card_owner=player2.name;
			card_owner_click= player2.name;
			return i;}
	}	
	//card_owner_click= " ";
	card_owner="";
	return -1;
}



int  which_card(int x,int y){
	for(int i= 0; i<3;i++){
		if ((player1.card[i].point.x <=x &&player1.card[i].point.x+30>=x)&&
				(player1.card[i].point.y <=y &&player1.card[i].point.y+30>=y)){
			card_owner = player1.name;
			card_owner_click= player1.name;
			//cy=player1.card[i].point.y;
			//cx=player1.card[i].point.x;
			return i;}
		if ((player2.card[i].point.x <=x &&player2.card[i].point.x+30>=x)&&
				(player2.card[i].point.y <=y &&player2.card[i].point.y+30>=y)){
			card_owner=player2.name;
			card_owner_click= player2.name;
			//cy=player2.card[i].point.y;
			//cx=player2.card[i].point.x;
			return i;}
		
	}
	//card_owner_click= " ";
	card_owner="";
	return -1;
}

int point(int mx,int my){
	/// point 1
	if((mx >= 200 && mx <= 200 + 30)&&( my>=40&& my <=40+30))
    {   return 1;}	
	else /// point 2
		if((mx >= 485&& mx <= 485 + 30)&&( my>=40&& my <=40+30))
    {   			return 2;		}
	 else /// point 3
		if((mx >= 800-30&& mx <= 800)&&( my>=40&& my <=40+30))
    {   			return 3;}
		else
	/// point 4
	if((mx >= 200 && mx <= 200 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
    {  		return 4;}
		else /// point 5
		if((mx >= 485&& mx <= 485 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
    {   			return 5;		}
	 else /// point 6
		if((mx >= 800-30&& mx <= 800)&&(my>=40+300-15&& my <=40+300-15+30))
    {   			return 6;}
			else	/// point 7
			if((mx >= 200 && mx <= 200 + 30)&&( my>=40+600-30&& my <=40+600))
		    { 				return 7;}
						else /// point 8
				if((mx >= 485&& mx <= 485 + 30)&&(my>=40+600-30&& my <=40+600))
		    { 					return 8;				}
			 else /// point 9
				if((mx >= 800-30&& mx <= 800)&&(my>=40+600-30&& my <=40+600))
		    {   					return 9;}
				else{		return 0;	}
	
}


//             keyboard  events  start
public void keyPressed(KeyEvent ke) {
showStatus("Key Down");
}
public void keyReleased(KeyEvent ke) {
showStatus("Key Up");
//st();
}
public void keyTyped(KeyEvent ke) {

repaint();
} //           end of keyb0ard events
////mouse methods 
public void mouseClicked(MouseEvent e) {

}

public void mouseExited(MouseEvent e) {
}

public void mousePressed(MouseEvent e) {
	swap_next_player();
	int mx,my;
	mx = e.getX();
	my = e.getY();
	/// point 1

	{if((mx >= 200 && mx <= 200 + 30)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 1  ";
			if( card_exist(1)){
				card_num =which_card(1);
				point =	card_owner_click + point;
			}
			pointx = 200+30;
			pointy = 40+20;
			dim=30;
			h_pointx = 200;
			h_pointy=40;
			showStatus(mx+ point + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);
			}
		
		else /// point 2
			if((mx >= 485&& mx <= 485 + 30)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 2 ";
			if( card_exist(2)){
				card_num=which_card(2);
				point =	card_owner_click +point;
			}
			pointx = 485+30;
			pointy = 40+20;
			dim=30;
			h_pointx = 485;
			h_pointy=40;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);
			}
		 else /// point 3
			if((mx >= 800-30&& mx <= 800)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 3 ";
			if( card_exist(3)){
				point =	card_owner_click +point;
				card_num=which_card(3);
			}
			pointx = 800;
			pointy = 40+20;
			dim=30;
			h_pointx = 800-30;
			h_pointy=40;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);}
		
		
		else
		/// point 4
		if((mx >= 200 && mx <= 200 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
	    {   
			
			point = "  on point 4 ";
			if( card_exist(4)){
				card_num=which_card(4);
							pointx = 200+30;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 200;
			h_pointy=40+300-15;
			showStatus(mx+ point + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);}}
		
		else /// point 5
			if((mx >= 485&& mx <= 485 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
	    {   
			point = "  on point 5 ";
			if( card_exist(5)){
				card_num=which_card(5);
				System.out.println("card_num===="+card_num);
				point =	card_owner_click +point;
			}
				
			pointx = 485+30;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 485;
			h_pointy=40+300-15;
			showStatus(mx+ point    + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);
			}
		 else /// point 6
			if((mx >= 800-30&& mx <= 800)&&(my>=40+300-15&& my <=40+300-15+30))
	    {   
			point = "  on point 6 ";
			if( card_exist(6)){
				card_num=which_card(6);
				point =	card_owner_click +point;
			}
			pointx = 800;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 800-30;
			h_pointy=40+300-15;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,200,40);}
		
			else	/// point 7
				if((mx >= 200 && mx <= 200 + 30)&&( my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 7 ";
					
					if( card_exist(7)){
						card_num=which_card(7);
						point =	card_owner_click +point;
					}
					pointx = 200+30;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 200;
					h_pointy=40+600-30;
					showStatus(mx+ point + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,200,40);}
				
				else /// point 8
					if((mx >= 485&& mx <= 485 + 30)&&(my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 8 ";
					if( card_exist(8)){
						card_num=which_card(8);
						point =	card_owner_click +point;
					}
					pointx = 485+30;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 485;
					h_pointy=40+600-30;
					showStatus(mx+ point    + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,200,40);
					}
				 else /// point 9
					if((mx >= 800-30&& mx <= 800)&&(my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 9 ";
					if( card_exist(9)){
						card_num=which_card(9);
						point =	card_owner_click +point;
					}
					pointx = 800;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 800-30;
					h_pointy=40+600-30;
					showStatus(mx+ point  + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,200,40);}
				
		else
	{ 		
			
			if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);
			dim=0;
		h_pointx =0;
		h_pointy=0;
			point ="";
			card_owner_click= " ";
			showStatus("X= "+mx +" ....Not on  point....    Y= " + my);
			card_num=-1;
			if(card_exist(mx,my)){
				System.out.println("yes");
					card_num= which_card(mx,my);
		}
			}
	
	///set initial 
	if(card_owner_click == player1.name){
		
		if(card_num>-1&&card_num<3){
			ix=player1.card[card_num].point.x;
			iy=player1.card[card_num].point.y;
		System.out.println("mouseReleased=for1_re "+card_num+" card pos1 "+player1.card[card_num].posi);
		}							
		}
		else 
	if(card_owner_click ==player2.name){
		if(card_num>-1&&card_num<3){
			ix=player2.card[card_num].point.x;
			iy=player2.card[card_num].point.y;
			
		System.out.println("mouseReleased=for2_re "+card_num+"   card pos "+player1.card[card_num].posi);
		
		//System.out.println("aaaaa"+posi);if(card_num>-1&&card_num<3)
		
		//System.out.println("aaaaa"+posi);

		}}}
		System.out.println("mouseClicked= "+card_num);
}

//end of  mousePressed(MouseEvent e)
public void mouseEntered(MouseEvent e) {
}// end of mouseEntered(MouseEvent e)


public void mouseReleased(MouseEvent e) {
//move back	
	
if(card_owner_click == player1.name){
		
		if(card_num>-1&&card_num<3){
			player1.card[card_num].point.x=ix;
			player1.card[card_num].point.y=iy;}							
		}
		else 
	if(card_owner_click ==player2.name){
		
		if(card_num>-1&&card_num<3){
			player2.card[card_num].point.x=ix;
			player2.card[card_num].point.y=iy;}	}///end of move back
	int mx,my;
	
	
	
	mx = e.getX();
	my = e.getY();
//	System.out.println("mouseReleased= " +card_num);
	
	
	/// point 1
			if((mx >= 200 && mx <= 200 + 50)&&( my>=40&& my <=40+50)){

				if( !card_exist(1)){
					System.out.println("mouseReleased= !card_exist(1)");
					if(card_owner_click == player1.name){
					int posi=	point(mx,my );
					if(card_num>-1&&card_num<3){
					msg2=	player1.card[card_num].move(player1,card_num, posi);
					player2.op_card=player1.card;}
												
					}
					else 
				if(card_owner_click ==player2.name){
					
					int posi=	point(mx,my );System.out.println("aaaaa"+posi);
					if(card_num>-1&&card_num<3)
						msg2=player2.card[card_num].move(player2,card_num, posi);
	
					}}repaint();
				}
			else /// point 2
				if((mx >= 485&& mx <= 485 + 50)&&( my>=40&& my <=40+50)){

					if( !card_exist(2)){
						if(card_owner_click==player1.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3){
							msg2=	player1.card[card_num].move(player1,card_num, posi);
							player2.op_card=player1.card;}
							
							
						}
						else 
					if(card_owner_click==player2.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3)
							msg2=	player2.card[card_num].move(player2,card_num, posi);
							
						}repaint();}}
			 else /// point 3
				if((mx >= 800-50&& mx <= 800)&&( my>=40&& my <=40+50))
		    {   

					if( !card_exist(3)){
						if(card_owner_click==player1.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3){
							msg2=	player1.card[card_num].move(player1,card_num, posi);
							player2.op_card=player1.card;}
							
						}
						else 
					if(card_owner_click==player2.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3)
							msg2=	player2.card[card_num].move(player2,card_num, posi);
							
						}repaint();}}
			else
			/// point 4
			if((mx >= 200 && mx <= 200 + 50)&&( my>=40+300-25&& my <=40+300-25+50))
		    {   
				
				
				if( !card_exist(4)){
					if(card_owner_click==player1.name){
					int posi=	point(mx,my );
					if(card_num>-1&&card_num<3){
						msg2=	player1.card[card_num].move(player1,card_num, posi);
						player2.op_card=player1.card;}
						
					}
					else 
				if(card_owner_click==player2.name){
					int posi=	point(mx,my );
					if(card_num>-1&&card_num<3)
						msg2=	player2.card[card_num].move(player2,card_num, posi);
						
					}
					
					 repaint();}
				}
			
			else /// point 5
				if((mx >= 475&& mx <= 475 + 50)&&( my>=40+300-25&& my <=40+300-25+50)){

					if( !card_exist(5)){
						if(card_owner_click==player1.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3){
							msg2=	player1.card[card_num].move(player1,card_num, posi);
							player2.op_card=player1.card;}
							
							
						}
						else 
					if(card_owner_click==player2.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3)
							msg2=player2.card[card_num].move(player2,card_num, posi);
							
						}repaint();}}
			 else /// point 6
				if((mx >= 800-50&& mx <= 800)&&(my>=40+300-25&& my <=40+300-25+50)){

					if( !card_exist(6)){
						if(card_owner_click==player1.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3){
							msg2=	player1.card[card_num].move(player1,card_num, posi);
							player2.op_card=player1.card;}
							
						}
						else 
					if(card_owner_click==player2.name){
						int posi=	point(mx,my );if(card_num>-1&&card_num<3)
							msg2=	player2.card[card_num].move(player2,card_num, posi);
							
						}repaint();}}
			
				else	/// point 7
					if((mx >= 200 && mx <= 200 + 50)&&( my>=40+600-50&& my <=40+600)){

						if( !card_exist(7)){
							if(card_owner_click==player1.name){
							int posi=	point(mx,my );if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(player1,card_num, posi);
								player2.op_card=player1.card;}
								
								
							}
							else 
						if(card_owner_click==player2.name){
							int posi=	point(mx,my );if(card_num>-1&&card_num<3)
								msg2=	player2.card[card_num].move(player2,card_num, posi);
								
							}repaint();}}
					else /// point 8
						if((mx >= 475&& mx <= 475 + 50)&&(my>=40+600-50&& my <=40+600)){

							if( !card_exist(8)){
								if(card_owner_click==player1.name){
								int posi=	point(mx,my );if(card_num>-1&&card_num<3){
									msg2=	player1.card[card_num].move(player1,card_num, posi);
									player2.op_card=player1.card;}
									
								}
								else 
							if(card_owner_click==player2.name){
								int posi=	point(mx,my );if(card_num>-1&&card_num<3)
									msg2=player2.card[card_num].move(player2,card_num, posi);
									
								}repaint();}}
					 else /// point 9
						if((mx >= 800-50&& mx <= 800)&&(my>=40+600-50&& my <=40+600)){

							if( !card_exist(9)){
								if(card_owner_click==player1.name){
								int posi=	point(mx,my );if(card_num>-1&&card_num<3){
									msg2=	player1.card[card_num].move(player1,card_num, posi);
									player2.op_card=player1.card;}
									
								}
								else 
							if(card_owner_click==player2.name){
								int posi=	point(mx,my );if(card_num>-1&&card_num<3)
									msg2=player2.card[card_num].move(player2,card_num, posi);
									
								}repaint();
								}
							}
			else{
				card_owner_click= " ";
				
				showStatus("X= " +mx +" ....Not moved....    Y= " + my);	}

			card_num=-1; 
			repaint();
			}


public void mouseDragged(MouseEvent e) {
int mx,my;
	
	mx = e.getX();
	my = e.getY();
	//System.out.println("moving "+card_owner+"num "+card_num);
	if(card_owner_click == player1.name){
		if(card_num>-1&&card_num<3)
			player1.card[card_num].moving(player1,card_num, mx-15,my-15);
		repaint(mx-15,my-15,30,30);						
		}
		else 
	if(card_owner_click ==player2.name){
		
		
		if(card_num>-1&&card_num<3)
		player2.card[card_num].moving(player2,card_num,mx-15,my-15);
		//System.out.println("aaaaa"+posi);
		repaint(mx-15,my-15,35,35);
		}
	mx = e.getX();
	my = e.getY();
	/// point 1
		if((mx >= 200 && mx <= 200 + 30)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 1  ";
			if( card_exist(1)){
				point =	card_owner +point;
			}
			
			pointx = 200+30;
			pointy = 40+20;
			dim=30;
			h_pointx = 200;
			h_pointy=40;
			showStatus(mx+ point + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);
			}
		
		else /// point 2
			if((mx >= 485&& mx <= 485 + 30)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 2 ";
			if( card_exist(2)){
				point =	card_owner +point;
			}
			
			pointx = 485+30;
			pointy = 40+20;
			dim=30;
			h_pointx = 485;
			h_pointy=40;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);
			}
		 else /// point 3
			if((mx >= 800-30&& mx <= 800)&&( my>=40&& my <=40+30))
	    {   
			point = "  on point 3 ";
			if( card_exist(3)){
				point =	card_owner +point;
			}
			
			pointx = 800;
			pointy = 40+20;
			dim=30;
			h_pointx = 800-30;
			h_pointy=40;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);}
		
		
		else
		/// point 4
		if((mx >= 200 && mx <= 200 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
	    {   
			point = "  on point 4 ";
			if( card_exist(4)){
				point =	card_owner +point;
			}
			
			pointx = 200+30;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 200;
			h_pointy=40+300-15;
			showStatus(mx+ point + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);}
		
		else /// point 5
			if((mx >= 485&& mx <= 485 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
	    {   
			point = "  on point 5 ";
			if( card_exist(5)){
				point =	card_owner +point;
			}
				
			pointx = 485+30;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 485;
			h_pointy=40+300-15;
			showStatus(mx+ point    + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);
			}
		 else /// point 6
			if((mx >= 800-30&& mx <= 800)&&(my>=40+300-15&& my <=40+300-15+30))
	    {   
			point = "  on point 6 ";
			if( card_exist(6)){
				point =	card_owner +point;
			}
			
			pointx = 800;
			pointy = 40+300-15+20;
			dim=30;
			h_pointx = 800-30;
			h_pointy=40+300-15;
			showStatus(mx+ point  + my);
			if (h_pointx!=0)
				 repaint(h_pointx,h_pointy,250,40);}
		
			else	/// point 7
				if((mx >= 200 && mx <= 200 + 30)&&( my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 7 ";
					
					if( card_exist(7)){
						point =	card_owner +point;
					}
					pointx = 200+30;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 200;
					h_pointy=40+600-30;
					showStatus(mx+ point + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,250,40);}
				
				else /// point 8
					if((mx >= 485&& mx <= 485 + 30)&&(my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 8 ";
					if( card_exist(8)){
						point =	card_owner +point;
					}
					
					pointx = 485+30;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 485;
					h_pointy=40+600-30;
					showStatus(mx+ point    + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,250,40);
					}
				 else /// point 9
					if((mx >= 800-30&& mx <= 800)&&(my>=40+600-30&& my <=40+600))
			    {   
					point = "  on point 6 ";
					if( card_exist(9)){
						point =	card_owner +point;
					}
					pointx = 800;
					pointy = 40+600-30+20;
					dim=30;
					h_pointx = 800-30;
					h_pointy=40+600-30;
					showStatus(mx+ point  + my);
					if (h_pointx!=0)
						 repaint(h_pointx,h_pointy,250,40);}
				
		else{
			if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);
			dim=0;
		h_pointx =0;
		h_pointy=0;
			point ="";
			
			showStatus("X= "+mx +" ....Not on  point....    Y= " + my);	}
	
	//end of  mouseDragged(MouseEvent e) 
}
void swap_next_player(){

	if (player2.play&&comp_play){
		player2.com_move();
	
repaint();}
}

public void mouseMoved(MouseEvent e) {
	
int	mx = e.getX();
int	my = e.getY();
	/// point 1
	if((mx >= 200 && mx <= 200 + 30)&&( my>=40&& my <=40+30))
    {   
		point = "  on point 1  ";
		if( card_exist(1)){
			point =	card_owner +point;
		}
		
		pointx = 200+30;
		pointy = 40+20;
		dim=30;
		h_pointx = 200;
		h_pointy=40;
		showStatus(mx+ point + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);
		}
	
	else /// point 2
		if((mx >= 485&& mx <= 485 + 30)&&( my>=40&& my <=40+30))
    {   
		point = "  on point 2 ";
		if( card_exist(2)){
			point =	card_owner +point;
		}
		
		pointx = 485+30;
		pointy = 40+20;
		dim=30;
		h_pointx = 485;
		h_pointy=40;
		showStatus(mx+ point  + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);
		}
	 else /// point 3
		if((mx >= 800-30&& mx <= 800)&&( my>=40&& my <=40+30))
    {   
		point = "  on point 3 ";
		if( card_exist(3)){
			point =	card_owner +point;
		}
		
		pointx = 800;
		pointy = 40+20;
		dim=30;
		h_pointx = 800-30;
		h_pointy=40;
		showStatus(mx+ point  + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);}
	
	
	else
	/// point 4
	if((mx >= 200 && mx <= 200 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
    {   
		point = "  on point 4 ";
		if( card_exist(4)){
			point =	card_owner +point;
		}
		
		pointx = 200+30;
		pointy = 40+300-15+20;
		dim=30;
		h_pointx = 200;
		h_pointy=40+300-15;
		showStatus(mx+ point + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);}
	
	else /// point 5
		if((mx >= 485&& mx <= 485 + 30)&&( my>=40+300-15&& my <=40+300-15+30))
    {   
		point = "  on point 5 ";
		if( card_exist(5)){
			point =	card_owner +point;
		}
			
		pointx = 485+30;
		pointy = 40+300-15+20;
		dim=30;
		h_pointx = 485;
		h_pointy=40+300-15;
		showStatus(mx+ point    + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);
		}
	 else /// point 6
		if((mx >= 800-30&& mx <= 800)&&(my>=40+300-15&& my <=40+300-15+30))
    {   
		point = "  on point 6 ";
		if( card_exist(6)){
			point =	card_owner +point;
		}
		
		pointx = 800;
		pointy = 40+300-15+20;
		dim=30;
		h_pointx = 800-30;
		h_pointy=40+300-15;
		showStatus(mx+ point  + my);
		if (h_pointx!=0)
			 repaint(h_pointx,h_pointy,250,40);}
	
		else	/// point 7
			if((mx >= 200 && mx <= 200 + 30)&&( my>=40+600-30&& my <=40+600))
		    {  
				point = "  on point 7 ";
				
				if( card_exist(7)){
					point =	card_owner +point;
				}
				pointx = 200+30;
				pointy = 40+600-30+20;
				dim=30;
				h_pointx = 200;
				h_pointy=40+600-30;
				showStatus(mx+ point + my);
				  repaint(400,0,5,1); //current position
				if (h_pointx!=0)
					 repaint(h_pointx,h_pointy,250,40);}
			
			else /// point 8
				if((mx >= 485&& mx <= 485 + 30)&&(my>=40+600-30&& my <=40+600))
		    {   
				point = "  on point 8 ";
				if( card_exist(8)){
					point =	card_owner +point;
				}
				
				pointx = 485+30;
				pointy = 40+600-30+20;
				dim=30;
				h_pointx = 485;
				h_pointy=40+600-30;
				showStatus(mx+ point    + my);
				if (h_pointx!=0)
					 repaint(h_pointx,h_pointy,250,40);
				}
			 else /// point 9
				if((mx >= 800-30&& mx <= 800)&&(my>=40+600-30&& my <=40+600))
		    {   
				point = "  on point 6 ";
				if( card_exist(9)){
					point =	card_owner +point;
				}
				pointx = 800;
				pointy = 40+600-30+20;
				dim=30;
				h_pointx = 800-30;
				h_pointy=40+600-30;
				showStatus(mx+ point  + my);
				if (h_pointx!=0)
					 repaint(h_pointx,h_pointy,250,40);}
			
	else{
		if (h_pointx!=0)
		 repaint(h_pointx,h_pointy,250,40);
		dim=0;
	h_pointx =0;
	h_pointy=0;
		point ="";
		
		showStatus("X= "+mx +" ....Not on  point....    Y= " + my);	}

		
		//end of mouseMoved(MouseEvent e)
	
}

//end of mouse methods


// Display methods

public Image getImage(String p){
	Image tem=null;
	try{
		URL	 url = Game.class.getResource(p);
		tem =Toolkit.getDefaultToolkit().getImage(url);
	}
	catch(Exception e){
		System.out.println("image error  "+e.getMessage());
	}
	return tem;
}
public void subpaint(Graphics g){
	
	final Font f = new Font("SansSerif", Font.BOLD, 50);
	g.setFont(f);
	
	Rectangle tl,tc,tr,cl,cc,cr,dl,dc,dr;
	g.setColor(Color.white );
	int dim=40;
	tl = new Rectangle(200,40,dim,dim);
	tc= new Rectangle(200+280,40,dim,dim);
	tr = new Rectangle(760,40,dim,dim);
	cr  = new Rectangle(200,40+280,dim,dim);
	cc = new Rectangle(200+280,40+280,dim,dim);
	cl = new Rectangle(760,40+280,dim,dim);
	
	dl= new Rectangle(200,600,dim,dim);
	
	dc= new Rectangle(200+280,600,dim,dim);
	
	dr = new Rectangle(760,600,dim,dim);
	Color v = new Color(170, 10,10);
	g.setColor(v);
	
	g.drawRect(200,40,600,600);
	
	
	g.drawImage( back1 ,200,40,600,600,this);
	g.drawImage( back2 ,(int)this.getWidth()-110,10,
			110,110,this);	
	g.drawLine(200,40, 790,640);g.drawLine(200+300,40, 200+300,630);
	g.drawLine(800,40, 200,640);g.drawLine(200,40+300, 800,40+300);
	Graphics2D g2 = (Graphics2D)g;g2.setColor(Color.BLUE);
	g2.fill(tl);g2.fill(tc);g2.fill(tr);
	g2.fill(cl);g2.fill(cc);g2.fill(cr); 
	g2.fill(dl);g2.fill(dc);g2.fill(dr);

	g.setColor(Color.WHITE);
	g.drawString("1", 200,40+40);
	g.drawString("2", 200+280,40+40);
	g.drawString("3", 760,40+40);
	g.drawString("4", 200,40+320);
	g.drawString("5", 200+280,40+320);
	g.drawString("6", 760,40+320);
	g.drawString("7", 200,640);
	g.drawString("8", 200+280,640);
	g.drawString("9", 760,640);
}

public void paint(Graphics g) {
	g.drawImage( back ,0,0,this.getWidth(),this.getHeight(),this);
	
	if(start==true){
		starter.cha_not();
	subpaint(g);
	g.setColor(Color.YELLOW);
	//player1.card[0].point
	player1.card[0].draw(g,player1.card[0].point,player1.card[0].posi);
	player1.card[1].draw(g,player1.card[1].point,player1.card[1].posi );
	player1.card[2].draw(g,player1.card[2].point ,player1.card[2].posi);
	g.setColor(Color.PINK);
	player2.card[0].draw(g,player2.card[0].point,player2.card[0].posi );
	//System.out.println(player2.card[0].point.y+"  oout  "+player2.card[0].point.x);
	player2.card[1].draw(g,player2.card[1].point,player2.card[1].posi );
	player2.card[2].draw(g,player2.card[2].point ,player2.card[2].posi);
//	g.setFont(Font.BOLD );
	
	

final Font f = new Font("SansSerif", Font.BOLD, 25);
g.setFont(f);
g.setColor(Color.magenta);
g.drawString(Raph, 265,670);
g.drawString(msg2,400, 20);
g.setColor(Color.getHSBColor(104, 33, 175));
g.drawString(point, pointx, pointy);

g.drawRect(h_pointx,h_pointy,dim,dim);
g.setColor(Color.red);
//g.drawRect(cx,cy,30,30);
}
	else{
		starter.cha();
		g.drawImage( back2 ,(int)this.getWidth()/2-60,10,
				250,250,this);	
		final Font f = new Font("SansSerif", Font.BOLD, 40);
		g.setFont(f);
		g.drawString("RAPHAEL RAYMOND PRODUCT*       ", 259,300);
		
	}}

class  thread1 implements Runnable{
	Thread play;
	thread1(){
	// Create a new, second thread
	play = new Thread(this, "Thread1");
	System.out.println("Child thread: " + play);
	play.start(); // Start the thread
	}
	
	// Display the banner.
	
	
	
		
	public void run() {
		
		
		try {
			
		Thread.sleep(440);
		} catch(InterruptedException e) {}
		
	
		for( ; ; ) {
			
			try {
				char 
				ch=Raph.charAt(0);
				if(Raph=="RAPHAEL RAYMOND PRODUCT     ")Thread.sleep(5000);
				Raph = Raph.substring(1, Raph.length());
				Raph =Raph+ ch;
				
				if (player1.play==false &&player2.play==false)
					if(player1.win)msg2=player1.name+" have won game over ";
					else
						if(player2.win)msg2=player2.name+" have won game over ";
				
				repaint(260,640,550,50);//265,685,400,40
			Thread.sleep(250);
			} catch(InterruptedException e) {}
			}
			
		
	}
	}
class  switch_player implements Runnable{
	Thread play;
	switch_player(){
	// Create a new, second thread
	play = new Thread(this, " switch_player");
	System.out.println("Child thread: " + play);
	play.start(); // Start the thread
	}
	
	public synchronized void st(){
	
		player1.play = true;
		if(player1.played){
			player1.played=false;
			
			player1.play =false;
			player2.play=true;
			
			//try {Thread.sleep(50);} catch(InterruptedException e) {}
				msg2="NEXT is "+player2.name;	
			}
		else
			if(player2.played){
				player2.played=false;
				player2.play =false;
				player1.play=true;
			//	try {Thread.sleep(50);} catch(InterruptedException e) {}
					msg2="NEXT is "+player1.name;	
				}
		while(player1.win==false && player2.win==false){
			
			if(player1.played){
				player1.played=false;
				System.out.println("here againt 11");
				player1.play =false;
				player2.play=true;
				
				//try {Thread.sleep(50);} catch(InterruptedException e) {}
					msg2="NEXT is "+player2.name;	
				}
			else
				if(player2.played){
					player2.played=false;
					player2.play =false;
					player1.play=true;
				//	try {Thread.sleep(50);} catch(InterruptedException e) {}
						msg2="NEXT is "+player1.name;	
					}
			winer();
			try {Thread.sleep(100);} catch(InterruptedException e) {}
				
			}
		if (player1.win==true)msg2=player1.name+" have won ";
		if (player2.win==true)msg2=player2.name+" have won ";
		player2.play =false;
		player1.play =false;
		try {Thread.sleep(100);} catch(InterruptedException e) {}
		msg2=msg2+"  game over ";
		return;
		}
	

		
	public void run() {
		try {
			
		Thread.sleep(500);
		
		} catch(InterruptedException e) {}
		
			try {
				st();
			Thread.sleep(50);
			System.out.println("the end of of swap ");
			} catch(InterruptedException e) {}
			
			try {
				player.play.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("the end of player swap thread ");	
	}
	
	
	}
class  control implements Runnable,ActionListener, ItemListener {
	Thread play;
	control(){
	// Create a new, second thread
	play = new Thread(this, "control");
	System.out.println("Child thread: " + play);
	
	play.start(); // Start the thread
	}
	
	Button starting ;
	Checkbox one , two;
	ItemEvent try1;
	CheckboxGroup cbg;
	
	
	public void run() {
		
		
	
		cbg = new CheckboxGroup();
		one = new Checkbox("You and computer ",cbg, true);
		//try1 =new ItemEvent();
		two = new Checkbox("Two people ",cbg,false);
		pl= new Label("player  ");
		nam1=new Label("player 1 Name ");
		name1=new TextField("RAPH  ");
		nam2=new Label("player 2 Name ");
		name2=new TextField("JIK  ");
		starting =new Button("START");
	
		add(starting);
		add(pl);add(one);add(two);
		add(nam1);
		add(name1);
		add(nam2);
		add(name2);
		starting.addActionListener(this);
		one.addItemListener(this);two.addItemListener(this);
		System.out.println("out of the control thread ");
			
	}
	void cha(){
		nam1.setVisible(true);
		name1.setVisible(true);
		nam2.setVisible(true);
		name2.setVisible(true);
		pl.setLocation(30, 70);
		one.setLocation(30, 100);
		two.setLocation(30, 120);
		starting.setBackground(Color.blue);
		starting.setLocation(10, 5);;
		
		nam1.setLocation(70, 160);
		name1.setLocation(167, 160);
		nam2.setLocation(70, 183);
		name2.setLocation(167, 183);
		
	}
	
	void cha_not(){
		
		pl.setVisible(false);
		one.setVisible(false);
		two.setVisible(false);
		//starting.setVisible(false);
		
		nam1.setVisible(false);
		name1.setVisible(false);
		nam2.setVisible(false);
		name2.setVisible(false);
		
	}
	public void itemStateChanged(ItemEvent e) {
		nam1.setVisible(true);
		name1.setVisible(true);
		nam2.setVisible(true);
		name2.setVisible(true);
		System.out.println("asdfgh"+e.getItem());
		if (e.getItem().equals("You and computer ")) {
			comp_play =true;
		}if(e.getItem().equals("Two people ")){
			
			cha();
			
			comp_play =false;
			
		}
			repaint();
		}

	


	public void actionPerformed(ActionEvent e) {
		
	String str = e.getActionCommand();
	if(str.equals("START")) {
		starting.setLabel("RESTART");
		 starting.setActionCommand("RESTART");
		 starting.setLocation(0,0);
		 starting.setSize(100,30);
		 
		start=true;
		
		
	}
	else if(str.equals("RESTART")) {
		starting.setLocation(0,0);
		 starting.setSize(100,30);
		starting();
		
		
	}
	else {
	msg = "You pressed Undecided.";
	}
	repaint();
	}

}
class  thread4 implements Runnable, LineListener{
	Thread play;
	thread4(){
	// Create a new, second thread
	play = new Thread(this, "Thread4");
	System.out.println("Child thread: " + play);
	play.start(); // Start the thread
	}
	
	boolean comp=false;
	public void update(LineEvent e) {
		
		LineEvent.Type t= e.getType();
		if(LineEvent.Type.STOP==t){
			comp=true;
			}}
	 public void  play(String name)throws IOException, UnsupportedAudioFileException, LineUnavailableException
	 {
	 	File f = new File("C:/Users/GBENGE AONDOAKULA/Documents/java work space/music/"+name);
	 	System.out.println("Enter f=="+f);
	 	AudioInputStream s = AudioSystem.getAudioInputStream(f);
	 	AudioFormat format = s.getFormat();
	 	DataLine.Info info = new DataLine.Info(Clip.class, format);
	 	Clip clip = (Clip)AudioSystem.getLine(info);
	 //	LineListener linlistener = (LineListener) clip;
	 	clip.addLineListener(this);
	 	clip.open(s);
	 	clip.start();
	 	while(!comp){
	 	try {
	 		Thread.sleep(1000);
	 	} catch (InterruptedException e) {
	 		e.printStackTrace();
	 	}}	 }
	
	
	
		
	public void run() {
		
		
		///thread4	p= new thread4();
		try {
			back_g_music.play("musi.wav");
		} catch (IOException e) {	e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {e.printStackTrace();
		} catch (LineUnavailableException e) {e.printStackTrace();
		}	
		
	}
	}
}




