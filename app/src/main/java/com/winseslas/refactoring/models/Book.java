package com.winseslas.refactoring.models;

/**
 * This class represents a book, with its name, description, image URL,
 * number of likes, and whether it is liked or not.
 */
public class Book {

    private String name;             // The name of the book
    private String description;      // The description of the book
    private String imageUrl;         // The URL of the image of the book
    private int numberOfLikes = 0;   // The number of likes of the book
    private boolean isLiked = false; // Whether the book is liked or not

    /**
     * Constructs a new Book object.
     *
     * @param name          The name of the book.
     * @param description   A brief description of the book.
     * @param imageUrl      The URL of the book cover image.
     * @param numberOfLikes The number of likes of the book.
     * @param isLiked       Whether the book is liked
     */
    public Book(String name, String description, String imageUrl, int numberOfLikes,  boolean isLiked) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.numberOfLikes = numberOfLikes;
        this.isLiked = isLiked;

    }

    /**
     * Returns the name of the book.
     *
     * @return the name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the book.
     *
     * @param name the name of the book
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the book.
     *
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book.
     *
     * @param description the description of the book
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the URL of the image of the book.
     *
     * @return the URL of the image of the book
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of the image of the book.
     *
     * @param imageUrl the URL of the image of the book
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Returns the number of likes of the book.
     *
     * @return the number of likes of the book
     */
    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    /**
     * Sets the number of likes of the book.
     *
     * @param numberOfLikes the number of likes of the book
     */
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    /**
     * Returns whether the book is liked or not.
     *
     * @return true if the book is liked, false otherwise
     */
    public boolean isLiked() {
        return isLiked;
    }

    /**
     * Sets whether the book is liked or not.
     *
     * @param liked true if the book is liked, false otherwise
     */
    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
