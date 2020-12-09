/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Endereco;

/**
 * @author wagne
 *
 */
public interface EnderecoService {

	Endereco salvar(Endereco endereco);
	List<Endereco> listarEndereco();
	void remover(Endereco endereco);
	Endereco buscarPorId(Integer idEndereco);
	void removerEndereco(Endereco buscarPorId);

}
