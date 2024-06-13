package onlineshop.merchandise;

// TODO: add JavaDoc like in {@link PlantMee}
public class Article {
  private static int articleCounter = 1;
  protected int articleNo;
  protected String title;
  protected String manufacturer;
  protected double price;
  protected String image;

  public Article() {
    this.articleNo = Article.articleCounter++;
  }

  public Article(String title, String manufacturer) {
    this.title = title;
    this.manufacturer = manufacturer;
  }

  public Article(String title, String manufacturer, double price, String image) {
    this();
    this.title = title;
    this.manufacturer = manufacturer;
    this.price = price;
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public int getArticleNo() {
    return articleNo;
  }

  public String getManufacturer() {
    return manufacturer;
  }
  
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public double getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }
}
