package com.dewey.his.common.model;

import java.util.List;

/**
 * ϵͳ���ܲ˵�
 * @author Administrator
 *
 */
public class FunctionVO{

	// ����Id
	private String id;

	// ��������
	private String text;

	/**
	 * ѡ��״̬
	 * 		0��δѡ
	 * 		1����ѡ
	 * 		2����ѡ
	 */
	// �û��Ƿ�ӵ�иù���
	private String checked;
	
	// �����Ƿ��ǿ�ݹ���
	private boolean isQuickMenu;
	
	// �����Ƿ���Ҷ�ӽڵ㹦��
	private boolean isLeaf;

	// ������ID
	private String pid;

	// �ӹ����б�
	private List<FunctionVO> children;
	
	// ��������
	private String url;

	public FunctionVO() {
	}

	public FunctionVO(String id, String text, String checked, String pid, String url, boolean isQuickMenu, boolean isLeaf, List<FunctionVO> children) {
		super();
		this.id = id;
		this.text = text;
		this.checked = checked;
		this.pid = pid;
		this.url = url;
		this.isQuickMenu = isQuickMenu;
		this.isLeaf = isLeaf;
		this.children = children;
	}
    
    public String toString() { 
        return id + " " + text;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public List<FunctionVO> getChildren() {
		return children;
	}

	public void setChildren(List<FunctionVO> children) {
		this.children = children;
	}
	
	public boolean isQuickMenu() {
		return isQuickMenu;
	}

	public void setQuickMenu(boolean isQuickMenu) {
		this.isQuickMenu = isQuickMenu;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
