package teamProject.food114.model;

public class Addr {
	private String addrNo;
	private String userId;
	private String addrAs;
	private String oldAddr;
	private String newAddr;
	private String detail;
	private String request;
	private String phone;
	public String getRequest() {
		return request;
	}
	public String getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(String addrNo) {
		this.addrNo = addrNo;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String defaultYn;
	public String getOldAddr() {
		return oldAddr;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setOldAddr(String oldAddr) {
		this.oldAddr = oldAddr;
	}
	public String getNewAddr() {
		return newAddr;
	}
	public void setNewAddr(String newAddr) {
		this.newAddr = newAddr;
	}
}
