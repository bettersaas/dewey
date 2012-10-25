package common.base.model.vo;

import java.util.List;

public class PagerVO{
	
	/* ��ʾ�ڼ�ҳ��ҳ�� */
	private Integer pageNo=1;
	
	/* ҳ��С��ҳ��¼���� */
	private Integer pageSize=10;    private Integer limit=10;     // pageSizeͬ���
	
	// ��ǰҳ��¼��
	private int currentPageSize = 0;

	// ��ҳ
	private int firstPage = 1;

	// ��ҳ
	private int prePage = 0;

	// ��ҳ
	private int nextPage = 0;

	// ĩҳ
	private int lastPage = 0;

	// �б�
	private List<?> pagerList = null;
	
	// �ӵڼ�����¼��ʼ
	private Integer offset;     // startRowͬ���
	
	/* ��ҳ��     -1ʱ�������ҳ�� */
	private Integer pageCount=0;
	
	/* �ܼ�¼��   */
	private Integer countAll = null;
	
	// ��ѯsql���
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
		return ("��ҳ��ѯ��Ϣ��countAll[" + countAll +"]pageNo[" +pageNo+ "]pageSize[" +pageSize+ "]pageCount[" +pageCount+ "]");
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getCountAll(){
		// �ܼ�¼��δ֪
		if (countAll == null) {
			return 0;
		}
		return countAll;
	}

	public void setCountAll(Integer countAll) {
		this.countAll = countAll;
		if (countAll != null) {
			// ����ҳ��
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
		// �����ҳ�ǵ�ǰҳ,����Ϊ��Чҳ��
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
		// ���ĩҳ�ǵ�ǰҳ,����Ϊ��Чҳ��
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