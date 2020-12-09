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

import br.com.eventosweb.model.Endereco;
import br.com.eventosweb.service.EnderecoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/enderecos/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping("/v1")
	public Endereco Salvarv1(@RequestBody Endereco endereco) {
		this.enderecoService.salvar(endereco);
		return endereco;
	}
	
	@ApiOperation(
			value="Cadastrar um endereco novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do endereco.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> salvarv2(@RequestBody Endereco endereco) {
		return ResponseEntity.ok().body(this.enderecoService.salvar(endereco));
	}
	
	@GetMapping("/v1")
	public List<Endereco> Listar(){
		return this.enderecoService.listarEndereco();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> Listarv2() {
		return ResponseEntity.ok().body(this.enderecoService.listarEndereco());
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.enderecoService.removerEndereco(this.enderecoService.buscarPorId(id));
		return "endereco informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Endereco> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.enderecoService.buscarPorId(id));	
	}

 	@PutMapping("/{id}")
	public Endereco buscarConvidadoId(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
 		Endereco enderecoBD = this.enderecoService.buscarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoBD, "id");
		this.enderecoService.salvar(enderecoBD);
		return enderecoBD;
	}


}
