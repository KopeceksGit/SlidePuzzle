package proj01;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Chunk extends JButton {
	private Dot origPos;
	private Dot currPos;
//	private ImageIcon icon;
	private boolean spareOne;
	
	public Chunk() {}
	
	public Chunk(Dot origPos, ImageIcon icon) {
		this.origPos = new Dot(origPos);
		this.currPos = origPos;
//		this.icon = icon;
		spareOne = false;
		
		setIcon(icon);
		setBorder(null);
		setOpaque(true);
	}
	
	public void setCurrPos(Dot newPos) {
		currPos = newPos;
	}
	
	public Dot getCurrPos() {
		return currPos;
	}
	
	public boolean isSpare() {
		return spareOne;
	}

	public boolean isInRightPos() {
		if( (origPos.getX() == currPos.getX()) &&
			(origPos.getY() == currPos.getY()) ) {
			return true;
		}
		return false;
	}

	public static Chunk getSpareChunk(Dot dot) {
		Chunk spare = 
			new Chunk(new Dot(dot), new ImageIcon() {
			
				@Override
				public void paintIcon(Component c, Graphics g, int x, int y) {
					Graphics2D gg = (Graphics2D) g;
					gg.setColor(Color.BLUE);
					gg.fillRect(0, 0, Config.CHUNKSIZE, Config.CHUNKSIZE);
					gg.dispose();
				}
				
				@Override
			    public int getIconWidth() {
					return Config.CHUNKSIZE;
				}
			    
				@Override
			    public int getIconHeight() {
					return Config.CHUNKSIZE;
				}
			});
		
		spare.spareOne = true;
		
		return spare;
	}
	
	@Override
	public Rectangle getBounds(Rectangle r) {
		super.setBounds(new Rectangle(currPos.getX() * Config.CHUNKSIZE,
									  currPos.getY() * Config.CHUNKSIZE,
									  Config.CHUNKSIZE + 3,
									  Config.CHUNKSIZE + 3 ));
		r = super.getBounds();
		return r;
	}
}
