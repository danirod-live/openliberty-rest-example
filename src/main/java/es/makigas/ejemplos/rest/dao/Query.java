package es.makigas.ejemplos.rest.dao;

import java.util.List;

public interface Query<T>
{    
    Query<T> page(int pag);
    
    Query<T> limit(int limit);
    
    List<T> get();
    
}
