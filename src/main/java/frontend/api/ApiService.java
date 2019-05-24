package frontend.api;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApiService {

	List getList(String url,@Nullable Map<String,String> filters) {
		ResponseEntity<String> response = sendRequest(url, HttpMethod.GET, null,filters);
		List<Object> data = new JacksonJsonParser().parseList(response.getBody());
		return (List) data;
	}

	Object get(String url) {
		ResponseEntity<String> response = sendRequest(url, HttpMethod.GET, null,null);
		Map<String, Object> data = new JacksonJsonParser().parseMap(response.getBody());
		return data;
	}

	Object put(String url, String entity) {
		ResponseEntity<String> response = sendRequest(url, HttpMethod.PUT, entity,null);
		return new JacksonJsonParser().parseMap(response.getBody());
	}

	Object post(String url, String entity) {
		ResponseEntity<String> response = sendRequest(url, HttpMethod.POST, entity,null);
		return new JacksonJsonParser().parseMap(response.getBody());
	}

	/**
	 * Send a request to an API endpoint.
	 *
	 * @param url : endpoint
	 * @return ResponseEntity with Body as String
	 */
	private ResponseEntity<String> sendRequest(String url, HttpMethod method, @Nullable String body,@Nullable Map<String,String> filters) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity;
		entity = body == null ? new HttpEntity<>(headers) : new HttpEntity<>(body, headers);

		RestTemplate restTemplate = new RestTemplate();

		
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if (filters != null) {
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue().replace(' ', '+'));
            }
        }
		return restTemplate.exchange(builder.toUriString(), method, entity, String.class);
	}
}
