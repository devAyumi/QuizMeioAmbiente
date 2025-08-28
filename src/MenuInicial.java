import javax.swing.*;
import java.awt.*;

// Classe principal que contém o método main
public class MenuInicial {
    public static void main(String[] args){
        JFrame frame = new JFrame("Aplicativo em tela cheia"); // criação do frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true); // remove bordas e barra de título
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximiza o frame horizontal e verticalmente (tela cheia)

        JPanel panel = new JPanel(); // criação do painel principal
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridBagLayout()); // define o gerenciador de layout como um GridBagLayout
        // GridBagLayout organiza os componentes em grade de linhas e colunas

        GridBagConstraints configBotoes = new GridBagConstraints();

        configBotoes.gridy = 0;
        configBotoes.anchor = GridBagConstraints.CENTER; // posição dentro da célula
        configBotoes.insets = new Insets(10,10,10,10); // margens

        JButton botaoIniciar = new JButton("INICIAR");
        Utils.configuracaoBotao(botaoIniciar, () -> Quiz.iniciarQuiz()); // Chama o método Utils e os parâmetros botaoIniciar e o runnable de Utils
        panel.add(botaoIniciar, configBotoes); // adiciona o botão "INICIAR" ao painel

        configBotoes.gridy = 1;
        JButton botaoSair = new JButton("SAIR");
        Utils.configuracaoBotao(botaoSair, () -> System.exit(0));
        panel.add(botaoSair, configBotoes); // adiciona o botão "SAIR" ao painel

        frame.add(panel); // adiciona o painel ao frame
        frame.setVisible(true); // torna o frame visível
    }
}