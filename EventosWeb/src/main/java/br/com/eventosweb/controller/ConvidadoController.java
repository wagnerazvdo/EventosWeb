/**
 * 
 */
package br.com.eventosweb.controller;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.eventosweb.model.Convidado;
import br.com.eventosweb.service.ConvidadoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/convidados/api")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService convidadoService;
	
	@PostMapping("/v1")
	public Convidado Salvarv1(@RequestBody Convidado convidado) {
		this.convidadoService.salvar(convidado);
		return convidado;
	}
	
	@ApiOperation(
			value="Cadastrar um Convidado novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Convidado.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Convidado> salvarv2(@RequestBody Convidado convidado) {
		return ResponseEntity.ok().body(this.convidadoService.salvar(convidado));
	}
	
	@GetMapping("/v1")
	public List<Convidado> Listar(){
		return this.convidadoService.listarConvidado();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Convidado>> Listarv2() {
		return ResponseEntity.ok().body(this.convidadoService.listarConvidado());
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.convidadoService.removerConvidado(this.convidadoService.buscarPorId(id));
		return "Convidado informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Convidado> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.convidadoService.buscarPorId(id));	
	}

 	@PutMapping("/{id}")
	public Convidado buscarConvidadoId(@PathVariable("id") Integer id, @RequestBody Convidado convidado) {
		Convidado convidadoBD = this.convidadoService.buscarPorId(id);
		BeanUtils.copyProperties(convidado, convidadoBD, "id");
		this.convidadoService.salvar(convidadoBD);
		return convidadoBD;
	}


}
