package parser;

import proj01.Chunk;

public interface Parser {
	
	public int getNumOfColls();
	
	public int getNumOfRows();
	
	public int getWidth();
	
	public int getHeight();
	
	public Chunk[][] parse();
	
}
