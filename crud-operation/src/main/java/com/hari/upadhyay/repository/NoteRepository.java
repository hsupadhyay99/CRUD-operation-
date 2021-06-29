package com.hari.upadhyay.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.upadhyay.entity.Note;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}