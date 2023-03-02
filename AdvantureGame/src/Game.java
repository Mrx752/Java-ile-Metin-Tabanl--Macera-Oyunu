import java.util.Scanner;
public class Game
{
    private Scanner input =new Scanner(System.in);

    public void start()
    {
        System.out.println("\t\t!! ADVANTURE GAME !!\n");
        //System.out.println("Lütfen isminizi giriniz :");
       // String playerName = input.nextLine();
        Player player = new Player("Rick shanchez");
        System.out.println(player.getName() + " Bu karanlık evrene hoşgeldiniz");
        System.out.println("------------------------------------------------------->");
        System.out.println("<--<=== Karakterler ===>--> ");
        player.selectCharacter();
        System.out.println("------------------------------------------------------->");

        Location loc = null;
        // burada bi nesne oluşturuldu fakat nesneniin özellikleri ve metodları boş anlamındadır
        System.out.println("Ufak bir not : Mağara , Orman ve Nehir bölümlerini bitirip Güvenli eve gelirsen oyunu kazanırsın : ) ");

        while (true)
        {
            System.out.println();
            player.printInfo();
            System.out.println();
            System.out.println("<--<=== Bölgeler ===>--> ");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Dağlık Alan < Mağara >");
            System.out.println("4 - Ağaçlık Alan < Orman >");
            System.out.println("5 - Sulak Alan < Nehir >");
            System.out.println("6 - Kayalık Alan < Maden >");
            System.out.println("0 - Oyunu Sonlandır");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
            int selectLoc = input.nextInt();


            if(
                 (selectLoc==3 && player.getInv().getFood().getId()==1 )      ||
                 (selectLoc==4 && player.getInv().getFirewood().getId()==1 )  ||
                 (selectLoc==5 && player.getInv().getWater().getId()==1 )
              )
            {

                System.out.println("Daha önceden ödül kazanılmıştır !!!");
                System.out.println("Bu bölüm tamamlanmıştır");
                continue;

            }

            if(player.getInv().getWater().getId() == 1 &  player.getInv().getFood().getId() == 1 & player.getInv().getFirewood().getId() == 1 & selectLoc ==1)
            {
                System.out.println("----------------------------------------------------------");
                System.out.println("----------------------------------------------------------");
                System.out.println("                    YOU WINN                ");
                System.out.println("----------------------------------------------------------");
                System.out.println("----------------------------------------------------------");
                System.out.println("Tebrikler Jotaro Hayranı Genç Adam Hikayeyi Tamamladın ");
                System.out.println("Serbst Maden Modundan Devam Edebilirsin");
                System.out.println();
                System.out.println();

            }


            switch (selectLoc)
            {
                case 0:
                    loc = null;
                    break;
                case 1:
                    loc = new SafeHouse(player);
                    //burada boş oluşturulan nesne yi güvenli eve atamış gibi oldu
                    //parantez içerisinde ki this daha önce üretilen nesne yani üzerinde işlem yapılan neseneye denk gelmektedir
                    break;
                case 2:
                    loc = new ToolStore(player);
                    break;
                case 3:
                    loc = new Cave(player);
                    break;
                case 4:
                    loc = new Forest(player);
                    break;
                case 5:
                    loc = new River(player);
                    break;
                case 6:
                    loc = new Mine(player);
                    break;
                    default:
                    loc = new SafeHouse(player); // varsayılan olarak güvenli ev olarak seçildi

            }
            if (loc == null)
            {
                System.out.println("BYE BYE");
                break;
            }

            if (!loc.onLocation())
            {
                System.out.println("ORA ORA GAME OVER ORA ORA");
                break;
            }


        }

    }


}
