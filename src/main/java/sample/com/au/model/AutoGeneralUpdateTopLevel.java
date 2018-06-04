package sample.com.au.model;

public class AutoGeneralUpdateTopLevel {
    int id;
    String createdAt;
    boolean isCompleted;
    String text;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(final boolean completed) {
        isCompleted = completed;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
