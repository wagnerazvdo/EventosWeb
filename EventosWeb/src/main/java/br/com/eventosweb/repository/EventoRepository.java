/**
 * 
 */
package br.com.eventosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eventosweb.model.Evento;

/**
 * @author wagne
 *
 */
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
