package set;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import acm.io.IODialog; 
//created a SetGame class
	@SuppressWarnings("serial")
	public class SetGame extends GraphicsProgram{
		
	//Applet height/width
		private static int APP_WIDTH=450;
		private static int APP_HEIGHT=250;
	//array/card grid specifications
		private int xcoord;
		private int ycoord;
		private static final int CARD_WIDTH=95;
		private static final int CARD_HEIGHT=65;
		private static final int CARD_SPACE=15;
		private static final int Y_OFFSET=10;
		private static final int NUM_ROWS=3;
		private static final int NUM_COLS=4;	
		private static final int NUM_CARD=4;
		RandomGenerator rgen = new RandomGenerator();
	//variables for the determining card location, attribute counter, match and announcement
		GObject cardClicked;
		private static int colorcounter;
		private static int shapecounter;
		private static int shadecounter;
		private static int numbercounter;
		boolean isNmatch;
		IODialog announcement = new IODialog();
		private static int gameCount;
		private static int mScore=0;
		private static int lScore=0;
		public GLabel wins,loses;
		
		public void run()
		{
		//set the applet size	
			setSize(APP_WIDTH,APP_HEIGHT);
			
		//setup the game and play	
			turns();
			setGame();
			addMouseListeners();
			
		}
		
		private void turns()
		{
			wins = new GLabel("Total Matchs "+mScore);
			
			wins.setColor(Color.RED);
			wins.setLocation(10,10);
			add(wins);
			
			loses = new GLabel("Total Mismatchs "+lScore);
			
			loses.setColor(Color.RED);
			loses.setLocation(330,10);
			add(loses);
					
			println(loses);
		}
		
		private void setGame() 
		{
		//create an array of Card class	
			Card[] cards = new Card[NUM_CARD];
		//loops through the array and displays each of the cards	
			for (int row= 0; row< NUM_ROWS; row++)
			{
				ycoord= Y_OFFSET+(CARD_SPACE+CARD_HEIGHT)*row;
				
					for(int col=0; col<NUM_COLS; col++)
						{
							int color = rgen.nextInt(1,3);
							int shape=rgen.nextInt(1,3);
							int shade=rgen.nextInt(1,3);
							int number=rgen.nextInt(1,3);
							
							xcoord= col*(CARD_WIDTH+CARD_SPACE);
							
							cards[col] = new Card(color,shape,shade,number,xcoord,ycoord);
							add(cards[col]);
							
						}
			}
			
		}	
		
		public void mouseClicked(MouseEvent e)
		{
		//determines the x/y values of the object	
		 cardClicked= getElementAt(e.getX(),e.getY());
		//cast to a Card class so that we can utilize the Card methods
		 Card cards = (Card)cardClicked;
		 if (cardClicked==null) return;
		  
		//this function stores the card attributes as long as the gameCount is less than 3	 		 
		 if (gameCount<3)
		 {
			colorcounter+= cards.thegetColor();
			shapecounter+= cards.getShape();
			shadecounter+= cards.getShade();
			numbercounter+= cards.getNumber();
			
			gameCount++;
			
			}
		//once the gameCount has reached 3, the function determines  match status  
		 if (gameCount==3)
		 {
		// call the boolean below to determine a match and announcement			 
			 if(isNOTmatch()==true) announcement.println("No match. Try again.");
			 else announcement.println ("Nice. You have a match");

		//reset the counters for another game		 			 
			 colorcounter=0;
			 shapecounter=0;
			 shadecounter=0;
			 numbercounter=0; 
			 gameCount=0;
			 remove(wins);
			remove(loses);
			
			setGame();
			turns();
		 }	
	
	}
	//This boolean determines whether match is false	
		public boolean isNOTmatch()
		{
			return ( ((colorcounter % 3 != 0) || (shapecounter % 3 != 0)||
			(shadecounter % 3 != 0) || (numbercounter % 3 != 0)));
									
		}

	
	}