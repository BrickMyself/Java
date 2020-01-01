package com.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Mainview extends JFrame {

	private JPanel contentPane;
	


	/**
	 * Create the frame.
	 */
	public Mainview() {
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dispose();
		JButton U_exit = new JButton("退出登录");
		U_exit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				int option=JOptionPane.showConfirmDialog(null, "是否退出登录？","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null);
				if(option!=JOptionPane.OK_OPTION)	
				return;
				dispose();
			}
		});
		U_exit.setFont(new Font("幼圆", Font.PLAIN, 15));
		U_exit.setForeground(new Color(255, 0, 0));
		U_exit.setBounds(832, 23, 107, 27);
		contentPane.add(U_exit);
		
		JButton P_display = new JButton("点击进入图书管理");
		P_display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bookseekview view=new Bookseekview();
			}
		});
		P_display.setForeground(Color.BLACK);
		P_display.setFont(new Font("幼圆", Font.PLAIN, 20));
		P_display.setBounds(-14, 172, 939, 61);
		contentPane.add(P_display);
		setVisible(true);
	}

}

