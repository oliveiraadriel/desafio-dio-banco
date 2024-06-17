public class Main {
    public static void main(String[] args) {
        Cliente nemo = new Cliente();

        nemo.setNome("Nemo");

        Conta cc = new ContaCorrente(nemo);

        Conta poupanca = new ContaPoupanca(nemo);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
