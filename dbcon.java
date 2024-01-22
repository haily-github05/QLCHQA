package duancuoiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dbcon {
	static String url ="jdbc:mysql://localhost:3306/QL_CHQA";
	static String user ="root";
	static String password= "haily0910";
	public static Connection getConnection() {
		Connection connection= null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;		
	}	
	public static List<NhanVien>findAll() {
		List<NhanVien>nhanvienList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLyNhanVien";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getInt("manv"),rs.getString("tennv"),rs.getString("sdt"),rs.getString("gioitinh"),rs.getString("ngayvaolv"),rs.getString("ngaysinh"),rs.getString("chucvu"),rs.getString("anh"));
				nhanvienList.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienList;
		
	}
	public static void xoa1(NhanVien nv) {
    	String query = "delete from QL_CHQA.QuanLyNhanVien where tennv='" + nv.getTennv() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static List<NhanVien> timkiem(NhanVien nv1) {
		List<NhanVien>nhanvienl= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLyNhanVien where Manv='"+nv1.getManv()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getInt("manv"),rs.getString("tennv"),rs.getString("sdt"),rs.getString("gioitinh"),rs.getString("ngayvaolv"),rs.getString("ngaysinh"),rs.getString("chucvu"),rs.getString("anh"));
				nhanvienl.add(nv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienl;				
	}	

	public static List<Sanpham>findAll2() {
		List<Sanpham>spList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham sp = new Sanpham(rs.getInt("maSp"),rs.getString("Chatlieu"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaNhap"),rs.getString("giaBan"),rs.getString("anh"));
				spList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return spList;
		
	}
	public static void xoa2(Sanpham sp) {
    	String query = "delete from QL_CHQA.QuanLySanPham where Masp='" + sp.getMaSp() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static List<Sanpham> timkiem2(Sanpham sanpham) {
		List<Sanpham>sp= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham where MaSp='"+sanpham.getMaSp()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham spham = new Sanpham(rs.getInt("maSp"),rs.getString("Chatlieu"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaNhap"),rs.getString("giaBan"),rs.getString("anh"));
				sp.add(spham);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	public static List<Donhang>findAll3() {
		List<Donhang>dh1List= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Donhang dh1 = new Donhang(rs.getInt("Mahd"),rs.getInt("Makh"),rs.getString("Tenkh"),rs.getString("sdt"),rs.getString("Ngayban"),rs.getInt("Manv"),rs.getInt("Masp"),rs.getString("Tensp"),rs.getString("Dongia"),rs.getString("Size"),rs.getInt("soluong"),rs.getString("giamgia"),rs.getString("thanhtien"));
				dh1List.add(dh1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dh1List;
		
	}
	public static List<Donhang> timkiem3(Donhang donhang1) {
		List<Donhang>dh1= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon where Mahd ='"+donhang1.getMahd()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Donhang dhang1 = new Donhang(rs.getInt("Mahd"),rs.getInt("Makh"),rs.getString("Tenkh"),rs.getString("sdt"),rs.getString("Ngayban"),rs.getInt("Manv"),rs.getInt("Masp"),rs.getString("Tensp"),rs.getString("Dongia"),rs.getString("Size"),rs.getInt("soluong"),rs.getString("giamgia"),rs.getString("thanhtien"));
				dh1.add(dhang1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dh1;
	}
	public static List<Tk>findAll4() {
		List<Tk>dn1List= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.DangNhap";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Tk dn1 = new Tk(rs.getString("Sdt"),rs.getString("Taikhoan"),rs.getString("Matkhau"),rs.getString("Chucvu"));
				dn1List.add(dn1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dn1List;
		
	}
	public static void xoa4(Tk tk) {
    	String query = "delete from QL_CHQA.DangNhap where Sdt='" + tk.getSdt() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      dbcon db = new dbcon();
    
	}
	
	

}
