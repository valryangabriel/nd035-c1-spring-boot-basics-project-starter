package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;
    private Authentication auth;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
        this.auth = SecurityContextHolder.getContext().getAuthentication();
    }

    public List<Note> getAllNotes() {
        String username = this.auth.getPrincipal().toString();
        System.out.println("notess::::: " + noteMapper.getNotes(username));
        return noteMapper.getNotes(username);
    }


}
