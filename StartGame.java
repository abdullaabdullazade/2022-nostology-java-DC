import javax.swing.*;
import java.util.Random;

public class StartGame {
    StartGame() {
        String a = "";
        for (int i = 1; i <= Players.playersnow.size(); i++) {
            a += i + ". " + Players.playersnow.get(i - 1) + "\n";
        }
        JOptionPane.showMessageDialog(null, "Oyun başladı\n" +
                "Oyunçular:\n" + a);
        while (true) {
            String choosing = JOptionPane.showInputDialog("1-Çarxı çevir");
            if (choosing.equals("1")) {
                dc();
            } else {
                JOptionPane.showMessageDialog(null, "Belə bir seçim yoxdur");
            }
        }

    }

    public static void dc() {
        Random random = new Random();
        String randomplayer = Players.playersnow.get(random.nextInt(Players.playersnow.size()));
        System.out.println(randomplayer);
        while (true) {
            String dc_ = JOptionPane.showInputDialog(null, randomplayer + "\n1-Doğruluq\n" +
                    "2-Cəsarət");
            if (dc_.equals("1")) {
                String[] dogruluq_ = {"Instagram hesabının şifrəsini de", "Heç sevmədiyin lakin onla yaxşı davrandığın dostunun adını de", "Sevdiyin qızın adını de','Neçə yaşında qız sevmisən?", "Heç xəyanət etmisən?", "Oyunçular içində xoşladığın oyunçu kimdir?", "Bir adamı öldürmək istəsən, kimi öldürərsən?"};
                int randomd = random.nextInt(dogruluq_.length - 1);
                JOptionPane.showMessageDialog(null, dogruluq_[randomd]);
                randomplayer = Players.playersnow.get(random.nextInt(Players.playersnow.size()));
                break;
            } else if (dc_.equals("2")) {
                String[] cesaret_ = {"Ən pis şəkli müəllimlər qrupunda paylaş", "Bir qıza ss göndər", "Müəllimin sözündən çıx", "Pəncərədən qışqıraraq sevdiyin qızın adını de", "Mən eşşəyəm adlı status qoy"};
                int randomd = random.nextInt(cesaret_.length - 1);
                JOptionPane.showMessageDialog(null, cesaret_[randomd]);
                randomplayer = Players.playersnow.get(random.nextInt(Players.playersnow.size()));
                break;

            } else {
                JOptionPane.showMessageDialog(null, "Belə bir seçim yoxdur");

            }
        }

    }

}
