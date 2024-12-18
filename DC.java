import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class DC {
    public static void main(String[] args) throws IOException {
        try {

            boolean running = true;
            while (running) {
                String chossing = JOptionPane.showInputDialog(null, "Salam. Oyuna xoş gəlmisiniz.Seçimlər\n" +
                        "1-Çoxlu oyunçu əlavə et\n" +
                        "2-Əvvəlki oyunçularla oyna\n" +
                        "3-Oyunçu əlavə et\n" +
                        "4-Yeni oyunçularla oyna\n" +
                        "5-Oyundan çıx\n" +
                        "6-Oyunçuları sıfırla");
                switch (chossing) {
                    case "1":
                        manyaddplayer();
                        break;
                    case "2":
                        playoldplayer();
                        break;
                    case "3":
                        oneaddplayer();
                        break;
                    case "4":
                        playnewplayer();
                        break;
                    case "5":
                        changeoldfile();
                        JOptionPane.showMessageDialog(null, "Sən çıxdın");
                        running = false;
                        break;
                    case "6":
                        resetplayer();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Belə seçim yoxdur");
                        break;
                }
            }
        } catch (NullPointerException e) {
            changeoldfile();

        }
    }

    public static void manyaddplayer() {
        int playerlength;
        try {
            playerlength = Integer.parseInt(JOptionPane.showInputDialog(null, "Oyunçuların sayını gir:"));

            for (int i = 1; i <= playerlength; i++) {
                while (true) {
                    String playername = JOptionPane.showInputDialog(null, i + "-ci oyunçunun adını gir:");
                    if (playername.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Player adı boş ola bilməz");
                    } else {
                        boolean d = noreplayplayer(playername);
                        if (d) {
                            Players.players.add(playername + "\n");
                            break;
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nəsə səhv gedir");
        }

    }

    public static void playoldplayer() throws IOException {
        String a = "";
        FileReader fileReader = new FileReader("C:\\Users\\Acer\\IdeaProjects\\CodeJava\\DC\\src\\players.txt");
        int data = fileReader.read();
        while (data != -1) {
            a += (char) data;
            data = fileReader.read();
        }
        fileReader.close();
        String[] playerssplit = a.split("-");
        System.out.println(playerssplit);
        if (playerssplit.length == 1) {
            JOptionPane.showMessageDialog(null, "Oyunçu yoxdur.");
        } else {
            for (String player : playerssplit) {
                Players.playersnow.add(player.trim());
            }
            new StartGame();

        }

    }

    public static void oneaddplayer() {
        while (true) {
            String name = JOptionPane.showInputDialog(null, "Oyunçu adı daxil et");
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Oyunçu adı boş ola bilməz");
            } else {
                boolean f = noreplayplayer(name);
                if (f) {
                    Players.players.add(name + '\n');
                    break;
                }
            }
        }
    }

    public static void playnewplayer() throws IOException {
        if (Players.players.size() != 0) {
            for (String i : Players.players) {
                Players.playersnow.add(i.trim());
            }
            changeoldfile();
            new StartGame();
        } else {
            JOptionPane.showMessageDialog(null, "Oyunçu yoxdur.");
        }


    }

    public static void changeoldfile() throws IOException {
        String a = "";
        for (int i = 0; i < Players.playersnow.size(); i++) {
            if (i != Players.playersnow.size() - 1) {
                System.out.println("k");
                a += Players.playersnow.get(i) + "-\n";
            } else {
                System.out.println("a");
                a += Players.playersnow.get(i) + "-";
            }
        }
        System.out.println(a);
        FileWriter fileWriter = new FileWriter("C:\\Users\\Acer\\IdeaProjects\\CodeJava\\DC\\src\\players.txt");
        fileWriter.write(a);
        fileWriter.close();

    }


    public static boolean noreplayplayer(String player) {
        for (String player_ : Players.players) {
            player = player.toLowerCase();
            if (player.equals(player_.toLowerCase())) {
                JOptionPane.showMessageDialog(null, "Eyni oyunçu ola bilməz");
                return false;
            }
        }
        return true;

    }

    public static void resetplayer() throws IOException {
        Players.players = new ArrayList();
        FileWriter fileWriter = new FileWriter("C:\\Users\\Acer\\IdeaProjects\\CodeJava\\DC\\src\\players.txt");
        fileWriter.write("");
        fileWriter.close();
        JOptionPane.showMessageDialog(null, "Bütün oyunçular sıfırlandı");

    }


}
