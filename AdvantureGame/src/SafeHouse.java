public class SafeHouse extends NormalLocation
{
    public SafeHouse(Player player)
    {
        super(player,"Güvenli Ev");
        // burada loc ismini kullınıcadan almamaıza gerek oolmadığından dolayı contr içerisine tanımlamıyoruz
        }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz :*) ");
        System.out.println("Canınız Yenilendi :*) ");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
