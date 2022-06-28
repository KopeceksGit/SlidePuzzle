package proj01;

import java.awt.Point;

public class Dot {
	private int x;
	private int y;

    public Dot() {
        this(0, 0);
    }
    
    public Dot(Point p) {
    	this(p.x, p.y);
    }

    public Dot(Dot p) {
        this(p.x, p.y);
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public Dot getPos() { return new Dot(x, y); }
    public Point toPoint() { return new Point(this.x, this.y); }
    
    // Local move plus-minus xx/yy
    public void shiftX(int x) {
    	shiftAside(x, 0);
    }
    
    // Local move plus-minus xx/yy
    public void shiftY(int y) {
    	shiftAside(0, y);
    }
    
    // Local move plus-minus xx/yy
    public void shiftAside(int x, int y) {
        this.x += x;
        this.y += y;
    }
    
    // Absolute coordinates
    public void moveTo(Dot p) {
        moveTo(p.x, p.y);
    }
    
    // Absolute coordinates
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isEqualTo(Dot that) {
    	if( (this.x == that.x) &&
			(this.y == that.y) ) {
    		return true;
    	}
    	return false;
    }

    public String toString() {
        return "[x=" + x + ",y=" + y + "]";
    }
}
