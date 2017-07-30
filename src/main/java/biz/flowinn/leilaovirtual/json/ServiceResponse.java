package biz.flowinn.leilaovirtual.json;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import biz.flowinn.leilaovirtual.vo.ItemVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result",
    "comments",
    "item",
    "allItems"
})
@XmlRootElement(name = "ServiceResponse")
public class ServiceResponse {
	
	public static final String SUCCESS = "OK";

	@XmlElement(required = false)
    protected String result;
	
    @XmlElement(required = false)
    protected String comments;
    
    @XmlElement(required = false)
    protected ItemVO item;
    
    @XmlElement(required = false)
    protected Set<ItemVO> allItems;
    
    
    
    
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ItemVO getItem() {
		return item;
	}
	public void setItem(ItemVO item) {
		this.item = item;
	}
	public Set<ItemVO> getAllItems() {
		return allItems;
	}
	public void setAllItems(Set<ItemVO> allItems) {
		this.allItems = allItems;
	}
    
    
    
    
}
