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
		//查找商品相信信息
		Product product = dao.findProductByPk(Integer.parseInt(id));
		//购物车
		HttpSession session = req.getSession();
		//每次都去session中去拿购物车，如果是第一次拿，那么购物车肯定是null的，如果是第二次拿，购物车肯定是非空的
		List<Product> cart = (List) session.getAttribute("cart");
		//第一次
		if(cart==null) {
			cart = new ArrayList<Product>();
			//将购物车放入到session中
			session.setAttribute("cart", cart);			
		}
		
		//将商品放入到购物车中
		cart.add(product);
		
		//转到成功页面
		req.setAttribute("msg", "您已成功将商品加入购物车！");
		req.setAttribute("p", product);
		req.getRequestDispatcher("info.jsp").forward(req, resp);		
		
		
	}
	

}
