package models.dao;

import java.util.List;
import models.Departamento;

public interface DepartamentoDAO {

	void inserir (Departamento obj);
	void atualizar (Departamento obj);
	void deletarById (Integer id);
	Departamento buscarId (Integer id);
	List <Departamento> buscarTodos ();
	
}
