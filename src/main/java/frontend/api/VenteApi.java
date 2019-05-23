package frontend.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import frontend.model.Vente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenteApi implements Api<Vente> {

    private static final String url = "http://localhost:8081/ventes";

    @Autowired
    private ApiService apiService;

    private ObjectMapper mapper;

    public VenteApi() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Vente[] getAll() {
        return mapper.convertValue(apiService.getList(url), new TypeReference<Vente[]>() {
        });
    }

    @Override
    public Vente get(int id) {
        return mapper.convertValue(apiService.get(url + '/' + id), new TypeReference<Vente>() {
        });
    }

    @Override
    public Vente create(Vente entity) throws JsonProcessingException {
        Object data = apiService.post(url, mapper.writeValueAsString(entity));
        return mapper.convertValue(data, new TypeReference<Vente>() {
        });
    }

    @Override
    public Vente edit(Vente entity) throws JsonProcessingException {
        Object data = apiService.put(url + '/' + entity.getId(), mapper.writeValueAsString(entity));
        return mapper.convertValue(data, new TypeReference<Vente>() {
        });
    }

    @Override
    public Vente delete(int id) {
        return null;
    }
}
