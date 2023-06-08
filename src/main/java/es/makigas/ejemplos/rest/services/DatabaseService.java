package es.makigas.ejemplos.rest.services;

import es.makigas.ejemplos.rest.dao.CRUD;
import es.makigas.ejemplos.rest.dao.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

class DatabaseService<M> implements CRUD<M> {

	@PersistenceContext(name = "application")
    private EntityManager manager;
    
    private Class<M> targetClass;
    
    private String entityName;
    
    public DatabaseService(Class<M> target, String entityName) {
        this.targetClass = target;
        this.entityName = entityName;
    }
    
    class QueryBuilder implements Query<M> {
        
        private int page = 1;
        
        private int limit = 10;

        @Override
        public Query<M> page(int pag) {
            this.page = pag;
            return this;
        }

        @Override
        public Query<M> limit(int limit) {
            this.limit = limit;
            return this;
        }

        @Override
        public List<M> get() {
            String query = "SELECT e FROM {e} e".replace("{e}", entityName);
            int offset = (page - 1) * limit;
            return (List<M>) manager.createQuery(query)
                    .setMaxResults(limit)
                    .setFirstResult(offset)
                    .getResultList();
            
        }
        
    }
    
    @Override
    public Query<M> list() {
        return new QueryBuilder();
    }

    @Override
    public Optional<M> get(Object id) {
        M entity = manager.find(this.targetClass, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public M insert(M model) { 
    	manager.persist(model);
        return model;
    }

    @Override
    public void update(M model) {
    	manager.merge(model);
    }

    @Override
    public void delete(M model) {
    	manager.remove(model);
    }
    
}
