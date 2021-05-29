package com.udacity.jwdnd.course1.cloudstorage.model;

public class NoteForm {
    private String username;
    private String noteTitle;
    private String noteDescription;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
}
