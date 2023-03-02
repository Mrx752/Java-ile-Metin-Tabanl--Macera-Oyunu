import java.util.Random;

public abstract class BattleLocation extends Location
{
    private Monster battleMonter;
    private String award;
    private int maxMonster;
    public BattleLocation(Player player, String locName,Monster battleMonter,String award,int maxMonster) {
        super(player, locName);
        this.battleMonter=battleMonter;
        this.award=award;
        this.maxMonster=maxMonster;

    }

    @Override
    public boolean onLocation()
    {

        int a = rannddomMonterNumber();
        System.out.println("Şuan buradasınız : " + this.getLocName());
        System.out.println("Dikkatli Ol !!!! " + a + "\ttane" + this.getBattleMonter().getName() +"  Karşına çıkabilir");
        System.out.println("<S>avaş ya da <K>aç");
        String selectCase = Location.input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S"))
        {
            if(combat(a))
            {
                System.out.println(this.getLocName() +"Bulunan tüm düşmanları yendiniz !!");
                printAward();

                return true;
            }
            //Savaşma işlemini yapıcak
        }
        if(this.getPlayer().getHealth() < 1)
        {
            System.out.println("Öldünüz !!");
            return false;
        }


        return true;
    }

    public boolean combat(int obsNumber)
    {
        for(int i = 1 ;i <= obsNumber ; i++)
        {
            this.getBattleMonter().setHealth(this.getBattleMonter().getOrjinalHealth());

            if(this.getBattleMonter().getId() == 4)
            {
                int a;
                a=randomDamgeMonster();
                this.getBattleMonter().setDamage(a);
            }

            playerStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getBattleMonter().getHealth() > 0 )
            {
                int b =fortune();
                System.out.println();
                System.out.println("<D>övüş ya da <K>aç");
                String selectCombat = Location.input.nextLine();
                selectCombat = selectCombat.toUpperCase();

                if (selectCombat.equals("D"))
                {
                    System.out.println("===================================================");
                    if (b < 50)
                    {
                        System.out.println("Siz vurdunuz !!");
                        this.getBattleMonter().setHealth(this.getBattleMonter().getHealth() - this.getPlayer().getDamage());
                        afterHit();

                        if (this.getBattleMonter().getHealth() > 0)
                        {
                            System.out.println();
                            System.out.println("Canavar size vurdu !!");
                            int monsterRealDamage = this.getBattleMonter().getDamage() - this.getPlayer().getInv().getPlayerArmor().getBlock();
                            if (monsterRealDamage < 0) monsterRealDamage = 0;
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterRealDamage);
                            afterHit();
                        }
                    }
                    else
                    {

                        System.out.println("Canavar size vurdu !!");
                        int monsterRealDamage = this.getBattleMonter().getDamage() - this.getPlayer().getInv().getPlayerArmor().getBlock();
                        if (monsterRealDamage < 0) monsterRealDamage = 0;
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterRealDamage);
                        afterHit();
                        System.out.println();
                        if(this.getPlayer().getHealth() > 0)
                        {
                            System.out.println("Siz vurdunuz !!");
                            this.getBattleMonter().setHealth(this.getBattleMonter().getHealth() - this.getPlayer().getDamage());
                            afterHit();
                            System.out.println();
                        }
                    }
                }
                else
                {
                    return false;
                }
                /*
                System.out.println("<V> ya da <K>aç");
                String selectCombat = Location.input.nextLine();
                selectCombat = selectCombat.toUpperCase();
                if (selectCombat.equals("V"))
                {

                    System.out.println("Siz vurdunuz !!");
                    this.getBattleMonter().setHealth(this.getBattleMonter().getHealth()-this.getPlayer().getDamage());
                    afterHit();

                    if(this.getBattleMonter().getHealth() > 0)
                    {
                        System.out.println();
                        System.out.println("Canavar size vurdu !!");
                        int monsterRealDamage = this.getBattleMonter().getDamage()-this.getPlayer().getInv().getPlayerArmor().getBlock();
                        if(monsterRealDamage < 0) monsterRealDamage = 0;
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterRealDamage);
                        afterHit();
                    }


                }
                else
                {
                    return false;
                }
            */
            }

            if(this.getBattleMonter().getId() == 4  && (this.getBattleMonter().getHealth() < this.getPlayer().getHealth()))
            {

                int a;
                a=fortune();
                if(a < 16) weaponItems();
                else if (a > 15 && a < 31) armorItems();
                else if(a > 30 && a < 56) moneyItems();
                else if (a > 55 && a < 101 )
                {
                    System.out.println();
                    System.out.println("Şansına küs !! :(");
                }


            }
            else if(this.getBattleMonter().getHealth() < this.getPlayer().getHealth())
            {
                System.out.println();
                System.out.println("Canavarı yendiniz..!!!");
                System.out.println(this.getBattleMonter().getAward() +" $ Ödülünü kazandınız ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getBattleMonter().getAward());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());

            }
            else
            {
                return false;
            }

        }

        return true;
    }

    public void printAward()
    {
        if(this.getBattleMonter().getId() == 1)
        {
            this.getPlayer().getInv().getFood().setName("Yemek Bulundu");
            this.getPlayer().getInv().getFood().setId(1);
            System.out.println("1. Ödül olan " + this.getPlayer().getInv().getFood().getName());
        }
        else if (this.getBattleMonter().getId() == 2)
        {
            this.getPlayer().getInv().getFirewood().setName("Odun Bulundu");
            this.getPlayer().getInv().getFirewood().setId(1);
            System.out.println("2. Ödül olan " + this.getPlayer().getInv().getFirewood().getName());

        }
        else if (this.getBattleMonter().getId() == 3)
        {
            this.getPlayer().getInv().getWater().setName("Su Bulundu");
            this.getPlayer().getInv().getWater().setId(1);
            System.out.println("3. Ödül olan " + this.getPlayer().getInv().getWater().getName());

        }
    }


    public void weaponItems()
    {
            int b;
            b=fortune();
            if(b<21)
            {
                System.out.println("Tebrikler yerden Ora Ora eldiveni buldunuz !!!!");
                System.out.println("Bulunan Ora Ora eldiveni Elinizde ki silah ile değiştirmek istiyor musunuz  ?");
                System.out.println("<E>vet ya da <H>ayır");
                String weaponChance = Location.input.nextLine();
                weaponChance = weaponChance.toUpperCase();
                if(weaponChance.equals("E"))
                {
                    System.out.print(this.getPlayer().getInv().getPlayerweapons().getName() + "Silahınız\t");
                    Weapons selectedWeapon = Weapons.getWeaponObjeById(3);
                    System.out.println(selectedWeapon.getName() +" ile değiştirildi");
                    this.getPlayer().getInv().setPlayerweapons(selectedWeapon);

                }
                else if(weaponChance.equals("H")) System.out.println("Elinizde ki silah değiştirilmedi");
            }
            else if (b > 20 && b < 51)
            {
                System.out.println("Tebrikler yerden Cenk Arabası Kılıcı buldunuz !!!!");
                System.out.println("Bulunan Cenk Arabası Elinizde ki silah ile değiştirmek istiyor musunuz  ?");
                System.out.println("<E>vet ya da <H>ayır");
                String weaponChance = Location.input.nextLine();
                weaponChance = weaponChance.toUpperCase();
                if(weaponChance.equals("E"))
                {
                    System.out.print(this.getPlayer().getInv().getPlayerweapons().getName() + "Silahınız\t");
                    Weapons selectedWeapon = Weapons.getWeaponObjeById(2);
                    System.out.println(selectedWeapon.getName() +" ile değiştirildi");
                    this.getPlayer().getInv().setPlayerweapons(selectedWeapon);
                }
                else if(weaponChance.equals("H")) System.out.println("Elinizde ki silah değiştirilmedi");

            }

            else if (b > 50 )
            {
                System.out.println("Tebrikler yerden Zümrüt Tabancası buldunuz !!!!");
                System.out.println("Bulunan Zümrüt Tabancasını Elinizde ki silah ile değiştirmek istiyor musunuz  ?");
                System.out.println("<E>vet ya da <H>ayır");
                String weaponChance = Location.input.nextLine();
                weaponChance = weaponChance.toUpperCase();
                if(weaponChance.equals("E"))
                {
                    System.out.print(this.getPlayer().getInv().getPlayerweapons().getName() + "Silahınız\t");
                    Weapons selectedWeapon = Weapons.getWeaponObjeById(1);
                    System.out.println(selectedWeapon.getName() +" ile değiştirildi");
                    this.getPlayer().getInv().setPlayerweapons(selectedWeapon);
                }
                else if(weaponChance.equals("H")) System.out.println("Elinizde ki silah değiştirilmedi");

            }

        }

    public void armorItems()
    {
        int b;
        b=fortune();
        if(b<21)
        {
            System.out.println("Tebrikler yerden Ağır Zırh buldunuz !!!!");
            System.out.println("Bulunan Ağır Zırhı Üstünüz de ki zırh ile değiştirmek istiyor musunuz  ?");
            System.out.println("<E>vet ya da <H>ayır");
            String armorChance = Location.input.nextLine();
            armorChance = armorChance.toUpperCase();
            if(armorChance.equals("E"))
            {
                System.out.print(this.getPlayer().getInv().getPlayerArmor().getName() + "Zırhınız\t");
                Armor selectedArmor = Armor.getArmotObjeById(3);
                System.out.println(selectedArmor.getName() +"\tZırhı ile değiştirildi");
                this.getPlayer().getInv().setPlayerArmor(selectedArmor);

            }
            else if(armorChance.equals("H")) System.out.println("Üstünüzde ki zırh değiştirilmedi");
        }
        else if (b > 20 && b < 51)
        {
            System.out.println("Tebrikler yerden Orta Zırh buldunuz !!!!");
            System.out.println("Bulunan Orta Zırhı Üstünüz de ki zırh ile değiştirmek istiyor musunuz  ?");
            System.out.println("<E>vet ya da <H>ayır");
            String armorChance = Location.input.nextLine();
            armorChance = armorChance.toUpperCase();
            if(armorChance.equals("E"))
            {
                System.out.print(this.getPlayer().getInv().getPlayerArmor().getName() + "Zırhınız\t");
                Armor selectedArmor = Armor.getArmotObjeById(2);
                System.out.println(selectedArmor.getName() +"\tZırhı ile değiştirildi");
                this.getPlayer().getInv().setPlayerArmor(selectedArmor);

            }
            else if(armorChance.equals("H")) System.out.println("Üstünüzde ki zırh değiştirilmedi");        }

        else if (b > 50 )
        {
            System.out.println("Tebrikler yerden Orta Zırh buldunuz !!!!");
            System.out.println("Bulunan Orta Zırhı Üstünüz de ki zırh ile değiştirmek istiyor musunuz  ?");
            System.out.println("<E>vet ya da <H>ayır");
            String armorChance = Location.input.nextLine();
            armorChance = armorChance.toUpperCase();
            if(armorChance.equals("E"))
            {
                System.out.print(this.getPlayer().getInv().getPlayerArmor().getName() + "Zırhınız\t");
                Armor selectedArmor = Armor.getArmotObjeById(1);
                System.out.println(selectedArmor.getName() +"\tZırhı ile değiştirildi");
                this.getPlayer().getInv().setPlayerArmor(selectedArmor);

            }
            else if(armorChance.equals("H")) System.out.println("Üstünüzde ki zırh değiştirilmedi");        }

        }

    public void moneyItems()
    {
        int b;
        b=fortune();
        if(b<21)
        {
            System.out.println("Tebrikler yerden 10 $ buldunuz");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
        }
        else if (b > 20 && b < 51)
        {
            System.out.println("Tebrikler yerden 5 $ buldunuz");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
        }
        else if (b > 50)
        {
            System.out.println("Tebrikler yerden 1 $ buldunuz");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
        }

    }






    public void afterHit()
    {
        System.out.println("Sağlığınız : " + this.getPlayer().getHealth());
        System.out.println(this.getBattleMonter().getName() + "  Sağlığı  " + this.getBattleMonter().getHealth());

    }

    public void monsterStats(int i)
    {
        System.out.println(i + ".Canavar değerleri ");
        System.out.println("---------------------------------->");
        System.out.println("Sağlık : " +this.getBattleMonter().getHealth());
        System.out.println("Hasar : " +this.getBattleMonter().getDamage());
        if(this.getBattleMonter().getAward() == 0) System.out.println("Ödül : Şansın varsa ödül de vardır");
        else System.out.println("Ödül : " +this.getBattleMonter().getAward());
        System.out.println();
    }
    public void playerStats() // oyuncunun özelliklerinin gösterilecği meetod
    {
        System.out.println();
        System.out.println("Oyuncu değerleri ");
        System.out.println("---------------------------------->");
        System.out.println("Sağlık : " +this.getPlayer().getHealth());
        System.out.println("Hasar : " +this.getPlayer().getDamage());
        System.out.println("Para : " +this.getPlayer().getMoney());
        if (this.getPlayer().getInv().getPlayerweapons().getDamage() > 0)
        {
            System.out.println("Silah : " + this.getPlayer().getInv().getPlayerweapons().getName());
        }
        System.out.println("Zırh : " + this.getPlayer().getInv().getPlayerArmor().getName());
        System.out.println("Engelleme : " + this.getPlayer().getInv().getPlayerArmor().getBlock());
        System.out.println();


    }

    public int fortune()
    {
        Random random = new Random();
        return random.nextInt(101);
    }
    public int rannddomMonterNumber()
    {
        Random random = new Random(); // random nesnesini tanımladık
        return random.nextInt(this.getMaxMonster()) + 1;
         // Burada 1 - 3 arası bi değer üretmesini söyledik
        // burada ki + 1 olmasaydıı (maxmonster değeri = 3)
       // 0 ile 2 arasında bir değer üretiicekti
      //+1 dediğimizden dolayı 1 ile 3 arası 1 değer üretim işlemi gerçekleşmektedir
    }
   public int randomDamgeMonster()
   {
       Random random = new Random(); // random nesnesini tanımladık
       return random.nextInt(4) + 3;
   }

    public Monster getBattleMonter() {
        return battleMonter;
    }

    public void setBattleMonter(Monster battleMonter) {
        this.battleMonter = battleMonter;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }


}

