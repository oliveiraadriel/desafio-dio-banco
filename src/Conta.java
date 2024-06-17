import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IiConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private double limiteSaqueDiario;
    private double limiteTransferenciaDiario;
    private boolean contaBloqueada;
    private double saldoDevedorEmprestimo;
    private boolean notificacoesHabilitadas;
    List<String> historicoTransacoes;
    private List<Beneficiario> beneficiarios;

    protected Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
        this.beneficiarios = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (contaBloqueada) {
            System.out.println("A conta está bloqueada. Não é possível realizar saques.");
            return;
        }
        if (valor > limiteSaqueDiario) {
            System.out.println("O valor excede o limite de saque diário.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            registrarTransacao("Saque: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao("Depósito: " + valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (contaBloqueada) {
            System.out.println("A conta está bloqueada. Não é possível realizar transferências.");
            return;
        }
        if (valor > limiteTransferenciaDiario) {
            System.out.println("O valor excede o limite de transferência diário.");
            return;
        }
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            registrarTransacao("Transferência para conta " + contaDestino.numero + ": " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void imprimirExtrato() {
        infosComuns();
        System.out.println("Histórico de Transações: " + historicoTransacoes);
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void pagarConta(double valor, String codigoBarras) {
        if (contaBloqueada) {
            System.out.println("A conta está bloqueada. Não é possível pagar contas.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            registrarTransacao("Pagamento de conta: " + codigoBarras + " - Valor: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void configurarLimiteSaqueDiario(double limite) {
        this.limiteSaqueDiario = limite;
    }

    @Override
    public void configurarLimiteTransferenciaDiario(double limite) {
        this.limiteTransferenciaDiario = limite;
    }

    @Override
    public void bloquearConta() {
        this.contaBloqueada = true;
    }

    @Override
    public void desbloquearConta() {
        this.contaBloqueada = false;
    }

    @Override
    public List<String> consultarHistoricoTransacoes() {
        return cliente.consultarHistoricoTransacoes(this);
    }

    @Override
    public void adicionarBeneficiario(String nome, Conta conta) {
        beneficiarios.add(new Beneficiario(nome, conta));
    }

    @Override
    public void removerBeneficiario(String nome) {
        beneficiarios.removeIf(beneficiario -> beneficiario.getNome().equals(nome));
    }

    @Override
    public List<String> consultarBeneficiarios() {
        List<String> listaBeneficiarios = new ArrayList<>();
        for (Beneficiario beneficiario : beneficiarios) {
            listaBeneficiarios.add(beneficiario.getNome());
        }
        return listaBeneficiarios;
    }

    @Override
    public void solicitarEmprestimo(double valor) {
        saldo += valor;
        saldoDevedorEmprestimo += valor;
        registrarTransacao("Empréstimo solicitado: " + valor);
    }

    @Override
    public double consultarSaldoDevedorEmprestimo() {
        return saldoDevedorEmprestimo;
    }

    @Override
    public void configurarNotificacoesTransacoes(boolean habilitar) {
        this.notificacoesHabilitadas = habilitar;
    }

    @Override
    public double consultarLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    @Override
    public double consultarLimiteTransferenciaDiario() {
        return limiteTransferenciaDiario;
    }

    private void registrarTransacao(String descricao) {
        historicoTransacoes.add(descricao);
        if (notificacoesHabilitadas) {
            System.out.println("Notificação: " + descricao);
        }
    }

    protected void infosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    // Classe interna para representar um beneficiário
    private static class Beneficiario {
        private String nome;
        private Conta conta;

        public Beneficiario(String nome, Conta conta) {
            this.nome = nome;
            this.conta = conta;
        }

        public String getNome() {
            return nome;
        }

        @SuppressWarnings("unused")
        public Conta getConta() {
            return conta;
        }
    }
}
