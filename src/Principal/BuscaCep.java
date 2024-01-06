package Principal;

import Modelos.Endereco;
import Modelos.EnderecoViaCep;
import Modelos.UsaJson;
import Modelos.Requisicao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaCep {

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        UsaJson usaJson = new UsaJson();
        while (true) {

            System.out.println("\nDigite um cep para ser pesquisado(apenas números) ou 'sair' para " +
                    "encerrar o programa: ");
            String cep = entrada.nextLine();

            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            if (cep.equalsIgnoreCase("sair"))
                break;

            if (cep.length() != 8){
                System.out.println("\nO número digitado nao possui 8 dígitos!");
                continue;
            }

            try {
                String json = Requisicao.requisita(url);

                if (usaJson.testaErro(json))
                    continue;

                System.out.println(url);
                System.out.println(json);


                EnderecoViaCep meuEnderecoViaCep = usaJson.deJson(json);
                System.out.println(meuEnderecoViaCep+"\n");

                Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
                System.out.println("Endereço convertido:");
                System.out.println(meuEndereco);

                enderecos.add(meuEndereco);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        UsaJson geraArquivo = new UsaJson();
        geraArquivo.salvaJson(enderecos);

        System.out.println("Programa finalizado!");
    }


}
