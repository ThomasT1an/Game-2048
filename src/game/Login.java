package game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	//声明所有组件的引用
	JLabel user,password;  //文本显示框
	JTextField userinput;//姓名输入框
	JTextField passinput;//学号输入框
	JButton bt1,bt2;//两个按钮
	JPanel MainPane; //主面板
	Login(){
		init();  //创建构造器，实现外观界面的初始化
	}
	public void init(){
		this.setTitle("2048登录页面");  //设置标题
		setResizable(false);			//禁止调整窗体大小
		getContentPane().setLayout(null);	//设置空布局
		setBounds(540, 50, 530, 660);  //窗口大小 位置
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击右上角退出
		setVisible(true); //设置窗口可见
		
		MainPane = new JPanel();					//创建主显示面板
		MainPane.setBackground(Color.WHITE);		//设置显示面板的背景色
		MainPane.setBounds(0, 0, 530, 660);          //面板完全覆盖整个界面
		getContentPane().add(MainPane);			//将面板添加到窗体
		MainPane.setLayout(null);					//设置面板空布局
		
		user=new JLabel("姓名:");     //姓名二字
		Color q=new Color(119,110,101);  //创建颜色
		user.setForeground(q);  //设置字体颜色为刚创建的颜色
		user.setFont(new java.awt.Font("微软雅黑",1,40));  //设置字体大小 粗细 和字体
		user.setBounds(10,100,200,150); //设置大小 位置
		MainPane.add(user);  //添加到主面板中
		
		password=new JLabel("学号:");     //学号二字
		password.setForeground(q);
		password.setFont(new java.awt.Font("微软雅黑",1,40));
		password.setBounds(10,260,200,100);
		MainPane.add(password);
		
		userinput=new JTextField(10);    //姓名输入框
		userinput.setBounds(170,125,250,100);
		userinput.setFont(new java.awt.Font("微软雅黑",1,40));
		MainPane.add(userinput);
		userinput.setVisible(true);
		
		passinput=new JTextField(15);  //学号输入框
		passinput.setBounds(170,260,300,100);
		passinput.setFont(new java.awt.Font("微软雅黑",1,40));
		MainPane.add(passinput);
		passinput.setVisible(true);
		
		bt1=new JButton("登录");   //登录按钮
		bt1.setBounds(10,400,180,100);
		bt1.setFont(new java.awt.Font("微软雅黑",1,40));
		MainPane.add(bt1);
		bt1.setVisible(true);
		
		bt2=new JButton("退出");   //退出按钮
		bt2.setBounds(300,400,180,100);
		bt2.setFont(new java.awt.Font("微软雅黑",1,40));
		MainPane.add(bt2);
		bt2.setVisible(true);
		this.setVisible(false);  //这一句和下一句加在一起相当于刷新窗口
		this.setVisible(true);
		
		myEvent(); //事件监听
	}
	public void myEvent()
	{
		bt1.addActionListener(new ActionListener(){ //登录按钮的监听
			public void actionPerformed(ActionEvent e)
			{
				if(userinput.getText().equals("111")&&passinput.getText().equals("111"))
				{
					level1 frame = new level1();
					frame.setVisible(true);
				}
			}
		});
		bt2.addMouseListener(new MouseAdapter(){ //退出按钮的监听
			public void mousePressed(MouseEvent e)
			{
				dispose();//关闭程序
			}
		});
	}
}
