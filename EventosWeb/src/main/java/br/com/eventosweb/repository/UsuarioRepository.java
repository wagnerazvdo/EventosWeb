/**
 * 
 */
package br.com.eventosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eventosweb.model.Usuario;

/**
 * @author wagne
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
