package ma.youcode.majesticcup.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T, RES, REQ> {
    Page<RES> readAll(Pageable pageable);
    List<RES> readAll();
     RES read(String id);
     void delete(String id);
    RES create(REQ req);
    RES update(String id,REQ req);
    T getById(String id);
}
