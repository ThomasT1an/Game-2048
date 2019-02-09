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
	private JLabel tips;					//最下方标签栏
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
	Font font = new Font("微软雅黑", Font.BOLD,18);			//设置字体类型和大小
	Font font2 = new Font("Frutiger", Font.BOLD,52);    //font2为方块中显示的字体
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
	 * 构造方法
	 */
	public level1(){
		super();
		setResizable(false);			//禁止调整窗体大小
		getContentPane().setLayout(null);	//设置空布局
		setBounds(540, 50, 530, 660);  //窗口大小 位置
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("2048");			//设置窗体标题
		
		scoresPane = new JPanel();					//创建分数显示面板
		scoresPane.setBackground(Color.WHITE);		//设置分数显示面板的背景色
		scoresPane.setBounds(0, 0, 530, 80);
		getContentPane().add(scoresPane);			//将得分面板添加到窗体
		scoresPane.setLayout(null);					//设置面板空布局
		Color e=new Color(187,173,160);
		
		label2048=new JLabel("2048");     //左上角的大2048
		Color q=new Color(119,110,101);
		label2048.setForeground(q);
		label2048.setFont(new java.awt.Font("华文琥珀",1,94));
		label2048.setBounds(10,5,300,80);
		scoresPane.add(label2048);
		
		textBest= new JLabel("BEST");    //BEST上半部分
		textBest.setFont(new java.awt.Font("consolas",1,18));
		Color w=new Color(238,228,218);
		textBest.setForeground(w);
		textBest.setOpaque(true);
		textBest.setHorizontalAlignment(SwingConstants.CENTER);
		textBest.setBackground(e);
		textBest.setBounds(265, 5, 110, 40);
		scoresPane.add(textBest);
		
		best=getBest();                                    //BEST下半部分 即显示部分
		//String BBest=best.toString();
		textBest1 = new JLabel(String.valueOf(best));
		textBest1.setFont(new java.awt.Font("consolas",1,26));
		textBest1.setForeground(Color.WHITE);
		textBest1.setOpaque(true);
		textBest1.setHorizontalAlignment(SwingConstants.CENTER);
		textBest1.setBackground(e);
		textBest1.setBounds(265, 40, 110,30);
		scoresPane.add(textBest1);
		
		textMaxScores = new JTextField("BEST");			//监听容器 隐藏在BEST下
		textMaxScores.setBorder(null);
		textMaxScores.setFont(new java.awt.Font("consolas",0,1));
		textMaxScores.setBackground(null);
		textMaxScores.setBounds(250, 5, 1, 1);
		textMaxScores.setEditable(false);
		scoresPane.add(textMaxScores);				
		
		
		textScores1= new JLabel("SCORE");                 //SCORE上半部分
		textScores1.setFont(new java.awt.Font("consolas",1,18));
		textScores1.setForeground(w);
		textScores1.setOpaque(true);
		textScores1.setHorizontalAlignment(SwingConstants.CENTER);
		textScores1.setBackground(e);
		textScores1.setBounds(385, 5, 110,40);
		scoresPane.add(textScores1);
		
		textScores = new JLabel(String.valueOf(scores));  //SCORE下半部分 即显示部分
		textScores.setFont(new java.awt.Font("consolas",1,26));
		textScores.setForeground(Color.WHITE);
		textScores.setOpaque(true);
		textScores.setHorizontalAlignment(SwingConstants.CENTER);
		textScores.setBackground(e);
		textScores.setBounds(385, 40, 110,30);
		scoresPane.add(textScores);
		
		mainPane = new JPanel();				//主面板
		mainPane.setBounds(0, 70, 540, 540);	
		Color main=new Color(187,173,160);
		mainPane.setBackground(main);
		this.getContentPane().add(mainPane);
		mainPane.setLayout(null);				//设置空布局
		
		jmb=new JMenuBar();                              //菜单栏的设置
		game=new JMenu("  游  戏  ");
		other=new JMenu("  其  他  ");
		level=new JMenu("难度设置");
		level1=new JMenuItem("难度 1");
		level2=new JMenuItem("难度 2");
		level3=new JMenuItem("难度 3");
		restart=new JMenuItem("重新开始");
		rank=new JMenu("排行榜");
		author=new JMenuItem("作者");
		lookrank=new JMenuItem("查看排名");
		deleterank=new JMenuItem("清空排名");
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
		
		texts = new  JLabel[4][4];			//游戏区域的16个JLabel 
		for(int i = 0; i < 4; i++){				//用遍历的方式创建
			for(int j = 0; j < 4; j++){
				texts[i][j] = new JLabel();	
				texts[i][j].setFont(font2);
				texts[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				texts[i][j].setText("");
				texts[i][j].setBounds((120 * j)+25, (120 * i)+20, 110, 110);	
				setColor(i, j, "");
				texts[i][j].setOpaque(true);               //设置透明
				mainPane.add(texts[i][j]);				
			}
		}
		tips = new JLabel("                            当前难度为 : 1");
		tips.setFont(font);
		tips.setBounds(60,490,400,50);
		mainPane.add(tips);
		
		textMaxScores.addKeyListener(new KeyAdapter(){				//按键监听器
			public void keyPressed(  KeyEvent e){
				 do_label_keyPressed(e);				//调用时间处理方法
			}
		});
	
		Create2();    //随机产生两个2方块 游戏开始
		Create2();
	}
	/*
	 * 菜单栏的监听
	 */
	public void myEvent(){ 
		restart.addActionListener(new ActionListener(){      //重新开始
			public void actionPerformed(ActionEvent e){
				level1 frame = new level1();
				frame.setVisible(true);
				
			}
		});
		level1.addActionListener(new ActionListener(){   //难度1
			public void actionPerformed(ActionEvent e){
				level1 frame=new level1();
				frame.setVisible(true);
			}
		});
		level2.addActionListener(new ActionListener(){  //难度2
			public void actionPerformed(ActionEvent e){
				level2 frame=new level2();
				frame.setVisible(true);
			}
		});
		level3.addActionListener(new ActionListener(){  //难度3
			public void actionPerformed(ActionEvent e){
				level3 frame=new level3();
				frame.setVisible(true);
			}
		});
		lookrank.addActionListener(new ActionListener(){   //查看排名
			public void actionPerformed(ActionEvent e){
				Icon icon=new ImageIcon("D://奖杯.jpg"); //绝对路径
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
						"排行榜",JOptionPane.PLAIN_MESSAGE,icon);
			}
		});
		
		deleterank.addActionListener(new ActionListener(){   //清空排名
			public void actionPerformed(ActionEvent e){
				int n=JOptionPane.showConfirmDialog(null, "确认清空？"," ",JOptionPane.YES_NO_OPTION);
				if(n==0)
					jdbc.qingkong();
			}
		});
		
		author.addActionListener(new ActionListener(){  //作者
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"计算机科学与技术1601田仲屹2811160106",
						"作者信息",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	/*
	 * 核心算法
	 */
	protected  void do_label_keyPressed(final KeyEvent e){
		int code = e.getKeyCode();	//获取所按键
		int a ;						//防止连加 
		String str ;								
		String str1;
		int num;
		switch(code){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:		//如果按键代码是左方向键或者A键
			for(int i = 0; i < 4; i++){	
				a = 5;
				for(int k = 0; k < 3; k++){
					for(int j = 1; j < 4; j++){					//遍历16个方块
						str = texts[i][j].getText();			//获取当前方块标签文本字符
						str1 = texts[i][j-1].getText();			//获取当前左1方块标签文本字符
						
						if(str1.compareTo("") == 0){				//如果左1方块文本为空字符
							texts[i][j-1].setText(str);				//字符左移
							setColor(i, j-1,str);
							texts[i][j].setText("");				//当前方块字符置空
							setColor(i, j, "");
						}else if((str.compareTo(str1) == 0) && (j !=a) && (j != a-1)){			//如果当前方块和左1方块文本字符相等
							num  = Integer.parseInt(str);
							scores += num;
							times ++;
							str = String.valueOf(2 * num);
							texts[i][j-1].setText(str);		//左1方块文本字符变为两方块之和
							setColor(i, j-1, str);
							texts[i][j].setText("");				//当前方块字符置空
							setColor(i, j, "");
							a = j;
						}
					}
				}
			}
			l1 = 1;				//用于判断游戏是否失败
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
	 * 产生随机方块 根据难度 难度1全部产生2 难度2中2与4的比例为5：1  难度3中2与4的比例为2：1
	 */
	public void Create2(){
		try {
			Thread.sleep(30);            //设置短暂延迟 使新出现的方块更易发现
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
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
		else if(l1 >0 && l2 >0 && l3 > 0 && l4 > 0){		//l1到l4同时被键盘赋值为1说明任何方向键都不能产生新的数字2，说明游戏失败
				tips.setText("                                 游戏结束");
			String name=JOptionPane.showInputDialog("少侠留下姓名：");
			System.out.println(scores);
			System.out.println(name);
			jdbc.addrank(name,scores);
		}
	}
	
	/*
	 * 设置不同数字方块的颜色
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
} //谢谢
