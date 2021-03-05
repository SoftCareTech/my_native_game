package gamesupport;
 

public class AutoPlayer extends Player{
	 boolean cade_a[]= new boolean[3];
	 boolean cade_free[]= new boolean[9];
	
	 public AutoPlayer(){
		 super("computer");
		 cade_a[0]= true; cade_a[1]= true; cade_a[2]= true;
		 cade_free[0]= true; cade_free[1]= true; cade_free[2]= 
	true;cade_free[3]= true; cade_free[4]= true; cade_free[5]= true;
	cade_free[6]= true; cade_free[7]= true; cade_free[8]= true;
		 
	 }
	 
	 boolean card_exi(int posi){//boolean card exist on  give position ?
			for(int i= 0; i<3;i++){
				if (super.card[i].posi== posi){
					return true;}//yes my card
				if (super.op_card[i].posi== posi){
					return true;}// yes opposite player card 
				
			}			
			return false;//no body card
		}
	 boolean side_correct(int s1,int s2){// boolean  parrallel wining side
			if(s1==1&&s2==9)return true;
			if(s1==2&&s2==8)return true;
			if(s1==3&&s2==7)return true;
			if(s1==4&&s2==6)return true;
			//if(s1==5||s2==5)return true;//   center  not needed
			if(s1==6&&s2==4)return true;
			if(s1==7&&s2==3)return true;
			if(s1==8&&s2==2)return true;
			if(s1==9&&s2==1)return true;
		return false;	
		}
	 boolean side_block(int s1,int s2){
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
	 
	 boolean card_block(int posi){ 
		 boolean result=false;
		if(posi==1) {
			if (card_exi(4 )&& card_exi(2 )){
				result= true;}}
		if(posi==2){
			if (card_exi( 1)&& card_exi( 3)){
				result= true;}}
		if(posi==3){
			if (card_exi( 2)&& card_exi( 6)){			
			result= true;}}
		if(posi==4){if (card_exi( 1)&& card_exi(7 )){			
			result= true;}
		}
		if(posi==5){
		result= false;}
		if(posi==6){if (card_exi(3 )&& card_exi( 9)){			
		result = true;}
		}
		if(posi==7){ if (card_exi(4 )&& card_exi(8 )){
		result= true;}
		}
		if(posi==8){if (card_exi( 7)&& card_exi( 9)){
		result= true;}
		}
		if(posi==9){if (card_exi(6 )&& card_exi(8 )){
		result= true;}
		}
		if(posi==0){
		result=false;}
		
		if(result==false)
		System.out.println(" side_block return false ");
		return result; 	
	}
	int get_blocked_card(){
		for(int h =0;h<3;h++){
			if (card_block(this.card[h].posi))
				return h;
			
		}
		return -1;
	}
	 




	 boolean block_time(){	
			for(int i= 0; i<3;i++){
				if (this.op_card[i].posi== 5)return true;
				}
					if (side_correct(this.op_card[0].posi,this.op_card[1].posi))return true;
					if (side_correct(this.op_card[0].posi,this.op_card[2].posi))return true;
					if (side_correct(this.op_card[1].posi,this.op_card[2].posi))return true;
		 return false;
	 }
	 boolean block_time_side(){	
					if (side_correct(this.op_card[0].posi,this.op_card[1].posi))return true;
					if (side_correct(this.op_card[0].posi,this.op_card[2].posi))return true;
					if (side_correct(this.op_card[1].posi,this.op_card[2].posi))return true;
		 return false;
	 }
	 int win_time(){	
			for(int i= 0; i<3;i++){
				if (this.card[i].posi== 5)return 5;
				}
					if (side_correct(card[0].posi,card[1].posi))return 1;
					if (side_correct(card[0].posi,card[2].posi))return 2;
					if (side_correct(card[1].posi,card[2].posi))return 3;
		 return 0;
	 }
	void wining(){
int s1=0,s2=0;
		if (win_time()==1&&!card_exi(5)){
			card[2].piority=9;
			card[2].tar=5;
		}else
		if (win_time()==2&&!card_exi(5)){
			card[1].piority=9;
			card[1].tar=5;
		}else
		if (win_time()==3&&!card_exi(5)){
			card[0].piority=9;
			card[0].tar=5;
		}else
			if(win_time()==5){
				int cc1=-1;
				for (int i=0;i<3;i++){
				if (card[i].posi==5)cc1=i;
				}
				if(cc1==0){ s1=1;s2=2;}
				if(cc1==1){s1=0;s2=2;}
				if(cc1==2){s1=0;s2=1;}	
				if (cc1>-1)
				{for (int p=1;p<10; p++){
					if(side_correct(card[s1].posi,p)){
						if(!card_exi(p)){
							for (int v=0;v<3;v++){
								if (card[v].correct_target(card[v].posi,p)){
									card[v].piority=9;
										card[v].tar=p;
										System.out.println(" RAPH-RAY 1"+v);
										}
							}}}
					if(side_correct(card[s2].posi,p)){
						if(!card_exi(p)){
							for (int v=0;v<3;v++){
								if (card[v].correct_target(card[v].posi,p)){
									card[v].piority=9;
										card[v].tar=p;
										System.out.println(" RAPH-RAY 2");
										}}}}}}}}
	void blocking(){
	///block_time() polarity ==7
		int s1=0,s2=0;
		if(block_time()){
			if(!card_exi(5)){
			  int c=	get_blocked_card();
		     	if (c>-1){
				card[c].piority=7;
				card[c].tar=5;}	
			}else{
			   int cc=-1;
			 for (int i=0;i<3;i++){
			   if (op_card[i].posi==5)cc=i;}
			 
			if (cc>-1){for (int p=1;p<10; p++){
				if(cc==0){ s1=1;s2=2;}
				if(cc==1){s1=0;s2=2;}
				if(cc==2){s1=0;s2=1;}
				if(side_correct(op_card[s1].posi,p)){
					if(!card_exi(p)){
						for (int v=0;v<3;v++){
							if (card[v].correct_target(card[v].posi,p)){
								card[v].piority=7;
									card[v].tar=p;}
						}}}
				if(side_correct(op_card[s2].posi,p)){
					if(!card_exi(p)){
						for (int v=0;v<3;v++){
							if (card[v].correct_target(card[v].posi,p)){
								card[v].piority=7;
									card[v].tar=p;}
						}}}
				}}}}//end  of blocked_time
		
		
	}
	 
	void wise_play1(){
		
		if (block_time_side())
			for(int i=0;i<3;i++){
				if (card[i].posi!=5){
					set_target(i);
				card[i].piority=8;}
			}
	}
void	 set_piority(){
	//reset piority
	for(int i =0;i<3;i++){
		card[i].piority=0;
	}
	//just set move positon as posible 
		for(int i=0;i<3;i++){
			set_target(i);
		}
		
	///card_block then remove center
/*	if(card_block(card[0].posi)&& card_block(card[1].posi)){
		set_target(2);
	card[2].piority=6;
	}else
	if( card_block(card[1].posi)&& card_block(card[2].posi)){
		set_target(0);
		card[0].piority=6;
		
	}else
	if(card_block(card[0].posi)&&card_block(card[2].posi)){
		set_target(1);
		card[1].piority=6;
		
	}*/
		 wise_play1();
	
	///if not finish initialis
			int jik=-1;
			for(int b=0;b<3;b++){
				if(card[b].posi==0)jik=b;
					}
			if(jik>-1){
			if(!card_exi(5)){
				card[jik].tar=5;
				card[jik].piority=8;
			}else
				
			for(int p=1;p<10;p++){
				if(!card_exi(p)){
					card[jik].tar=p;
					card[jik].piority=8;}}
			
			}
			blocking();
			wining();
	}
	
	 void update_free(){
		/* for (int p=1;p<10;p++){
			 if(card_exi(p)){
				cade_free[p]=false; 
			 }else
				 cade_free[p]= true;
				
			} */
		 for (int c=0;c<3;c++){
			 set_target(c) ;
		 }
	 }
	 
	 int h_p(){
		 for(int h=9;h>-1;h--)
		 for(int i =0;i<3;i++){
			if( card[i].piority==h){
				return i;
			}
		 }
		 
		 return -1;
	 }
	 
	void  set_target(int c){
		
		for(int t=1;t<10;t++){
			if (!card_exi(t))
		         if(card[c].correct_target(card[c].posi, t)){
		        	 card[c].piority=1;
		        	 card[c].tar=t;
		        	 return;
		         }
		}
		
		 
	 }
int	com_which_card_move( ){
	update_free();
	set_piority();
	int h=h_p();

	return h;
}
	
public	void  com_move(){
	int c= com_which_card_move( );
	int des =0;
	if(c>-1 ){
		des=card[c].tar;
		card[c].move(this, c, des);}
	else 
		System.out.println("error in  void	moved(){");
		}

}