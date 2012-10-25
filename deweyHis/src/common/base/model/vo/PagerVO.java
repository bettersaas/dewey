package common.base.model.vo;

import java.util.List;

public class PagerVO{
	
	/* 显示第几页或页码 */
	private Integer pageNo=1;
	
	/* 页大小或页记录行数 */
	private Integer pageSize=10;    private Integer limit=10;     // pageSize同义词
	
	// 当前页记录数
	private int currentPageSize = 0;

	// 首页
	private int firstPage = 1;

	// 上页
	private int prePage = 0;

	// 下页
	private int nextPage = 0;

	// 末页
	private int lastPage = 0;

	// 列表
	private List<?> pagerList = null;
	
	// 从第几条记录开始
	private Integer offset;     // startRow同义词
	
	/* 总页数     -1时需带回总页数 */
	private Integer pageCount=0;
	
	/* 总记录数   */
	private Integer countAll = null;
	
	// 查询sql语句
	private String sql = null;
	
	public PagerVO() {
		super();
	}
	
	public PagerVO(Integer pageNo, Integer pageSize) {
		super();
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
	}
	
	public PagerVO(Integer pageNo, Integer pageSize, Integer countAll) {
		super();
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
		this.setCountAll(countAll);
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public String toString() {
		return ("分页查询信息：countAll[" + countAll +"]pageNo[" +pageNo+ "]pageSize[" +pageSize+ "]pageCount[" +pageCount+ "]");
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getCountAll(){
		// 总记录数未知
		if (countAll == null) {
			return 0;
		}
		return countAll;
	}

	public void setCountAll(Integer countAll) {
		this.countAll = countAll;
		if (countAll != null) {
			// 求总页数
			this.pageCount = countAll % pageSize == 0 ? countAll/pageSize : countAll/pageSize + 1;
			// this.pageCount = countAll/pageSize+(countAll%pageSize>0?1:0);
		}
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = this.limit = pageSize;
	}

	public Integer getOffset() {
		this.offset = (this.pageNo - 1) * this.pageSize;
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPageSize() {
		if (pagerList != null) {
			this.currentPageSize = pagerList.size();
		} else {
			this.currentPageSize = 0;
		}
		return currentPageSize;
	}

	public void setCurrentPageSize(int currentPageSize) {
		this.currentPageSize = currentPageSize;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		// 如果首页是当前页,则置为无效页号
		if (firstPage == this.pageNo) {
			firstPage = 0;
		}
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		this.prePage = this.getPageNo() - 1;
		return prePage;
	}

	public void setPrePage(int prePage) {
		if (prePage < 1) {
			prePage = 0;
		}
		this.prePage = prePage;
	}

	public int getNextPage() {
		this.nextPage = this.getPageNo() + 1;
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		this.lastPage= this.getPageCount();
		return lastPage;
	}

	public List<?> getPagerList() {
		return pagerList;
	}

	public void setPagerList(List<?> pagerList) {
		this.pagerList = pagerList;
	}

	public void setLastPage(int lastPage) {
		// 如果末页是当前页,则置为无效页号
		if (lastPage == this.pageNo) {
			lastPage = 0;
		}
		this.lastPage = lastPage;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}