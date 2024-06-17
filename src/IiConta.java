import java.util.List;

public interface IiConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

    double consultarSaldo();

    void pagarConta(double valor, String codigoBarras);

    void configurarLimiteSaqueDiario(double limite);

    void configurarLimiteTransferenciaDiario(double limite);

    void bloquearConta();

    void desbloquearConta();

    List<String> consultarHistoricoTransacoes();

    void adicionarBeneficiario(String nome, Conta conta);

    void removerBeneficiario(String nome);

    List<String> consultarBeneficiarios();

    void solicitarEmprestimo(double valor);

    double consultarSaldoDevedorEmprestimo();

    void configurarNotificacoesTransacoes(boolean habilitar);

    double consultarLimiteSaqueDiario();

    double consultarLimiteTransferenciaDiario();
}
