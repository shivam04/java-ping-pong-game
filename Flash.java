import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Flash
{
	JFrame f;
	JLabel l;
	JProgressBar p;
	Flash()
	{
		f = new JFrame();
		f.setLayout(null);
		f.setUndecorated(true);
		l = new JLabel();
		ImageIcon icon = new ImageIcon("flash.png");
		l.setIcon(icon);
		l.setBounds(0,0,800,400);
		f.add(l);
		p = new JProgressBar();
		p.setBounds(0,370,800,10);
		l.add(p);
		JLabel l1 = new JLabel("<html>&copy; Copyright 2015-16 </html>");
		l1.setBounds(650,385,150,15);
		l.add(l1);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int  sw = (int)(d.getWidth());
        int  sh = (int)(d.getHeight());
        f.setLocation((sw-800)/2,(sh-400)/2);
		f.setSize(800,400);
		f.setVisible(true);
		t = new Timer(1000,new Load());
		t.start();
	}
	Timer t;
	int num = 0;
	class Load implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			num = num + 10;
			p.setValue(num);
			if(num>100)
			{
				t.stop();
				new GiveName();
				f.dispose();
			}
		}
	}
	public static void main(String a[])
	{
		new Flash();
	}
}