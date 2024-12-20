package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.senane.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.services.GenericService;
import ma.youcode.majesticcup.services.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static ma.senane.utilities.response.Response.success;

@RequiredArgsConstructor
public abstract class GenericController<T ,RES , REQ> {

    protected final GenericService<T, RES, REQ> genericService;
    protected final Class<T> entityClass;

    @GetMapping("/get/{id}")
    public ResponseEntity<SuccessDTO> handleRead(@PathVariable String id ) {
        RES resDTO =  genericService.read(id);
        return success(200, getClassName() +" retrieved successfully.", getClassName().toLowerCase() , resDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<SuccessDTO> handleReadAll(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RES> responseDTO =  genericService.readAll(pageable);
        return success(200, getClassName() +" retrieved successfully.", String.format("%ss", getClassName().toLowerCase() ), responseDTO);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> handleCreate(@RequestBody @Validated(OnCreate.class) REQ request) {
        RES responseDTO =  genericService.create(request);
        return success(201, getClassName() +" created successfully.", getClassName().toLowerCase() ,responseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SuccessDTO> handleUpdate(@PathVariable("id") String id, @RequestBody REQ request) {
        RES resDTO = genericService.update( id , request);
        return success(200, getClassName() +" updated successfully.", getClassName().toLowerCase() , resDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessDTO> handleDelete(@PathVariable("id") String id) {
        genericService.delete(id);
        return success(200, getClassName() +" deleted successfully.");
    }

    private String getClassName() {
        return entityClass.getSimpleName();
    }
}
