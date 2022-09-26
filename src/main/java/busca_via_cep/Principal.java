package busca_via_cep;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Informe o CEP: ");
			final String cep = scanner.next();
			try {
				System.out.println("Aguarde... Buscando o endereço...");
				final Endereco endereco = EnderecoService.buscaEnderecoPorCep(cep);
				System.out.println("Pronto! Endereço retornado.");
				System.out.println("Logradouro.: " + endereco.getLogradouro());
				System.out.println("Complemento: " + endereco.getComplemento());
				System.out.println("Bairro.....: " + endereco.getBairro());
				System.out.println("Localidade.: " + endereco.getLocalidade());
				System.out.println("UF.........: " + endereco.getUf());
			} catch(Exception e) {
				System.out.println("Ocorreu um erro ao buscar o endereço.\n" + e.getMessage());
			}
		} finally {
			scanner.close();
		}
	}

}
