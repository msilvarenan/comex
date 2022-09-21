package br.com.alura.comex.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.comex.Status;
import br.com.alura.comex.data.orm.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

	List<Cliente> findByStatus(Status status);

	List<Cliente> findByNome(String nome);
	
}
