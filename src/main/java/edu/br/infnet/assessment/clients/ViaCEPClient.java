package edu.br.infnet.assessment.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.br.infnet.assessment.model.domain.Endereco;

@Service
public class ViaCEPClient {

	private final RestTemplate restTemplate = new RestTemplate();

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco buscarEnderecoPorCep(String cep) {
        ResponseEntity<Endereco> response = restTemplate.getForEntity(VIA_CEP_URL, Endereco.class, cep);
        return response.getBody();
    }
}