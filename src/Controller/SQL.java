package Controller;

import Model.BookOnTape;
import Model.Furniture;
import Model.Video;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class SQL {

    private Connection con ;

    private static final String SQL_INSERT_VIDEO = "INSERT INTO rrs.video (id , title , duration ,type ,publisher) VALUES (?,?,?,?,?) ";

    private static final String SQL_INSERT_BOOK = "INSERT INTO rrs.book (id , title , description ,writer ,type , publisher ,country) VALUES (?,?,?,?,?,?,?) ";

    private static final String SQL_INSERT_FURNITURE = "INSERT INTO rrs.furniture (id , name , type ,uses) VALUES (?,?,?,?) ";

    private static final String SQL_SELECT_ALL_VIDEO = "SELECT * FROM rrs.video";

    private static final String SQL_SELECT_ALL_BOOK = "SELECT * FROM rrs.book";

    private static final String SQL_SELECT_ALL_FURNITURE = "SELECT * FROM rrs.furniture";

    private static final String SQL_SELECT_VIDEO_BY_ID = "SELECT * FROM rrs.video v WHERE v.id = ? LIMIT 1";

    private static final String SQL_SELECT_BOOK_BY_ID = "SELECT * FROM rrs.book b WHERE b.id = ? LIMIT 1";

    private static final String SQL_SELECT_FURNITURE_BY_ID = "SELECT * FROM rrs.furniture f WHERE f.id = ? LIMIT 1";

    public SQL(Connection con) {
        this.con = con;
    }

    public String randomSerialId(){

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();

        return randomString;
    }

    public int insertNewVideo(Video video) {

        try(PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_VIDEO)) {

            preparedStatement.setString(1, "video_" + randomSerialId() );
            preparedStatement.setString(2, video.getTitle());
            preparedStatement.setString(3, video.getDuration());
            preparedStatement.setString(4, video.getType());
            preparedStatement.setString(5, video.getPublisher());

            int row = preparedStatement.executeUpdate();

            return row;

        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }

    public int insertNewBook(BookOnTape book) {

        try(PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_BOOK)) {

            preparedStatement.setString(1, "book_" + randomSerialId() );
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getDescriptions() );
            preparedStatement.setString(4, book.getWriter());
            preparedStatement.setString(5, book.getType());
            preparedStatement.setString(6, book.getPublisher());
            preparedStatement.setString(7, book.getCountry());

            int row = preparedStatement.executeUpdate();

            return row;

        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }

    public int insertNewFurniture(Furniture furniture) {

        try(PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_FURNITURE)) {

            preparedStatement.setString(1, "furniture_" + randomSerialId() );
            preparedStatement.setString(2, furniture.getName());
            preparedStatement.setString(3, furniture.getType() );
            preparedStatement.setString(4, furniture.getUses());

            int row = preparedStatement.executeUpdate();

            return row;

        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }

    public ArrayList<Video> getAllVideos(){

        ArrayList<Video> listVideo = new ArrayList<>();

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_VIDEO);) {

            while(rs.next()){

                String id  = rs.getString("id");

                String title  = rs.getString("title");

                String duration  = rs.getString("duration");

                String type  = rs.getString("type");

                String publisher  = rs.getString("publisher");

                listVideo.add(new Video(id , title ,duration ,type ,publisher));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listVideo;
    }

    public ArrayList<BookOnTape> getAllBooks(){

        ArrayList<BookOnTape> listBooks = new ArrayList<>();

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_BOOK);) {

            while(rs.next()){

                String id  = rs.getString("id");

                String title  = rs.getString("title");

                String description  = rs.getString("description");

                String writer  = rs.getString("writer");

                String type  = rs.getString("type");

                String publisher  = rs.getString("publisher");

                String country  = rs.getString("country");

                listBooks.add(new BookOnTape(id , title ,description , writer ,type ,publisher ,country));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listBooks;
    }


    public ArrayList<Furniture> getAllVFurniture(){

        ArrayList<Furniture> listFurniture = new ArrayList<>();

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_FURNITURE);) {

            while(rs.next()){

                String id  = rs.getString("id");

                String name  = rs.getString("name");

                String type  = rs.getString("type");

                String uses  = rs.getString("uses");

                listFurniture.add(new Furniture(id , name ,type ,uses ));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listFurniture;
    }

    public Video findVideoById (String id) {
        Video video = null ;

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL_SELECT_VIDEO_BY_ID)) {
            preparedStatement.setString(1 , id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                String idT = rs.getString("id");

                String title = rs.getString("title");

                String duration = rs.getString("duration");

                String type = rs.getString("type");

                String publisher = rs.getString("publisher");

                video = new Video(idT , title , duration ,type ,publisher);
            }
        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return video;
    }

    public BookOnTape findBookById (String id) {
        BookOnTape book = null ;

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL_SELECT_BOOK_BY_ID)) {
            preparedStatement.setString(1 , id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                String idT = rs.getString("id");

                String title = rs.getString("title");

                String description = rs.getString("description");

                String writer = rs.getString("writer");

                String type = rs.getString("type");

                String publisher = rs.getString("publisher");

                String country = rs.getString("country");

                book = new BookOnTape(idT , title , description ,writer ,type ,publisher ,country);
            }
        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return book;
    }

    public Furniture findFurnitureById (String id) {
        Furniture furniture = null ;

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL_SELECT_FURNITURE_BY_ID)) {
            preparedStatement.setString(1 , id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                String idT = rs.getString("id");

                String name = rs.getString("name");

                String type = rs.getString("type");

                String uses = rs.getString("uses");

                furniture = new Furniture(idT , name , type , uses);
            }
        }
        catch (SQLException e){

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return furniture;
    }

}
