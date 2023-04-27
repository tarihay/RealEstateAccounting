package ru.nsu.gorin.db.realestateaccounting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.gorin.db.realestateaccounting.model.dto.ObjectDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.QuestionDTO;
import ru.nsu.gorin.db.realestateaccounting.service.ObjectService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/objects")
@RequiredArgsConstructor
public class ObjectController {

    private final ObjectService objectService;


    @PostMapping("/new")
    public ResponseEntity<Integer> createObject(@RequestBody ObjectDTO dto) {
        return new ResponseEntity<>(objectService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<HttpStatus> updateObject(@PathVariable Integer id, @RequestBody ObjectDTO dto) {
        objectService.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> deleteObject(@PathVariable Integer id) {
        objectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<ObjectDTO> getEmptyObject() {
        return new ResponseEntity<>(objectService.getNewObject(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDTO> getObject(@PathVariable Integer id) {
        return new ResponseEntity<>(objectService.getObject(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ObjectDTO>> getObjects(@RequestParam Integer amount, @RequestParam Integer skip) {
        return new ResponseEntity<>(objectService.getObjects(amount, skip), HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalCount() {
        return new ResponseEntity<>(objectService.getTotalCount(), HttpStatus.OK);
    }

    @PostMapping("/{objectId}/question/new")
    public ResponseEntity<HttpStatus> addQuestion(@PathVariable Integer objectId, @RequestBody QuestionDTO dto) {
        objectService.createQuestion(objectId, dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{objectId}/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions(@PathVariable Integer objectId) {
        return new ResponseEntity<>(objectService.getQuestions(objectId), HttpStatus.OK);
    }
}
