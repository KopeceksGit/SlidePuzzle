package parser;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import io.IO;
import proj01.Chunk;
import proj01.Config;
import proj01.Dot;

public class ParserImpl implements Parser {
	private int w, h;
	private BufferedImage wholeIMG;
	
	public ParserImpl(IO io) {
		wholeIMG = io.load();
		w = wholeIMG.getWidth();
		h = wholeIMG.getHeight();
		
		cropToDivisibleSize();
	}
	
	@Override
	public int getNumOfColls() {
		return w / Config.CHUNKSIZE;
	}
	
	@Override
	public int getNumOfRows() {
		return h / Config.CHUNKSIZE;
	}
	
	@Override
	public int getWidth() {
		return w;
	}
	
	@Override
	public int getHeight() {
		return h;
	}
	
	@Override
	public Chunk[][] parse() {
		Chunk c[][] = new Chunk[getNumOfColls()][getNumOfRows()];
		
		BufferedImage buff = null;
		
		for(int row = 0; row < getNumOfRows(); row++) {
			for(int coll = 0; coll < getNumOfColls(); coll++) {
				
				buff = wholeIMG.getSubimage(coll * Config.CHUNKSIZE,
											row * Config.CHUNKSIZE,
											Config.CHUNKSIZE,
											Config.CHUNKSIZE);
				
				c[coll][row] = new Chunk(new Dot(coll, row), new ImageIcon(buff));
			}
		}
		return c;
	}
	
	private void cropToDivisibleSize() {
		int tempW = w;
		int tempH = h;
		
		while(tempW % Config.CHUNKSIZE != 0) --tempW;
		while(tempH % Config.CHUNKSIZE != 0) --tempH;
		
		if((w != tempW) || (h != tempH)) {
			wholeIMG = wholeIMG.getSubimage(0, 0, tempW, tempH);
			w = wholeIMG.getWidth();
			h = wholeIMG.getHeight();
		}
	}

}
