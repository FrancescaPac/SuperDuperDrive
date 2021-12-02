package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES")
    List<Note> allNotes();

    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    Note getNoteByUserId(Integer userId);

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    Note getNoteByNoteId(Integer noteId);

    @Insert("INSERT INTO NOTES ( notetitle, notedescription, userid) VALUES( #{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNewNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteId = #{noteid}")
    public int deleteNote(int noteId);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} " +
            "WHERE noteid = #{noteId}")
    public int updateNote(Note notes);
}

