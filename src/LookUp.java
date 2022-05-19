import Controller.Connections;
import Controller.SQL;
import Model.BookOnTape;
import Model.Furniture;
import Model.Video;

import java.util.ArrayList;
import java.util.Scanner;

public class LookUp {
    private static final Scanner sc = new Scanner(System.in); //instance for reading keyboard input

    // make a connection to database , need to provide user and password

    private static final String username = "root";

    private static final String password = "2512hieuA";
    private static final  Connections connections = new Connections("jdbc:mysql://localhost:3306/rrs?autoReconnect=true&useSSL=false" , username , password);

    private static final SQL sql = new SQL(connections.getConnections());

    public static void main(String[] args) {

        boolean isBeakApp = false;

        System.out.println("Welcome to Rudy's Rental System");

        while(!isBeakApp) {

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Please pick your LOOK UP options");
            System.out.println("1. Provide data for Video database");
            System.out.println("2. Provide data for Furniture database");
            System.out.println("3. Provide data for Book on Tape database");
            System.out.println("4. Print all video data set to console");
            System.out.println("5. Print all furniture data set to console");
            System.out.println("6. Print all book data set to console");
            System.out.println("7. Find your item");
            System.out.println("Other. Exit your program");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

            int options = sc.nextInt();
            sc.nextLine();

            switch (options){
                case 1 :
                    provideDataForVideoDB();
                    break;
                case 2 :
                    provideDataForFurnitureDB();
                    break;
                case 3 :
                    provideDataForBookDB();
                    break;
                case 4 :
                    printAllVideoData();
                    break;
                case 5 :
                    printAllFurnitureData();
                    break;
                case 6 :
                    printAllBookData();
                    break;
                case 7 :
                    findItem();
                    break;
                default:
                    isBeakApp = true;
                    break;
            }
        }
    }
    public static void provideDataForVideoDB() {
        System.out.println("* Insert data into video table :");

        System.out.println("Video Title :");

        String title = sc.nextLine();

        System.out.println("Video Duration :");

        String duration = sc.nextLine();

        System.out.println("Video Type :");

        String type = sc.nextLine();

        System.out.println("Video Publisher :");

        String publisher = sc.nextLine();

        System.out.println("Inserting ,please wait ...");

        int rs = sql.insertNewVideo(new Video(title , duration ,type ,publisher ));

        if(rs == 1 ){
            System.out.println("Inserted successful!");
        }else {
            System.out.println("Insert failed!");
        }
    }

    public static void provideDataForBookDB() {
        System.out.println("* Insert data into book table :");

        System.out.println("Book Title :");

        String title = sc.nextLine();

        System.out.println("Book description :");

        String description = sc.nextLine();

        System.out.println("Book Writer :");

        String writer = sc.nextLine();

        System.out.println("Book Type :");

        String type = sc.nextLine();

        System.out.println("Book Publisher :");

        String publisher = sc.nextLine();

        System.out.println("Book Country :");

        String country = sc.nextLine();

        System.out.println("Inserting ,please wait ...");

        int rs = sql.insertNewBook(new BookOnTape( title,  description,  writer,  type,  publisher,  country));

        if(rs == 1 ){
            System.out.println("Inserted successful!");
        }else {
            System.out.println("Insert failed!");
        }
    }

    public static void provideDataForFurnitureDB() {
        System.out.println("* Insert data into video table :");

        System.out.println("Furniture Name :");

        String name = sc.nextLine();

        System.out.println("Furniture Type :");

        String type = sc.nextLine();

        System.out.println("Furniture Uses :");

        String uses = sc.nextLine();

        System.out.println("Inserting ,please wait ...");

        int rs = sql.insertNewFurniture(new Furniture( name,  type,  uses));

        if(rs == 1 ){
            System.out.println("Inserted successful!");
        }else {
            System.out.println("Insert failed!");
        }
    }

    public static void printAllVideoData () {
        System.out.println("List all video data set");
        ArrayList<Video> listVideos = sql.getAllVideos();

        for (Video video: listVideos
        ) {
            System.out.println(video.getDescription());
        }
    }

    public static void printAllBookData () {
        System.out.println("List all book data set");
        ArrayList<BookOnTape> listBooks = sql.getAllBooks();

        for (BookOnTape book: listBooks
        ) {
            System.out.println(book.getDescription());
        }
    }

    public static void printAllFurnitureData () {

        System.out.println("List all furniture data set");
        ArrayList<Furniture> listFurniture = sql.getAllVFurniture();

        for (Furniture furniture: listFurniture
        ) {
            System.out.println(furniture.getDescription());
        }
    }

    public static void findItem() {
        System.out.println("Quick find information about items you only need their serial number(ID)");

        System.out.println("Provide serial number :");

        String id = sc.nextLine();

        Video v = sql.findVideoById(id);

        BookOnTape b = sql.findBookById(id);

        Furniture f = sql.findFurnitureById(id);

        if(v != null){
            System.out.println("Found !!! Serial number belongs to a video : ");
            System.out.println(v.getDescription());
        }else if(b !=null){
            System.out.println("Found !!! Serial number belongs to a book : ");
            System.out.println(b.getDescription());
        } else if (f != null) {
            System.out.println("Found !!! Serial number belongs to a furniture : ");
            System.out.println(f.getDescription());
        }else if (v == null && b == null && f == null) System.out.println("No record was found with serial number : " + id);
    }
}
