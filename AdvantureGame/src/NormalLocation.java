public abstract class NormalLocation extends Location
{
    public NormalLocation(Player player, String locName) {
        super(player, locName);
    }


    @Override
    public boolean onLocation() {
        return true; // normal location larda boolenları her zaman true  döndürücez
                    // Bunun sebebi ise normal loc larda ölme gibi bi durum olmadığından

    }
}
