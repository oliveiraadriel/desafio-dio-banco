import java.util.List;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);

    }

    @Override
    public void imprimirExtrato() {
        super.infosComuns();
    }

    @Override
    public double consultarSaldo() {
        return agencia;

    }

    @Override
    public void pagarConta(double valor, String codigoBarras) {
        //
    }

    @Override
    public void configurarLimiteSaqueDiario(double limite) {
        //
    }

    @Override
    public void configurarLimiteTransferenciaDiario(double limite) {
        //
    }

    @Override
    public List<String> consultarHistoricoTransacoes() {
        return historicoTransacoes;

    }

    @Override
    public void removerBeneficiario(String nome) {
        //
        throw new UnsupportedOperationException("Unimplemented method 'removerBeneficiario'");
    }

    @Override
    public List<String> consultarBeneficiarios() {
        return historicoTransacoes;

    }

    @Override
    public void solicitarEmprestimo(double valor) {
        //
        throw new UnsupportedOperationException("Unimplemented method 'solicitarEmprestimo'");
    }

    @Override
    public double consultarSaldoDevedorEmprestimo() {
        //
        throw new UnsupportedOperationException("Unimplemented method 'consultarSaldoDevedorEmprestimo'");
    }

    @Override
    public void configurarNotificacoesTransacoes(boolean habilitar) {
        //
        throw new UnsupportedOperationException("Unimplemented method 'configurarNotificacoesTransacoes'");
    }

    @Override
    public double consultarLimiteSaqueDiario() {
        //
        throw new UnsupportedOperationException("Unimplemented method 'consultarLimiteSaqueDiario'");
    }

    @Override
    public double consultarLimiteTransferenciaDiario() {
        //
        throw new UnsupportedOperationException("Unimplemented method 'consultarLimiteTransferenciaDiario'");
    }

}
