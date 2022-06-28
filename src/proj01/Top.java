package proj01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Top extends JFrame implements Runnable {
	
	Top(Board board) {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setLayout(null);
		panel.setBounds(0, 0, board.getWidth(), board.getHeight());

		for(Chunk c : board.getChunkList()) {
			panel.add(c);
		}	
		
		add(panel, BorderLayout.CENTER);
		getContentPane().setPreferredSize(
				new Dimension( (panel.getBounds().getSize().width + 
							    this.getInsets().left + this.getInsets().right), 
							   (panel.getBounds().getSize().height + 
							    this.getInsets().top + this.getInsets().bottom)) );
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	@Override
	public void run() {
//		System.out.println("");
	}
	
}
