package duancuoiki;
import java.io.Serializable;
import java.util.Date;

public class NhanVien implements Serializable{
	private int manv;
	private String tennv;
	private String sdt;
	private String gioitinh;
	private String ngayvaolv;
	private String ngaysinh;
	private String chucvu;
	private String anh;
	public NhanVien(int manv, String tennv,String sdt, String gioitinh, String ngayvaolv, String ngaysinh, String chucvu,String anh) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.sdt=sdt;
		this.gioitinh = gioitinh;
		this.ngayvaolv = ngayvaolv;
		this.ngaysinh = ngaysinh;
		this.chucvu = chucvu;
		this.anh= anh;
	} 
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgayvaolv() {
		return ngayvaolv;
	}
	public void setNgayvaolv(String ngayvaolv) {
		this.ngayvaolv = ngayvaolv;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}

	
}