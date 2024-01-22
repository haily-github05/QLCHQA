package duancuoiki;

public class Donhang {
	private int Mahd,Makh;
	private String Tenkh;
	private String sdt;
	private String ngayban;
	private int Manv;
	private int Masp;
	private String Tensp,Dongia,size;
	private int soluong;
	private String giamgia,thanhtien;
	public Donhang(int mahd, int makh, String tenkh, String sdt, String ngayban, int manv, int masp, String tensp,
			String dongia,String size, int soluong, String giamgia, String thanhtien) {
		super();
		Mahd = mahd;
		Makh = makh;
		Tenkh = tenkh;
		this.sdt = sdt;
		this.ngayban = ngayban;
		Manv = manv;		
		Masp = masp;
		Tensp = tensp;
		Dongia = dongia;
	    this.size = size;
		this.soluong = soluong;
		this.giamgia = giamgia;
		this.thanhtien = thanhtien;
	}
	public Donhang() {
		// TODO Auto-generated constructor stub
	}
	public int getMahd() {
		return Mahd;
	}
	public void setMahd(int mahd) {
		Mahd = mahd;
	}
	public int getMakh() {
		return Makh;
	}
	public void setMakh(int makh) {
		Makh = makh;
	}
	public String getTenkh() {
		return Tenkh;
	}
	public void setTenkh(String tenkh) {
		Tenkh = tenkh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getNgayban() {
		return ngayban;
	}
	public void setNgayban(String ngayban) {
		this.ngayban = ngayban;
	}
	public int getManv() {
		return Manv;
	}
	public void setManv(int manv) {
		Manv = manv;
	}
	public int getMasp() {
		return Masp;
	}
	public void setMasp(int masp) {
		Masp = masp;
	}
	public String getTensp() {
		return Tensp;
	}
	public void setTensp(String tensp) {
		Tensp = tensp;
	}
	public String getDongia() {
		return Dongia;
	}
	public void setDongia(String dongia) {
		Dongia = dongia;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(String giamgia) {
		this.giamgia = giamgia;
	}
	public String getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(String thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}