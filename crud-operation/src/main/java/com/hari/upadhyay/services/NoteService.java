package com.hari.upadhyay.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.upadhyay.entity.Note;
import com.hari.upadhyay.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	NoteRepository noteRepository;
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
    }
	
	public Note update(Note note) {
		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}


	public Note save(Note note) {
		return noteRepository.save(note);
	}


	public Optional<Note> findById(Long noteId) {
		return noteRepository.findById(noteId);
	}


	public List<Note> findAll() {
		return noteRepository.findAll();
	}


	public void delete(Note note) {
		noteRepository.delete(note);		
	}


	}
	


	