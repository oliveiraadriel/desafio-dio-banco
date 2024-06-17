import java.util.List;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(Cliente cliente) {
    super(cliente);

  }

  @Override
  public void imprimirExtrato() {
    System.out.println("===Extato Conta poupanca===");
    super.infosComuns();
  }

  @Override
  public double consultarSaldo() {
    //
    throw new UnsupportedOperationException("Unimplemented method 'consultarSaldo'");
  }

  @Override
  public void pagarConta(double valor, String codigoBarras) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'pagarConta'");
  }

  @Override
  public void configurarLimiteSaqueDiario(double limite) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'configurarLimiteSaqueDiario'");
  }

  @Override
  public void configurarLimiteTransferenciaDiario(double limite) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'configurarLimiteTransferenciaDiario'");
  }

  @Override
  public void bloquearConta() {
    //
    throw new UnsupportedOperationException("Unimplemented method 'bloquearConta'");
  }

  @Override
  public void desbloquearConta() {
    //
    throw new UnsupportedOperationException("Unimplemented method 'desbloquearConta'");
  }

  @Override
  public List<String> consultarHistoricoTransacoes() {
    //
    throw new UnsupportedOperationException("Unimplemented method 'consultarHistoricoTransacoes'");
  }

  @Override
  public void adicionarBeneficiario(String nome, Conta conta) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'adicionarBeneficiario'");
  }

  @Override
  public void removerBeneficiario(String nome) {
    //
    throw new UnsupportedOperationException("Unimplemented method 'removerBeneficiario'");
  }

  @Override
  public List<String> consultarBeneficiarios() {
    //
    throw new UnsupportedOperationException("Unimplemented method 'consultarBeneficiarios'");
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
