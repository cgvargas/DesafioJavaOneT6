/**
 * Esta classe representa a aplicação principal do sistema bancário CGVBank.
 * Permite aos usuários abrir uma conta bancária, visualizar informações da conta
 * e realizar operações como depósito, saque e consulta de saldo.
 * Também conta com segurança de transação de saque e depósito.
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

        String tipoConta = JOptionPane.showInputDialog(null, "Conta Corrente ou Poupança:");
        if (tipoConta == null) { // Se o usuário clicou em "Cancelar"
            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
            System.exit(0); // Encerrar o programa
        }
        ob.setTipoConta(tipoConta);

        String saldoStr = JOptionPane.showInputDialog(null, "Valor do depósito:");
        if (saldoStr == null) { // Se o usuário clicou em "Cancelar"
            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
            System.exit(0); // Encerrar o programa
        }
        ob.setSaldo(Double.parseDouble(saldoStr));


        // Exibir informações da conta
        JOptionPane.showMessageDialog(null, ob);

        // Chamar o menu passando o objeto OperadorBancario
        Menu menu = new Menu(ob);
        menu.exibirMenu();
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


