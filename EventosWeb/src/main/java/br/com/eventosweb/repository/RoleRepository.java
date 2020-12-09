/**
 * 
 */
package br.com.eventosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eventosweb.model.Role;

/**
 * @author wagne
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

