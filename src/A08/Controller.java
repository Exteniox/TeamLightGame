package AU8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {
	private Model m;
	private View v;
	
	public Controller() {
		this.m = new Model(5, 5);
		this.v = new View(this);
		newGame();
	}
	
	private void newGame(){
		m.scramble();
		updateView();
	}
	
	private void updateView(){
		for(int i = 0; i < m.getWidth(); ++i)
			for(int j = 0; j < m.getHeight(); ++j)
				v.updateCell(i, j, m.peek(i, j));
		v.repaint();
	}

	public void actionPerformed(ActionEvent arg0) {
		newGame();
	}

	public void mouseClicked(MouseEvent e) {
		m.poke(e.getX()/50, e.getY()/50);
		updateView();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
