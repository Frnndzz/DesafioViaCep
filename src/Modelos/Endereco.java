package Modelos;

public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private int ibge;
    private int gia;
    private int ddd;
    private int siafi;

    public Endereco(EnderecoViaCep e) {
        this.cep = e.cep();
        this.logradouro = e.logradouro();
        this.complemento = e.complemento();
        this.bairro = e.bairro();
        this.localidade = e.localidade();
        this.uf = e.uf();
        this.ibge = Integer.parseInt(e.ibge());
        this.gia = Integer.parseInt(e.ibge());
        this.ddd = Integer.parseInt(e.ddd());
        this.siafi = Integer.parseInt(e.siafi());
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge=" + ibge +
                ", gia=" + gia +
                ", ddd=" + ddd +
                ", siafi=" + siafi +
                '}';
    }
}
