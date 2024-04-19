package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Menu extends JPanel implements ActionListener {
    private JFrame frame;
    public static JPanel panelCardLayout;
    private JLabel title;
    private JButton quanLySach;
    private JButton quanLyNhanVien;
    private JButton quanLyHoaDon;
    private JButton thongKe;
    private JButton exit;
    private JButton quanLyKhachHang;
    public static CardLayout cardLayout = new CardLayout();
    public Menu() {
        frame = new JFrame();
        frame.setTitle("Book Management");
        panelCardLayout = new JPanel();
        panelCardLayout.setLayout(cardLayout);
        initPanel();
        panelCardLayout.add(this,"menu");
        panelCardLayout.add(new QuanLySach(),"quanlysach");
        panelCardLayout.add(new ThongKe(),"thongke");
        panelCardLayout.add(new QuanLyNhanVien(),"quanlynhanvien");
        panelCardLayout.add(new QuanLyKhachHang(),"quanlykhachhang");
        panelCardLayout.add(new QuanLyHoaDon(),"quanlyhoadon");
        frame.add(panelCardLayout);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void initPanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1050,700));
        this.setBackground(new Color(55,55,55));
        title = new JLabel("QUẢN LÝ BÁN SÁCH TẠI HIỆU SÁCH - NHÓM 7");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("",Font.PLAIN,30));
        title.setBounds(200,50,800,40);
        this.add(title);
        //-------------
        quanLySach = new JButton("Quản Lý Sách");
        quanLySach.setFont(new Font("",Font.PLAIN,20));
        quanLySach.setBounds(120,220,250,80);
        this.add(quanLySach);
        quanLyNhanVien = new JButton("Quản Lý Nhân Viên");
        quanLyNhanVien.setFont(new Font("",Font.PLAIN,20));
        quanLyNhanVien.setBounds(120,320,250,80);
        this.add(quanLyNhanVien);
        quanLyHoaDon = new JButton("Quản Lý Hoá Đơn");
        quanLyHoaDon.setFont(new Font("",Font.PLAIN,20));
        quanLyHoaDon.setBounds(400,220,250,80);
        this.add(quanLyHoaDon);
        thongKe = new JButton("Thống kê");
        thongKe.setFont(new Font("",Font.PLAIN,20));
        thongKe.setBounds(680,220,250,80);
        this.add(thongKe);
        exit = new JButton("Exit");
        exit.setFont(new Font("",Font.PLAIN,20));
        exit.setBounds(680,320,250,80);
        this.add(exit);
        quanLyKhachHang = new JButton("Quản Lý Khách Hàng");
        quanLyKhachHang.setFont(new Font("",Font.PLAIN,20));
        quanLyKhachHang.setBounds(400,320,250,80);
        this.add(quanLyKhachHang);
        quanLySach.addActionListener(this);
        quanLyKhachHang.addActionListener(this);
        quanLyHoaDon.addActionListener(this);
        quanLyNhanVien.addActionListener(this);
        thongKe.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quanLySach) {
            cardLayout.show(panelCardLayout,"quanlysach");
        }
        else if(e.getSource() == quanLyHoaDon) {
            cardLayout.show(panelCardLayout,"quanlyhoadon");
        }
        else if(e.getSource() == quanLyKhachHang) {
            cardLayout.show(panelCardLayout,"quanlykhachhang");
        }
        else if(e.getSource() == quanLyNhanVien) {
            cardLayout.show(panelCardLayout,"quanlynhanvien");
        }
        else if(e.getSource() == thongKe) {
            cardLayout.show(panelCardLayout,"thongke");
        }
        else if(e.getSource() == exit) {
            exit(0);
        }
    }
}
