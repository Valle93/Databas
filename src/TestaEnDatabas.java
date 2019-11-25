public class TestaEnDatabas {

    public static void main(String[] args) {

        QuestionDatabase test = new QuestionDatabase();

        System.out.println(test.getMovieQuestions().get(0));
        System.out.println("\n");
        System.out.println(test.getMovieQuestions().get(1));
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        String äraraag = "tegöga";

        test.getGameQuestions().get(0).shuffleAnswers();
        test.getGameQuestions().get(1).shuffleAnswers();

        System.out.println(test.getGameQuestions().get(0));
        System.out.println("\n");
        System.out.println(test.getGameQuestions().get(1));

    }
}
