package proj01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineImpl implements ActionListener {
	private Board board;
	private Chunk reserved;
	private Chunk spare;
	
	EngineImpl(Board board) {
		this.board = board;
		
		addListeners();
		
		saveThisGetSpare();
		
		shuffle();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Chunk btn = (Chunk) e.getSource();
		
		Dot h = new Dot();
		
		Dot d = new Dot(btn.getCurrPos());
		d.shiftX(-1);
		if(d.isEqualTo(spare.getCurrPos())) {
			h = spare.getCurrPos();
			spare.setCurrPos(btn.getCurrPos());
			btn.setCurrPos(h);
			btn.getParent().invalidate();
			btn.revalidate();
			btn.getParent().repaint();
			return;
		}
		
		d = new Dot(btn.getCurrPos());
		d.shiftX(+1);
		if(d.isEqualTo(spare.getCurrPos())) {
			h = spare.getCurrPos();
			spare.setCurrPos(btn.getCurrPos());
			btn.setCurrPos(h);
			btn.getParent().invalidate();
			btn.revalidate();
			btn.getParent().repaint();
			return;
		}
		
		d = new Dot(btn.getCurrPos());
		d.shiftY(-1);
		if(d.isEqualTo(spare.getCurrPos())) {
			h = spare.getCurrPos();
			spare.setCurrPos(btn.getCurrPos());
			btn.setCurrPos(h);
			btn.getParent().invalidate();
			btn.revalidate();
			btn.getParent().repaint();
			return;
		}
		
		d = new Dot(btn.getCurrPos());
		d.shiftY(+1);
		if(d.isEqualTo(spare.getCurrPos())) {
			h = spare.getCurrPos();
			spare.setCurrPos(btn.getCurrPos());
			btn.setCurrPos(h);
			btn.getParent().invalidate();
			btn.revalidate();
			btn.getParent().repaint();
			return;
		}
		
//		btn.getParent().invalidate();
//		btn.revalidate();
//		btn.getParent().repaint();
//		System.out.print("ORIG: " + "  ");	
//		System.out.println("CURR: ");	
//		System.out.println("Clicked: " + btn.getCurrPos());
//		System.out.println("Spare  : " + spare.getCurrPos());
//		System.out.println("Reserved " + reserved.getCurrPos());
	}
	
	private void addListeners() {
		board.getChunkList().forEach(elem -> {
			elem.addActionListener(this);
		});
	}
	
	private final int INDEX = 0;
	private void saveThisGetSpare() {
		reserved = board.getChunkList().remove(INDEX);
		spare = Chunk.getSpareChunk(reserved.getCurrPos());
		board.getChunkList().add(INDEX, spare);
	}
	
	private void shuffle() {
		List<Dot> dots = new ArrayList<>();
		
		for(Chunk c : board.getChunkList()) {
			dots.add(c.getCurrPos());
		}
		
		Collections.shuffle(dots);
		
		for(int i = 0; i < dots.size(); i++) {
			board.getChunkList().get(i).setCurrPos(dots.get(i));
		}
	}
	
}
