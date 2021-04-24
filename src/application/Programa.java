package application;

import java.util.Date;
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
		
		System.out.println("=====TEST 4: Inserir um novo Vendedor =====");
		Vendedor novoVendedor = new Vendedor (null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(novoVendedor);
		System.out.println("Cadastrado com Sucesso! novo ID = " + novoVendedor.getId());
		
		System.out.println("=====TEST 5: Atualziar um Vendedor =====");
		vendedor = vendedorDao.buscarId(1);
		vendedor.setNome("Martha Waine");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualizado com Sucesso!");
		
		
		
		
		}
	
		

}
