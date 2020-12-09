package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Convidado;

public interface ConvidadoService {

	Convidado salvar(Convidado convidado);
	List<Convidado> listarConvidado();
	void remover(Convidado convidado);
	Convidado buscarPorId(Integer idConvidado);
	void removerConvidado(Convidado buscarPorId);

}
