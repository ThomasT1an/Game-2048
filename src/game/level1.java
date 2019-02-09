package game;
import jdbc.UserBean;
import jdbc.jdbc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class level1 extends JFrame{
	private JMenuBar jmb;
	private JMenu game;
	private JMenu level;
	private JMenu rank;
	private JMenuItem author;
	private JMenuItem lookrank;
	private JMenuItem deleterank;
	private JMenuItem level1;
	private JMenuItem level2;
	private JMenuItem level3;
	private JMenuItem restart;
	private JMenu other;
	private JPanel scoresPane;
	private JPanel mainPane;
	private JLabel label2048 ;
	private JLabel tips;					//���·���ǩ��
	private JTextField textMaxScores;
	private JLabel textScores;
	private JLabel textBest;
	private JLabel textBest1;
	private JLabel textScores1;
	private JLabel[][] texts;
	private static Integer best;
	static int i=0;
	private Icon icon2;
	private int times = 16;					
	private int scores = 0;					
	private int l1,l2,l3,l4;				
	Font font = new Font("΢���ź�", Font.BOLD,18);			//�����������ͺʹ�С
	Font font2 = new Font("Frutiger", Font.BOLD,52);    //font2Ϊ��������ʾ������
	Random random = new Random();
	

	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					level1 frame = new level1();
					frame.setVisible(true);
				best=getBest();
				//	Thread thread = new Thread(frame);
				//	thread.start();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
	}
	public static Integer getBest()
	{
		best=jdbc.getBest();
		System.out.println(best);
		return best;
	}
	/**
	 * ���췽��
	 */
	public level1(){
		super();
		setResizable(false);			//��ֹ���������С
		getContentPane().setLayout(null);	//���ÿղ���
		setBounds(540, 50, 530, 660);  //���ڴ�С λ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("2048");			//���ô������
		
		scoresPane = new JPanel();					//����������ʾ���
		scoresPane.setBackground(Color.WHITE);		//���÷�����ʾ���ı���ɫ
		scoresPane.setBounds(0, 0, 530, 80);
		getContentPane().add(scoresPane);			//���÷������ӵ�����
		scoresPane.setLayout(null);					//�������ղ���
		Color e=new Color(187,173,160);
		
		label2048=new JLabel("2048");     //���ϽǵĴ�2048
		Color q=new Color(119,110,101);
		label2048.setForeground(q);
		label2048.setFont(new java.awt.Font("��������",1,94));
		label2048.setBounds(10,5,300,80);
		scoresPane.add(label2048);
		
		textBest= new JLabel("BEST");    //BEST�ϰ벿��
		textBest.setFont(new java.awt.Font("consolas",1,18));
		Color w=new Color(238,228,218);
		textBest.setForeground(w);
		textBest.setOpaque(true);
		textBest.setHorizontalAlignment(SwingConstants.CENTER);
		textBest.setBackground(e);
		textBest.setBounds(265, 5, 110, 40);
		scoresPane.add(textBest);
		
		best=getBest();                                    //BEST�°벿�� ����ʾ����
		//String BBest=best.toString();
		textBest1 = new JLabel(String.valueOf(best));
		textBest1.setFont(new java.awt.Font("consolas",1,26));
		textBest1.setForeground(Color.WHITE);
		textBest1.setOpaque(true);
		textBest1.setHorizontalAlignment(SwingConstants.CENTER);
		textBest1.setBackground(e);
		textBest1.setBounds(265, 40, 110,30);
		scoresPane.add(textBest1);
		
		textMaxScores = new JTextField("BEST");			//�������� ������BEST��
		textMaxScores.setBorder(null);
		textMaxScores.setFont(new java.awt.Font("consolas",0,1));
		textMaxScores.setBackground(null);
		textMaxScores.setBounds(250, 5, 1, 1);
		textMaxScores.setEditable(false);
		scoresPane.add(textMaxScores);				
		
		
		textScores1= new JLabel("SCORE");                 //SCORE�ϰ벿��
		textScores1.setFont(new java.awt.Font("consolas",1,18));
		textScores1.setForeground(w);
		textScores1.setOpaque(true);
		textScores1.setHorizontalAlignment(SwingConstants.CENTER);
		textScores1.setBackground(e);
		textScores1.setBounds(385, 5, 110,40);
		scoresPane.add(textScores1);
		
		textScores = new JLabel(String.valueOf(scores));  //SCORE�°벿�� ����ʾ����
		textScores.setFont(new java.awt.Font("consolas",1,26));
		textScores.setForeground(Color.WHITE);
		textScores.setOpaque(true);
		textScores.setHorizontalAlignment(SwingConstants.CENTER);
		textScores.setBackground(e);
		textScores.setBounds(385, 40, 110,30);
		scoresPane.add(textScores);
		
		mainPane = new JPanel();				//�����
		mainPane.setBounds(0, 70, 540, 540);	
		Color main=new Color(187,173,160);
		mainPane.setBackground(main);
		this.getContentPane().add(mainPane);
		mainPane.setLayout(null);				//���ÿղ���
		
		jmb=new JMenuBar();                              //�˵���������
		game=new JMenu("  ��  Ϸ  ");
		other=new JMenu("  ��  ��  ");
		level=new JMenu("�Ѷ�����");
		level1=new JMenuItem("�Ѷ� 1");
		level2=new JMenuItem("�Ѷ� 2");
		level3=new JMenuItem("�Ѷ� 3");
		restart=new JMenuItem("���¿�ʼ");
		rank=new JMenu("���а�");
		author=new JMenuItem("����");
		lookrank=new JMenuItem("�鿴����");
		deleterank=new JMenuItem("�������");
		other.add(rank);
		other.add(author);
		rank.add(lookrank);
		rank.add(deleterank);
		game.add(level);
		game.add(restart);
		level.addSeparator();
		level.add(level1);
		level.add(level2);
		level.add(level3);
		jmb.add(game);
		jmb.add(other);
		myEvent();
		this.setJMenuBar(jmb);
		
		texts = new  JLabel[4][4];			//��Ϸ�����16��JLabel 
		for(int i = 0; i < 4; i++){				//�ñ����ķ�ʽ����
			for(int j = 0; j < 4; j++){
				texts[i][j] = new JLabel();	
				texts[i][j].setFont(font2);
				texts[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				texts[i][j].setText("");
				texts[i][j].setBounds((120 * j)+25, (120 * i)+20, 110, 110);	
				setColor(i, j, "");
				texts[i][j].setOpaque(true);               //����͸��
				mainPane.add(texts[i][j]);				
			}
		}
		tips = new JLabel("                            ��ǰ�Ѷ�Ϊ : 1");
		tips.setFont(font);
		tips.setBounds(60,490,400,50);
		mainPane.add(tips);
		
		textMaxScores.addKeyListener(new KeyAdapter(){				//����������
			public void keyPressed(  KeyEvent e){
				 do_label_keyPressed(e);				//����ʱ�䴦����
			}
		});
	
		Create2();    //�����������2���� ��Ϸ��ʼ
		Create2();
	}
	/*
	 * �˵����ļ���
	 */
	public void myEvent(){ 
		restart.addActionListener(new ActionListener(){      //���¿�ʼ
			public void actionPerformed(ActionEvent e){
				level1 frame = new level1();
				frame.setVisible(true);
				
			}
		});
		level1.addActionListener(new ActionListener(){   //�Ѷ�1
			public void actionPerformed(ActionEvent e){
				level1 frame=new level1();
				frame.setVisible(true);
			}
		});
		level2.addActionListener(new ActionListener(){  //�Ѷ�2
			public void actionPerformed(ActionEvent e){
				level2 frame=new level2();
				frame.setVisible(true);
			}
		});
		level3.addActionListener(new ActionListener(){  //�Ѷ�3
			public void actionPerformed(ActionEvent e){
				level3 frame=new level3();
				frame.setVisible(true);
			}
		});
		lookrank.addActionListener(new ActionListener(){   //�鿴����
			public void actionPerformed(ActionEvent e){
				Icon icon=new ImageIcon("D://����.jpg"); //����·��
				String ranking=null;
				String rank1=jdbc.getRankingname(1);
				String rank2=jdbc.getRankingname(2);
				String rank3=jdbc.getRankingname(3);
				String rank4=jdbc.getRankingname(4);
				String rank5=jdbc.getRankingname(5);
				Integer socre1=jdbc.getRankingsocres(1);
				Integer socre2=jdbc.getRankingsocres(2);
				Integer socre3=jdbc.getRankingsocres(3);
				Integer socre4=jdbc.getRankingsocres(4);
				Integer socre5=jdbc.getRankingsocres(5);
				ranking="1 ."+rank1+"        "+socre1.toString()+"\n"
				+"2 ."+rank2+"        "+socre2.toString()+"\n"
				+"3 ."+rank3+"        "+socre3.toString()+"\n"
				+"4 ."+rank4+"        "+socre4.toString()+"\n"
				+"5 ."+rank5+"        "+socre5.toString()+"\n";
				
				JOptionPane.showMessageDialog(null,ranking,
						"���а�",JOptionPane.PLAIN_MESSAGE,icon);
			}
		});
		
		deleterank.addActionListener(new ActionListener(){   //�������
			public void actionPerformed(ActionEvent e){
				int n=JOptionPane.showConfirmDialog(null, "ȷ����գ�"," ",JOptionPane.YES_NO_OPTION);
				if(n==0)
					jdbc.qingkong();
			}
		});
		
		author.addActionListener(new ActionListener(){  //����
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"�������ѧ�뼼��1601������2811160106",
						"������Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	/*
	 * �����㷨
	 */
	protected  void do_label_keyPressed(final KeyEvent e){
		int code = e.getKeyCode();	//��ȡ������
		int a ;						//��ֹ���� 
		String str ;								
		String str1;
		int num;
		switch(code){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:		//����������������������A��
			for(int i = 0; i < 4; i++){	
				a = 5;
				for(int k = 0; k < 3; k++){
					for(int j = 1; j < 4; j++){					//����16������
						str = texts[i][j].getText();			//��ȡ��ǰ�����ǩ�ı��ַ�
						str1 = texts[i][j-1].getText();			//��ȡ��ǰ��1�����ǩ�ı��ַ�
						
						if(str1.compareTo("") == 0){				//�����1�����ı�Ϊ���ַ�
							texts[i][j-1].setText(str);				//�ַ�����
							setColor(i, j-1,str);
							texts[i][j].setText("");				//��ǰ�����ַ��ÿ�
							setColor(i, j, "");
						}else if((str.compareTo(str1) == 0) && (j !=a) && (j != a-1)){			//�����ǰ�������1�����ı��ַ����
							num  = Integer.parseInt(str);
							scores += num;
							times ++;
							str = String.valueOf(2 * num);
							texts[i][j-1].setText(str);		//��1�����ı��ַ���Ϊ������֮��
							setColor(i, j-1, str);
							texts[i][j].setText("");				//��ǰ�����ַ��ÿ�
							setColor(i, j, "");
							a = j;
						}
					}
				}
			}
			l1 = 1;				//�����ж���Ϸ�Ƿ�ʧ��
			Create2();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			for(int i = 0; i < 4; i ++){
				a = 5;
				for(int k = 0; k < 3; k++){
					for(int j = 2; j >= 0; j--){
						str = texts[i][j].getText();
						str1 = texts[i][j + 1].getText();
						
						if(str1.compareTo("") == 0){
							texts[i][j + 1].setText(str);
							setColor(i, j+1, str);
							texts[i][j].setText("");
							setColor(i, j, "");
						}
						else if(str.compareTo(str1) == 0 && j !=a && j != a+ 1){
							num  = Integer.parseInt(str);
							scores += num ;
							times ++;
							str = String.valueOf(2 * num);
							texts[i][j + 1].setText(str);
							setColor(i, j+1, str);
							texts[i][j].setText("");
							setColor(i, j, "");
							a = j;
						}
					}
				}
			}
			l2 = 1;
			Create2();
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			for(int j = 0; j < 4; j++){
				a = 5;
				for(int k = 0; k < 3; k++){
					for(int i = 1; i < 4; i++){
						str = texts[i][j].getText();
						str1 = texts[i - 1][j].getText();
					
						if(str1.compareTo("") == 0){
							texts[i - 1][j].setText(str);
							setColor(i-1, j, str);
							texts[i][j].setText("");
							setColor(i, j, "");
						}
						else if(str.compareTo(str1) == 0 && i != a && i != a -1){
							num  = Integer.parseInt(str);
							scores += num ;
							times ++;
							str = String.valueOf(2 * num);
							texts[i - 1][j].setText(str);
							setColor(i-1, j, str);
							texts[i][j].setText("");
							setColor(i, j, "");
							a = i;
						}
					}
				}
			}
			l3 =1;
			Create2();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			for(int j = 0; j < 4; j ++){
				a = 5;
				for(int k = 0; k < 5; k++){
					for(int i = 2; i >= 0; i--){
						str = texts[i][j].getText();
						str1 = texts[i + 1][j].getText();
						
						if(str1.compareTo("") == 0){
							texts[i + 1][j].setText(str);
							setColor(i+1, j, str);
							texts[i][j].setText("");
							setColor(i, j, "");
						}
						else if(str.compareTo(str1) == 0 && i != a && i != a + 1){
							num  = Integer.parseInt(str);
							scores += num ;
							times ++;
							str = String.valueOf(2 * num);
							texts[i + 1][j].setText(str );
							setColor(i+1, j, str);
							texts[i][j].setText("");
							setColor(i, j, "");
							a = i;
						}
					}
				}
			}
			l4 = 1;
			Create2();
			break;
			default:
				break;
		}
		textScores.setText(String.valueOf(scores));
	}
	
	/*
	 * ����������� �����Ѷ� �Ѷ�1ȫ������2 �Ѷ�2��2��4�ı���Ϊ5��1  �Ѷ�3��2��4�ı���Ϊ2��1
	 */
	public void Create2(){
		try {
			Thread.sleep(30);            //���ö����ӳ� ʹ�³��ֵķ�����׷���
		} catch (InterruptedException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		int i ,j;
		boolean r = false;
		String str;
		
		if(times > 0){
			while(!r){
				i = random.nextInt(4);
				j = random.nextInt(4);
				str = texts[i][j].getText();
				if((str.compareTo("") == 0)){
					texts[i][j].setIcon(icon2);
					texts[i][j].setText("2");
					setColor(i, j, "2");
					times --;
					r = true;
					l1 = l2 = l3 = l4 = 0;			
				}
			}
		}
		else if(l1 >0 && l2 >0 && l3 > 0 && l4 > 0){		//l1��l4ͬʱ�����̸�ֵΪ1˵���κη���������ܲ����µ�����2��˵����Ϸʧ��
				tips.setText("                                 ��Ϸ����");
			String name=JOptionPane.showInputDialog("��������������");
			System.out.println(scores);
			System.out.println(name);
			jdbc.addrank(name,scores);
		}
	}
	
	/*
	 * ���ò�ͬ���ַ������ɫ
	 */
	public void setColor(int i, int j, String str){
		switch(str){
		case "2":
			Color a=new Color(238,228,218);
			texts[i][j].setBackground(a); //238 228 218
			texts[i][j].setForeground(Color.BLACK);
			break;
		case "4":
			Color b=new Color(237,224,200);
			texts[i][j].setBackground(b);//237 224 200
			texts[i][j].setForeground(Color.BLACK);
			break;
		case "8":
			Color c=new Color(242,177,121);
			texts[i][j].setBackground(c);  //242 177 121
			texts[i][j].setForeground(Color.white);
			break;
		case "16":
			Color d=new Color(245,149,99);
			texts[i][j].setBackground(d); //245 149 99
			texts[i][j].setForeground(Color.white);
			break;
		case "32":
			Color e=new Color(246,124,95);
			texts[i][j].setBackground(e); //246 124 95
			texts[i][j].setForeground(Color.white);
			break;
		case "64":
			Color f=new Color(246,94,59);
			texts[i][j].setBackground(f);
			texts[i][j].setForeground(Color.white);
			break;
		case "128":
			Color g=new Color(237,207,114);
			texts[i][j].setBackground(g);
			texts[i][j].setForeground(Color.white);
			break;
		case "256":
			Color h=new Color(237,204,97);
			texts[i][j].setBackground(h);
			texts[i][j].setForeground(Color.white);
			break;
		case "512":
			texts[i][j].setBackground(Color.cyan);
			texts[i][j].setForeground(Color.white);
			break;
		case "1024":
			texts[i][j].setBackground(Color.green);
			texts[i][j].setForeground(Color.white);
			break;
		case "2048":
			texts[i][j].setBackground(Color.blue);
			texts[i][j].setForeground(Color.white);
			break;
		case "":
		case "4096":
			texts[i][j].setBackground(Color.white);
			break;
		default:
			break;
		}
	}
} //лл
