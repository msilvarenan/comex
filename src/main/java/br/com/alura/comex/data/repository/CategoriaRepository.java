package br.com.alura.comex.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.comex.StatusCategoria;
import br.com.alura.comex.data.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {

	List<Categoria> findByStatus(StatusCategoria status);
	
	@Query("SELECT c FROM Categoria c ORDER BY c.nome ASC")
	List<Categoria> listaTodas();
	
}
