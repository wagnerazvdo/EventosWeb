/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Usuario;

/**
 * @author wagne
 *
 */
public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	List<Usuario> listarUsuario();
	void remover(Usuario usuario);
	Usuario buscarPorId(Integer idUsuario);
	void removerUsuario(Usuario buscarPorId);

}
