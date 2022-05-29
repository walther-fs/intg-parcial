package parcial.isil.resource;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseResource <T,ID>{
    ResponseEntity<T> get(ID id);
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> post(T t);
    ResponseEntity<T> put(T t, ID id);
    ResponseEntity<?> delete(ID id);
}
