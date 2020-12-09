/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eventosweb.exception.EntidadeNãoEncontradaException;
import br.com.eventosweb.model.Usuario;
import br.com.eventosweb.repository.UsuarioRepository;

/**
 * @author wagne
 *
 */

@Service
public class UsuarioServiceImpl implements UsuarioService{


	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
		
	}


	@Override
	public List<Usuario> listarUsuario() {
		return this.usuarioRepository.findAll();
	}

	
	@Override
	@Transactional
	public void removerUsuario(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
		
	}

	
	
	@Override
	@Transactional
	public void removerPorId(int idUsuario) {
		this.usuarioRepository.deleteById(idUsuario);
		
	}

	
	
	@Override
	public Usuario buscarPorId(int idUsuario) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
		if(usuario.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o Usuario pesquisado!");
		} else
		return usuario.get();
	}




	@Override
	public Usuario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}