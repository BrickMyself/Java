package com.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.DataBase;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Bookseekview extends JFrame {

	private JPanel contentPane;
	private JTextField Sel_keyword1;
	private JTable TabParklist;
	private  String tsh=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookseekview frame = new Bookseekview();
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
	public Bookseekview() {
		setTitle("图书信息列表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton Btn_delete = new JButton("删除");
		panel.add(Btn_delete);
		Btn_delete.setForeground(Color.RED);
		
		JButton Btn_edit = new JButton("编辑");
		panel.add(Btn_edit);
		Btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tsh!=null)
				{
					Bookedit stu=new Bookedit(null,tsh);
					BindData();
					tsh=null;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请选择需要编辑的信息","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		Btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tsh!=null)
				{
					
					int option=JOptionPane.showConfirmDialog(null, "确定删除？","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null);
					if(option!=JOptionPane.OK_OPTION)
						
					return;
					Connection conn=DataBase.getConnection();
					
					try {
						Statement smt=conn.createStatement();
						String sql="delete  from [BookManage]  where BookID='"+tsh+"'";
						int num=smt.executeUpdate(sql);
						if(num>0)
						{
							BindData();tsh=null;
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
					
				else
				{
					JOptionPane.showMessageDialog(null, "请选择需要删除的信息","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
						
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel label_2 = new JLabel("图书号：");
		panel_1.add(label_2);
		
		Sel_keyword1 = new JTextField();
		panel_1.add(Sel_keyword1);
		Sel_keyword1.setColumns(10);
		
		JButton Btn_Query = new JButton("查询");
		panel_1.add(Btn_Query);
		Btn_Query.setForeground(Color.DARK_GRAY);
		Btn_Query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BindData();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		TabParklist = new JTable();
		TabParklist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index=TabParklist.getSelectedRow();
				if(index>-1)
				{
					tsh=(String)TabParklist.getValueAt(index, 0);
				}
			}
		});
		TabParklist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TabParklist.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"书号", "书名 " ,"作者", "出版时间", "出版单位",
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(TabParklist);
		
		JButton Btn_add = new JButton("添加");
		scrollPane.setRowHeaderView(Btn_add);
		Btn_add.setForeground(Color.DARK_GRAY);
		Btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bookedit stu=new Bookedit(null,null);
				BindData();
			}
		});
		BindData();
		
		setVisible(true); 
		
	}

	private void BindData()
	{
		String keyword1=Sel_keyword1.getText().trim();
		Connection conn=DataBase.getConnection();
		
		try {
			Statement smt=conn.createStatement();
			String sql="select * from [BookManage] ";
			if(keyword1.length()>0)
			{
				sql+="where  BookID like '%"+keyword1+"%'";
				
				
			}
			
			
			
			ResultSet rs=smt.executeQuery(sql);
			DefaultTableModel mode=(DefaultTableModel)TabParklist.getModel();
			mode.setRowCount(0);
			while(rs.next())
			{
				String[] parkInfo={
						rs.getString("BookID"),
						String.valueOf(rs.getString("BookName")),
						String.valueOf(rs.getString("BorrowTime")),
						rs.getString("ReturnTime"),
						rs.getString("FinalTime"),
				};
				mode.addRow(parkInfo);
					
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
	
	

