import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Numbers extends Thread {

	private JLabel label;
	private JPanel panel;

	public Numbers(JPanel panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void run() {
		Random r = new Random();

		JLabel[] labels = new JLabel[10000];
		String[] numbers = { "1", "2", "3", "4", "5", "6"," 7", "8", "9", "0" };
		
		int x = 0;
		int y = 0;
		JLabel l = null;
		for (int i = 0; i < labels.length; i++) {
			 x = r.nextInt(panel.getBounds().width);
			 y = r.nextInt(panel.getBounds().height);
			
			l = new JLabel();
			l.setBounds(x, y , 10, 10);
			l.setFont(new Font("Tahoma", Font.PLAIN, 10));
			l.setForeground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			//l.setBorder(BorderFactory.createLineBorder(Color.GREEN));
			
			labels[i] = l;
			labels[i].setText(numbers[r.nextInt(10)]);
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.add(l);
			panel.repaint();
		}
		
		
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(labels.length);

	}
}
