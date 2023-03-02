public abstract class GameCharacter
{
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;

    // Eğer ki bu sınıfı abstract olarak tanımlamadan samurai okçu vb gibi karakterleri nesne halinde oluşturmak isteseydik
    // sınıfın kendii içeisinde kendi sınıfından nesneler yaparak bu işlemin aynısını yapmış olurduk
    //private GameCharacter samurai =new GameCharacter(5,21,15); bu şekilde de aynı işlem tanımlanmış olabilirdi
    //farklkı bir çözüm yöntemidir


    public GameCharacter(String name,int id,int damage, int health, int money)
    {
        this.name=name;
        this.id=id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getDamage() {
        return damage;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
