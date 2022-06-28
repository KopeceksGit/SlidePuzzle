package proj01;

import java.util.ArrayList;
import java.util.List;
import parser.Parser;

public class BoardImpl implements Board {
	private int width, height;
	private int numXTiles;
	private int numYTiles;
	private List<Chunk> chunks = new ArrayList<>();
	
	public BoardImpl(Parser parser) {
		numXTiles = parser.getNumOfColls();
		numYTiles = parser.getNumOfRows();
		width = parser.getWidth();
		height = parser.getHeight();
		
		fillListWithChunks(parser.parse());
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public int getNumXTiles() {
		return numXTiles;
	}
	
	@Override
	public int getNumYTiles() {
		return numYTiles;
	}
	
	@Override
	public List<Chunk> getChunkList() {
		return chunks;
	}
	
	private void fillListWithChunks(Chunk[][] ccc) {
		for(Chunk[] cc : ccc)
			for(Chunk c : cc)
				chunks.add(c);
	}

}
