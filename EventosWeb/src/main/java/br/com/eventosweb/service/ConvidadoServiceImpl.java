/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eventosweb.model.Convidado;
import br.com.eventosweb.repository.ConvidadoRepository;

/**
 * @author wagne
 *
 */
@Service
public class ConvidadoServiceImpl implements ConvidadoService{

	@Autowired
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
	public void remover(Convidado convidado) {
		this.convidadoRepository.delete(convidado);
	}

	@Override
	public Convidado buscarPorId(Integer idConvidado) {
		return this.convidadoRepository.findById(idConvidado).get();
	}

	@Override
	public void removerConvidado(Convidado buscarPorId) {
		// TODO Auto-generated method stub
		
	}



}
