import java.io.Serializable;

public class Productes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idProd;
	private String descProd;
	private int amountProd;
	private double unitPrice;
    
        public Productes() {}
	
	public Productes(int idProd, String descProd, int amountProd, double unitPrice) {
		super();
		this.idProd = idProd;
		this.descProd = descProd;
		this.amountProd = amountProd;
		this.unitPrice = unitPrice;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getDescProd() {
		return descProd;
	}
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	public int getAmountProd() {
		return amountProd;
	}
	public void setAmountProd(int amountProd) {
		this.amountProd = amountProd;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Productes [idProd=" + idProd + ", descProd=" + descProd + ", amountProd=" + amountProd + ", unitPrice=" + unitPrice + "]";
	}
}