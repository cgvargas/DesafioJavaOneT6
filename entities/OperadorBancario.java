/**
 * Esta classe representa um operador bancário que gerencia informações de conta.
 * Pode ser usado para criar, manipular e consultar dados de conta bancária.
 */
package entities;


public class OperadorBancario {
    public String nome;
    public String tipoConta;
    public double saldo;

    /**
     * Construtor padrão da classe OperadorBancario.
     */
    public OperadorBancario() {
    }

    /**
     * Construtor da classe OperadorBancario.
     * @param nome O nome do cliente.
     * @param tipoConta O tipo de conta (Corrente ou Poupança).
     * @param saldo O saldo inicial da conta.
     */
    public OperadorBancario(String nome, String tipoConta, double saldo) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    // Métodos getter e setter...
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Realiza um depósito na conta bancária.
     * @param deposito O valor a ser depositado.
     */
    public void depositar(double deposito) {
        saldo += deposito;
    }

    /**
     * Realiza um saque na conta bancária.
     * @param saque O valor a ser sacado.
     */
    public void sacar(double saque) {
        saldo -= saque;
    }

    /**
     * Gera a impressão dos dados
     * da abertura de conta e da
     * consulta do saldo.
     */
    @Override
    public String toString() {
        return "\nExtrato " +
                "\n========================" +
                "\nNome: " + nome +
                "\nTipo de Conta: " + tipoConta +
                "\nSaldo: R$ " + String.format("%.2f", saldo) +
                "\n========================" +
                "\n ";

    }
}
