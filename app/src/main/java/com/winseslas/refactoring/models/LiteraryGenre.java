package com.winseslas.refactoring.models;

/**
 * Represents a literary genre.
 * @author Winseslas
 */
public class LiteraryGenre {
    private String name;
    private String description;

    /**
     * Constructs a new literary genre object with the specified name and description.
     *
     * @param name the name of the genre
     * @param description the description of the genre
     */
    public LiteraryGenre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the name of the genre.
     *
     * @return the name of the genre
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the genre.
     *
     * @param name the name of the genre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the genre.
     *
     * @return the description of the genre
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the genre.
     *
     * @param description the description of the genre
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
