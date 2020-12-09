/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eventosweb.model.Usuario;
import br.com.eventosweb.repository.UsuarioRepository;

/**
 * @author wagne
 *
 */

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
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
	public void remover(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		return this.usuarioRepository.findById(idUsuario).get();
	}

	@Override
	public void removerUsuario(Usuario buscarPorId) {
		// TODO Auto-generated method stub
		
	}



}