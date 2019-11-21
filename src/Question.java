public class Question {

    String question;
    Answer[] answers;

    public Question(String question, Answer[] answers){

        this.question = question;
        this.answers = answers;
        this.answers[0].setisCorrect(true);
    }

    public String toString(){

        String frågaOchAlternativ = this.getQuestion() + "\n";

        for (int i = 0; i < 4; i++) {

            frågaOchAlternativ += this.getAnswers()[i].getClaim() + "\n";
        }

        return frågaOchAlternativ;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
