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

        /*
        perguntas.add(new Pergunta(
                "Qual destes animais sofre com a poluição dos oceanos?",
                Arrays.asList("Tartarugas marinhas", "Peixes", "Corais", "Todos"),
                3
        ));

        perguntas.add(new Pergunta(
                "Plantar árvores ajuda o planeta porque elas:",
                Arrays.asList("Produzem oxigênio e absorvem gás carbônico", "Produzem lixo", "Secam os rios"),
                0
        ));

        perguntas.add(new Pergunta(
                "Qual é a principal fonte de energia limpa e renovável?",
                Arrays.asList("Energia solar", "Queima de carvão", "Gasolina"),
                0
        ));

        perguntas.add(new Pergunta(
                "Qual das opções não é um material reciclável?",
                Arrays.asList("Pacote de bala", "Copo de plástico", "Casca de banana"),
                2
        ));

        perguntas.add(new Pergunta(
                "Para economizar energia, devemos:",
                Arrays.asList("Deixar a TV ligada sem ninguém assistindo", "Apagar as luzes quando não precisamos", "Tomar banhos longos e quentes"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que acontece se queimarmos muito lixo?",
                Arrays.asList("Ajuda a natureza", "Polui o ar com fumaça tóxica", "Deixa o clima mais fresco"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que devemos fazer com pilhas e baterias usadas?",
                Arrays.asList("Jogar no lixo comum", "Enterrar no quintal", "Levar para pontos de coleta especiais"),
                2
        ));

        perguntas.add(new Pergunta(
                "Qual gás em excesso causa o aquecimento global?",
                Arrays.asList("Oxigênio", "Gás carbônico (CO₂)", "Gás do riso"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que podemos fazer para usar menos plástico?",
                Arrays.asList("Usar sacolas reutilizáveis", "Usar canudos descartáveis", "Comprar garrafas de plástico todo dia"),
                0
        ));

        perguntas.add(new Pergunta(
                "Jogar lixo nos rios pode causar:",
                Arrays.asList("Água limpa", "Morte de peixes e poluição", "Aumento da pesca"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que é melhor para o planeta:",
                Arrays.asList("Andar de carro sozinho sempre", "Usar bicicleta, caminhar ou transporte público", "Deixar o carro ligado parado"),
                1
        ));

        perguntas.add(new Pergunta(
                "Por que devemos reduzir o uso de sacolas plásticas?",
                Arrays.asList("Porque ocupam espaço em casa", "Porque poluem e demoram muito para se decompor", "Porque não são bonitas"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que podemos fazer com roupas que não usamos mais?",
                Arrays.asList("Jogar no lixo", "Doar para outras pessoas", "Enterrar no quintal"),
                1
        ));

        perguntas.add(new Pergunta(
                "Qual dessas ações ajuda o planeta?",
                Arrays.asList("Economizar água ao escovar os dentes", "Deixar a torneira aberta sem motivo", "Lavar a calçada com mangueira"),
                0
        ));

        perguntas.add(new Pergunta(
                "Qual dessas ações ajuda a salvar árvores?",
                Arrays.asList("Imprimir tudo em papel", "Reciclar papel", "Jogar papel no rio"),
                1
        ));

        perguntas.add(new Pergunta(
                "O que é coleta seletiva?",
                Arrays.asList("Separação do lixo", "Jogar lixo no mato", "Queimar o lixo"),
                0
        ));

        perguntas.add(new Pergunta(
                "Economizar água é importante porque...",
                Arrays.asList("A água é infinita", "A água pode acabar", "A conta de luz aumenta"),
                1
        ));

        perguntas.add(new Pergunta(
                "Qual destes materiais pode ser reciclado?",
                Arrays.asList("Papel", "Comida", "Tecido sujo"),
                0
        ));

        perguntas.add(new Pergunta(
                "O que acontece quando desmatamos as florestas?",
                Arrays.asList("O clima melhora", "Animais perdem seus lares", "A terra fica mais fértil"),
                1
        ));

        perguntas.add(new Pergunta(
                "Como podemos ajudar o planeta na escola?",
                Arrays.asList("Jogando lixo no chão", "Separando o lixo", "Usando mais papel"),
                1
        ));*/

        final int[] pontos = {0};
        final int[] perguntaAtual = {0};

        // Cria o Runnable que exibe e atualiza as perguntas
        Runnable[] mostrarPergunta = new Runnable[1];

        mostrarPergunta[0] = () -> {
            panel.removeAll();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Box.createVerticalGlue());

            // Verifica se terminou o quiz
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
                resultado.setForeground(Color.BLACK);
                resultado.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(resultado);

                panel.add(Box.createRigidArea(new Dimension(0, 20)));
                botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(botaoSair);

                panel.add(Box.createVerticalGlue());
                panel.revalidate();
                panel.repaint();
                return;
            }

            // Exibe a pergunta atual
            Pergunta p = perguntas.get(perguntaAtual[0]);
            JLabel perguntaEnunciado = new JLabel(p.enunciado);
            perguntaEnunciado.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(perguntaEnunciado);

            panel.add(Box.createRigidArea(new Dimension(0, 20)));

            // Cria as alternativas
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
                    SwingUtilities.invokeLater(mostrarPergunta[0]);
                });

                grupoOpcoes.add(opcao);
                panel.add(opcao);
            }

            panel.add(Box.createVerticalGlue());
            panel.revalidate();
            panel.repaint();
        };
        SwingUtilities.invokeLater(mostrarPergunta[0]);
    }
}
        /*Runnable mostrarPergunta = new Runnable() {
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
                    resultado.setForeground(Color.BLACK);
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
                    resultado.setForeground(Color.BLACK);
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
        };*/