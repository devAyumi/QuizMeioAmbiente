import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Pergunta {
    String enunciado;
    List<String> alternativas;
    int respostaCorreta;

    public Pergunta(String enunciado, List<String> alternativas, int respostaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }
}

public class Quiz extends JFrame {
    public static void iniciarQuiz(JPanel panel, JButton botaoSair) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        // Layout BoxLayout vertical
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual destas atitudes ajuda a combater a poluição?",
                Arrays.asList("Jogar lixo no chão", "Reciclar garrafas plásticas", "Queimar pneus"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que significa a palavra reciclar?",
                Arrays.asList("Jogar fora", "Enterrar o lixo", "Reaproveitar materiais"),
                2
        ));

        perguntas.add(new Pergunta(
                "O que acontece quando jogamos óleo de cozinha na pia?",
                Arrays.asList("Nada acontece", "Pode poluir a água e o solo", "Limpa os canos"),
                1
        ));

        final int[] pontos = {0};
        final int[] perguntaAtual = {0};

        Runnable mostrarPergunta = new Runnable() {
            @Override
            public void run() {
                panel.removeAll();

                // Glue antes do conteúdo para centralizar verticalmente
                panel.add(Box.createVerticalGlue());

                if (perguntaAtual[0] >= perguntas.size()) {
                    String mensagemFinal;
                    if (pontos[0] <= 800) {
                        mensagemFinal = "Vamos aprender a cuidar melhor do planeta?";
                    } else if (pontos[0] < 2000) {
                        mensagemFinal = "Você está chegando lá! O planeta agradece.";
                    } else {
                        mensagemFinal = "Você realmente sabe como cuidar do planeta! Parabéns!";
                    }

                    JLabel resultado = new JLabel("Pontuação final: " + pontos[0] + " — " + mensagemFinal);
                    resultado.setFont(new Font("Arial", Font.BOLD, 16));
                    resultado.setForeground(Color.BLUE);
                    resultado.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(resultado);



                    // Glue depois do conteúdo para centralizar verticalmente
                    panel.add(Box.createVerticalGlue());

                    panel.revalidate();
                    panel.repaint();
                    return;
                }

                Pergunta p = perguntas.get(perguntaAtual[0]);

                JLabel perguntaEnunciado = new JLabel(p.enunciado);
                perguntaEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
                perguntaEnunciado.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(perguntaEnunciado);

                panel.add(Box.createRigidArea(new Dimension(0, 20)));

                ButtonGroup grupoOpcoes = new ButtonGroup();

                for (int i = 0; i < p.alternativas.size(); i++) {
                    String textoAlternativa = p.alternativas.get(i);
                    JRadioButton opcao = new JRadioButton(textoAlternativa);
                    opcao.setBackground(Color.GRAY);
                    opcao.setAlignmentX(Component.CENTER_ALIGNMENT);
                    int indiceOpcao = i;

                    opcao.addActionListener(e -> {
                        if (indiceOpcao == p.respostaCorreta) {
                            pontos[0] += 100;
                        }
                        perguntaAtual[0]++;
                        // Atualiza a próxima pergunta referenciando o Runnable correto
                        SwingUtilities.invokeLater(this);  // THIS é o ActionListener, errado!
                    });

                    grupoOpcoes.add(opcao);
                    panel.add(opcao);
                }

                // Glue depois do conteúdo para centralizar verticalmente
                panel.add(Box.createVerticalGlue());

                panel.revalidate();
                panel.repaint();
            }
        };

        // Corrigir o uso do 'this' dentro do ActionListener:
        // Para isso, precisamos modificar a criação dos botões para usar a referência externa 'mostrarPergunta'.

        // Vamos criar uma versão corrigida do Runnable que funcione com o ActionListener

        // Vou modificar a lógica para capturar o Runnable antes e usar dentro do listener:
        final Runnable atualizarPergunta = mostrarPergunta;

        mostrarPergunta = new Runnable() {
            @Override
            public void run() {
                panel.removeAll();

                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.add(Box.createVerticalGlue());

                if (perguntaAtual[0] >= perguntas.size()) {
                    String mensagemFinal;
                    if (pontos[0] <= 800) {
                        mensagemFinal = "Vamos aprender a cuidar melhor do planeta?";
                    } else if (pontos[0] < 2000) {
                        mensagemFinal = "Você está chegando lá! O planeta agradece.";
                    } else {
                        mensagemFinal = "Você realmente sabe como cuidar do planeta! Parabéns!";
                    }

                    JLabel resultado = new JLabel("Pontuação final: " + pontos[0] + " — " + mensagemFinal);
                    resultado.setFont(new Font("Arial", Font.BOLD, 16));
                    resultado.setForeground(Color.BLUE);
                    resultado.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(resultado);

                    panel.add(Box.createRigidArea(new Dimension(0, 20)));
                    botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(botaoSair); // adiciona o botão Sair aqui no final do quiz

                    panel.add(Box.createVerticalGlue());
                    panel.revalidate();
                    panel.repaint();
                    return;
                }

                Pergunta p = perguntas.get(perguntaAtual[0]);

                JLabel perguntaEnunciado = new JLabel(p.enunciado);
                perguntaEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
                perguntaEnunciado.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(perguntaEnunciado);

                panel.add(Box.createRigidArea(new Dimension(0, 20)));

                ButtonGroup grupoOpcoes = new ButtonGroup();

                for (int i = 0; i < p.alternativas.size(); i++) {
                    String textoAlternativa = p.alternativas.get(i);
                    JRadioButton opcao = new JRadioButton(textoAlternativa);
                    opcao.setAlignmentX(Component.CENTER_ALIGNMENT);
                    opcao.setBackground(Color.GRAY);
                    int indiceOpcao = i;

                    opcao.addActionListener(e -> {
                        if (indiceOpcao == p.respostaCorreta) {
                            pontos[0] += 100;
                        }
                        perguntaAtual[0]++;
                        SwingUtilities.invokeLater(atualizarPergunta);
                    });

                    grupoOpcoes.add(opcao);
                    panel.add(opcao);
                }

                panel.add(Box.createVerticalGlue());

                panel.revalidate();
                panel.repaint();
            }
        };

        SwingUtilities.invokeLater(mostrarPergunta);
    }
}