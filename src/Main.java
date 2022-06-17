import java.util.Scanner;

public class Main {
    /*
  1. Kullanıcının mağazanın altın kartı varsa,% 30 indirim alır
  2. Kullanıcının mağazanın gümüş kartı varsa,% 20 indirim alır
  2. Kullanıcı mağazanın bir üyesi ise,% 10 indirim alır
  3. Kullanıcı 2 yıldan fazla bir süredir müşteriyse,% 5 indirim alır.
  4. Faturadaki her 200 ABD Doları için 5 ABD Doları indirim yapılır (örneğin, 950 ABD Doları için 20 ABD Doları alırsınız
  bir indirim olarak).
  5. Yüzdeye dayalı indirimler telefonlarda geçerli değildir.
  6. Bir kullanıcı, bir faturadaki yüzdeye dayalı indirimlerden yalnızca birini alabilir.
     */
    public static void main(String[]args){
        Scanner scan= new Scanner(System.in);
        String kart,urun;
        System.out.println("Lütfen kart tipinizi giriniz:(altın,gümüş)");
        kart=scan.next();
        int uyelikSorgulama,uyeSuresi,faturaTutarı, adet;
        double fiyat;
        System.out.println("Sitemize üye iseniz 1 üye değil iseniz 2 tuşlayınız.");
        uyelikSorgulama=scan.nextInt();
        System.out.println("Üyelik süreniz 2 yıldan fazla ise 1 tuşlayınız.");
        uyeSuresi=scan.nextInt();
        System.out.print("Satın alacağınız ürünün türünü giriniz:");
        urun=scan.next();
        System.out.print("Ürününüzün fiyatını giriniz:");
        fiyat=scan.nextDouble();

        boolean durum=false;

        double uyelikIndirimi,kartIndirimi,otomatikIndirim,urunIndirimi;

        if(kart.equalsIgnoreCase("altın") && durum==false){
            kartIndirimi= fiyat * 0.30;
            fiyat -= kartIndirimi;
            System.out.println("indirimli fiyat: " + fiyat);

            adet=(int) (fiyat/200);
            int indirim=adet*5;
            fiyat -= indirim;

            System.out.println("Fiyat da yapılan indirim tutarı: "+indirim);
            System.out.println("İndirimli fiyat: "+fiyat);

            durum=true;

        }else if (kart.equalsIgnoreCase("gümüş") && durum==false ){
            kartIndirimi=fiyat * 0.20;
            fiyat -= kartIndirimi;
            System.out.println("indirimli fiyat: " + fiyat);

            adet=(int) (fiyat/200);
            int indirim=adet*5;
            fiyat -=indirim;

            System.out.println("Fiyat da yapılan indirim tutarı: "+indirim);
            System.out.println("İndirimli fiyat: "+fiyat);

            durum=true;

        }

        if ((uyelikSorgulama==1) && durum==false) {
            uyelikIndirimi=fiyat * 0.10;
            fiyat -= uyelikIndirimi;
            System.out.println("üyelik indirimi: " + fiyat);

            adet=(int) (fiyat/200);
            int indirim=adet*5;
            fiyat -=indirim;

            System.out.println("Fiyat da yapılan indirim tutarı: "+indirim);
            System.out.println("İndirimli fiyat: "+fiyat);

            durum=true;

        } else if ((uyelikSorgulama!=1)) {
            uyelikIndirimi =0;
            System.out.println("üyelik indirimi uygulanmadı.");
        } else if ((uyeSuresi>=2) && durum==false) {
            uyelikIndirimi=fiyat * 0.5;
            fiyat -= uyelikIndirimi;
            System.out.println("indirimli fiyat" + fiyat);

            adet=(int) (fiyat/200);
            int indirim=adet*5;
            fiyat -= indirim;

            System.out.println("Fiyat da yapılan indirim tutarı: "+indirim);
            System.out.println("İndirimli fiyat: "+fiyat);

            durum=true;
        }

        if(urun.equalsIgnoreCase("telefon")) {
            fiyat= fiyat - 0 ;
            System.out.println("Telefonlarda indirim uygulanamaz.");
        }

    }
}
