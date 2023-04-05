package edu.br.infnet.assessment.model.service;

import edu.br.infnet.assessment.model.domain.Endereco;

public interface ViaCepService {
    Endereco buscarEnderecoPorCep(String cep);
}

