public class Inventory
{
    private Weapons playerweapons;
    private Armor playerArmor;


    //toplanan eşyaların bazılarına negatif bir özellik eklenmesi (zehir gibi..) durumda sınıflar üzerinden direkt
    //bi şekilde halledilebilsin diye 3 ayrı sınıf olarak tanımlanmıştır
    private Food food;
    private Firewood firewood;
    private Water water;

    public Inventory() {

        this.playerweapons = new Weapons("Yumruk",-1,0,0);
        this.playerArmor = new Armor(-1,"ince gömlek",0,0);
        this.water=new Water("Su bulunamadı",0);
        this.firewood=new Firewood("Odun bulunamadı",0);
        this.food=new Food("Yemek bulunamadı",0);

    }


    public Weapons getPlayerweapons() {
        return playerweapons;
    }

    public void setPlayerweapons(Weapons playerweapons) {
        this.playerweapons = playerweapons;
    }

    public Armor getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(Armor playerArmor) {
        this.playerArmor = playerArmor;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Firewood getFirewood() {
        return firewood;
    }

    public void setFirewood(Firewood firewood) {
        this.firewood = firewood;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }
}
