import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.util.*;
import java.util.List;

class Pergunta {
    String enunciado;
    List<String> alternativas; // Lista de alternativas possíveis
    int respostaCorreta;

    // Construtor da classe Pergunta
    public Pergunta(String enunciado, List<String> alternativas, int respostaCorreta) {
        this.enunciado = enunciado; // Inicializa o enunciado
        this.alternativas = alternativas; // Inicializa a lista de alternativas
        this.respostaCorreta = respostaCorreta; // Define qual é a alternativa correta
    }
}

public class Quiz {
    public static void iniciarQuiz() {
        int pontos = 0;
        // Cria uma lista de perguntas
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual destas atitudes ajuda a combater a poluição?",
                Arrays.asList("Jogar lixo no chão", "Reciclar garrafas plásticas", "Queimar pneus"),
                1 // "Reciclar garrafas plásticas" é a resposta correta (índice 1)
        ));

        perguntas.add(new Pergunta(
                "O que significa a palavra reciclar?",
                Arrays.asList("Jogar fora", "Enterrar o lixo", "Reaproveitar materiais"),
                1
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
        ));
*/

        // Laço que percorre todas as perguntas da lista
        // A cada volta no laço, ele pega um elemento da lista "perguntas" e o coloca na variável p do tipo "Pergunta".
        for (Pergunta p : perguntas) { // p representa cada objeto Pergunta da lista "perguntas"
            int resposta = JOptionPane.showOptionDialog(
                    null, // sem frame pai (dialog aparece no centro), se houvesse uma janela principal, o diálogo poderia ser associado a ela por meio de um parâmetro
                    p.enunciado, // texto da pergunta
                    "QUIZ DO MEIO AMBIENTE", // título da janela
                    JOptionPane.DEFAULT_OPTION, // vai exibir as opções padrão
                    JOptionPane.QUESTION_MESSAGE, // define o ícone da janela como, nesse caso "?"
                    null, // utiliza o ícone de QUESTION_MESSAGE se null ou coloca um ícone customizado
                    p.alternativas.toArray(), // converte lista para array para opções
                    null // opção padrão selecionada quando o diálogo abrir, nesse caso nenhuma alternativa pré-selecionada
            );

            // a resposta vai ser o índice clicado, ou −1 se a janela for fechada

            if (resposta == -1){
                JOptionPane.showMessageDialog(null, "Quiz cancelado");
                System.exit(0);
            }

            if (resposta == p.respostaCorreta){
                JOptionPane.showMessageDialog(null, "Correto!");
                pontos += 100;
            } else {
                JOptionPane.showMessageDialog(null, "Incorreto! A resposta correta é: " + p.alternativas.get(p.respostaCorreta));
                // p.alternativas.get(p.respostaCorreta) - pega a string da respostaCorreta
                // p.respostaCorreta - pega o índice da respostaCorreta
            }
        }
        String mensagemFinal = null;

        if (pontos <= 800){
            mensagemFinal = "Vamos aprender a cuidar melhor do planeta?";
        } else if (pontos > 800 && pontos < 2000) {
            mensagemFinal = "Você está chegando lá! O planeta agradece.";
        } else if (pontos > 2000) {
            mensagemFinal = "Você realmente sabe como cuidar do planeta! Parabéns!";
        }

//    public static JTextArea MostrarMensagemFinal(){
//        JTextArea pontuacaoEMensagemFinal = new JTextArea("Pontuação final: "/* + pontos + "!" + "\n" + mensagemFinal*/);
//        pontuacaoEMensagemFinal.setVisible(true);
//        return pontuacaoEMensagemFinal;
//    }

        JOptionPane.showMessageDialog(null, "Pontuação final: " + pontos + "!" + "\n" + mensagemFinal);
    }
}