package com.vit.explorevellore;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Krishna Kalubandi on 14-04-2015.
 */
public class DatabaseWriter {
    SQLiteDatabase db;
    private static final String[] TABLE_NAMES = {"attractions","dining","accommodation","shopping","theatres"};
    String attractions[] = {"Vellore Fort","Musuem","Golden Temple", "Ratnagiri Murugan Temple","Park"};
    String attractionsLocations[] = {
            "Vellore Fort, Fort Round Rd, Balaji Nagar, Vellore, Tamil Nadu 632004",
                    " inside the vellore fort,fort round rd,vellore",
                    "Sri Narayani Peetam, Sri Puram, Thirumalai Kodi, Vellore, Tamil Nadu 632055",
                    "ratnagiri, walagah taluk,, Vellore, Tamil Nadu 632517",
                    "Muthanna Nagar, Tollgate, New Sankaranpalayam Road, Vellore, Tamil Nadu 632001"
    };
    String attractionsDistances[] = {"9km","9km","16.3km","14.4km","5km"};
    String attractionsFares[] ={"150","150","200","180","50"};
    String dining[]={
            "Dominos Pizza","Papa johns","hundreds heritage","Toms diner","Limra","Darling Residency","River View"
            ,"Flo cafe","Bakers hub","Olive Kitchen","Vellore kitchen","Andhra Spice","Swagath","China Town","Big Chick",
            "Vellore Fried Chicken","Café Coffee day"
    };
    String diningLocations[] = {
            "Ground Floor,Mega Mart,No. 66,Katpadi Main Road, Thirunagar, Near Rangalaya Marriage Hall, Vellore, Tamil Nadu 632007",
            " Inside vit university","14th East Cross Rd, Gandhinagar, Vellore, Tamil Nadu 632006","13 tv nagar,opp vit university,vellore",
            "opp to allmart,Vellore,Tamil Nadu 632014"," #11/8,Officers Line Anna Salai,Vellore,Tamil Nadu 632001",
            "New Katpadi Road,Kilithampatarai,Katpadi,National Highway 234, Pune, Tamil Nadu 632064",
            "Gaurang Mall,SH-59,Tiruvalam Road,Opp Vellore Institue of Technology, Katpadi, Vellore, Tamil Nadu 632007",
            "Shop No. 98, First Floor, Opp to Aascar theater, Katpadi road, National Highway 234, Vellore, Tamil Nadu 632007",
            "No 151, Vit College Road, Katpadi, Vellore – 632002"," No: 1, Near Green Circle, NH 46 Service Road, Thottapalayam, Vellore, Tamil Nadu 632004",
            " opp.  to main gate,vit university,Vellore, Tamil Nadu 632014"," opp. To 3rd gate,vit university,vellore,Tamilnadu 632014",
            " Town no .118, Arcot road,, Opp to CMC, Vellore, Tamil Nadu 632001"," opp.  To  Vit university,Vellore, Tamil Nadu 632014",
            " #22, Near Dhanabakyam Kalyana Mandapam, 8th East Main Road, Gandhinagar, Vellore, Tamil Nadu 632006",
            " Near VIT College, Selvam Nagar, Katpadi, Vellore, Tamil Nadu 632014"
    };
    String diningPhones[] = {
            "04162244445","NULL","09655057100","08008368829","NULL","04162213001","04162225251","04164303323","04166536653","04162249808",
            "04162223330","08122289998","07845321234","04162226224","04164201222", "04162240577","18604253399"
    };
    String diningHours[] = {"11:00 am– 11:00 pm","NULL","12:00 am – 3:00 pm & 7:30-11:00 pm","11:00 am-11:00 pm","NULL","NULL","NULL","10:00 am-11:00 pm",
            "9:00 am-11:00 pm","11:00 am-3:00 pm & 6:30–10:00 pm","6:30-11:00 pm","11:00 am–11:00 pm","11:00 am-11:00 pm","12:00-3:30 pm & 6:30-11:00 pm",
            "NULL","11:30 am-10:30 pm","9:00 am- 11:00 pm"};
    String diningDistances[] = {"3.8km","0","3.5km","100m","600m","9.5km","6.4km","210m","2.9km","1.3km","6.5km","100m","100m","12km","190m","3.6km","1.3km"};
    String diningFares[] = {"50","0","50","20","30","150","90","30","40","30","60","20","20","180","20","50","30"};
    String accommodation[] = {
            "Hotel Baby Residency","Hotel Mount  Paradise","Hotel Khanna","Hotel Palm Tree","Grt Residency","Ghee kay Millenia"
            ,"Poppys anukula Residency","Darling residency","Hotel Surabhi","Hotel River view","Hotel Grand Krishna","Hotel Saravana Bhavan"
    };
    String accommodationPhones[] = {
            "0416 222 6484","0416 222 8631","099429 93369","0416 222 2960","0416 220 6466","04172 245 480","NULL",
            "0416 221 3001","NULL","0416 222 5251","NULL","NULL"
    };
    String accommodationLocations[] = {
            "No.7 Officers Line ,Veerasamy Nagar,Vellore Tamil Nadu,632001",
            "No.37,New Bye-pass Road(Next Collector office),Vellore,Tamil Nadu 632006",
            "No.16,Officers Line,Vellore,Tamil Nadu,632001",
            "10,Thennamara Street,Kosapet,Near Corporation Office,Vellore,Tamil Nadu,632001",
            "No. 145,Green Circle,New By-Pass Road,Vellore,Tamil Nadu,632004",
            " #69,SIPCOT Road Near National Highway 4,Bharathi Nagar,Ranipet,Vellore,Tamil Nadu,632403",
            "opp New Bus Stand,New Bridge Road,Vevekanandar Nagar,Thottapalayam, Vellore,Tamil Nadu, 632012 ",
            " #11/8 Officers Line, Anna Salai, Vellore,Tamil Nadu,632001",
            "Babu Rao Street,Near Jothi Lodge,Gandhi Road,Vellore,Tamil Nadu,632004",
            "New Katpadi Road ,Kilithampatarai, Katpadi, National Highway 234,Tamil Nadu,632064",
            "171,Alamelumangapuram, Arcot Main Road,Vellore, Tamil Nadu 632009",
            " #710, Bangalore Road , Near J P Mahal ,Konnavattam,  Vellore, Tamil Nadu, 632014"

    };
    String accommodationFares[] = {"160","120","160","150","150","200","150","150","160","100","120","N/A"};
    String accommodationDistances[] = {"9.9km","7.4km","9.4km","9km","9.5km","21.2km","9km","9.5","9.8","7.5","8km","N/A"};
    String shopping[] = {
            "Waves","Globus","Gr8 buys","Chennai Silks","Megamart","Bata Showroom","All Mart","More","Joyyalukkas"
    };
    String shoppingLocations[] = {
            "katpadi Road,Vellore",
            " Men'S Park Thottapalayam, Surplus Cotton Officers Line, vellore",
            " No 66/5,Katpadi-vellore main Rd,Gandhi Nagar, Vellore, Tamil Nadu 632006",
            " No.37,Chennai-Bengaluru New By-Pass Road,Opposite Collector Office Road,Vellore,Tamil Nadu 632012",
            "No.11,New Katpadi Road,Vellore,Tamil Naidu 632004",
            " near CMC Hospital, Katpadi Road National Highway 234, Thottapalayam, Vellore, Tamil Nadu",
            " V.I.T. Shopping Complex, Vellore, Tamil Nadu 632007",
            " 232 &223, South Service Road Phase I Vallalar Nagar, Sathuvacheri, Vellore - 632009, Below Meenakshi Mahal Opposite Vallalar Matriculation School",
            "11, Officers Line, Katpadi, Vellore- 632001"
    };
    String shoppingPhones[] = {"097509 28574","NULL", "0416 224 6072", "0416 222 0215", "0416 222 5560", "1800 419 228", "NULL","08652906676","0416 2233916"};
    String shoppingHours[] = {"10:00-10:30pm","10:00-10:30 pm","10:00-10:30pm","10:00-10:30 pm","10:00-10:30pm","10:00-10:30 pm","10:00-10:30pm","10:00-10:30 pm","10:00-10:30pm"};
    String shoppingFares[] = {"30","30","50","100","80","70","20","120","130"};
    String shoppingDistances[] = {"2km","2km","4km","7.9km","6.7km","5.7km","100m","9.2km","9.4km"};
    String theatres[] = {

            "Aascars Theatres","Galaxy Cinemas","Sri Raghavendra Theatre","Silambu Cinemas","Alankar Theatre","Raja Theatre",
            "Big Cinemas Lakshmi","Venus Theatre","Thirumalai Theatre","Kural theatre","Apsara Theatre"
    };
    String theatresLocations[] = {
            "State Highway 9, vellore ,Tamil Nadu","Muthamizh Nagar,Katpadi,Tamil Nadu,632006",
            "Main Road, Near Nano Tailor ,Shenbakkam, Vellore,Tamil Nadu ,632015",
            "Main Road, Near Krishna Garden ,Shenbakkam, vellore ,Tamil Nadu, 632015","3 Infantry Rd, Vasanthapuram, Kosapet, Vellore ,Tamil Nadu ,632001",
            "krishnanagar,vellore,tamilnadu","Plot No 56, Old No 26, Thorapadi Road, Officers Line,Vellore Ho,Vellore,632001"," Krishna Nagar Depot,632001",
            "Arts College Road, Near Muthu Rangam,Otteri,Vellore,Tamil Nadu,632002","Bangalore Rd ,Konavattam ,Vellore, Tamil Nadu, 632004",
            "Azad Road, SH-207 Vasantapuram , Kosapet,  Vellore ,Tamil Nadu"

    };
    String theatresPhones[] = {
            "0416 224 3833","04162248847","04162290910","NULL","07498869702","NULL", "9360923599","NULL","NULL","NULL","NULL"
    };
    String theatresDistances[] = {"2.9km","2.0km","8.9km","8.4km","9.4km","9km","9km","10.8km","12.9km","8.4km","10.9km"};
    String theatresFares[] = {
            "60","30","150","150","150","150","150","180","200","150","180"
    };
    String allNames[][] = {attractions,dining,accommodation,shopping,theatres};
    String allLocations[][] = {attractionsLocations,diningLocations,accommodationLocations,shoppingLocations,theatresLocations};
    String allDistances[][] = {attractionsDistances,diningDistances,accommodationDistances,shoppingDistances,theatresDistances};
    String allFares[][] = {attractionsFares,diningFares,accommodationFares,shoppingFares,theatresFares};
    String allPhones[][] = {diningPhones,accommodationPhones,shoppingPhones,theatresPhones};
    String allHours[][] = {diningHours,shoppingHours};
    DatabaseWriter(SQLiteDatabase db){
        this.db = db;
    }
    public void write(){
        for(int i = 0; i < TABLE_NAMES.length; i++){
            for(int j = 0; j < allLocations[i].length; j++){
                ContentValues values = new ContentValues();
                values.put("name",allNames[i][j]);
                values.put("location",allLocations[i][j]);
                values.put("distance", allDistances[i][j]);
                values.put("fare",allFares[i][j]);
                if(i != 0)
                    values.put("phone",allPhones[i-1][j]);
                if(i == 1)
                    values.put("hours",allHours[0][j]);
                if(i == 3)
                    values.put("hours",allHours[1][j]);
                db.insert(TABLE_NAMES[i],null,values);

            }
        }

    }
}
