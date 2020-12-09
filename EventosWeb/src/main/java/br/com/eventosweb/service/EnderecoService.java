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

	Endereco buscarPorId(Integer id);

	void removerEndereco(Object buscarPorId);

	void removerEndereco(Endereco endereco);

	void removerPorId(int idEndereco);

	Endereco buscarPorId(int idEndereco);

}
