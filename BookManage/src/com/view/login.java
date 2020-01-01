package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.DataBase;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class login extends JFrame {
	
	private JPanel contentPane;
	private JTextField User_name;
	private JPasswordField User_pwd;
	private JLabel Lab_error;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setType(Type.UTILITY);
		setResizable(false);
		setForeground(Color.RED);
		setTitle("登录系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("系统登录");
		label.setForeground(new Color(0, 0, 128));
		label.setBackground(Color.DARK_GRAY);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.PLAIN, 30));
		label.setBounds(332, 13, 224, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("账号：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		label_1.setBounds(225, 134, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("密  码：");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		label_2.setBounds(225, 233, 72, 18);
		contentPane.add(label_2);
		
		User_name = new JTextField();
		User_name.setBounds(366, 131, 190, 24);
		contentPane.add(User_name);
		User_name.setColumns(10);
		
		User_pwd = new JPasswordField();
		User_pwd.setBounds(367, 230, 189, 24);
		contentPane.add(User_pwd);
		
		JButton Login =  new JButton("登录");
		Login.setFont(new Font("幼圆", Font.PLAIN, 15));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = User_name.getText();
				String userPwd = User_pwd.getText();
				Connection conn=DataBase.getConnection();
				
				try {
					Statement smt=conn.createStatement();
					String sql="select * from [Managers] where ManagerID='"+userName+"' and ManagerPassword='"+userPwd+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next())
					{
						Mainview win =new Mainview();
					}
					else 
					{
						Lab_error.setText("用户名或密码错误！");
					}
					rs.close();
					smt.close();
					conn.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					Lab_error.setText("用户名或密码错误！");
					e1.printStackTrace();
				}
				
			}
		});
		Login.setBounds(225, 346, 72, 27);
		contentPane.add(Login);
		this.dispose();
		JButton reset = new JButton("取消");
		reset.setFont(new Font("幼圆", Font.PLAIN, 15));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login log=new login();
			}
		});
		reset.setBounds(593, 346, 72, 27);
		contentPane.add(reset);
		
		Lab_error = new JLabel("");
		Lab_error.setFont(new Font("华文楷体", Font.PLAIN, 20));
		Lab_error.setForeground(new Color(255, 0, 0));
		Lab_error.setBounds(159, 226, 174, 18);
		contentPane.add(Lab_error);	
		setVisible(true);
	}
}
