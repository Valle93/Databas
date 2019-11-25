public class Question {


    String question;
    String[] answers;
    String correctAnswer;

    public Question(String question, String[] answers){

        this.question = question;
        this.answers = answers;
        this.correctAnswer = answers[0];
    }

    public String toString(){

        String questionAndAlternatives = this.getQuestion() + "\n";

        for (int i = 0; i < 4; i++) {

            questionAndAlternatives += this.getAnswers()[i] + "\n";
        }

        return questionAndAlternatives;

    }

    public void shuffleAnswers(){

        String[] shuffled = this.getAnswers();

        String tempAnswer;

        for (int i = 0; i < 100; i++) {

            byte randomOne = (byte)(Math.random()*3);

            System.out.println(randomOne);

            tempAnswer = shuffled[randomOne];

            byte randomTwo = (byte)(Math.round(Math.random()*3));

            System.out.println(randomTwo);

            shuffled[randomOne] = shuffled[randomTwo];

            shuffled[randomTwo] = tempAnswer;

        }

        this.setAnswers(shuffled);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() { return correctAnswer; }

    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
}
