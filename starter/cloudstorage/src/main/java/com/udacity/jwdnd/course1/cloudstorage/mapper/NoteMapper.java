package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Note> getNotes(Integer userid);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid)" +
            "VALUES (#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    int deleteNote(Integer noteId);
}
