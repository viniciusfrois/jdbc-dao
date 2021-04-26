package application;

import java.util.List;
import java.util.Scanner;

import models.Departamento;
import models.dao.DepartamentoDAO;
import models.dao.FabricaDAO;

public class ProgramaDepartamento {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartamentoDAO departamentoDao = FabricaDAO.criarDepartamentoDao();

		System.out.println("=== TEST 1: Buscar por Id =======");
		Departamento dep = departamentoDao.buscarId(1);
		System.out.println(dep);

		System.out.println("=== TEST 2: Buscar Todos =======");
		List<Departamento> list = departamentoDao.buscarTodos();
		for (Departamento d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: Inserir =======");
		Departamento novoDepartamento = new Departamento(null, "Musica");
		departamentoDao.inserir(novoDepartamento);
		System.out.println("Inserido! Novo id: " + novoDepartamento.getId());

		System.out.println("\n=== TEST 4: Atualizar =======");
		Departamento dep2 = departamentoDao.buscarId(1);
		dep2.setNome("Comida");
		departamentoDao.atualizar(dep2);
		System.out.println("Atualizado com Sucesso!");

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Informe o ID para deletar: ");
		int id = sc.nextInt();
		departamentoDao.deletarById(id);
		System.out.println("Deletado com Sucesso!");

		sc.close();
	}

}
