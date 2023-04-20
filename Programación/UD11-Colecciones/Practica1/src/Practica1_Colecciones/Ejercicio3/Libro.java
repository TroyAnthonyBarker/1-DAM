package Practica1_Colecciones.Ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Libro {
    private String title;
    private String author;
    private LocalDate postingDate;
    private LocalDate releaseDate;

    private String language;

    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, u", Locale.ENGLISH);

    public Libro(String title, String author, String postingDate, String releaseDate, String language) {
        String[] temp = releaseDate.split(" ");
        String[] temp2 = postingDate.split(" ");
        if (temp.length >= 3) {
            if (!temp[1].matches("\\d+,")) temp[1] = "1,";
            if (!temp[2].matches("\\d+")) temp[2] = "2000";
            releaseDate = temp[0] + " " + temp[1] + " " + temp[2];
        }
        else releaseDate = "January 1, 2000";
        if (temp2.length >= 3) {
            if (!temp2[1].matches("\\d+,")) temp2[1] = "1,";
            if (!temp2[2].matches("\\d+")) temp2[2] = "2000";
            postingDate = temp2[0] + " " + temp2[1] + " " + temp2[2];
        }
        else releaseDate = "January 1, 2000";
        this.title = title.trim();
        this.author = author.trim();
        this.postingDate = LocalDate.parse(postingDate, dateFormat);
        this.releaseDate = LocalDate.parse(releaseDate, dateFormat);
        this.language = language.trim();
    }

    public Libro(String title, String author, String releaseDate, String language) {
        String[] temp = releaseDate.split(" ");
        if (temp.length >= 3) {
            if (!temp[1].matches("\\d+,")) temp[1] = "1,";
            if (!temp[2].matches("\\d+")) temp[2] = "2000";
            releaseDate = temp[0] + " " + temp[1] + " " + temp[2];
        }
        else releaseDate = "January 1, 2000";
        this.title = title.trim();
        this.author = author.trim();
        this.releaseDate = LocalDate.parse(releaseDate.trim(), dateFormat);
        this.language = language.trim();
    }

    @Override
    public String toString() {
        String postingDate, releaseDate;
        if (this.releaseDate != null) releaseDate = this.releaseDate.format(dateFormat);
        else releaseDate = "No info";
        if (this.postingDate != null) postingDate = this.postingDate.format(dateFormat);
        else postingDate = "No info";

        return "Title: " + title + ", Author: " + author + ", PostingDate: " + postingDate + ", releaseDate: " + releaseDate + ", language: " + language;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPostingDate() {
        if (postingDate == null) return LocalDate.of(1, 1, 1);
        return postingDate;
    }

    public LocalDate getReleaseDate() {
        if (postingDate == null) return LocalDate.of(1, 1, 1);
        return releaseDate;
    }

    public String getLanguage() {
        return language;
    }
}
