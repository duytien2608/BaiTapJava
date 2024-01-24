package quanLyThuTienDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtSoNha;
	private JTextField txtMa;
	private JTextField txtSoCu;
	private JTextField txtSoMoi;
	ArrayList<ModelThongTin> list = new ArrayList<ModelThongTin>();
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManHinhChinh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhChinh.class.getResource("/images/pay.png")));
		setTitle("Quản lý thu tiên điện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ BIÊN LAI THU TIỀN ĐIỆN");
		lblNewLabel.setForeground(new Color(250, 128, 114));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(258, 26, 443, 51);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 75, 896, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Họ Và Tên:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(79, 291, 130, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số Nhà:");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(79, 353, 130, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mã Công Tơ Điện:");
		lblNewLabel_1_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(79, 420, 167, 35);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Số Cũ:");
		lblNewLabel_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(516, 291, 130, 35);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Số Mới:");
		lblNewLabel_1_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(516, 353, 130, 35);
		contentPane.add(lblNewLabel_1_4);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTen.setBounds(271, 291, 176, 35);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(271, 353, 176, 35);
		contentPane.add(txtSoNha);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMa.setColumns(10);
		txtMa.setBounds(271, 420, 176, 35);
		contentPane.add(txtMa);

		txtSoCu = new JTextField();
		txtSoCu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCu.setColumns(10);
		txtSoCu.setBounds(656, 291, 154, 35);
		contentPane.add(txtSoCu);

		txtSoMoi = new JTextField();
		txtSoMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoMoi.setColumns(10);
		txtSoMoi.setBounds(656, 353, 154, 35);
		contentPane.add(txtSoMoi);

		JButton btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themThongTin();
			}
		});
		btnThem.setBackground(new Color(250, 128, 114));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(172, 503, 98, 35);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (opt == JOptionPane.YES_OPTION) {
					int index = table.getSelectedRow();

					// Xóa dòng được lựa chọn
					if (index >= 0) {
						((DefaultTableModel) table.getModel()).removeRow(index);
					}
				}
			}
		});
		btnXoa.setBackground(new Color(250, 128, 114));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBounds(354, 503, 98, 35);
		contentPane.add(btnXoa);

		JButton btnChnhSua = new JButton("CHỈNH SỬA");
		btnChnhSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn chỉnh sửa?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (opt == JOptionPane.YES_OPTION) {
					chinhSua();
				}
			}
		});
		btnChnhSua.setBackground(new Color(250, 128, 114));
		btnChnhSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChnhSua.setBounds(516, 503, 147, 35);
		contentPane.add(btnChnhSua);

		JButton btnHuy = new JButton("HỦY BỎ");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn hủy bỏ?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (opt == JOptionPane.YES_OPTION) {
					resetForm();

				}
			}
		});
		btnHuy.setBackground(new Color(250, 128, 114));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(749, 503, 130, 35);
		contentPane.add(btnHuy);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(103, 99, 789, 148);
		contentPane.add(scrollPane_2);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienThiForm();
			}
		});
		scrollPane_2.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "H\u1ECD V\u00E0 T\u00EAn", "S\u1ED1 Nh\u00E0",
						"M\u00E3 C\u00F4ng T\u01A1 \u0110i\u1EC7n", "S\u1ED1 C\u0169", "S\u1ED1 M\u1EDBi",
						"T\u1ED5ng Ti\u1EC1n \u0110i\u1EC7n" }));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hienThiDataVaoTable();

	}

	public void hienThiDataVaoTable() {
		for (ModelThongTin tn : list) {
			model.addRow(new Object[] { tn.getHoVaTen(), tn.getSoNha(), tn.getMaCongToDien(), tn.getSoCu(),
					tn.getSoMoi(), null });
		}
	}

	public void hienThiForm() {
		int row = table.getSelectedRow();

		String hoTen = table.getValueAt(row, 0).toString();
		String soNha = table.getValueAt(row, 1).toString();
		String ma = table.getValueAt(row, 2).toString();
		int soCu = Integer.parseInt(table.getValueAt(row, 3).toString());
		int soMoi = Integer.parseInt(table.getValueAt(row, 4).toString());

		// Hiển thị dữ liệu
		txtHoTen.setText(hoTen);
		txtSoNha.setText(soNha);
		txtMa.setText(ma);
		txtSoCu.setText(String.valueOf(soCu));
		txtSoMoi.setText(String.valueOf(soMoi));

	}

	public void chinhSua() {
		int row = table.getSelectedRow();

		// Lấy giá trị của các ô trong dòng được lựa chọn
		String hoTen = txtHoTen.getText();
		String soNha = txtSoNha.getText();
		String ma = txtMa.getText();
		int soCu = Integer.parseInt(txtSoCu.getText());
		int soMoi = Integer.parseInt(txtSoMoi.getText());
		int tongTien = (soMoi - soCu) * 3000;

		// Điền thông tin vào các JTextField
		txtHoTen.setText(hoTen);
		txtSoNha.setText(soNha);
		txtMa.setText(ma);
		txtSoCu.setText(String.valueOf(soCu));
		txtSoMoi.setText(String.valueOf(soCu));

		ModelThongTin tn = new ModelThongTin(hoTen, soNha, ma, soCu, soMoi, tongTien);
		// Chỉnh sửa thông tin của dòng được lựa chọn
		table.getModel().setValueAt(hoTen, row, 0);
		table.getModel().setValueAt(soNha, row, 1);
		table.getModel().setValueAt(ma, row, 2);
		table.getModel().setValueAt(soCu, row, 3);
		table.getModel().setValueAt(soMoi, row, 4);
		table.getModel().setValueAt(tongTien, row, 5);
		resetForm();
	}

	public void resetForm() {
		txtHoTen.setText("");
		txtSoNha.setText("");
		txtMa.setText("");
		txtSoCu.setText("");
		txtSoMoi.setText("");
	}

	protected void themThongTin() {
		// TODO Auto-generated method stub
		String hoTen = txtHoTen.getText();
		String soNha = txtSoNha.getText();
		String ma = txtMa.getText();
		int soCu = Integer.parseInt(txtSoCu.getText());
		int soMoi = Integer.parseInt(txtSoMoi.getText());
		int tongTien = (soMoi - soCu) * 3000;

		if (validData()) {
			JOptionPane.showMessageDialog(this, "Tạo mới thành công");
			resetForm();
			Object[] rowData = new Object[] { hoTen, soNha, ma, soCu, soMoi, tongTien };

			((DefaultTableModel) table.getModel()).addRow(rowData);

		}

	}

	private boolean validData() {
		String hoTen = txtHoTen.getText();
		String soNha = txtSoNha.getText();
		String ma = txtMa.getText();
		int soCu = Integer.parseInt(txtSoCu.getText());
		int soMoi = Integer.parseInt(txtSoMoi.getText());
//		Họ tên không được để trống, có thể gồm nhiều từ ngăn cách bởi khoảng 
//		trắng. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự 
		if (!(hoTen.length() > 0 && hoTen.matches("[\\p{L}' ]+"))) {
			JOptionPane.showMessageDialog(this, "Họ tên không được chứa số và kí tự đặc biệt");
			return false;
		}
		if (!(soCu > 0)) {
			JOptionPane.showMessageDialog(this, "Số cũ phải lớn hơn 0 và không chứa ký tự đặc biệt");
			return false;
		}
		if (!(soMoi > soCu)) {
			JOptionPane.showMessageDialog(this, "Số mới phải lớn hơn số cũ và không chứa ký tự đặc biệt");
			return false;
		}
		return true;
	}

	protected void lamMoiBang() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		hienThiDataVaoTable();
	}
}
