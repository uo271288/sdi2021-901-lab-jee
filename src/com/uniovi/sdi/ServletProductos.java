package com.uniovi.sdi;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/productos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProductos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Producto> productosTienda = new ProductosService().getProductos();
		String producto = request.getParameter("producto");

		if (producto != null) {
			eliminarProducto(productosTienda, producto);
		}
		request.setAttribute("productosTienda", productosTienda);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void eliminarProducto(List<Producto> productosTienda, String claveProducto) {
		Producto productoABorrar = null;
		for (Producto producto : productosTienda) {
			if (producto.getNombre().equals(claveProducto))
				productoABorrar = producto;
		}
		productosTienda.remove(productoABorrar);
	}
}
