import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
class WinApp6 extends KeyAdapter
{
	JLabel label1,label2,l;
	Timer t;
	JFrame f;
	String nm;
	int c=0;
	int flag=0;
	int cl[][] = {
		{10,10,8,8},
		{10,8,10,7},
		{11,11,7,8},
		{8,10,8,8}
	};
	int cr[][] = {
		{4,4,4,4},
		{3,5,3,5},
		{5,3,3,4},
		{4,4,4,4}
	};
	int checkx[][]={
		{0,400,720,400},
		{0,320,720,440},
		{0,440,720,320},
		{0,400,720,400}
	};
	int checky[][]={
		{160,0,160,320},
		{200,0,120,320},
		{120,0,120,320},
		{160,0,160,320}
	};
	int gameover[][] = {
		{330,430},
		{370,470},
		{250,350},
		{330,430}
	};
	int i=0;
	public WinApp6(String name)
	{
		nm = name;
		f = new JFrame("Game 1");
		f.setUndecorated(true);
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.white);
		label1 = new JLabel();
		ImageIcon icon1 = new ImageIcon("1.png");
		label1.setIcon(icon1);
		label1.setBounds(400,320,30,30);
		label2 = new JLabel();
		ImageIcon icon2 = new ImageIcon("2.png");
		label2.setIcon(icon2);
		label2.setBounds(400,350,75,17);
		l=new JLabel();
		l.setBounds(750,160,30,30);
		p.add(l);
		JLabel l1 = new JLabel();
		l1.setBounds(750,100,150,25);
		l1.setText(name);
		p.add(label1);
		p.add(label2);
		p.add(l1);
		f.addKeyListener(this);
		f.add(p);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int  sw = (int)(d.getWidth());
        int  sh = (int)(d.getHeight());
        f.setLocation((sw-900)/2,(sh-400)/2);
		f.setSize(900,400);
		f.setVisible(true);
		t = new Timer(100,new MyActionListen());
		t.start();
		Timer k= new Timer(200,new A());
		k.start();
	}
	int a=400, b=320;
	int u,v;
	public class MyActionListen implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(i==0)
			{
				u = 3;
			}
			else
			{
				u=i-1;
			}
			if((a>checkx[i][0]&&a<=checkx[u][3])&&(b>checky[i][0]&&b<=checky[u][3])&&flag==0)
			{
				a-=cl[i][0];
				b-=cr[i][0];
			}
			else if((a>=checkx[i][0]&&a<checkx[i][1])&&(b>checky[i][1]&&b<=checky[i][0]))
			{
				flag=1;
				a+=cl[i][1];
				b-=cr[i][1];
			}
			else if((a>=checkx[i][1]&&a<checkx[i][2])&&(b>=checky[i][1]&&b<checky[i][2]))
			{
				a+=cl[i][2];
				b+=cr[i][2];
			}
			else if((a>checkx[i][3]&&a<=checkx[i][2])&&(b>=checky[i][2]&&b<checky[i][3]))
			{
				a-=cl[i][3];
				b+=cr[i][3];
			}
			if((x<gameover[i][0]||x>gameover[i][1])&&b==320)
			{
				//System.out.println(gameover[i][0]+" "+x+" "+gameover[i][1]);
				//JOptionPane.showMessageDialog(f,"Sorry"+" Game Over \n You got "+c+" points");
				t.stop();
				f.dispose();
			}
			else if(b==320)
			{
				//System.out.println(gameover[i][0]+" "+x+" "+gameover[i][1]);
				flag=0;
				i=(i+1)%4;
				c++;
			}
			label1.setBounds(a,b,30,30);
		}
	}
	class A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			l.setText(c+"");
		}
	}
	int x=400;
	public void keyPressed(KeyEvent e)
	{
		int kc = e.getKeyCode();
		if(kc==KeyEvent.VK_LEFT)
		{
			if(x>=7)
			{
				x= x-5;
			}
		}
		else if(kc==KeyEvent.VK_RIGHT)
		{
			if(x<=645)
			{
				x=x+5;
			}
		}
		label2.setBounds(x,350,75,17);
	}
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name: ");
		String name = sc.nextLine();
		new WinApp6(name);
		//System.out.println("k");
	}
}