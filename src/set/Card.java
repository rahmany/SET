
package set;

import acm.graphics.*;

// create Card class with number,color,shape and shade instant fields
public class Card extends GCompound {

		private int color;
		private int shape;
		private int shade;
		private int number;
		private double xcoord;
		private double ycoord;
		
		

		
// created a constructor and initialized the attributes
		public Card(int color, int shape, int shade, int number,double x, double y) {
			
			setLocation(x,y);
			this.color = color;
			this.shape = shape;
			this.shade = shade;
			this.number = number;
			this.xcoord=x;
			this.ycoord=y;
			
			int imgNum = (color * 3) + (shape * 9) + (shade * 27) + (number -39);
			String imagesLocation = "images/"+imgNum+"."+"gif";
			
			
			
			GImage images = new GImage(imagesLocation);
			add(images, 0, 0);
			
			
		}

		
	// created setter/getters for number/color/shape and shade fields
	
		public int thegetColor() {
			return color;
		}


		public void thesetColor(int color) {
			this.color = color;
		}


		public int getShape() {
			return shape;
		}


		public void setShape(int shape) {
			this.shape = shape;
		}


		public int getShade() {
			return shade;
		}


		public void setShade(int shade) {
			this.shade = shade;
		}


		public int getNumber() {
			return number;
		}


		public void setNumber(int number) {
			this.number = number;
		}
		
		
		public double getXcoord() {
			return xcoord;
		}


		public void setXcoord(double xcoord) {
			this.xcoord = xcoord;
		}


		public double getYcoord() {
			return ycoord;
		}


		public void setYcoord(double ycoord) {
			this.ycoord = ycoord;
		}


		//this method returns a string value of the field color
		private String getColorString(){
			
		String colorString="invalid color";
			
			if(color==1)
				{
				colorString="Red";
				}
			else if(color==2)
				{
				colorString="Purple";
				}
			
			else if(color==3)
				{
				colorString="Green";
				}
			
			return colorString;
			}
			
		//this method returns a string value of the field shape
		private String getShapeString(){
			
		String shapeString="invalid shape";
		
			if(shape==1)
				{
				shapeString="squiggle";
				}
			else if(shape==2)
				{
				shapeString="diamond";
				}
		
			else if(shape==3)
				{
				shapeString="oval";
				}

			return shapeString;
			
		}
		//this method returns a string value of the field shade
		private String getShadegString(){
			
			String shadeString="invalid shade";
			
			if(shade==1)
				{
				shadeString="solid";
				}
			else if(shade==2)
				{
				shadeString="striped";
				}
		
			else if(shade==3)
				{
				shadeString="open";
				}
			
				return shadeString;
			
			}	
			
		//this method returns the card data as a readable string
		public String toString() {
			String cardString= getNumber()+" "+getColorString() + " "+ getShapeString()+" "
			+ getShadegString()+"(s)";
			
			return cardString;
		}
		
	}




