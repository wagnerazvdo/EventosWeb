/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eventosweb.exception.EntidadeNãoEncontradaException;
import br.com.eventosweb.model.Endereco;
import br.com.eventosweb.repository.EnderecoRepository;

/**
 * @author wagne
 *
 */
@Service
public class EnderecoServiceImpl implements EnderecoService{

	private EnderecoRepository enderecoRepository;

	@Override
	@Transactional
	public Endereco salvar(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
		
	}


	@Override
	public List<Endereco> listarEndereco() {
		return this.enderecoRepository.findAll();
	}

	
	
	@Override
	@Transactional
	public void removerEndereco(Endereco endereco) {
		this.enderecoRepository.delete(endereco);
		
	}

	
	
	@Override
	@Transactional
	public void removerPorId(int idEndereco) {
		this.enderecoRepository.deleteById(idEndereco);
		
	}

	
	
	@Override
	public Endereco buscarPorId(int idEndereco) {
		Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);
		if(endereco.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o Endereco pesquisado!");
		} else
		return endereco.get();
	}



	@Override
	public Endereco buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removerEndereco(Object buscarPorId) {
		// TODO Auto-generated method stub
		
	}

}