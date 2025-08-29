import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Utils {
    public static void configuracaoBotao(JButton botao, Runnable acao) {
        Font fonteOriginal = new Font("Arial", Font.PLAIN, 20); // cria uma variável de fonte

        botao.setBackground(Color.GRAY); // pega a background do panel em MenuInicial
        botao.setFocusPainted(false); // remove o contorno de foco ao clicar
        botao.setBorderPainted(false); // remove a borda
        botao.setContentAreaFilled(false); // remove o preenchimento
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // deixa o cursor em formato de mão ao passar por cima
        botao.setFont(fonteOriginal); // define a fonte como a variável

        if (acao != null){ // verifica se alguma ação foi passada
            botao.addActionListener(e -> acao.run()); // acao é um parâmetro do tipo Runnable -> bloco de código que pode ser executado com run()
        } // oq for runnable será executado se acao não for null

        botao.addMouseListener(new MouseAdapter() { // estilo quando mouse passa por cima
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setFont(new Font("Arial", Font.BOLD, 20));
            }
        });
        botao.addMouseListener(new MouseAdapter() { // estilo quando mouse sai de cima
            @Override
            public void mouseExited(MouseEvent e) {
                botao.setFont(fonteOriginal);
            }
        });
    }

    public static GridBagConstraints criarConfigBotoes(int gridy){ // como configBotoes era uma variável local, foi criado um método que transmitisse a variável para o Main
        GridBagConstraints configBotoes = new GridBagConstraints();

        configBotoes.gridy = gridy;
        configBotoes.anchor = GridBagConstraints.CENTER; // posição dentro da célula
        configBotoes.insets = new Insets(10,10,10,10); // margens
        return configBotoes;
    }
}