package proj01;

import java.util.List;

public interface Board {
	
	public int getWidth();
	
	public int getHeight();
	
	public int getNumXTiles();
	
	public int getNumYTiles();
	
	public List<Chunk> getChunkList();
	
}
