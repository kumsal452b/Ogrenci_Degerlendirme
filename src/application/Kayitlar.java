package application;

public class Kayitlar {
	String ad,soyad,numara,vize,finall,b_n,h_n;
	public Kayitlar() {
		
	}
	public Kayitlar(String ad, String soyad, String numara, String vize, String finall, String b_n, String h_n) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.numara = numara;
		this.vize = vize;
		this.finall = finall;
		this.b_n = b_n;
		this.h_n = h_n;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getNumara() {
		return numara;
	}

	public void setNumara(String numara) {
		this.numara = numara;
	}

	public String getVize() {
		return vize;
	}

	public void setVize(String vize) {
		this.vize = vize;
	}

	public String getFinall() {
		return finall;
	}

	public void setFinall(String finall) {
		this.finall = finall;
	}

	public String getB_n() {
		return b_n;
	}

	public void setB_n(String b_n) {
		this.b_n = b_n;
	}

	public String getH_n() {
		return h_n;
	}

	public void setH_n(String h_n) {
		this.h_n = h_n;
	}
	

}
