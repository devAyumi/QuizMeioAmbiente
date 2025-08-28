import javax.swing.*;

// Classe principal que contém o metodo main
public class MenuInicial {
    public static void main(String[] args){
        String[] opcoes = {"INICIAR", "SAIR"};
        int opcaoMenu = JOptionPane.showOptionDialog(
                null,
                null,
                "QUIZ DO MEIO AMBIENTE",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (opcaoMenu == 0){
            Quiz.iniciarQuiz();
        } else {
            System.exit(0);
        }
    }
}