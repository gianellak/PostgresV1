import java.math.BigDecimal;
import java.util.UUID;


public class Registro {

	private String 		idCliente; 
	private Double		monto;
	private String 		tipoOp;
	
	
	
	public Registro(String idCliente, Double monto, String c) {
		super();
		this.idCliente = idCliente;
		this.monto = monto;
		this.tipoOp = c;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double bigDecimal) {
		this.monto = bigDecimal;
	}
	public String getTipoOp() {
		return tipoOp;
	}
	public void setTipoOp(String tipoOp) {
		this.tipoOp = tipoOp;
	}
	

}
