package Model;

public class Video extends  Thing{

    private String id;

    private String title;

    private String duration;

    private String type ;

    private String publisher;

    public Video(String id, String title, String duration, String type, String publisher) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.type = type;
        this.publisher = publisher;
    }

    public Video(String title, String duration, String type, String publisher) {
        this.title = title;
        this.duration = duration;
        this.type = type;
        this.publisher = publisher;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    @Override
    public String getDescription() {
        return  "*------------------------------*\n"+
                "ID : " + this.id  +
                "\nTitle : " + this.title +
                "\nDuration : " + this.duration +
                "\nType : " + this.type +
                "\nPublisher : " + this.publisher +
                "\n*------------------------------*";
    }
}
