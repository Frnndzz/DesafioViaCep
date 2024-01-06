package Modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UsaJson {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void salvaJson(List<Endereco> enderecos) throws IOException {
        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();

        if (!enderecos.isEmpty())
            System.out.println("\nEndereços salvos com sucesso!\n");
    }

    public boolean testaErro(String json) {
        if (json.equalsIgnoreCase("{\n" +
                "  \"erro\": true\n" +
                "}")) {
            System.out.println("\nO cep digitado não existe!");
            return true;
        }
        return false;
    }

    public EnderecoViaCep deJson(String json) {
        return gson.fromJson(json, EnderecoViaCep.class);
    }
}
