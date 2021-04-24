package models.dao;

import db.DBConnect;
import models.dao.implemento.VendedorDaoJDBC;

public class FabricaDAO {
	
	public static VendedorDAO criarVendedorDao () {
		return new VendedorDaoJDBC(DBConnect.getConnection());
	}

}
