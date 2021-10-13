import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Card.java
 * A card has a suit (spade, heart, diamond, club) and a face (ace, 2, 3, ..., 10, Jack, Queen, King).
 * This class provides methods for drawing and constructing a card.
 *
 * @author  Jake Wilson
 * @version Mar 15, 2014
 */
public class Card {
  
  private String suit;
  private String face;
  
  private BufferedImage suitImg;
  
  private Color color;
  private Font  font;
  
  private int cornerX, cornerY;
  private int rightX;
  private int bottomY;
  
  public static final int HEIGHT = 100, WIDTH = 60;
  
  /**
   * All possible suits a card may have
   */
  public static final String[] SUITS = {"S", "H", "D", "C"};
  
  /**
   * All possible face values a card may have
   */
  public static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  
  public boolean faceDown;
  
  /**
   * No-arg constructor that initializes the card to the Ace of Spades
   */
  public Card() {
    this("A", "S");
  }
  
  /**
   * Constructor that suits the card suit to s and the card face to f and the location to (0, 0)
   * @param s the suit of the card
   * @param f the face of the card
   */
  public Card(String s, String f) {
    this(s, f, 0, 0);
  }
  
  /**
   * Constructor that initializes all variables to passed in parameters
   * 
   * @param f the face of the card
   * @param s the suit of the card
   * @param x the top-left x coordinate of the card
   * @param y the top-left y coordinate of the card
   */
  public Card(String f, String s, int x, int y) {
    setFace(f);
    setSuit(s);
    setLocation(x, y);
    if (!initImage()) {
      // TODO: quit the game here somehow
    }
    faceDown = true;
    font = new Font("Courier New", Font.BOLD, 20);
  }
  
  /**
   * Draws the card to a graphics context
   * @param g the graphics context to draw the card on
   */
  public void draw(Graphics g) {
    if (!faceDown) {
      g.setColor(Color.white);
      g.fillRect(cornerX, cornerY, WIDTH, HEIGHT);
      //g.fillRoundRect(cornerX, cornerY, WIDTH, HEIGHT, 10, 10);
      g.setColor(color);
      g.setFont(font);
      g.drawString(face  , cornerX + 3, cornerY + 20);
      g.drawImage(suitImg, cornerX + 6, cornerY + 26, null);
    } else { // draw the back of the card
      g.setColor(new Color(156, 14, 23));
      g.fillRect(cornerX, cornerY, WIDTH, HEIGHT);
      //g.fillRoundRect(cornerX, cornerY, WIDTH, HEIGHT, 10, 10);
    }
    g.setColor(Color.black);
    g.drawRoundRect(cornerX, cornerY, WIDTH, HEIGHT, 10, 10);
  }
  
  /**
   * Initializes the suit and face images of the card depending on what suit and face the card is
   * @return whether the image initialization was successful
   */
  private boolean initImage() {
    boolean success = true;
    try {
      switch (suit) {
      case "S":
        suitImg = ImageIO.read(new File("resources/spade.png"));
        color   = Color.black;
        break;
      case "H":
        suitImg = ImageIO.read(new File("resources/heart.png"));
        color   = Color.red;
        break;
      case "D":
        suitImg = ImageIO.read(new File("resources/diamond.png"));
        color   = Color.red;
        break;
      case "C":
        suitImg = ImageIO.read(new File("resources/club.png"));
        color   = Color.black;
        break;
      default: // should be impossible
        success = false;
      }
    } catch (IOException ioex) {
      System.out.println("Error reading image.");
      success = false;
    }
    
    return success;
  }
  
  /**
   * Sets the suit to s if it's valid
   * @param s the new suit
   */
  private void setSuit(String s) {
    if (isValidSuit(s))
      suit = s;
  }
  
  /**
   * Sets the face to s if it's valid
   * @param s the new face
   */
  private void setFace(String s) {
    if (isValidFace(s))
      face = s;
  }
  
  /**
   * Determines if the passed in suit is valid
   * @param s the suit
   * @return whether s is valid
   */
  private boolean isValidSuit(String s) {
    boolean valid = false;
    for (int i = 0; i < SUITS.length; i++) {
      if (s.equals(SUITS[i])) {
        valid = true;
        break;
      }
    }
    
    return valid;
  }
  
  /**
   * Determines if the passed in face is valid
   * @param s the face
   * @return whether s is valid
   */
  private boolean isValidFace(String s) {
    boolean valid = false;
    for (int i = 0; i < FACES.length; i++) {
      if (s.equals(FACES[i])) {
        valid = true;
        break;
      }
    }
    
    return valid;
  }
  
  /**
   * @return the card suit
   */
  public String getSuit() {
    return suit;
  }
  
  /**
   * @return the card face
   */
  public String getFace() {
    return face;
  }
  
  /**
   * Returns the index in the faces array of the passed in the string
   * @param s the string to check
   * @return the index in the faces array of s or -1 if not found
   */
  public static int getFaceIndex(String s) {
    for (int i = 0; i < FACES.length; i++)
      if (s.equals(FACES[i])) return i;
    
    return -1;
  }
  
  /**
   * Returns the index in the suits array of the passed in the string
   * @param s the string to check
   * @return the index in the suits array of s or -1 if not found
   */
  public static int getSuitIndex(String s) {
    for (int i = 0; i < SUITS.length; i++)
      if (s.equals(SUITS[i])) return i;
    
    return -1;
  }
  
  /**
   * @return the top left x coordinate of the card
   */
  public int getX() {
    return cornerX;
  }
  
  /**
   * @return the top left y coordinate of the card
   */
  public int getY() {
    return cornerY;
  }
  
  /**
   * @return the x coordinate of the right side of the card
   */
  public int getRightX() {
    return rightX;
  }
  
  /**
   * @return the y coordinate of the bottom of the card
   */
  public int getBottomY() {
    return bottomY;
  }
  
  /**
   * Sets the top left corner of the card to (x, y)
   * @param x the top-left x coordinate of the card
   * @param y the top-left y coordinate of the card
   */
  public void setLocation(int x, int y) {
    cornerX = x;
    cornerY = y;
    assignVertices();
  }
  
  /**
   * @return the string: "<face> of <suit>"
   */
  public String toString() {
    return face + " of " + suit;
  }
  
  /**
   * Checks whether the suit and face of two cards match
   * @param c the card to check for equality
   * @return whether this card and c have the same suit and face
   */
  public boolean equals(Card c) {
    return c.getSuit().equals(this.suit) && c.getFace().equals(this.face);
  }
  
  /**
   * Assigns the rightX and bottomY vertices based on the top left corner location
   */
  private void assignVertices() {
    rightX = cornerX + WIDTH;
    bottomY   = cornerY + HEIGHT;
  }
  
  /**
   * @return the color of the card
   */
  public Color getColor() {
    return color;
  }

}
