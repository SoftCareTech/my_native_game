package gamesupport;

public class PointXY{
	public int x,y ;
	public PointXY(){ }
	
public	void setxy(int a,int b){
	
		x=a;
		y=b;
	} 
public 	void  point(int posi ){
	switch(posi){
		case 1:this.x=200;this.y=40;
		break;	
		case 2:this.x= 500;this.y =40  ;
		break;
		case 3: this.x= 800 ;this.y = 40 ;
		break;
		case 4:this.x= 200 ;this.y =340  ;
		break;
		case 5:this.x= 500 ;this.y =340  ;
		break;
		case 6:this.x=800; this.y =340  ;
		break;
		case 7:this.x= 200; this.y = 640  ;
		break;
		case 8:this.x= 500; this.y = 640 ;
		break;
		case 9:this.x= 800; this.y =640  ;
		break;
		}
	
	}
	
	
}