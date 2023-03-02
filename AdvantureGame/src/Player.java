import java.util.Scanner;

public class Player
{
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String name;
    private String charName;


    private Scanner input =new Scanner(System.in);
    //selectcharacter methodunnda kullınıcıdan bi veri alınacağından dolayı burada scanner tanımlandı

    private Inventory inv;

    public Player(String name)
    {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCharacter()
    {
        //seçme işlemii yapıcak metod için içerisinde karakterleri nesne şeklinde tanımlılyoruz
        // Samurai samurai = new Samurai();
        //Archer archer = new Archer();
        //Knight knight = new Knight();
        //Burada ştek tek tanımladığımız nesneleri şu şekilde de yapabilirilz

        GameCharacter[] characterList = {new Samurai(),new Archer(),new Knight()};
        // Burada polimorfizm (çok biçimlilik ) kullanarak nesne oluşturduk oluşturulan nesneler samuurai okçu ve şövalye gibi davraanır

        for (GameCharacter a:characterList)
        {
            System.out.println(a.getName() +"\t\tID: "+ a.getId() +"\tHasar: " + a.getDamage() + "\tSağlık: " + a.getHealth() +"\tPara: " + a.getMoney());

        }

        System.out.println("\nSeçmek istediğiniz karaterin ID numarısını giriniz : ");
        int selcectCharacter = input.nextInt();

        switch (selcectCharacter)
        {
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

            default:
                System.out.println("Yanlış ya da hatallı tuşlama sonucu otomatik olarak karakter seçimi yapılmıştır !!");
                initPlayer(new Samurai());
        }

        System.out.println("Seçtiğiniz karater ==> "+ this.charName+"\tHasar: " + this.damage + "\tSağlık: " + this.health +"\tPara: " + this.money );
        // initplayer da charnam i değiştirdiğimzden dolayı bu şekilde bi kullanım sağlayabiliyoruz
    }
/*
    public void selectLocation()
    {
        Location loc = null; // burada bi nesne oluşturuldu fakat nesneniin özellikleri ve metodları boş anlamındadır
        System.out.println("Bölgeler");
        System.out.println("1 - Güvenli Ev");
        System.out.println("2 - Mağaza");
        System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
        int selectLoc = input.nextInt();
        switch (selectLoc)
        {
            case 1:
                loc = new SafeHouse(this);
                //burada boş oluşturulan nesne yi güvenli eve atamış gibi oldu
                //parantez içerisinde ki this daha önce üretilen nesne yani üzerinde işlem yapılan neseneye denk gelmektedir
                break;

            case 2:
                loc = new ToolStore(this);
                break;

            default:
                loc = new SafeHouse(this); // varsayılan olarak güvenli ev olarak seçildi

        }
        loc.onLocation();
    } */
    public void initPlayer(GameCharacter b)
    {
       // bu method karakterlerin özelliklerini playera aktarmada işe yarıyor
       //aktarma sebebi ise ileride silah vs alındığında hasar vb şeyler de artma meydana gelicek
       // ve biz bunu player nesnesi üzerinden değiştiricez

        this.setDamage(b.getDamage());
        this.setHealth(b.getHealth());
        this.setMoney(b.getMoney());
        this.setCharName(b.getName());
        this.setOrijinalHealth(b.getHealth());
    }

    public void printInfo()
    {
        System.out.println("// Silahınız =--> " +this.getInv().getPlayerweapons().getName() + "\tHasarınız =--> " + this.getDamage() + "\tSağlığınız =--> " + this.getHealth() + "\tParanız =--> " + this.getMoney() + " //");
        System.out.println("// Zırhınız =--> " +this.getInv().getPlayerArmor().getName() + "\tEngellemesi =--> " + this.getInv().getPlayerArmor().getBlock() + " //");
        System.out.println();
        System.out.println("Bulunan bölge ödülleri :");
        System.out.println("1. ödül :" + this.getInv().getFood().getName());
        System.out.println("2. ödül :" + this.getInv().getFirewood().getName());
        System.out.println("3. ödül :" + this.getInv().getWater().getName());

    }

    public int getDamage() {
        return( damage + this.getInv().getPlayerweapons().getDamage() );
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
}
