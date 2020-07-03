package com.chinaedu.taoku.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinaedu.taoku.dao.ProductDao;
import com.chinaedu.taoku.pojo.Product;

/**
 * Servlet implementation class ProductDetail
 */
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//��ȡ��ƷID
		String id = request.getParameter("id");
		//ȥ��ѯ���ݿ�
		ProductDao dao = new ProductDao();
		
		Product p = dao.findProductByPk(Integer.parseInt(id));
		
		//�����ݷ����������У�Ŀ���ǽ����ݴ��뵽ҳ����ȥ
		request.setAttribute("p", p);
		
		//��תҳ��
		request.getRequestDispatcher("product_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
