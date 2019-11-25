package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    public static void readProperties() {


        Path p = Paths.get("src\\sample\\Properties.txt");

        try (BufferedReader br = Files.newBufferedReader(p)) {
            br.readLine();
            Main.name = br.readLine();
            br.readLine(); br.readLine();
            Main.rounds = Integer.parseInt(br.readLine());
            br.readLine(); br.readLine();
            Main.questionsPerRound = Integer.parseInt(br.readLine());

        } catch (IOException io) {

            io.printStackTrace();
        }

    }

        public static void writeToProperties(
                String name, String rounds, String questionsPerRound
        ) {

            Path p = Paths.get("src\\sample\\Properties.txt");

            try (BufferedWriter bw = Files.newBufferedWriter(p)) {

                bw.write("Player Name:");
                bw.newLine();
                bw.write(name);
                bw.newLine(); bw.newLine();
                bw.write("Rounds:");
                bw.newLine();
                bw.write(rounds);
                bw.newLine(); bw.newLine();
                bw.write("Questions Per Round:");
                bw.newLine();
                bw.write(questionsPerRound);

            } catch (IOException io) {

                io.printStackTrace();
            }

    }

}

