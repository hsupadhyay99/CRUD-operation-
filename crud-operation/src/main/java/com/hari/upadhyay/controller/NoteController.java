package com.hari.upadhyay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hari.upadhyay.entity.Note;
import com.hari.upadhyay.exception.ResourceNotFoundException;
import com.hari.upadhyay.repository.NoteRepository;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;

	@GetMapping("/")
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	@PostMapping("/")
	public Note createNote(@RequestBody Note note) {
		return noteRepository.save(note);
	}

	@GetMapping("/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	@PutMapping("/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId, @RequestBody Note noteDetails) {

		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());

		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		noteRepository.delete(note);

		return ResponseEntity.ok().build();
	}
}