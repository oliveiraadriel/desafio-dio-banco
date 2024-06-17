import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> consultarHistoricoTransacoes(Conta conta) {
        return new ArrayList<>(conta.historicoTransacoes);
    }

}