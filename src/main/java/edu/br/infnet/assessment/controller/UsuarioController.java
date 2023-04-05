package edu.br.infnet.assessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.br.infnet.assessment.model.domain.Endereco;
import edu.br.infnet.assessment.model.domain.Usuario;
import edu.br.infnet.assessment.model.service.EnderecoService;
import edu.br.infnet.assessment.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    private final EnderecoService enderecoService;

    public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService) {
		this.usuarioService = usuarioService;
		this.enderecoService = enderecoService;
	}
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
    	
    	Endereco endereco = enderecoService.buscarEnderecoPorCep(usuario.getCep());
    	
    	usuario.setLogradouro(endereco.getLogradouro());
    	usuario.setBairro(endereco.getBairro());
    	usuario.setLocalidade(endereco.getLocalidade());
    	usuario.setUf(endereco.getUf());
    	
    	Usuario novoUsuario = usuarioService.addUser(usuario);
    	
    	return new ResponseEntity<>(novoUsuario, null, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getAll() {
    	
    	return ResponseEntity.ok(usuarioService.getUserList());
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    	
    	usuarioService.removeUser(id);
    	
    	return ResponseEntity.ok().build();
    	
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuarioPorId(@PathVariable Long id) {
    	return usuarioService.getUserById(id);
    }

}

