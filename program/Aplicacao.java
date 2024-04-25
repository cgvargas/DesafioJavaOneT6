/**
 * Esta classe representa a aplicação principal do sistema bancário CGVBank.
 * Permite aos usuários abrir uma conta bancária, visualizar informações da conta
 * e realizar operações como depósito, saque e consulta de saldo.
 */
package program;

import entities.Menu;
import entities.OperadorBancario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.net.URL;

public class Aplicacao {

    /**
     * Método principal que inicia a aplicação.
     * @param args Os argumentos da linha de comando (não utilizado).
     */
    public static void main(String[] args) {
        // Criar objeto OperadorBancario
        OperadorBancario ob = new OperadorBancario();

        // Exibir imagem
        exibirImagem();

        JOptionPane.showMessageDialog(null, "Abertura de conta");

        // Obter dados do usuário
        String nomeCliente = JOptionPane.showInputDialog(null, "Nome do cliente:");
        if (nomeCliente == null) { // Se o usuário clicou em "Cancelar"
            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
            System.exit(0); // Encerrar o programa
        }
        ob.setNome(nomeCliente);

        String tipoConta = escolherTipoConta();
        if (tipoConta == null) {
            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
            System.exit(0);
        }
        ob.setTipoConta(tipoConta);

        String saldoStr;
        double saldo = 0.0;
        boolean valorValido = false;
        do {
            saldoStr = JOptionPane.showInputDialog(null, "Valor do depósito:");
            if (saldoStr == null) { // Se o usuário clicou em "Cancelar"
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                System.exit(0);
            }
            // Substituir vírgulas por pontos na string antes de converter para double
            saldoStr = saldoStr.replace(',', '.');
            try {
                saldo = Double.parseDouble(saldoStr);
                valorValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número válido.");
            }
        } while (!valorValido);
        ob.setSaldo(saldo);

        JOptionPane.showMessageDialog(null, ob);

        Menu menu = new Menu(ob);
        menu.exibirMenu();
    }

    private static String escolherTipoConta() {
        String[] opcoesConta = {"Corrente", "Poupança", "Investimento"};
        return (String) JOptionPane.showInputDialog(
                null,
                "Escolha o tipo de conta:",
                "Seleção de Tipo de Conta",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesConta,
                opcoesConta[0]
        );
    }

    /**
     * Método para exibir a imagem do logo do banco.
     */
    private static void exibirImagem() {
        // Carregar a imagem
        URL imageUrl = Aplicacao.class.getResource("CGVBank.png");
        ImageIcon icon = new ImageIcon(imageUrl);

        // Exibir a imagem em um JOptionPane
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(null, label, "CGVBank of Brazil", JOptionPane.PLAIN_MESSAGE);
    }
}


