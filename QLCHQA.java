package duancuoiki;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DialogOwner;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.mysql.cj.jdbc.NClob;
import com.toedter.calendar.JDateChooser;

public class QLCHQA extends JFrame {
private static JTable tbl = new JTable();
private static JTable tbl2 = new JTable();
private static JTable tbl3 = new JTable();
private static JTable tbl4 = new JTable();
private JLabel a;
private JLabel a2;
private String imagePath;
private String imagePath2;	
public QLCHQA() {	
	setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY" );
	setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel emptyJPanel = new JPanel();
        Container container = getContentPane();	
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setPreferredSize(new Dimension(190,765));;
        panel.add(panel1,BorderLayout.WEST);
//add Ảnh
        ImageIcon anh = new ImageIcon("///Users/hohaily/eclipse-workspace/java/src/picture/Logo.png");
        Image scaledImage = anh.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        anh= new ImageIcon(scaledImage);
        JLabel panel11 = new JLabel(anh,JLabel.RIGHT);
        panel11.setIcon(anh);      
        panel1.add(panel11);

        JPanel panel12 = new JPanel();
        panel12.setBackground(Color.pink);
        panel12.setPreferredSize(new Dimension(190,500));;
        panel1.add(panel12);
        JButton quanlynhanvien = new JButton("Quản lý nhân viên ");
        quanlynhanvien.setPreferredSize(new Dimension(180,60)); 
        JButton quanlysanpham = new JButton("Quản lý sản phẩm ");
        quanlysanpham.setPreferredSize(new Dimension(180,60));
        JButton quanlydonhang = new JButton("Quản lý đơn hàng ");          
        quanlydonhang.setPreferredSize(new Dimension(180,60));
        JButton quanlydangnhap = new JButton("Quản lý đăng nhập ");          
        quanlydangnhap.setPreferredSize(new Dimension(180,60));
        panel12.add(quanlynhanvien);
        panel12.add(quanlysanpham);
        panel12.add(quanlydonhang);
        panel12.add(quanlydangnhap);

        JPanel pn = new JPanel();       
        pn.setBackground(Color.pink);
        pn.setPreferredSize(new Dimension(1200,765));;
        panel.add(pn);
 //Trang1       
        JPanel panelquanlynhanvien = new JPanel(new BorderLayout());
	JLabel jLabel_1= new JLabel("Quản Lý Nhân Viên",JLabel.CENTER);
	Font font = new Font("Serif",Font.CENTER_BASELINE,50);
	jLabel_1.setFont(font);
	jLabel_1.setBackground(Color.pink);
	jLabel_1.setOpaque(true);
		
	panelquanlynhanvien.add(jLabel_1,BorderLayout.NORTH);
	pn.add(panelquanlynhanvien,BorderLayout.CENTER);
	JPanel pn1 = new JPanel();
	pn1.setBackground(Color.pink);
	pn1.setPreferredSize(new Dimension(800,180));
	panelquanlynhanvien.add(pn1);
		
	JPanel pn11 = new JPanel (new GridLayout(4,8));
	pn11.setBackground(Color.pink);
	pn11.setPreferredSize(new Dimension(1060,140));
	pn1.add(pn11,BorderLayout.WEST);
		
	JPanel pn12 = new JPanel();
	pn12.setBackground(Color.pink);
	pn12.setPreferredSize(new Dimension(120,170));
	pn1.add(pn12);
	a =new JLabel(" ");
	a.setPreferredSize(new Dimension(120,160));
	pn12.add(a);	 
	JLabel lblManv = new JLabel("    Mã nhân viên:");
	JTextField txtManv = new JTextField();
	JLabel lblTennv = new JLabel("    Tên nhân viên:");
	JTextField txtTennv= new JTextField();
	JLabel sdt = new JLabel("    SĐT");
	JTextField txtsdt= new JTextField();
	JLabel lblgt = new JLabel("    Giới tính:");
	JTextField txtgt= new JTextField();
	JLabel lblNgaylv = new JLabel("    Ngày vào làm việc:");
	JTextField txtNgaylv = new JTextField();
	JLabel lblNgaysinh = new JLabel("    Ngày sinh:");
	JTextField txtNgaysinh = new JTextField();
	JLabel lblchucvu = new JLabel("    Chức vụ:");
	JTextField txtchucvu = new JTextField();	
	JLabel themanh = new JLabel("    Thêm ảnh:");
	JTextField txtthemanh = new JTextField();		
	pn11.add(lblManv);
	pn11.add(txtManv);
	pn11.add(lblTennv);
	pn11.add(txtTennv);
	pn11.add(sdt);
	pn11.add(txtsdt);
	pn11.add(lblgt);
	pn11.add(txtgt);
	pn11.add(lblNgaylv);
	pn11.add(txtNgaylv);
	pn11.add(lblNgaysinh);
	pn11.add(txtNgaysinh);
	pn11.add(lblchucvu);
	pn11.add(txtchucvu);		
        pn11.add(themanh);
	pn11.add(txtthemanh);
    	JPanel pn1a= new JPanel();
    	pn1a.setBackground(Color.pink);
        pn1a.setPreferredSize(new Dimension(1200,580));
        panelquanlynhanvien.add(pn1a,BorderLayout.SOUTH);
  	
        JButton btnThem = new JButton("Thêm");
    	JButton btnXoa = new JButton("Xóa");
    	JButton btnSua = new JButton("Sửa");
    	pn1a.add(btnThem);
    	pn1a.add(btnXoa);
    	pn1a.add(btnSua);

    	DefaultTableModel dm=new DefaultTableModel();
    	dm.addColumn("Mã nhân viên");
    	dm.addColumn("Tên nhân viên");
    	dm.addColumn("SĐT");
    	dm.addColumn("Giới tính");
    	dm.addColumn("Ngày vào làm việc");
    	dm.addColumn("Ngày sinh");
    	dm.addColumn("Chức vụ");
    	dm.addColumn("Đường dẫn ảnh"); 
    	tbl =new JTable(dm);
    	JScrollPane sc=new JScrollPane(tbl);
    	sc.setPreferredSize(new Dimension(1190,440));
    	showData(dbcon.findAll());    	
        pn1a.add(sc,BorderLayout.SOUTH); 
        
        JPanel pn1b= new JPanel();
    	pn1b.setBackground(Color.pink);
        pn1b.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem = new JButton("Tìm kiếm");
    	JTextField txttimkiem= new JTextField(20);
    	JButton ql = new JButton("Quay lại");
        pn1a.add(pn1b);
        pn1a.add(txttimkiem);
    	pn1a.add(btntimkiem); 
    	pn1a.add(ql);
    	ql.setVisible(false);
        btnThem.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {    	    	
    	    	try {
    	        int manv = Integer.parseInt(txtManv.getText());
    	        String tennv = txtTennv.getText();
    	        String sdt= txtsdt.getText();
    	        String gioitinh = txtgt.getText();    	        
    	        String ngayvaolv = txtNgaylv.getText();
    	        String ngaysinh = txtNgaysinh.getText();
    	        String chucvu = txtchucvu.getText();
    	        String anh = txtthemanh.getText();
                NhanVien nv = new NhanVien();
                nv.setAnh(imagePath);
                
    	        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
    	        model.addRow(new Object[]{manv, tennv,sdt,gioitinh, ngayvaolv, ngaysinh, chucvu,anh});
        	     
    	         String url ="jdbc:mysql://localhost:3306/QL_CHQA";
    	         String user ="root";
    	    	 String password= "haily0910";
   	    
    	    	 String sqlThem = "INSERT INTO QL_CHQA.QuanLyNhanVien (manv,tennv,sdt, gioitinh, ngayvaolv,ngaysinh, chucvu,anh) VALUES (?,?, ?, ?, ?, ?, ?,?)";
    	    	 try {
    	    	     Connection connection = DriverManager.getConnection(url, user, password);
    	    	     PreparedStatement pstmt = connection.prepareStatement(sqlThem);
    	    	     pstmt.setInt(1, manv);
    	    	     pstmt.setString(2, tennv);
    	    	     pstmt.setString(3, sdt);
    	    	     pstmt.setString(4, gioitinh);
    	    	     pstmt.setString(5, ngayvaolv);
    	    	     pstmt.setString(6, ngaysinh);
    	    	     pstmt.setString(7, chucvu);
    	    	     pstmt.setString(8,anh);
    	    	     pstmt.executeUpdate();
    	    	     
    	    	 } catch (SQLException e1) {
    	    	     e1.printStackTrace();
    	    	 }
    	        clearTextFields();
    	    }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Nhân Viên.");
            }
    	    	clearTextFields();
        }
    	    private void clearTextFields() {
    	        txtManv.setText("");
    	        txtTennv.setText("");
    	        txtsdt.setText("");
    	        txtgt.setText("");
    	        txtNgaylv.setText("");
    	        txtNgaysinh.setText("");
    	        txtchucvu.setText("");
    	        txtthemanh.setText("");
    	        a.setIcon(null);
    	    }
    	});
        btnXoa.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub        		
        		NhanVien nv = new NhanVien();
				nv.setTennv(txtTennv.getText());				
				dbcon.xoa1(nv);
				showData(dbcon.findAll());	
				clearTextFields();
			}
        	private void clearTextFields() {
    	        txtManv.setText("");
    	        txtTennv.setText("");
    	        txtsdt.setText("");
    	        txtgt.setText("");
    	        txtNgaylv.setText("");
    	        txtNgaysinh.setText("");
    	        txtchucvu.setText("");
    	        txtthemanh.setText("");
    	        a.setIcon(null);
    	    }
		});       
    	btnSua.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) { 
    	    	NhanVien nv= new NhanVien();
   	    	    nv.setManv(Integer.parseInt(txtManv.getText())); 
   	    	    nv.setTennv( txtTennv.getText());
   	    	    nv.setSdt(txtsdt.getText());
    	        nv.setGioitinh(txtgt.getText()); ;
    	        nv.setNgayvaolv(txtNgaylv.getText()); 
                nv.setNgaysinh(txtNgaysinh.getText());
    	        nv.setChucvu(txtchucvu.getText());
    	        nv.setAnh(txtthemanh.getText());

    	    	String url = "jdbc:mysql://localhost:3306/QL_CHQA";
    	        String user = "root";
    	        String password = "haily0910";
    	        String query = "UPDATE QuanLyNhanVien SET tennv=?,sdt=?, gioitinh=?, ngayvaolv=?, ngaysinh=?, chucvu=?, anh=? WHERE manv=?";  	      	    	     	              
    	        try (Connection connection = DriverManager.getConnection(url, user, password);
    	             PreparedStatement pstmt = connection.prepareStatement(query)) {   	        	 
    	            pstmt.setString(1, nv.getTennv());
    	            pstmt.setString(2, nv.getSdt());
    	            pstmt.setString(3, nv.getGioitinh());
    	            pstmt.setString(4, nv.getNgayvaolv());
    	            pstmt.setString(5, nv.getNgaysinh());
    	            pstmt.setString(6, nv.getChucvu());
    	            pstmt.setString(7, nv.getAnh());
    	            pstmt.setInt(8, nv.getManv());        
    	            pstmt.executeUpdate();
    	            JOptionPane.showMessageDialog(null,"Sửa thành công!");
    	            showData(dbcon.findAll());
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();
    	        }
    	        clearTextFields();
    	    }
    	    private void clearTextFields() {
    	        txtManv.setText("");
    	        txtTennv.setText("");
    	        txtsdt.setText("");
    	        txtgt.setText("");
    	        txtNgaylv.setText("");
    	        txtNgaysinh.setText("");
    	        txtchucvu.setText("");
    	        txtthemanh.setText("");
    	        a.setIcon(null);
    	    }
    	});
    	tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    	    public void valueChanged(ListSelectionEvent event) {
    	        if (!event.getValueIsAdjusting()) {
    	            int selectedRow = tbl.getSelectedRow();
    	            if (selectedRow != -1) {
    	                Object manv = tbl.getValueAt(selectedRow, 0);
    	                Object tennv = tbl.getValueAt(selectedRow, 1);
    	                Object sdt = tbl.getValueAt(selectedRow, 2);
    	                Object gioitinh = tbl.getValueAt(selectedRow, 3);
    	                Object ngayvaolv = tbl.getValueAt(selectedRow, 4);
    	                Object ngaysinh = tbl.getValueAt(selectedRow, 5);
    	                Object chucvu = tbl.getValueAt(selectedRow, 6);
    	                Object anh = tbl.getValueAt(selectedRow, 7);

    	                txtManv.setText(manv.toString());
    	                txtTennv.setText(tennv.toString());
    	                txtsdt.setText(sdt.toString());
    	                txtgt.setText(gioitinh.toString());
    	                txtNgaylv.setText(ngayvaolv.toString());
    	                txtNgaysinh.setText(ngaysinh.toString());
    	                txtchucvu.setText(chucvu.toString());
    	                txtthemanh.setText(anh.toString());
    	                displayImage(anh.toString());
    	            }
    	        }
    	    }
    	});
        btntimkiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NhanVien nv = new NhanVien();
				nv.setManv(Integer.parseInt(txttimkiem.getText()));
				showData(dbcon.timkiem(nv));
				ql.setVisible(true);
				ql.addActionListener(new ActionListener() {
					@Override				
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txttimkiem.setText("");
						ql.setVisible(false);
						showData(dbcon.findAll());
					}
				});	
			}
        });
//Trang2        
        JPanel panelquanlysanpham = new JPanel(new BorderLayout());
        JLabel jLabel_2= new JLabel("Quản Lý Sản Phẩm",JLabel.CENTER);
        Font font2 = new Font("Serif",Font.CENTER_BASELINE,50);
  	jLabel_2.setFont(font2); 
        jLabel_2.setBackground(Color.pink);
        jLabel_2.setOpaque(true);
  	panelquanlysanpham.add(jLabel_2,BorderLayout.NORTH);
  	    
  	JPanel pn2 = new JPanel();
  	pn2.setBackground(Color.pink);
      	pn2.setPreferredSize(new Dimension(800,180));
  	panelquanlysanpham.add(pn2);

	JPanel pn21 = new JPanel (new GridLayout(4,8));
	pn21.setBackground(Color.pink);
	pn21.setPreferredSize(new Dimension(1030,140));
	pn2.add(pn21,BorderLayout.WEST);

	JPanel pn22 = new JPanel();
	pn22.setBackground(Color.pink);
	pn22.setPreferredSize(new Dimension(160,170));
	pn2.add(pn22);
	a2 =new JLabel(" ");
	a2.setPreferredSize(new Dimension(150,160));
	pn22.add(a2);	    

    	JLabel lblMasp = new JLabel("    Mã sản phẩm:");
        JTextField txtMasp = new JTextField();
    	JLabel lblchatlieu = new JLabel("    Chất liệu:");
    	JTextField txtchatlieu = new JTextField();
    	JLabel lblTensp = new JLabel("    Tên sản phẩm:");
    	JTextField txtTen = new JTextField();
    	JLabel lblsz = new JLabel("    Size");
    	JTextField txtsz = new JTextField();     	
  	JLabel lblSoluong = new JLabel("    Số lượng:");
  	JTextField txtSoluong = new JTextField();
  	JLabel lblGianhap = new JLabel("    Giá nhập:");
  	JTextField txtGianhap = new JTextField(); 
  	JLabel lblGiaban = new JLabel("    Giá bán:");  	    
	JTextField txtGiaban = new JTextField();
  	JLabel themanh2 = new JLabel("    Đường dẫn ảnh:");
	JTextField txtthemanh2 = new JTextField(); 
  	pn21.add(lblMasp);
  	pn21.add(txtMasp);
  	pn21.add(lblchatlieu);
  	pn21.add(txtchatlieu);
     	pn21.add(lblTensp);
    	pn21.add(txtTen);
    	pn21.add(lblsz);
    	pn21.add(txtsz);
    	pn21.add(lblSoluong);
    	pn21.add(txtSoluong);
    	pn21.add(lblGianhap);
    	pn21.add(txtGianhap);   
    	pn21.add(lblGiaban);
    	pn21.add(txtGiaban);
    	pn21.add(themanh2);
    	pn21.add(txtthemanh2); 
	
    	JPanel pn2a= new JPanel(); 
    	pn2a.setBackground(Color.pink);
        pn2a.setPreferredSize(new Dimension(1200,580));
        panelquanlysanpham.add(pn2a,BorderLayout.SOUTH);

        JButton btnThem2 = new JButton("Thêm");
     	JButton btnXoa2 = new JButton("Xóa");
    	JButton btnSua2 = new JButton("Sửa");
    	pn2a.add(btnThem2);
    	pn2a.add(btnXoa2);  
    	pn2a.add(btnSua2);
   
    	DefaultTableModel dm2=new DefaultTableModel();
    	dm2.addColumn("Mã sản phẩm");
    	dm2.addColumn("Chất liệu");
    	dm2.addColumn("Tên sản phẩm");
    	dm2.addColumn("Size");
    	dm2.addColumn("Số lượng");
    	dm2.addColumn("Giá nhập");
    	dm2.addColumn("Giá bán");
    	dm2.addColumn("Đường dẫn ảnh"); 
    	tbl2 =new JTable(dm2);
    	JScrollPane sc2=new JScrollPane(tbl2);
    	sc2.setPreferredSize(new Dimension(1190,440));
    	pn2a.add(sc2,BorderLayout.SOUTH);
    	pn.add(panelquanlysanpham,BorderLayout.CENTER);
    	showData2(dbcon.findAll2());
  	
    	JPanel pn2b= new JPanel();
    	pn2b.setBackground(Color.pink);  
        pn2b.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem2 = new JButton("Tìm kiếm");
    	JTextField txttimkiem2= new JTextField(20);
    	JButton ql2 = new JButton("Quay lại");
    	ql2.setVisible(false);
    	pn2a.add(pn2b); 
    	pn2a.add(txttimkiem2);
    	pn2a.add(btntimkiem2);
    	pn2a.add(ql2);
    	panelquanlysanpham.setVisible(false);

	    btnThem2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    	    try {			    
	                int maSp = Integer.parseInt(txtMasp.getText());
	                String chatlieu = txtchatlieu.getText();        
	                String tenSp= txtTen.getText();
	                String size= txtsz.getText();
	                int soLuong = Integer.parseInt(txtSoluong.getText());
	                String giaNhap = txtGianhap.getText();
                        String giaBan = txtGiaban.getText();
                        String anh = txtthemanh2.getText();
                        Sanpham  sp = new Sanpham();
                        sp.setAnh(imagePath2);
             
	                DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
	                model.addRow(new Object[]{maSp,chatlieu, tenSp,size, soLuong,giaNhap, giaBan,anh});

	                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
	                String user ="root";
	    	        String password= "haily0910";
	    	        String sqlThem2 = "INSERT INTO QL_CHQA.QuanLySanPham (maSp,Chatlieu,tenSP,size,soLuong, giaNhap,giaBan,anh) VALUES (?,?,?,?, ?, ?, ?, ?)";
	    	       try {
	    	    	   Connection connection = DriverManager.getConnection(url, user, password);	    	     
	    	           PreparedStatement pstmt = connection.prepareStatement(sqlThem2);
	    	           pstmt.setInt(1, maSp);
	    	           pstmt.setString(2, chatlieu);
	    	           pstmt.setString(3, tenSp);
	    	           pstmt.setString(4, size);
	    	           pstmt.setInt(5, soLuong);
	    	           pstmt.setString(6, giaNhap);
	    	           pstmt.setString(7, giaBan);
	    	           pstmt.setString(8, anh); 
	    	           pstmt.executeUpdate();
	    	       } catch (SQLException e1) {
	    	         e1.printStackTrace();
	    	         }	                 
	            }catch (NumberFormatException ex) { 	
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Sản Phẩm.");
                    }
	    	    clearTextFields();
	    	    }	        
	        private void clearTextFields() {
	        	 txtMasp.setText("");	       
	             txtchatlieu.setText("");
	             txtTen.setText("");
	             txtsz.setText("");
	             txtSoluong.setText("");
	             txtGianhap.setText("");
	             txtGiaban.setText("");
	             txtthemanh2.setText("");
	             a2.setIcon(null);	             
	        }
	        });
	     btnXoa2.addActionListener(new ActionListener() {	
	    	 @Override
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Sanpham sp = new Sanpham();
				 sp.setMaSp(Integer.parseInt(txtMasp.getText()));
				 dbcon.xoa2(sp);
				 showData2(dbcon.findAll2());
				 clearTextFields();
				}
	    	 private void clearTextFields() {
	             txtMasp.setText("");	       
	             txtchatlieu.setText("");
	             txtTen.setText("");
	             txtsz.setText("");
	             txtSoluong.setText("");
	             txtGianhap.setText("");
	             txtGiaban.setText("");
	             txtthemanh2.setText("");
	             a2.setIcon(null);	             
	             }
	    	 });
	     btnSua2.addActionListener(new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    	     Sanpham sp= new Sanpham();
	             sp.setMaSp(Integer.parseInt(txtMasp.getText())); 
	    	     sp.setChatLieu(txtchatlieu.getText());
	    	     sp.setTenSp(txtTen.getText());
	    	     sp.setSize(txtsz.getText());
	    	     sp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
	    	     sp.setGiaNhap(txtGianhap.getText()); 
 	             sp.setGiaBan(txtGiaban.getText()); 
 	             sp.setAnh(txtthemanh2.getText());
 	        
 	             String url = "jdbc:mysql://localhost:3306/QL_CHQA";
 	             String user = "root"; 
 	             String password = "haily0910";
 	             String query = "UPDATE QL_CHQA.QuanLySanPham SET Chatlieu=? ,tenSp=?,Size=?, soLuong=?, giaNhap=?, giaBan=?, anh=? WHERE maSp=?";      
 	             try (Connection connection = DriverManager.getConnection(url, user, password);
 	            		 PreparedStatement pstmt = connection.prepareStatement(query)) {
 	            	 pstmt.setString(1, sp.getChatLieu());
 	                 pstmt.setString(2, sp.getTenSp());
 	                 pstmt.setString(3, sp.getSize());
 	                 pstmt.setInt(4, sp.getSoLuong());  
 	                 pstmt.setString(5, sp.getGiaNhap());    
 	                 pstmt.setString(6, sp.getGiaBan());
 	                 pstmt.setString(7, sp.getAnh()); 
 	                 pstmt.setInt(8, sp.getMaSp());                
 	                 pstmt.executeUpdate();
 	                 JOptionPane.showMessageDialog(null,"Sửa thành công!");
			         showData2(dbcon.findAll2());
			         } catch (SQLException ex) {
			        	 ex.printStackTrace();	        
			         } 	       
 	             clearTextFields(); 	   
	    	 } 	   
	    	 private void clearTextFields() {       	
	    		 txtMasp.setText("");	       
                 txtchatlieu.setText("");
                 txtTen.setText("");
                 txtsz.setText("");
                 txtSoluong.setText("");
                 txtGianhap.setText("");
                 txtGiaban.setText("");  
                 txtthemanh2.setText("");
                 a2.setIcon(null);	                   
	    	 }	
	     });	 	
	     tbl2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {		   
	    	 public void valueChanged(ListSelectionEvent event) {		        
	    		 if (!event.getValueIsAdjusting()) {		            
	    			 int selectedRow = tbl2.getSelectedRow();		            
	    			 if (selectedRow != -1) {		                
	    				 Object maSp = tbl2.getValueAt(selectedRow, 0);
		                 Object Chatlieu = tbl2.getValueAt(selectedRow, 1);
		                 Object tenSp = tbl2.getValueAt(selectedRow, 2);
		                 Object size = tbl2.getValueAt(selectedRow, 3);
		                 Object soLuong = tbl2.getValueAt(selectedRow, 4);
		                 Object giaNhap = tbl2.getValueAt(selectedRow, 5);
		                 Object giaBan = tbl2.getValueAt(selectedRow, 6);
		                 Object anh = tbl2.getValueAt(selectedRow, 7);

		                 txtMasp.setText(maSp != null ? maSp.toString() : "");
		                 txtchatlieu.setText(Chatlieu != null ? Chatlieu.toString() : "");
		                 txtTen.setText(tenSp != null ? tenSp.toString() : "");
		                 txtsz.setText(size != null ? size.toString() : "");
		                 txtSoluong.setText(soLuong != null ? soLuong.toString() : "");
		                 txtGianhap.setText(giaNhap != null ? giaNhap.toString() : "");
		                 txtGiaban.setText(giaBan != null ? giaBan.toString() : "");
		                 txtthemanh2.setText(anh != null ? anh.toString() : "");
		                 displayImage2(anh != null ? anh.toString() : "");		           
	    			 }	    			 
	    		 }		  
	    	 }		   
	     });       
	     btntimkiem2.addActionListener(new ActionListener() {       
	    	 @Override
	          public void actionPerformed(ActionEvent e) {
	    		 // TODO Auto-generated method stub
			     Sanpham sp = new Sanpham();
			     sp.setMaSp(Integer.parseInt(txttimkiem2.getText()));
			     showData2(dbcon.timkiem2(sp));
			     ql2.setVisible(true);
			     ql2.addActionListener(new ActionListener() {
			    	 @Override
			    	 public void actionPerformed(ActionEvent e) {
			    		 // TODO Auto-generated method stub
					     txttimkiem2.setText("");
					     ql2.setVisible(false);
					     showData2(dbcon.findAll2());					    
			    	 }			    	
			     });				   
	    	 }	              
	     });
//Trang3         	
	     JPanel panelquanlydonhang = new JPanel(new BorderLayout());       
         JLabel jLabel_3= new JLabel("Lập Hoá Đơn",JLabel.CENTER);
	     Font font3 = new Font("Serif",Font.CENTER_BASELINE,50);
	     jLabel_3.setFont(font3);
	     jLabel_3.setBackground(Color.pink);
         jLabel_3.setOpaque(true); 
	     panelquanlydonhang.add(jLabel_3,BorderLayout.NORTH);
	
	     JPanel pn3 = new JPanel(new GridLayout(7,4));
	     pn3.setBackground(Color.pink);
      	 pn3.setPreferredSize(new Dimension(800,230));  
	     panelquanlydonhang.add(pn3,BorderLayout.CENTER);

	     JLabel lblMahd = new JLabel("    Mã hoá đơn:");
	     JTextField txtMahd = new JTextField();
	     JLabel lblMakh = new JLabel("    Mã khách hàng:");
	     JTextField txtMakh= new JTextField();
	     JLabel lblTenkh = new JLabel("    Tên khách hàng:");
	     JTextField txtTenkh= new JTextField();
	     JLabel lblsdt = new JLabel("    SĐT:");
	     JTextField txtsdt2 = new JTextField();
	     JLabel lblNgayban = new JLabel("    Ngày bán:");
	     JTextField txtNgayban = new JTextField();
	     JLabel lblManv3 = new JLabel("    Mã nhân viên:");
	     JTextField txtManv3 = new JTextField();
	     JLabel lblMasp4 = new JLabel("    Mã sản phẩm:");
	     JTextField txtMasp3 = new JTextField();
	     JLabel lblTensp3 = new JLabel("    Tên sản phẩm:");
	     JTextField txtTensp3= new JTextField();
	     JLabel lbldongia = new JLabel("    Đơn giá:");
     	 JTextField txtdongia= new JTextField();
     	 JLabel lblsize = new JLabel("    Size:");
	     JTextField txtsize = new JTextField();
	     JLabel lblsoluong = new JLabel("    Số lượng:");
	     JTextField txtsoluong = new JTextField();
	     JLabel lblgiamgia = new JLabel("    Giảm giá (%):");
	     JTextField txtgiamgia = new JTextField();
	     JLabel trong = new JLabel();
	     JLabel trong1 = new JLabel();
	     JLabel lblThanhtien = new JLabel("    Thành tiền:");
	     JTextField txtThanhtien = new JTextField(); 
         JButton btnThemhd = new JButton("Thêm hoá đơn");
	     JButton btnSuahd = new JButton("Sửa hoá đơn");
	     pn3.add(lblMahd); 
	     pn3.add(txtMahd);
	     pn3.add(lblMakh);
	     pn3.add(txtMakh);
	     pn3.add(lblTenkh);
	     pn3.add(txtTenkh);
	     pn3.add(lblsdt);
	     pn3.add(txtsdt2);
	     pn3.add(lblNgayban);
	     pn3.add(txtNgayban);
	     pn3.add(lblManv3);
	     pn3.add(txtManv3);
	     pn3.add(lblMasp4);
	     pn3.add(txtMasp3);
	     pn3.add(lblTensp3);
	     pn3.add(txtTensp3);
	     pn3.add(lbldongia);
	     pn3.add(txtdongia);
	     pn3.add(lblsize);
	     pn3.add(txtsize);	     
	     pn3.add(lblsoluong);
	     pn3.add(txtsoluong);
	     pn3.add(lblgiamgia);
	     pn3.add(txtgiamgia);
	     pn3.add(trong);
	     pn3.add(trong1);
	     pn3.add(lblThanhtien);
	     pn3.add(txtThanhtien); 
	
	    JPanel pn4= new JPanel();
	    pn4.setBackground(Color.pink);
        pn4.setPreferredSize(new Dimension(1200,560));
        panelquanlydonhang.add(pn4,BorderLayout.SOUTH);
        pn4.add(btnThemhd);
	    pn4.add(btnSuahd);
    
	    DefaultTableModel dm3=new DefaultTableModel();
	    dm3.addColumn("Mã hoá đơn");
	    dm3.addColumn("Mã khách hàng");
	    dm3.addColumn("Tên khách hàng");
	    dm3.addColumn("SĐT");
	    dm3.addColumn("Ngày bán");  
	    dm3.addColumn("Mã nhân viên");
	    dm3.addColumn("Mã sản phẩm");
	    dm3.addColumn("Tên sản phẩm");
	    dm3.addColumn("Đơn giá");
	    dm3.addColumn("Size");
	    dm3.addColumn("Số lượng");
	    dm3.addColumn("Giảm giá (%)");
	    dm3.addColumn("Thành tiền");
	    tbl3 =new JTable(dm3);	
	    JScrollPane sc3=new JScrollPane(tbl3);
	    sc3.setPreferredSize(new Dimension(1190,390));
	    showData3(dbcon.findAll3());
	    pn4.add(sc3,BorderLayout.SOUTH);
	    JPanel pn3a= new JPanel();
	    pn3a.setBackground(Color.pink);
        pn3a.setPreferredSize(new Dimension(700,5));
        pn4.add(pn3a);
    
        JButton btntimkiem3 = new JButton("Tìm kiếm");
	    JTextField txttimkiem3= new JTextField(20);
	    JButton ql3 = new JButton("Quay lại");
    	ql3.setVisible(false);
	    pn4.add(txttimkiem3);
	    pn4.add(btntimkiem3);
	    pn4.add(ql3);
        pn.add(panelquanlydonhang,BorderLayout.CENTER);
	    panelquanlydonhang.setVisible(false);
	    btnThemhd.addActionListener(new ActionListener() {
	    	@Override	    
	    	public void actionPerformed(ActionEvent e) {	        
	    		try {	            
	    			int Mahd = Integer.parseInt(txtMahd.getText());
	                int Makh = Integer.parseInt(txtMakh.getText());
	                String Tenkh = txtTenkh.getText();
	                String sdt = txtsdt2.getText();
	                String Ngayban = txtNgayban.getText();
	                int Manv = Integer.parseInt(txtManv3.getText());
	                int Masp = Integer.parseInt(txtMasp3.getText());
	                String Tensp = txtTensp3.getText();
	                double Dongia = Double.parseDouble(txtdongia.getText());
	                String size = txtsize.getText();
	                int soluong = Integer.parseInt(txtsoluong.getText());
	                int giamgia = Integer.parseInt(txtgiamgia.getText());
	                double thanhtien = soluong * Dongia * (1 - giamgia / 100);

	                DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
	                model.addRow(new Object[]{Mahd, Makh, Tenkh, sdt, Ngayban, Manv, Masp, Tensp, Dongia,size, soluong, giamgia, thanhtien});

	                String url = "jdbc:mysql://localhost:3306/QL_CHQA";
	                String user = "root";
	                String password = "haily0910";
	                String sqlThem3 = "INSERT INTO QL_CHQA.Laphoadon (Mahd, Makh, Tenkh, sdt, Ngayban, Manv, Masp, Tensp, Dongia,size, soluong, giamgia, thanhtien) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	                try {
	                	Connection connection = DriverManager.getConnection(url, user, password);	                 
	                	PreparedStatement pstmt = connection.prepareStatement(sqlThem3);
	                    pstmt.setInt(1, Mahd);
	                    pstmt.setInt(2, Makh);
	                    pstmt.setString(3, Tenkh);
	                    pstmt.setString(4, sdt);
	                    pstmt.setString(5, Ngayban);
	                    pstmt.setInt(6, Manv);
	                    pstmt.setInt(7, Masp);
	                    pstmt.setString(8, Tensp);
	                    pstmt.setDouble(9, Dongia);
	                    pstmt.setString(10, size);
	                    pstmt.setInt(11, soluong);
	                    pstmt.setDouble(12, giamgia);
	                    pstmt.setDouble(13, thanhtien);
	                    pstmt.executeUpdate();	            
	                } catch (SQLException e1) {	                
	                	e1.printStackTrace();           
	                }           
	                clearTextFields();	        
	    		} catch (NumberFormatException ex) {	            
	    			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho các trường số.");	       
	    		}	    
	    	}	    
	    	private void clearTextFields() {	       
	    		txtMahd.setText("");
	            txtMakh.setText("");
	            txtTenkh.setText("");
	            txtsdt2.setText("");
	            txtNgayban.setText("");
	            txtManv3.setText("");
	            txtMasp3.setText("");
	            txtTensp3.setText("");
	            txtdongia.setText("");
	            txtsize.setText("");
	            txtsoluong.setText("");
	            txtgiamgia.setText("");
	            txtThanhtien.setText("");	   
	    	}	
	    });
	    btnSuahd.addActionListener(new ActionListener() {   
	    	@Override
	        public void actionPerformed(ActionEvent e) {	    	
	    		Donhang dh= new Donhang();
	         	dh.setMahd(Integer.parseInt(txtMahd.getText()));
	    	    dh.setMakh(Integer.parseInt(txtMakh.getText())); 
	    	    dh.setTenkh( txtTenkh.getText());
	    	    dh.setSdt(txtsdt2.getText()); 
	            dh.setNgayban(txtNgayban.getText()); ;
	            dh.setManv(Integer.parseInt(txtManv3.getText())); 
	            dh.setMasp(Integer.parseInt(txtMasp3.getText())); 
                dh.setTensp(txtTensp3.getText());
	            dh.setDongia(txtdongia.getText()); 
	            dh.setSize(txtsize.getText());
	            dh.setSoluong(Integer.parseInt(txtsoluong.getText()));
	            dh.setGiamgia(txtgiamgia.getText()); 
	            dh.setThanhtien(txtThanhtien.getText());
	            String url = "jdbc:mysql://localhost:3306/QL_CHQA";
	            String user = "root";
	            String password = "haily0910";
	            String query = "UPDATE QL_CHQA.Laphoadon SET Makh=?,Tenkh=?,sdt=?,Ngayban=?,Manv=?,Masp=?,Tensp=?,Dongia=?,size=?,soluong=?,giamgia=?,thanhtien=? WHERE Mahd=?";  	        
	            try (Connection connection = DriverManager.getConnection(url, user, password);	        	     
	            		PreparedStatement pstmt = connection.prepareStatement(query)) {	        		        	    
	            	pstmt.setInt(1, dh.getMakh());
	        	    pstmt.setString(2, dh.getTenkh());
	        	    pstmt.setString(3, dh.getSdt());
	        	    pstmt.setString(4, dh.getNgayban());
	        	    pstmt.setInt(5, dh.getManv());
	        	    pstmt.setInt(6, dh.getMasp());
	        	    pstmt.setString(7, dh.getTensp());
	        	    pstmt.setString(8, dh.getDongia());
	        	    pstmt.setString(9, dh.getSize());
	        	    pstmt.setInt(10, dh.getSoluong());
	        	    pstmt.setString(11, dh.getGiamgia());
	        	    pstmt.setString(12, dh.getThanhtien());
	        	    pstmt.setInt(13, dh.getMahd());
	        	    pstmt.executeUpdate();
	        	    JOptionPane.showMessageDialog(null,"Sửa thành công!");
			        showData3(dbcon.findAll3());        	
	            } catch (SQLException ex) {
	        	    ex.printStackTrace();
	        	}clearTextFields();
	    }
	    private void clearTextFields() {
	        txtMahd.setText("");
	        txtMakh.setText("");
	        txtTenkh.setText("");
	        txtsdt2.setText("");
	        txtNgayban.setText("");
	        txtManv3.setText("");
	        txtMasp3.setText("");
	        txtTensp3.setText("");
	        txtdongia.setText("");
	        txtsize.setText("");
	        txtsoluong.setText("");
	        txtgiamgia.setText("");
	        txtThanhtien.setText("");
	    }
	});
	tbl3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting()) {
	            int selectedRow = tbl3.getSelectedRow();
	            if (selectedRow != -1) {
	                Object mahd = tbl3.getValueAt(selectedRow, 0);
	                Object makh = tbl3.getValueAt(selectedRow, 1);
	                Object tenkh = tbl3.getValueAt(selectedRow, 2);
	                Object sdt = tbl3.getValueAt(selectedRow, 3);
	                Object ngayban = tbl3.getValueAt(selectedRow, 4);
	                Object manv = tbl3.getValueAt(selectedRow, 5);
	                Object masp = tbl3.getValueAt(selectedRow, 6);
	                Object tensp = tbl3.getValueAt(selectedRow, 7);
	                Object dongia = tbl3.getValueAt(selectedRow, 8);
	                Object size = tbl3.getValueAt(selectedRow, 9);
	                Object soluong = tbl3.getValueAt(selectedRow, 10);
	                Object giamgia = tbl3.getValueAt(selectedRow, 11);
	                Object thanhtien = tbl3.getValueAt(selectedRow, 12);

	                txtMahd.setText(mahd.toString());
	                txtMakh.setText(makh.toString());
	                txtTenkh.setText(tenkh.toString());
	                txtsdt2.setText(sdt.toString());
	                txtNgayban.setText(ngayban.toString());
	                txtManv3.setText(manv.toString());
	                txtMasp3.setText(masp.toString());
	                txtTensp3.setText(tensp.toString());
	                txtdongia.setText(dongia.toString());
	                txtsize.setText(size.toString());
	                txtsoluong.setText(soluong.toString());
	                txtgiamgia.setText(giamgia.toString());
	                txtThanhtien.setText(thanhtien.toString());
	                
	            }
	        }
	    }
	});  
	btntimkiem3.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Donhang dh = new Donhang();
				dh.setMahd(Integer.parseInt(txttimkiem3.getText()));
				showData3(dbcon.timkiem3(dh));
				ql3.setVisible(true);
				ql3.addActionListener(new ActionListener() {
								@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txttimkiem3.setText("");
						ql3.setVisible(false);
						showData3(dbcon.findAll3());
					}
				});	
			}	
	    });
	
//Trang4	
	    JPanel panelquanlydangnhap = new JPanel(new BorderLayout());
		JLabel jLabel_4= new JLabel("Quản Lý Đăng Nhập",JLabel.CENTER);
		Font font4 = new Font("Serif",Font.CENTER_BASELINE,50);
		jLabel_4.setFont(font);
	    jLabel_4.setBackground(Color.pink);
	    jLabel_4.setOpaque(true);
	    JPanel pn5 = new JPanel();
	    pn5.setBackground(Color.pink);
     	pn5.setPreferredSize(new Dimension(1200,140));  
	    panelquanlydangnhap.add(pn5,BorderLayout.CENTER);
	    
	    JPanel pn51 = new JPanel (new GridLayout(4,2));
		pn51.setBackground(Color.pink);
		pn51.setPreferredSize(new Dimension(800,130));
		pn5.add(pn51,BorderLayout.WEST);

	    JLabel lblsdt4 = new JLabel("    SĐT:");
	    JTextField txtsdt4 = new JTextField();
	    JLabel lbltaikhoan = new JLabel("    Tài khoản:");
	    JTextField txttaikhoan = new JTextField();
	    JLabel lblmatkhau = new JLabel("    Mật khẩu:");
	    JTextField txtmatkhau= new JTextField();
	    JLabel lblchucvu4 = new JLabel("    Chức vụ:");
	    JTextField txtchucvu4 = new JTextField();
	    pn51.add(lblsdt4);
	    pn51.add(txtsdt4);
	    pn51.add(lbltaikhoan);
	    pn51.add(txttaikhoan);
	    pn51.add(lblmatkhau);
	    pn51.add(txtmatkhau);
	    pn51.add(lblchucvu4);
	    pn51.add(txtchucvu4);
	    
	    JPanel pn52= new JPanel(); 
    	pn52.setBackground(Color.pink);
        pn52.setPreferredSize(new Dimension(1200,660));
        panelquanlydangnhap.add(pn52,BorderLayout.SOUTH);

        JButton btnThem4 = new JButton("Thêm");
     	JButton btnXoa4 = new JButton("Xóa");
    	JButton btnSua4 = new JButton("Sửa");
    	pn52.add(btnThem4);
    	pn52.add(btnXoa4);  
    	pn52.add(btnSua4);
   
    	DefaultTableModel dm4=new DefaultTableModel();
    	dm4.addColumn("SĐT");
    	dm4.addColumn("Tài khoản");
    	dm4.addColumn("Mật khẩu");
    	dm4.addColumn("Chức vụ");
    	tbl4 =new JTable(dm4);
    	JScrollPane sc4=new JScrollPane(tbl4);
    	sc4.setPreferredSize(new Dimension(1190,480));
    	pn52.add(sc4,BorderLayout.SOUTH);
    	showData4(dbcon.findAll4());
		
	panelquanlydangnhap.add(jLabel_4,BorderLayout.NORTH);
        pn.add(panelquanlydangnhap,BorderLayout.CENTER);
	panelquanlydangnhap.setVisible(false);
	btnThem4.addActionListener(new ActionListener() {
	        @Override	
		public void actionPerformed(ActionEvent e) {
	    	    try {	    	    		                
	                String sdt = txtsdt4.getText();        
	                String ten = txttaikhoan.getText();
	                String mk  = txtmatkhau.getText();
	                String chucvu = txtchucvu4.getText();
            
	                DefaultTableModel model = (DefaultTableModel) tbl4.getModel();
	                model.addRow(new Object[]{sdt,ten,mk,chucvu});

	                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
	                String user ="root";
	    	        String password= "haily0910";
	    	        String sqlThem4 = "INSERT INTO QL_CHQA.DangNhap (sdt,taikhoan,matkhau,chucvu) VALUES (?,?,?,?)";
	    	       try {
	    	    	   Connection connection = DriverManager.getConnection(url, user, password);	    	     
	    	           PreparedStatement pstmt = connection.prepareStatement(sqlThem4);
	    	           pstmt.setString(1, sdt);
	    	           pstmt.setString(2,ten);
	    	           pstmt.setString(3, mk);
	    	           pstmt.setString(4, chucvu);
	    	           pstmt.executeUpdate();
	    	       } catch (SQLException e1) {
	    	         e1.printStackTrace();
	    	         }	                 
	            }catch (NumberFormatException ex) { 	
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng.");
                    }
	    	    clearTextFields();
	    	    }	        
	        private void clearTextFields() {
	        	 txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");
	        }
	        });
	     btnXoa4.addActionListener(new ActionListener() {	
	    	 @Override
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Tk tk = new Tk();
				 tk.setSdt(txtsdt4.getText());
				 dbcon.xoa4(tk);
				 showData4(dbcon.findAll4());
				 clearTextFields();
				}
	    	 private void clearTextFields() {
	             txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");  
	             }
	    	 });
	     btnSua4.addActionListener(new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    		 Tk tk= new Tk();
	    	     tk.setSdt(txtsdt4.getText());
	    	     tk.setTen(txttaikhoan.getText());
	    	     tk.setMk(txtmatkhau.getText());
 	             tk.setChucvu(txtchucvu4.getText());
 	        
 	             String url = "jdbc:mysql://localhost:3306/QL_CHQA";
 	             String user = "root"; 
 	             String password = "haily0910";
 	             String query = "UPDATE QL_CHQA.DangNhap SET Taikhoan=?,Matkhau=?, Chucvu=? WHERE Sdt=? ";      
 	             try (Connection connection = DriverManager.getConnection(url, user, password);
 	            		 PreparedStatement pstmt = connection.prepareStatement(query)) { 	 
 	            	 pstmt.setString(1, tk.getTen());
 	                 pstmt.setString(2, tk.getMk());
 	                 pstmt.setString(3, tk.getChucvu());
 	                 pstmt.setString(4, tk.getSdt());               
 	                 pstmt.executeUpdate();
 	                 JOptionPane.showMessageDialog(null,"Sửa thành công!");
			         showData4(dbcon.findAll4());
			         } catch (SQLException ex) {
			        	 ex.printStackTrace();	        
			         } 	       
 	             clearTextFields(); 	   
	    	 } 	   
	    	 private void clearTextFields() {
	        	 txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");  
	             }
	    	 });
	    tbl4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    	    public void valueChanged(ListSelectionEvent event) {
    	        if (!event.getValueIsAdjusting()) {
    	            int selectedRow = tbl4.getSelectedRow();
    	            if (selectedRow != -1) {
    	                Object sdt = tbl4.getValueAt(selectedRow, 0);
    	                Object ten = tbl4.getValueAt(selectedRow, 1);
    	                Object mk = tbl4.getValueAt(selectedRow, 2);
    	                Object chucvu = tbl4.getValueAt(selectedRow, 3);
    	                
    	                txtsdt4.setText(sdt.toString());
    	                txttaikhoan.setText(ten.toString());
    	                txtmatkhau.setText(mk.toString());
    	                txtchucvu4.setText(chucvu.toString());
    	              
    	            }
    	        }
    	    }
    	});		
	quanlynhanvien.addActionListener(e -> {            
		if (!panelquanlynhanvien.isVisible()) {
             panelquanlynhanvien.setVisible(true);
             panelquanlysanpham.setVisible(false);
             panelquanlydonhang.setVisible(false); 
             panelquanlydangnhap.setVisible(false);
		}
	});        
	quanlysanpham.addActionListener(e -> {            
		if (!panelquanlysanpham.isVisible()) {
             panelquanlysanpham.setVisible(true);
             panelquanlynhanvien.setVisible(false);
             panelquanlydonhang.setVisible(false); 
             panelquanlydangnhap.setVisible(false);
		}       
	});       
	quanlydonhang.addActionListener(e -> {               
		if (!panelquanlydonhang.isVisible()) {                   
			panelquanlydonhang.setVisible(true);                  
			panelquanlynhanvien.setVisible(false);                    
			panelquanlysanpham.setVisible(false);
			panelquanlydangnhap.setVisible(false);
		}        
	});
	quanlydangnhap.addActionListener(e -> {               
		if (!panelquanlydangnhap.isVisible()) {                   
			panelquanlydangnhap.setVisible(true);                  
			panelquanlynhanvien.setVisible(false);                    
			panelquanlysanpham.setVisible(false);
			panelquanlydonhang.setVisible(false);
		}        
	});
	add(panel,BorderLayout.CENTER);
    setLocationRelativeTo(null);
    setVisible(true);		
	}	
	private void displayImage(String imagePath) {
		if (imagePath != null && !imagePath.isEmpty()) {
	    ImageIcon originalIcon = new ImageIcon(imagePath);
	    Image originalImage = originalIcon.getImage();
	    Image resizedImage = originalImage.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    a.setIcon(resizedIcon);
		 } else {
		   a.setIcon(null);
		 }		 
	}
	private void displayImage2(String imagePath2) {
	        if (imagePath2 != null && !imagePath2.isEmpty()) {
	    ImageIcon originalIcon = new ImageIcon(imagePath2);
	    Image originalImage = originalIcon.getImage();
	    Image resizedImage = originalImage.getScaledInstance(150, 160, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    a2.setIcon(resizedIcon);
		} else {
	      a2.setIcon(null);
	    }
	}

	public void showData(List<NhanVien> nhanViens) {
		List<NhanVien>Lnv = new ArrayList<>();
    	Lnv=nhanViens;
    	DefaultTableModel nvmodel;
    	tbl.getModel();
    	nvmodel = (DefaultTableModel)tbl.getModel();
    	nvmodel.setRowCount(0);
	    Lnv.forEach(nhanvien -> {
	        nvmodel.addRow(new Object[]{
	                nhanvien.getManv(), nhanvien.getTennv(), nhanvien.getSdt(), nhanvien.getGioitinh(),
	                nhanvien.getNgayvaolv(), nhanvien.getNgaysinh(), nhanvien.getChucvu(),nhanvien.getAnh()
	        });
	    });
	}
	public void showData2(List<Sanpham> sanpham) {
		List<Sanpham>Lsp = new ArrayList<>();
    	Lsp=sanpham;
    	DefaultTableModel spmodel;
    	tbl2.getModel();
    	spmodel = (DefaultTableModel)tbl2.getModel();
    	spmodel.setRowCount(0);
	    Lsp.forEach(sp -> {
	        spmodel.addRow(new Object[]{
	                sp.getMaSp(), sp.getChatLieu(), sp.getTenSp(), sp.getSize(),
	                sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(),sp.getAnh()
	        });
	    });
	}
	public void showData3(List<Donhang> donhang1) {
		List<Donhang>Ldh1 = new ArrayList<>();
    	Ldh1=donhang1;
    	DefaultTableModel dh1model;
    	tbl3.getModel();
    	dh1model = (DefaultTableModel)tbl3.getModel();
    	dh1model.setRowCount(0);
	    Ldh1.forEach(dh1 -> {
	        dh1model.addRow(new Object[]{
	                dh1.getMahd(), dh1.getMakh(), dh1.getTenkh(),
	                dh1.getSdt(),dh1.getNgayban(), dh1.getManv(), dh1.getMasp(), dh1.getTensp(), dh1.getDongia(), dh1.getSize(),
	                dh1.getSoluong(), dh1.getGiamgia(), dh1.getThanhtien()
	        });
	    });
	}
	public void showData4(List<Tk> tk) {
		List<Tk>Ltk = new ArrayList<>();
    	Ltk=tk;
    	DefaultTableModel tkmodel;
    	tbl4.getModel();
    	tkmodel = (DefaultTableModel)tbl4.getModel();
    	tkmodel.setRowCount(0);
	    Ltk.forEach(tk1 -> {
	        tkmodel.addRow(new Object[]{
	                tk1.getSdt(), tk1.getTen(), tk1.getMk(),tk1.getChucvu()
	        });
	    });
	}
    public static void main(String[] args) {
    	QLCHQA qly = new QLCHQA();
    	qly.setLocationRelativeTo(null);
		qly.setVisible(true);    	
    }
}
