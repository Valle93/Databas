public class TestaEnDatabas {

    public static void main(String[] args) {

        QuestionDatabase test = new QuestionDatabase();

        System.out.println(test.getMovieQuestions().get(0));
        System.out.println("\n");
        System.out.println(test.getMovieQuestions().get(1));

    }
}
