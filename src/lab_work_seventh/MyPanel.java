package lab_work_seventh;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	
	
	private VisualMassiv massiv = new VisualMassiv();
	
	public void keyAction(KeyEvent e)
	{
		switch (e.getKeyCode()) {		
		case KeyEvent.VK_UP:
			massiv.moveUp();
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			massiv.moveDown();
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			massiv.moveLeft();
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			massiv.moveRight();
			repaint();
			break;
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		massiv.draw(g,this);
	}
	
}
