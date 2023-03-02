import java.util.Arrays;

public class ToolStore extends NormalLocation
{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("<--- Mağazaya Hoşgeldiniz --->");
        boolean showmenu = true;
        while (showmenu)
        {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.println("Seçiminiz :");
            int selectToolstore = Location.input.nextInt();
            input.nextLine();

            while (selectToolstore < 1 || selectToolstore > 3) {
                System.out.println("Hatalı giriş yaptınız tekrar deneyiniz .!!");
                selectToolstore = Location.input.nextInt();
            }

            switch (selectToolstore) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Paranız olunca yine bekleriz..... :(((((((( ");
                    showmenu = false;
                    break;
            }

        }
        return true;
    }



    public void printWeapon()
    {
        System.out.println("========== >Silahlar< ========== ");
        System.out.println();

        for (Weapons w: Weapons.weapons())
        {
            // Burada w adından nesne üretiliyor (nesne üretmekten kastımız int a gibi bi değişkenin tanımlanması )
            //Weapons.weapons() da list şeklinde üretilmiş nesneleri dolaşıyor
             System.out.println(w.getName() + "\tID : " +w.getId() + "\tHasar : " +w.getDamage() + "\tFiyat : " + w.getPrice());
        }

        System.out.println("Çıkış yapmak için --> 0");

        }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz : ");
        int selectweapon = Location.input.nextInt();

        while (selectweapon < 0 || selectweapon > 3) {
            System.out.println("Hatalı giriş yaptınız tekrar deneyiniz .!!");
            selectweapon = Location.input.nextInt();
        }

        if(selectweapon != 0)
        {
            Weapons selectedweaponnull = Weapons.getWeaponObjeById(selectweapon);
            // burada eğer ki seçimin bir karşılığı yoksa
            // selectedweaponnull = null olucak
            // if içerisine ona göre işleme giricek

            if (selectedweaponnull != null) {
                if (selectedweaponnull.getPrice() > this.getPlayer().getMoney()) {
                    //burada ki this üzerinde işlem yapılan playera
                    // denk gelmetedir
                    //player daha önce location class ında da tanımlanmıştır
                    System.out.println("Yeterli paranız bulunmamaktadır. :/ $$ /:");
                } else {
                    System.out.println(selectedweaponnull.getName() + " Silahını satın aldınız  ::)))))");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedweaponnull.getPrice());
                    System.out.println("Kalan paranız |=> " + this.getPlayer().getMoney() + " $");
                    // System.out.println("Önce ki silahınız : " + this.getPlayer().getInv().getPlayerweapons().getName());
                    this.getPlayer().getInv().setPlayerweapons(selectedweaponnull);
                    // System.out.println("Yeni silahınız : " + selectedweaponnull.getName());
                }


            }


        }

    }

    public void printArmor()
    {
        System.out.println("========== >Zırhlar< ========== ");
        System.out.println();
        for (Armor a: Armor.armors())
        {
            // Burada w adından nesne üretiliyor (nesne üretmekten kastımız int a gibi bi değişkenin tanımlanması )
            //Weapons.weapons() da list şeklinde üretilmiş nesneleri dolaşıyor
            System.out.println(a.getName() + "\tID : " +a.getId() + "\tEngelleme : " +a.getBlock() + "\tFiyat : " + a.getPrice());
        }
        System.out.println("Çıkış yapmak için --> 0");
    }

    public void buyArmor()
    {
        System.out.println("Bir zırh seçiniz : ");
        int selectArmor = Location.input.nextInt();

        while (selectArmor < 0 ||   selectArmor > 3)
        {
            System.out.println("Hatalı giriş yaptınız tekrar deneyiniz .!!");
            selectArmor = Location.input.nextInt();
        }

        if(selectArmor !=0)
        {
            Armor selectedArmornull = Armor.getArmotObjeById(selectArmor);

            if (selectedArmornull != null) {
                if (selectedArmornull.getPrice() > this.getPlayer().getMoney()) {
                    //burada ki this üzerinde işlem yapılan playera
                    // denk gelmetedir
                    //player daha önce location class ında da tanımlanmıştır
                    System.out.println("Yeterli paranız bulunmamaktadır. :/ $$ /:");
                } else {
                    System.out.println(selectedArmornull.getName() + " Zırhını satın aldınız  ::)))))");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmornull.getPrice());
                    System.out.println("Kalan paranız |=> " + this.getPlayer().getMoney() + " $");
                    this.getPlayer().getInv().setPlayerArmor(selectedArmornull);

                }


            }

        }

    }

}
