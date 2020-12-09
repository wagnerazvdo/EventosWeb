/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Role;

/**
 * @author wagne
 *
 */
public interface RoleService {
	
	Role salvar(Role role);
	List<Role> listarRole();
	void remover(Role role);
	Role buscarPorId(Integer idRole);
	void removerRole(Role buscarPorId);

}
