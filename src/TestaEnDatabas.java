public class TestaEnDatabas {

    public static void main(String[] args) {

        QuestionDatabase test = new QuestionDatabase();

        System.out.println(test.getMusicQuestions().get(0).toString());

        System.out.println(test.getGameQuestions().get(0).toString());

        System.out.println(test.getMusicQuestions().get(1).toString());

        System.out.println(test.getMovieQuestions().size());

        System.out.println(test.getMovieQuestions().get(1).toString());



    }
}
