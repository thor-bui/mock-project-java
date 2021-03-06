package vn.manage.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

	public static ResponseEntity<?> generateResponse(HttpStatus status, Object data) {
		Map<String, Object> map = new HashMap<>();

		map.put("data", data);

		return new ResponseEntity<Object>(map, status);
	}

	public static ResponseEntity<?> generateResponse(HttpStatus status, boolean success) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", success);

		return new ResponseEntity<>(map, status);
	}

	public static ResponseEntity<?> generateResponse(HttpStatus status, Object data, Page<?> pages) {
		Map<String, Object> map = new HashMap<>();

		map.put("totalCount", pages.getTotalElements());
		map.put("data", data);
		map.put("paging",
			new ResponseHandler.PagingAndFilteringResponse(pages.getSize(), pages.getNumber() + 1, pages.getTotalPages()));

		return new ResponseEntity<>(map, status);
	}

	@Data
	@AllArgsConstructor
	private static class PagingAndFilteringResponse {
		private Integer size;
		private Integer currentPage;
		private Integer totalPages;
	}
}
