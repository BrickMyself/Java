package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Mesginsert extends JFrame {

	private JPanel contentPane;
	private JTextField P_lpn;
	private JTextField P_starttime;
	private JTextField P_endtime;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Mesginsert() {
		setTitle("图书信息录入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("图书号：");
		label.setFont(new Font("华文楷体", Font.PLAIN, 25));
		label.setBounds(115, 117, 138, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("图书名称：");
		label_1.setFont(new Font("华文楷体", Font.PLAIN, 25));
		label_1.setBounds(115, 185, 136, 42);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("还书时间：");
		label_2.setFont(new Font("华文楷体", Font.PLAIN, 25));
		label_2.setBounds(115, 265, 132, 33);
		contentPane.add(label_2);
		
		P_lpn = new JTextField();
		P_lpn.setBounds(253, 129, 150, 24);
		contentPane.add(P_lpn);
		P_lpn.setColumns(10);
		
		P_starttime = new JTextField();
		P_starttime.setBounds(253, 198, 150, 24);
		contentPane.add(P_starttime);
		P_starttime.setColumns(10);
		
		P_endtime = new JTextField();
		P_endtime.setBounds(253, 273, 150, 24);
		contentPane.add(P_endtime);
		P_endtime.setColumns(10);
		
		JLabel label_3 = new JLabel("请输入：");
		label_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_3.setBounds(120, 49, 88, 30);
		contentPane.add(label_3);
		
		JButton But_save = new JButton("保存");
		But_save.setForeground(new Color(25, 25, 112));
		But_save.setFont(new Font("华文楷体", Font.PLAIN, 20));
		But_save.setBounds(116, 397, 113, 27);
		contentPane.add(But_save);
		
		JButton But_back = new JButton("返回");
		But_back.setForeground(new Color(25, 25, 112));
		But_back.setFont(new Font("华文楷体", Font.PLAIN, 20));
		But_back.setBounds(317, 399, 113, 27);
		contentPane.add(But_back);
		setVisible(true);
	}

}
