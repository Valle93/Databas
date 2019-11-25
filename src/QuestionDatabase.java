import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class QuestionDatabase {


    private ArrayList[] genres;
    private ArrayList<Question> movieQuestions;
    private ArrayList<Question> musicQuestions;
    private ArrayList<Question> gameQuestions;
    private ArrayList<Question> javaQuestions;

    public QuestionDatabase(){

        this.genres = new ArrayList[4];

        this.movieQuestions = new ArrayList<>();
        this.musicQuestions = new ArrayList<>();
        this.gameQuestions = new ArrayList<>();
        this.javaQuestions = new ArrayList<>();

        this.genres[0] = this.musicQuestions;
        this.genres[1] = this.movieQuestions;
        this.genres[2] = this.gameQuestions;
        this.genres[3] = this.javaQuestions;

        Path[] paths = new Path[4];
        paths[0] = Paths.get("src\\musicQuestions.txt");
        paths[1] = Paths.get("src\\movieQuestions.txt");
        paths[2] = Paths.get("src\\gameQuestions.txt");
        paths[3] = Paths.get("src\\javaQuestions.txt");

        for (int i = 0; i < paths.length; i++) {

            try(BufferedReader br = Files.newBufferedReader(paths[i], Charset.forName("ISO-8859-1"))){

                String tempString;

                while((tempString = br.readLine()) != null){

                    String question = tempString;

                    String[] answers = new String[4];
                    for (int j = 0; j < 4; j++) {
                        answers[j] = br.readLine();
                    }

                    Question questionObject = new Question(question,answers);

                    this.genres[i].add(questionObject);

                }

            }catch(IOException io){
                io.printStackTrace();
            }
        }

    }

    public ArrayList<Question> getMovieQuestions() {
        return movieQuestions;
    }

    public void setMovieQuestions(ArrayList<Question> movieQuestions) {
        this.movieQuestions = movieQuestions;
    }

    public ArrayList<Question> getMusicQuestions() {
        return musicQuestions;
    }

    public void setMusicQuestions(ArrayList<Question> musicQuestions) {
        this.musicQuestions = musicQuestions;
    }

    public ArrayList<Question> getGameQuestions() {
        return gameQuestions;
    }

    public void setGameQuestions(ArrayList<Question> gameQuestions) {
        this.gameQuestions = gameQuestions;
    }

    public ArrayList[] getGenres() {
        return genres;
    }

    public void setGenres(ArrayList[] genres) {
        this.genres = genres;
    }


}
