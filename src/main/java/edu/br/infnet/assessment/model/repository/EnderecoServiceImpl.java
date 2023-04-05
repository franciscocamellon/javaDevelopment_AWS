package edu.br.infnet.assessment.model.repository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.br.infnet.assessment.model.domain.Endereco;
import edu.br.infnet.assessment.model.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private static final String URL = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    public EnderecoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Endereco buscarEnderecoPorCep(String cep) {
        String url = URL + cep + "/json";
        return restTemplate.getForObject(url, Endereco.class);
    }
}

