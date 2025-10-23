import javax.swing.*;
import java.awt.*;

// Classe principal que contém o metodo main
public class MenuInicial {
    public static void main(String[] args){
        JFrame frame = new JFrame("Aplicativo em tela cheia"); // criação do frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false); // remove bordas e barra de título
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximiza o frame horizontal e verticalmente (tela cheia)

        JPanel panel = new JPanel(); // criação do painel principal
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridBagLayout()); // define o gerenciador de layout como um GridBagLayout
        // GridBagLayout organiza os componentes em grade de linhas e colunas

        GridBagConstraints configBotoes = Utils.criarConfigBotoes(0); // chama o metodo criado para armazenar a variável configBotoes

        JButton botaoIniciar = new JButton("INICIAR");
        JButton botaoSair = new JButton("SAIR");
        Utils.configuracaoBotao(botaoIniciar, () -> Quiz.iniciarQuiz(panel, botaoSair)); // Chama o metodo Utils e os parâmetros botaoIniciar, runnable de Utils e leva o panel para Quiz
        panel.add(botaoIniciar, configBotoes); // adiciona o botão "INICIAR" ao painel

        configBotoes.gridy = 1;
        Utils.configuracaoBotao(botaoSair, () -> System.exit(0));
        panel.add(botaoSair, configBotoes); // adiciona o botão "SAIR" ao painel

        frame.add(panel); // adiciona o painel ao frame
        frame.setVisible(true); // torna o frame visível
    }
}