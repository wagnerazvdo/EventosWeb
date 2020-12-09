/**
 * 
 */
package br.com.eventosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.eventosweb.model.Endereco;

/**
 * @author wagne
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
