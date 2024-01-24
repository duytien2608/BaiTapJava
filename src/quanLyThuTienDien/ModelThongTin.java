package quanLyThuTienDien;

public class ModelThongTin {
	private String hoVaTen;
	private String soNha;
	private String maCongToDien;
	private int soCu;
	private int soMoi;
	private int tongTien;
	
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getSoNha() {
		return soNha;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getMaCongToDien() {
		return maCongToDien;
	}
	public void setMaCongToDien(String maCongToDien) {
		this.maCongToDien = maCongToDien;
	}
	public int getSoMoi() {
		return soMoi;
	}
	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}
	public int getSoCu() {
		return soCu;
	}
	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}
	/**
	 * @param hoVaTen
	 * @param soNha
	 * @param maCongToDien
	 * @param soMoi
	 * @param soCu
	 */
	public ModelThongTin(String hoVaTen, String soNha, String maCongToDien, int soCu, int soMoi, int tongTien) {
		super();
		this.hoVaTen = hoVaTen;
		this.soNha = soNha;
		this.maCongToDien = maCongToDien;
		this.soCu = soCu;
		this.soMoi = soMoi;
		this.tongTien = tongTien;
	}
	/**
	 * 
	 */
	public ModelThongTin() {
		super();
		// TODO Auto-generated constructor stub
	}
}
