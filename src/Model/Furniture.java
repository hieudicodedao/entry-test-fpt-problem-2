package Model;

public class Furniture extends Thing{

    private String id ;

    private String name ;

    private String type;

    private String uses;

    public Furniture(String id, String name, String type, String uses) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.uses = uses;
    }

    public Furniture(String name, String type, String uses) {
        this.name = name;
        this.type = type;
        this.uses = uses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    @Override
    public String getDescription() {
        return "*------------------------------*\n"+
                "\n ID : " + this.id  +
                "\nName : " + this.name +
                "\nType : " + this.type +
                "\nUses : " + this.uses +
                "\n*------------------------------*";
    }
}
