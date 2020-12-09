/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eventosweb.exception.EntidadeNãoEncontradaException;
import br.com.eventosweb.model.Role;
import br.com.eventosweb.repository.RoleRepository;

/**
 * @author wagne
 *
 */
@Service
public class RoleServiceImpl implements RoleService{


	private RoleRepository RoleRepository;

	@Override
	@Transactional
	public Role save(Role role) {
		return this.RoleRepository.save(role);
		
	}


	@Override
	public List<Role> listarRole() {
		return this.RoleRepository.findAll();
	}

	@Override
	@Transactional
	public void removerRole(Role role) {
		this.RoleRepository.delete(role);
		
	}

	
	@Override
	@Transactional
	public void removerPorId(int idRole) {
		this.RoleRepository.deleteById(idRole);
		
	}

	

	public Role buscarPorId(int idRole) {
		Optional<Role> role = this.RoleRepository.findById(idRole);
		if(role.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o Role pesquisado!");
		} else
		return role.get();
	}


	
	@Override
	public void salvar(Role role) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Role buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removerRole(Object buscarPorId) {
		// TODO Auto-generated method stub
		
	}

}
