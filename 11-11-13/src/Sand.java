
public class Sand {

	
	int x,y;
	char type;
	boolean moving;
	
	public Sand()
	{
		this.x = 0;
		this.y = 0;
		this.type = 'a';
		this.moving = false;
	}
	
	
	public Sand(int x, int y,boolean moving,char type) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.moving = moving;
		this.type = type;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public char getType() {
		return type;
	}


	public void setType(char type) {
		this.type = type;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}




}
