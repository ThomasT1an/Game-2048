package game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	//�����������������
	JLabel user,password;  //�ı���ʾ��
	JTextField userinput;//���������
	JTextField passinput;//ѧ�������
	JButton bt1,bt2;//������ť
	JPanel MainPane; //�����
	Login(){
		init();  //������������ʵ����۽���ĳ�ʼ��
	}
	public void init(){
		this.setTitle("2048��¼ҳ��");  //���ñ���
		setResizable(false);			//��ֹ���������С
		getContentPane().setLayout(null);	//���ÿղ���
		setBounds(540, 50, 530, 660);  //���ڴ�С λ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������Ͻ��˳�
		setVisible(true); //���ô��ڿɼ�
		
		MainPane = new JPanel();					//��������ʾ���
		MainPane.setBackground(Color.WHITE);		//������ʾ���ı���ɫ
		MainPane.setBounds(0, 0, 530, 660);          //�����ȫ������������
		getContentPane().add(MainPane);			//�������ӵ�����
		MainPane.setLayout(null);					//�������ղ���
		
		user=new JLabel("����:");     //��������
		Color q=new Color(119,110,101);  //������ɫ
		user.setForeground(q);  //����������ɫΪ�մ�������ɫ
		user.setFont(new java.awt.Font("΢���ź�",1,40));  //���������С ��ϸ ������
		user.setBounds(10,100,200,150); //���ô�С λ��
		MainPane.add(user);  //��ӵ��������
		
		password=new JLabel("ѧ��:");     //ѧ�Ŷ���
		password.setForeground(q);
		password.setFont(new java.awt.Font("΢���ź�",1,40));
		password.setBounds(10,260,200,100);
		MainPane.add(password);
		
		userinput=new JTextField(10);    //���������
		userinput.setBounds(170,125,250,100);
		userinput.setFont(new java.awt.Font("΢���ź�",1,40));
		MainPane.add(userinput);
		userinput.setVisible(true);
		
		passinput=new JTextField(15);  //ѧ�������
		passinput.setBounds(170,260,300,100);
		passinput.setFont(new java.awt.Font("΢���ź�",1,40));
		MainPane.add(passinput);
		passinput.setVisible(true);
		
		bt1=new JButton("��¼");   //��¼��ť
		bt1.setBounds(10,400,180,100);
		bt1.setFont(new java.awt.Font("΢���ź�",1,40));
		MainPane.add(bt1);
		bt1.setVisible(true);
		
		bt2=new JButton("�˳�");   //�˳���ť
		bt2.setBounds(300,400,180,100);
		bt2.setFont(new java.awt.Font("΢���ź�",1,40));
		MainPane.add(bt2);
		bt2.setVisible(true);
		this.setVisible(false);  //��һ�����һ�����һ���൱��ˢ�´���
		this.setVisible(true);
		
		myEvent(); //�¼�����
	}
	public void myEvent()
	{
		bt1.addActionListener(new ActionListener(){ //��¼��ť�ļ���
			public void actionPerformed(ActionEvent e)
			{
				if(userinput.getText().equals("111")&&passinput.getText().equals("111"))
				{
					level1 frame = new level1();
					frame.setVisible(true);
				}
			}
		});
		bt2.addMouseListener(new MouseAdapter(){ //�˳���ť�ļ���
			public void mousePressed(MouseEvent e)
			{
				dispose();//�رճ���
			}
		});
	}
}
