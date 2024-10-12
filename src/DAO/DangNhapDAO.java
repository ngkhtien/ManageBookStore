package DAO;

import DTO.KhachHangDTO;
import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DangNhapDAO {
    SqlConnect conn = new SqlConnect("localhost", "root", "", "bookstore");
    
    public DangNhapDAO(){
        try{
            conn.testDriver();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database taikhoan");
        }
    }
    
    public ArrayList docTK(){
        ArrayList<TaiKhoanDTO> taikhoan = new ArrayList<>();
        try {
            String query = "select * from taikhoan";
            ResultSet rs = conn.executeQuery(query);
            
            while(rs.next()){
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaTK(rs.getString("MaTK"));
                tk.setTenTK(rs.getString("TenTaiKhoan"));
                tk.setMk(rs.getString("MatKhau"));
                tk.setQuyen(rs.getString("Quyen"));
                tk.setStatus(rs.getInt("TrangThai")==1?true:false);                
                taikhoan.add(tk);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ database");
        }
        return taikhoan;
    }
}
