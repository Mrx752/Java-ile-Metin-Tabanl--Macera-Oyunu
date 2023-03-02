public class Weapons
{
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapons(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons() // başşka bir classta kullnırken nesne oluşturmamak için static ifadesi yazıldı
    {
        Weapons[] weaponslist = new Weapons[3];
        weaponslist[0]=new Weapons("Zümrüt Tabancası",1,2,25);
        weaponslist[1]=new Weapons("Cenk Arabası Kılıcı",2,3,35);
        weaponslist[2]=new Weapons("Ora Ora eldiveni ",3,7,45);
        return weaponslist;
    }

    public static Weapons getWeaponObjeById(int id)
    {

        for(Weapons w2 : Weapons.weapons())
        {
            if(w2.getId() == id) return w2;
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
