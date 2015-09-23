package py.com.anguja.historico_obra.dto;

public class Respuesta {

	private String message;
	private Boolean success;
	
	public Respuesta(){
		
	}
	
	public Respuesta(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String menssage) {
		this.message = menssage;
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}


}
