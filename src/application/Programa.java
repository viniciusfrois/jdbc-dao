package application;

import models.Vendedor;
import models.dao.FabricaDAO;
import models.dao.VendedorDAO;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDao = FabricaDAO.criarVendedorDao();
		Vendedor vendedor = vendedorDao.buscarId(2);
		System.out.println(vendedor);
		

	}

}
