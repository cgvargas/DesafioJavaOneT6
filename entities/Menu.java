/**
 * Esta classe representa o menu de operações bancárias.
 * Permite que os usuários realizem operações como consulta, depósito, saque, etc.
 */
package entities;

import javax.swing.JOptionPane;

public class Menu {
    private OperadorBancario ob;

    /**
     * Construtor da classe Menu.
     * @param ob O operador bancário associado ao menu.
     */
    public Menu(OperadorBancario ob) {
        this.ob = ob;
    }

    /**
     * Exibe o menu de operações bancárias e permite que os usuários realizem operações.
     */
    public void exibirMenu() {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao CGVBank!");

        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Consultar", "Depositar", "Sacar", "Sair"},
                    "Sair");

            switch (opcao) {
                case 0: // Consultar
                    JOptionPane.showMessageDialog(null, ob);
                    break;
                case 1: // Depositar
                    double valorDeposito;
                    String valorDepositoStr;
                    do {
                        valorDepositoStr = JOptionPane.showInputDialog("Valor a depositar:");
                        if (valorDepositoStr == null) { // Se o usuário clicou em "Cancelar"
                            opcao = JOptionPane.DEFAULT_OPTION;
                            break;
                        }
                        // Substituir vírgulas por pontos na string antes de converter para double
                        valorDepositoStr = valorDepositoStr.replace(',', '.');
                        try {
                            valorDeposito = Double.parseDouble(valorDepositoStr);
                            if (valorDeposito > 0) {
                                ob.depositar(valorDeposito);
                                JOptionPane.showMessageDialog(null, ob);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Valor inválido. Digite um valor positivo.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número válido.");
                        }
                    } while (true);
                    break;
                case 2: // Sacar
                double valorSaque;
                String valorSaqueStr;
                do {
                    valorSaqueStr = JOptionPane.showInputDialog("Valor a sacar:");
                    if (valorSaqueStr == null) { // Se o usuário clicou em "Cancelar"
                        opcao = JOptionPane.DEFAULT_OPTION;
                        break;
                    }
                    // Substituir vírgulas por pontos na string antes de converter para double
                    valorSaqueStr = valorSaqueStr.replace(',', '.');
                    try {
                        valorSaque = Double.parseDouble(valorSaqueStr);
                        if (valorSaque > 0 && valorSaque <= ob.getSaldo()) {
                            ob.sacar(valorSaque);
                            JOptionPane.showMessageDialog(null, ob);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Valor inválido ou saldo insuficiente.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número válido.");
                    }
                } while (true);
                break;
            case 3: // Sair
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                break;
            default: // Cancelar (Voltar à janela de opções)
                opcao = JOptionPane.DEFAULT_OPTION;
                break;
            }
        } while (opcao != 3); // Sair apenas quando a opção for "Sair"
    }
}


