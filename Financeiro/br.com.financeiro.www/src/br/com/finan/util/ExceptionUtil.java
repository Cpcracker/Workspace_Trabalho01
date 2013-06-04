package br.com.finan.util;

/**
 * @author TecnologiaTi
 * 
 */

public class ExceptionUtil extends Exception {

	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public ExceptionUtil(Exception e) {
		ex = e;
		msg = e.getMessage();
	}

	public ExceptionUtil(Exception e, String mensagem) {
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}

}
