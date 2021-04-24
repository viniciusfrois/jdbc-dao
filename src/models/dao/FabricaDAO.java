package models.dao;

import models.dao.implemento.VendedorDaoJDBC;

public class FabricaDAO {
	
	public static VendedorDAO criarVendedorDao () {
		return new VendedorDaoJDBC();
	}

}
