package com.cv.tech.framework.value;

import java.io.Serializable;
import java.util.List;

public class JQGridResponse<T extends Serializable> {
	/**
	 * Current page
	 */
	private int page;

	/**
	 * Total pages
	 */
	private int total;

	/**
	 * Total number of records
	 */
	private long records;

	/**
	 * Contains the actual data
	 */
	private List<T> rows;
	
	public JQGridResponse() {
		// TODO Auto-generated constructor stub
	}

	public JQGridResponse(int page, int total, int records,
			List<T> rows) {
		super();
		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = rows;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "JQGridResponse [page=" + page + ", total=" + total
				+ ", records=" + records + ", rows=" + rows + "]";
	}
	
	
}
