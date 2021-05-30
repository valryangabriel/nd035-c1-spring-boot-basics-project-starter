package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private User user;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    private Authentication auth;


    public NoteService(NoteMapper noteMapper, UserMapper userMapper) {
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
        this.auth = SecurityContextHolder.getContext().getAuthentication();
    }

    public List<Note> getAllNotes(String username) {
        User user = userMapper.getUser(username);
        return noteMapper.getNotes(user.getUserId());
    }

    public NoteForm getNote(Integer id) {
        return noteMapper.getNote(id);
    }

    public String getUserName() {
        return this.auth.getPrincipal().toString();
    }

    public int createNote(NoteForm noteForm) {
        User user = userMapper.getUser(noteForm.getUsername());
        return noteMapper.createNote(new Note(null ,noteForm.getNoteTitle(), noteForm.getNoteDescription(), user.getUserId()));
    }

    public void deleteNote(Integer id) {
        noteMapper.deleteNote(id);
    }


}
