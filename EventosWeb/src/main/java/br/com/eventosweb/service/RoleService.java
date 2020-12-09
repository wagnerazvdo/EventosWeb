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


	List<Role> listarRole();

	Role buscarPorId(Integer id);

	void removerRole(Object buscarPorId);

	void removerRole(Role role);

	void removerPorId(int idRole);

	Role buscarPorId(int idRole);

	Role save(Role role);

	void salvar(Role role);

}
