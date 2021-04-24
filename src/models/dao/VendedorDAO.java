package models.dao;

import java.util.List;
import models.Departamento;
import models.Vendedor;

public interface VendedorDAO {
	
	void inserir (Vendedor obj);
	void atualizar (Vendedor obj);
	void deletarById (Vendedor obj);
	Vendedor buscarId (Integer id);
	List <Vendedor> buscarTodos ();
	List <Vendedor> buscarDepartamento (Departamento departamento);
	

}
