package application;

import java.util.List;

import models.Departamento;
import models.Vendedor;
import models.dao.FabricaDAO;
import models.dao.VendedorDAO;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDao = FabricaDAO.criarVendedorDao();
		
		System.out.println("=====TEST 1: Buscar vendedor por ID =====");
		Vendedor vendedor = vendedorDao.buscarId(2);
		System.out.println(vendedor);
		
		System.out.println("=====TEST 2: Buscar vendedor por Departamento =====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.buscarDepartamento(departamento);
		for (Vendedor vend : lista) {
			System.out.println(vend);
		}
		
		System.out.println("=====TEST 3: Buscar Todos Vendedores =====");
		lista = vendedorDao.buscarTodos();
		for (Vendedor vend : lista) {
			System.out.println(vend);
		}

	}

}
