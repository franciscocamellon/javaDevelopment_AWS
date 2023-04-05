package edu.br.infnet.assessment.model.service;

import edu.br.infnet.assessment.model.domain.Endereco;

public interface EnderecoService {
	
	Endereco buscarEnderecoPorCep(String cep);

}
