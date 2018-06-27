package exception;

public class ProjectException extends RuntimeException {
	
	private String url;
	
	public ProjectException(String msg, String url) {
		super(msg);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
}
