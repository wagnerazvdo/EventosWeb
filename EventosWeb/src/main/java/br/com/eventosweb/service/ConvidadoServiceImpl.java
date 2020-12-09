/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eventosweb.exception.EntidadeNãoEncontradaException;
import br.com.eventosweb.model.Convidado;
import br.com.eventosweb.repository.ConvidadoRepository;

/**
 * @author wagne
 *
 */

@Service
public class ConvidadoServiceImpl implements ConvidadoService{


	private ConvidadoRepository convidadoRepository;

	@Override
	@Transactional
	public Convidado salvar(Convidado convidado) {
		return this.convidadoRepository.save(convidado);
		
	}


	@Override
	public List<Convidado> listarConvidado() {
		return this.convidadoRepository.findAll();
	}

	
	@Override
	@Transactional
	public void removerConvidado(Convidado convidado) {
		this.convidadoRepository.delete(convidado);
		
	}

	
	@Override
	@Transactional
	public void removerPorId(int idConvidado) {
		this.convidadoRepository.deleteById(idConvidado);
		
	}

	
	@Override
	public Convidado buscarPorId(int idConvidado) {
		Optional<Convidado> convidado = this.convidadoRepository.findById(idConvidado);
		if(convidado.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o convidado pesquisado!");
		} else
		return convidado.get();
	}

}