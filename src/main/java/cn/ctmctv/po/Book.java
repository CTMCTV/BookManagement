package cn.ctmctv.po;

public class Book {
    private int id;
    private String name;
    private String author;
    private String price;
    private String description;
    private String bcn;
    private int delete;

    public Book(){

    }

    public Book(String name, String author, String price, String description, String bcn, int delete) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.description = description;
        this.bcn = bcn;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBcn() {
        return bcn;
    }

    public void setBcn(String bcn) {
        this.bcn = bcn;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return name+author+price+description+bcn+delete;
    }
}
