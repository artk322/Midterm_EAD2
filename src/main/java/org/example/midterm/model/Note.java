package org.example.midterm.model;

public class Note {
    private String title;
    private Long id;
    private String date;
    private Boolean status;


    public Note() {
    }


    public Note(String title, Long id, String date, Boolean status) {
        this.title = title;
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}