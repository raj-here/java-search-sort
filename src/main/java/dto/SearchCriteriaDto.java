package dto;

import java.util.List;

enum SORT_OREDR {
	ASC, DESCC
}

public class SearchCriteriaDto {
	private List<SearchQuery> search;
	private String sort;
	private SORT_OREDR order;

	public List<SearchQuery> getSearch() {
		return search;
	}

	public void setSearch(List<SearchQuery> search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public SORT_OREDR getOrder() {
		return order;
	}

	public void setOrder(SORT_OREDR order) {
		this.order = order;
	}

}
