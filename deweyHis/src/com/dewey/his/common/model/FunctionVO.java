package com.dewey.his.common.model;

import java.util.List;

/**
 * 系统功能菜单
 * @author Administrator
 *
 */
public class FunctionVO{

	// 功能Id
	private String id;

	// 功能名称
	private String text;

	/**
	 * 选择状态
	 * 		0：未选
	 * 		1：已选
	 * 		2：半选
	 */
	// 用户是否拥有该功能
	private String checked;
	
	// 功能是否是快捷功能
	private boolean isQuickMenu;
	
	// 功能是否是叶子节点功能
	private boolean isLeaf;

	// 父功能ID
	private String pid;

	// 子功能列表
	private List<FunctionVO> children;
	
	// 功能链接
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
