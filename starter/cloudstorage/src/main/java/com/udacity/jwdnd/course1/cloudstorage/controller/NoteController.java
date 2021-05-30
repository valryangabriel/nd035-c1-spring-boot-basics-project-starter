package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("home/notes/")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String createNote(@ModelAttribute("noteForm") NoteForm noteForm, Authentication auth, Model model) {
        noteForm.setUsername(auth.getName());
        this.noteService.createNote(noteForm);
        model.addAttribute("notes", noteService.getAllNotes(auth.getName()));
        return "home";
    }

    @GetMapping("edit/{noteId}")
    public String editNote(@PathParam("noteId") Integer noteId, Model model) {
        model.addAttribute("noteForm", noteService.getNote(noteId));
        return "edit-note";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable("id") Integer id, Authentication auth, Model model) {
        noteService.deleteNote(id);
    }
}
