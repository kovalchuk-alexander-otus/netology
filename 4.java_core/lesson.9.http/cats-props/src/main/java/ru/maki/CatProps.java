package ru.maki;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatProps {
    private String id;
    private String text;
    private Pets pets;
    private String user;
    private int upvotes;

    public CatProps(@JsonProperty("id") String id,
                    @JsonProperty("text") String text,
                    @JsonProperty("type") Pets pets,
                    @JsonProperty("user") String user,
                    @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.pets = pets;
        this.user = user;
        this.upvotes = upvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "CatProps{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pets=" + pets +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
