package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.DataBase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class Bookedit extends JDialog {

	private JPanel contentPane;
	private JTextField Txt_tsh;
	private JTextField Txt_starttime;
	private JTextField Txt_endtime;
	private JTextField Txt_time;
	private JTextField Txt_datetime;
    private JLabel error;
    private String book_tsh=null;


	/**
	 * Create the frame.
	 */
	public Bookedit(Frame f,String _tsh) { 
		super(f,"书籍信息编辑",true);
		book_tsh=_tsh;
		setResizable(false);
		setTitle("信息编辑");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("图书号：");
		label.setFont(new Font("幼圆", Font.PLAIN, 20));
		label.setBounds(106, 82, 115, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("图书名：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		label_1.setBounds(466, 82, 104, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("作者：");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 20));
		label_2.setBounds(111, 177, 110, 18);
		contentPane.add(label_2);
		
		Txt_tsh = new JTextField();
		Txt_tsh.setBounds(212, 78, 172, 24);
		contentPane.add(Txt_tsh);
		Txt_tsh.setColumns(10);
		
		JLabel label_3 = new JLabel("出版时间：");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 20));
		label_3.setBounds(453, 177, 104, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("出版单位：");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 20));
		label_4.setBounds(106, 282, 103, 18);
		contentPane.add(label_4);
		
		Txt_starttime = new JTextField();
		Txt_starttime.setBounds(597, 78, 175, 24);
		contentPane.add(Txt_starttime);
		Txt_starttime.setColumns(10);
		
		Txt_endtime = new JTextField();
		Txt_endtime.setBounds(217, 176, 176, 24);
		contentPane.add(Txt_endtime);
		Txt_endtime.setColumns(10);
		
		Txt_time = new JTextField();
		Txt_time.setBounds(605, 176, 177, 24);
		contentPane.add(Txt_time);
		Txt_time.setColumns(10);
		
		Txt_datetime = new JTextField();
		Txt_datetime.setBounds(217, 281, 176, 24);
		contentPane.add(Txt_datetime);
		Txt_datetime.setColumns(10);
		
		JButton Btn_save = new JButton("确定");
		Btn_save.setFont(new Font("仿宋", Font.PLAIN, 15));
		Btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cph=Txt_tsh.getText();
				String start=Txt_starttime.getText();
				String end=Txt_endtime.getText();
				String time=Txt_time.getText();
				String money=Txt_datetime.getText();
				if(cph.equals(""))
				{
					error.setText("书号不能为空!");
					return;
				}
				if(start.equals(""))
				{
					error.setText("书名不能为空!");
					return;
				}
				if(end.equals(""))
				{
					error.setText("借书时间不能为空!");
					return;
				}
				if(time.equals(""))
				{
					error.setText("还书时间不能为空!");
					return;
				}
				if(money.equals(""))
				{
					error.setText("借书时长不能为空");
					return;
				}
				Connection conn=DataBase.getConnection();
				
				try {
					Statement smt=conn.createStatement();
					String sql="";
					if(book_tsh==null)
					{
						
					sql="insert into [BookManage](BookID,BookName,BorrowTime,ReturnTime,FinalTime) values(";
					sql+="'"+cph+"',";
					sql+="'"+start+"',";
					sql+="'"+end+"',";
					sql+="'"+time+"',";
					sql+="'"+money+"')";
					}
					else
					{
						sql="update [BookManage] set";
						
						sql+=" BookName='"+start+"',";
						sql+=" BorrowTime='"+end+"',";
						sql+=" ReturnTime='"+time+"',";
						sql+=" FinalTime='"+money+"'";
						
						sql+="  where BookID='"+cph+"'";
					}
					int num=smt.executeUpdate(sql);
					if(num>0)
					{
						dispose();
					}
					else
					{
						
					}
					smt.close();
					conn.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Btn_save.setBounds(559, 293, 79, 27);
		contentPane.add(Btn_save);
		this.dispose();
		JButton Btn_cancel = new JButton("取消");
		Btn_cancel.setFont(new Font("宋体", Font.PLAIN, 15));
		Btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Btn_cancel.setBounds(732, 293, 73, 27);
		contentPane.add(Btn_cancel);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setFont(new Font("华文楷体", Font.PLAIN, 20));
		error.setBounds(60, 462, 220, 18);
		contentPane.add(error);
		Init();
		setVisible(true);
	}
	private void Init()
	{
		   if(book_tsh==null) return;
		   Txt_tsh.setEditable(false);
		   Connection conn=DataBase.getConnection();
			
			try {
				Statement smt=conn.createStatement();
				String sql="select * from [BookManage]  where BookID='"+book_tsh+"'";
				
				ResultSet rs=smt.executeQuery(sql);

				if(rs.next())
				{
					Txt_tsh.setText(rs.getString("BookID"));
					Txt_starttime.setText(String.valueOf(rs.getString("BookName")));
					Txt_endtime.setText(String.valueOf(rs.getString("BorrowTime")));
					Txt_time.setText(rs.getString("ReturnTime"));
					Txt_datetime.setText(rs.getString("FinalTime"));
					
				
						
				}
		
				rs.close();
				smt.close();
				conn.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
	}
}
