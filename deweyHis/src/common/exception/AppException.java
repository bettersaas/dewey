package common.exception;

public class AppException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4831869270005804023L;

	private Object[] args;
    
    private String errorCode;
	
    public AppException (String errorCode) {
        this.errorCode = errorCode;
    }
    
    public AppException(String errorCode, String args0) {
        this(errorCode, new Object[]{args0});
    }
    
    public AppException(String errorCode, Object[] args) {
        this.errorCode = errorCode;
        this.args = args;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
