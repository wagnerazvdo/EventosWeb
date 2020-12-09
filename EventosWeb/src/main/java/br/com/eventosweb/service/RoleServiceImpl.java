/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eventosweb.model.Role;
import br.com.eventosweb.repository.RoleRepository;

/**
 * @author wagne
 *
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public Role salvar(Role role) {
		return this.roleRepository.save(role);
	}

	@Override
	public List<Role> listarRole() {
		return this.roleRepository.findAll();
	}
	@Override
	@Transactional
	public void remover(Role role) {
		this.roleRepository.delete(role);
	}

	@Override
	public Role buscarPorId(Integer idRole) {
		return this.roleRepository.findById(idRole).get();
	}

	@Override
	public void removerRole(Role buscarPorId) {
		// TODO Auto-generated method stub
		
	}



}
