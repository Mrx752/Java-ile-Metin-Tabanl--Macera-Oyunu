import java.util.Scanner;

public abstract class Location
{

   private Player player; //oyunda ki mekanları içerisine oyuncu atmamız gerektiğinden dolayı içerisine tanımladık
   private String locName;

   public static Scanner input =new Scanner(System.in);
   // static olduğunda sadece 1 defa üretilir her nesne üretildiğinde üretilmez

    public Location(Player player, String locName) {
        this.player = player;
        this.locName = locName;
    }


    public abstract boolean onLocation(); //abs olarak tanımlanmasının sebebi bunu bütün alt sınıfların kullanması içindir
    //burada tanımlannan abs methodlar sadece abs sınıfı içinde içleri doldurulamaz (eski bilgi ).


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
















}
