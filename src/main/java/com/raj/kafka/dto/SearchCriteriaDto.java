package com.raj.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {
	private Integer pageNumber=0;
	private Integer pageSize;
	private List<SearchQuery> search;
	private String sort;
	private String order;

}
