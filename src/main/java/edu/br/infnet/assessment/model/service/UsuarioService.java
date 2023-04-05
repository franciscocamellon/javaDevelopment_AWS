package edu.br.infnet.assessment.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.infnet.assessment.model.domain.Usuario;
import edu.br.infnet.assessment.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		
		this.usuarioRepository = usuarioRepository;
		
	}

	public Usuario addUser(Usuario usuario) {
        
        usuarioRepository.save(usuario);
        
        return usuario;
	}
	
	public void removeUser(Long key) {
		
		usuarioRepository.deleteById(key);
		
	}
	
	public List<Usuario> getUserList() {
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	public Optional<Usuario> getUserById(Long id) {
		
		return usuarioRepository.findById(id);
		
	}

}
