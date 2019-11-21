import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class QuestionDatabase {


    private ArrayList[] genrer;
    private ArrayList<Question> FilmFrågor;
    private ArrayList<Question> MusikFrågor;
    private ArrayList<Question> SpelFrågor;

    public QuestionDatabase(){

        this.genrer = new ArrayList[3];

        this.FilmFrågor = new ArrayList<>();
        this.MusikFrågor = new ArrayList<>();
        this.SpelFrågor = new ArrayList<>();

        this.genrer[0] = this.FilmFrågor;
        this.genrer[1] = this.MusikFrågor;
        this.genrer[2] = this.SpelFrågor;

    ArrayList[] listOfArrayQuestions = new ArrayList[3];

    listOfArrayQuestions[0] = this.FilmFrågor;
    listOfArrayQuestions[1] = this.MusikFrågor;
    listOfArrayQuestions[2] = this.SpelFrågor;

        Path[] paths = new Path[3];
        paths[0] = Paths.get("src\\FilmFrågor.txt");
        paths[1] = Paths.get("src\\MusikFrågor.txt");
        paths[2] = Paths.get("src\\SpelFrågor.txt");


        for (int i = 0; i < 3; i++) {

            try(BufferedReader br = Files.newBufferedReader(paths[i])){

                String tempString;

                while((tempString = br.readLine()) != null){

                    String question = tempString;

                    Answer[] answers = new Answer[4];
                    for (int j = 0; j < 4; j++) {
                        answers[j] = new Answer(br.readLine());
                    }

                    Question questionObject = new Question(question,answers);

                    this.genrer[i].add(questionObject);

                }

            }catch(IOException io){
                io.printStackTrace();
            }
        }

    }

    public ArrayList<Question> getFilmFrågor() {
        return FilmFrågor;
    }

    public void setFilmFrågor(ArrayList<Question> filmFrågor) {
        FilmFrågor = filmFrågor;
    }

    public ArrayList<Question> getMusikFrågor() {
        return MusikFrågor;
    }

    public void setMusikFrågor(ArrayList<Question> musikFrågor) {
        MusikFrågor = musikFrågor;
    }

    public ArrayList<Question> getSpelFrågor() {
        return SpelFrågor;
    }

    public void setSpelFrågor(ArrayList<Question> spelFrågor) {
        SpelFrågor = spelFrågor;
    }

    public ArrayList[] getGenrer() {
        return genrer;
    }

    public void setGenrer(ArrayList[] genrer) {
        this.genrer = genrer;
    }


}
