package com.chinaedu.taoku.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinaedu.taoku.dao.ProductDao;
import com.chinaedu.taoku.pojo.Product;

/**
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		ProductDao dao  = new ProductDao();
		//������Ʒ������Ϣ
		Product product = dao.findProductByPk(Integer.parseInt(id));
		//���ﳵ
		HttpSession session = req.getSession();
		//ÿ�ζ�ȥsession��ȥ�ù��ﳵ������ǵ�һ���ã���ô���ﳵ�϶���null�ģ�����ǵڶ����ã����ﳵ�϶��Ƿǿյ�
		List<Product> cart = (List) session.getAttribute("cart");
		//��һ��
		if(cart==null) {
			cart = new ArrayList<Product>();
			//�����ﳵ���뵽session��
			session.setAttribute("cart", cart);			
		}
		
		//����Ʒ���뵽���ﳵ��
		cart.add(product);
		
		//ת���ɹ�ҳ��
		req.setAttribute("msg", "���ѳɹ�����Ʒ���빺�ﳵ��");
		req.setAttribute("p", product);
		req.getRequestDispatcher("info.jsp").forward(req, resp);		
		
		
	}
	

}
