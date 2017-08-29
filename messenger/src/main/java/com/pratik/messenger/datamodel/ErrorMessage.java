package com.pratik.messenger.datamodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errCd;
	private String errMsg;
	private String docs;
	
	// to create instances on the run
	public ErrorMessage(String errCd, String errMsg, String docs) {
		super();
		this.errCd = errCd;
		this.errMsg = errMsg;
		this.docs = docs;
	}
	
	//to serialize and de-serialize
	public ErrorMessage() {
		
	}
	
	
	public String getErrCd() {
		return errCd;
	}
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getDocs() {
		return docs;
	}
	public void setDocs(String docs) {
		this.docs = docs;
	}
	
	
	
}
