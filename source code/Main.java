package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Abatoɔ");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
    }

    public static void main(String[] args) {
        //Districts for testing
        District ds1 = new District("Tema North", Region.GreaterAccra);
        District ds2 = new District("Ayawoaso West", Region.GreaterAccra);
        District ds3 = new District("Sagnarigu East", Region.Savannah);
        District ds4 = new District("Nohani South", Region.Savannah);
        District ds5 = new District("Assin North", Region.Central);

        //Polling stations for testing
        PollingStation ps1 = new PollingStation("St.Martin's School", ds1, new File("St.Martins's School.txt"));
        PollingStation ps2 = new PollingStation("North Kaneshie Point 4", ds1, new File("North Kaneshie Point 4.txt"));
        PollingStation ps3 = new PollingStation("Our Lady of Fatima", ds3, new File("Our Lady of Fatima.txt"));
        PollingStation ps4 = new PollingStation("Oti Memorial", ds2, new File("Oti Memorial.txt"));
        PollingStation ps5 = new PollingStation("Sakasaka Zone", ds3, new File("Sakasaka Zone.txt"));
        PollingStation ps6 = new PollingStation("Ola Cathedral", ds2, new File("Ola Cathedral.txt"));
        PollingStation ps7 = new PollingStation("Kalpohini R/C",ds5, new File("Kalpohini.txt"));
        PollingStation ps8 = new PollingStation("St.Augustine Primary",ds5, new File("St.Augustine Primary.txt"));
        PollingStation ps9 = new PollingStation("White Chapel",ds4, new File("White Chapel.txt"));
        PollingStation ps10 = new PollingStation("Pramso D/A",ds4, new File("Pramso.txt"));

        //Voters for testing
        Voter v1 = new Voter("Aka Ebenezer", LocalDate.of(1978,8,12),'M',"Akim Tafo",70752023,ps1,"akben101");
        Voter v2 = new Voter("Kelvin Anim", LocalDate.of(1995,4,16),'M', "Navrongo",20122023,ps1, "kev123");
        Voter v3 = new Voter("Rita Segbaya", LocalDate.of(2000,12,28),'F', "Keta",71712023,ps4, "riri20");
        Voter v4 = new Voter("Woraba Ghansah", LocalDate.of(1988,12,3),'F', "Atebubu", 12132155,ps8,"vidash23");
        Voter v5 = new Voter("John Dumelo", LocalDate.of(1989,5,24),'M',"Ho",1111115,ps6,"jodem45");
        Voter v6 = new Voter("Emmanuel Kwarase", LocalDate.of(1978,8,12),'M',"Akim Tafo",73212023,ps3,"salu54");
        Voter v7 = new Voter("Mumuni Salamatu", LocalDate.of(1995,4,16),'F', "Navrongo",1111117,ps5, "damoa30");
        Voter v8 = new Voter("David Ebo Adjepon-Yamoah", LocalDate.of(1976,11,27), 'M', "Koforidua", 1111118,ps2,"trei000");
        Voter v9 = new Voter("Elvis Okoh", LocalDate.of(1901,7,17), 'M', "Obuasi", 1111119,ps9,"elVis177");
        Voter v10 = new Voter("Miriam Duke", LocalDate.of(2002,1,29), 'F',"Cape Coast", 1111010,ps7,"miri75");
        Voter v11 = new Voter("Aisha Nuhu", LocalDate.of(1969,9,3), 'F', "Mumpurugi Yoyo",1111011,ps10,"cash234");
        Voter v12 = new Voter("Naa Ayi-Mensah", LocalDate.of(1998,3,7), 'F', "Korobite",1111012,ps4,"123lll");
        Voter v13 = new Voter("Joesph Mensah", LocalDate.of(1963,10,23), 'M', "Odumasi",1111013,ps5,"qwerty789");
        Voter v14 = new Voter("Selasi Azumah", LocalDate.of(1949,9,3), 'M', "Akatsi",1111014,ps1,"asdfg456");
        Voter v15 = new Voter("Christelle McCarthy", LocalDate.of(2001,12,28), 'F', "Mamprobi",1111015,ps2,"chris111");
        Voter v16 = new Voter("Kekeli Mensah", LocalDate.of(2000,5,17), 'M', "Nogokpo",5648521,ps7,"keks787");
        Voter v17 = new Voter("Omieibi Bagshaw", LocalDate.of(1999,3,6), 'M', "Assin Fosu",7845202,ps8,"bag123");
        Voter v18 = new Voter("Samuella Mensah", LocalDate.of(2001,8,26), 'F', "Atonsu",8969741,ps6,"men123");
        Voter v19 = new Voter("Umuh-Kusum Kataale", LocalDate.of(1967,9,11), 'F', "Tamale",3658596,ps6,"kat123");
        Voter v20 = new Voter("Miriam Adjaye", LocalDate.of(1982,2,14), 'F', "Kumasi",4547856,ps3,"mimi2000");
        Voter v21 = new Voter("Gabriel Owusu", LocalDate.of(1944,12,8), 'M', "Ahafo",2325214,ps8,"gab16#");
        Voter v22 = new Voter("Elaine Roberts", LocalDate.of(1888,10,24), 'F', "Keta",5524661,ps9,"rob600");
        Voter v23 = new Voter("Rebecca Awuah", LocalDate.of(2000,11,18), 'F', "Chokor",5458596,ps4,"kat2123");
        Voter v24 = new Voter("Ngolo Kante", LocalDate.of(1988,10,24), 'M', "Walewale",3332221,ps7,"kant4000");
        Voter v25 = new Voter("Nana Boakye", LocalDate.of(1923,5,18), 'M', "Efie Kuma",3659596,ps5,"muma123");


        Admin.addVoter(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25);
        Admin.addPollingStation(ps1,ps2,ps3,ps4,ps5,ps6,ps7,ps8,ps9,ps10);
        Admin.addDistrict(ds1,ds2,ds3,ds4,ds5);
        Admin.addRegion(Region.Oti, Region.Eastern, Region.BonoEast, Region.Ashanti, Region.Ahafo,
                     Region.Central, Region.Bono, Region.Northern, Region.NorthEast, Region.UpperEast,
                     Region.WesternNorth, Region.Western, Region.Volta, Region.UpperWest);

        launch(args);
    }
}
