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

	Usuario buscarPorId(Integer id);

	void removerUsuario(Usuario buscarPorId);

	void removerPorId(int idUsuario);

	Usuario buscarPorId(int idUsuario);

}
