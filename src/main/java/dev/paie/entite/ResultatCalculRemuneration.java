package dev.paie.entite;

public class ResultatCalculRemuneration {
	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;
	
	/** Getter for salaireDeBase
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	/** Setter
	 * @param salaireDeBase the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	/** Getter for salaireBrut
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}
	/** Setter
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/** Getter for totalRetenueSalarial
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}
	/** Setter
	 * @param totalRetenueSalarial the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	/** Getter for totalCotisationsPatronales
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}
	/** Setter
	 * @param totalCotisationsPatronales the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}
	/** Getter for netImposable
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}
	/** Setter
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	/** Getter for netAPayer
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}
	/** Setter
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}
}