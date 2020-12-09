/**
 * 
 */
package br.com.eventosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eventosweb.model.Convidado;

/**
 * @author wagne
 *
 */
@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Integer>{

}
