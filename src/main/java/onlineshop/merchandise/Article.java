package onlineshop.merchandise;

/**
 * This class represents an article in the online shop. Each article has a unique article number, a title,
 * a manufacturer, a price, and an image.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */

public class Article {
  private static int articleCounter = 1;
  protected int articleNo;
  protected String title;
  protected String manufacturer;
  protected double price;
  protected String image;

  /**
   * Default constructor that initializes the article with a unique article number.
   */
  public Article() {
    this.articleNo = Article.articleCounter++;
  }

  /**
   * Constructs an article with the specified title and manufacturer.
   *
   * @param title The title of the article.
   * @param manufacturer The manufacturer of the article.
   */
  public Article(String title, String manufacturer) {
    this.title = title;
    this.manufacturer = manufacturer;
  }

  /**
   * Constructs an article with the specified title, manufacturer, price, and image.
   *
   * @param title The title of the article.
   * @param manufacturer The manufacturer of the article.
   * @param price The price of the article.
   * @param image The image URL of the article.
   */
  public Article(String title, String manufacturer, double price, String image) {
    this();
    this.title = title;
    this.manufacturer = manufacturer;
    this.price = price;
    this.image = image;
  }

  /**
   * Gets the image URL of the article.
   *
   * @return The image URL of the article.
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the unique article number.
   *
   * @return The unique article number.
   */
  public int getArticleNo() {
    return articleNo;
  }

  /**
   * Gets the manufacturer of the article.
   *
   * @return The manufacturer of the article.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Sets the manufacturer of the article.
   *
   * @param manufacturer The manufacturer of the article.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Gets the price of the article.
   *
   * @return The price of the article.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Gets the title of the article.
   *
   * @return The title of the article.
   */
  public String getTitle() {
    return title;
  }
}
