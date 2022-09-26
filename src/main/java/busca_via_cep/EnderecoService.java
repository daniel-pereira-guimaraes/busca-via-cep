package busca_via_cep;

import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EnderecoService {
	
	static final String URL_WEB_SERVICE = "https://viacep.com.br/ws/";
	static final int CODIGO_SUCESSO = 200;
	
	public static Endereco buscaEnderecoPorCep(String cep) throws Exception {
		final URL url = new URL(URL_WEB_SERVICE + cep + "/json");
		final HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
		try {
			if (conexao.getResponseCode() != CODIGO_SUCESSO)
				throw new Exception(conexao.getResponseCode() + ": " + conexao.getResponseMessage());
			final ObjectMapper om = new ObjectMapper();
			return om.readValue(conexao.getInputStream(), Endereco.class);
		} finally {
			conexao.disconnect();
		}
	}

}
