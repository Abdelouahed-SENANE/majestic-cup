package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import ma.senane.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.exceptions.custom.NoContentException;
import ma.youcode.majesticcup.services.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public abstract class GenericServiceImpl<T , RES , REQ> implements GenericService<T, RES , REQ> {

    private final MongoRepository<T, String> genericRepository;
    private final GenericMapper<T, RES , REQ> genericMapper;
    private final Class<T> classEntity;


    public Page<RES> readAll(Pageable pageable) {
        Page<T> page = genericRepository.findAll(pageable);

        if (page.getContent().isEmpty()) {
            throw new NoContentException(getClassName()+"s");
        }

        return page.map(genericMapper::toResponseDTO);
    }

    public List<RES> readAll( ) {
        return genericMapper.toResponseDTOs(genericRepository.findAll());
    }

    public RES read(String id) {
        return genericMapper.toResponseDTO(getEntity(id));
    }

    public void delete(String id) {
        T entity = getEntity(id);
        genericRepository.delete(entity);
    }

    @Override
    public T getById(String id) {
        return genericRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("%s not found", getClassName())));
    }

    public T getEntity(String id) {
        return genericRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(getClassName()+" not found."));
    }


    private String getClassName() {
        return classEntity.getSimpleName();
    }
}
