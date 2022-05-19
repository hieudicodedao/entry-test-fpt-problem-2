package Model;

public class BookOnTape extends Thing{

    private String id ;

    private String title;

    private String descriptions;

    private String writer;

    private String type ;

    private String publisher;

    private String country;

    public BookOnTape(String id, String title, String descriptions, String writer, String type, String publisher, String country) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
        this.writer = writer;
        this.type = type;
        this.publisher = publisher;
        this.country = country;
    }

    public BookOnTape(String title, String descriptions, String writer, String type, String publisher, String country) {
        this.title = title;
        this.descriptions = descriptions;
        this.writer = writer;
        this.type = type;
        this.publisher = publisher;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescription(String description) {
        this.descriptions = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getDescription() {
        return "*------------------------------*\n"+
                "\n ID : " + this.id  +
                "\nTitle : " + this.title +
                "\nDescription : " + this.descriptions +
                "\nWriter : " + this.writer +
                "\nType : " + this.type +
                "\nPublisher : " + this.publisher +
                "\nCountry : " + this.country +
                "\n*------------------------------*";
    }
}
