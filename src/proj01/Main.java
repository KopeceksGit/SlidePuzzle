package proj01;

import javax.swing.SwingUtilities;
import io.IO;
import io.IOImpl;
import parser.Parser;
import parser.ParserImpl;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		IO io = new IOImpl();
		io.setString(Config.FILE_NAME1);
		
		Parser parser = new ParserImpl(io);
		
		Board board = new BoardImpl(parser);
		
		EngineImpl engine = new EngineImpl(board);
		
		Top app;
		
		SwingUtilities.invokeLater(app = new Top(board));

	}

}
