package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import connect.ConnectThongKe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThongKe extends JPanel implements ActionListener {
    private JLabel title;
    private BufferedImage title_image;
    private JPanel panelBar;
    private JButton sachBanChay;
    private JButton hieusuatNV;
    private JButton ChiNhanh;
    private JButton tonKho;
    private JPanel panelCardLayout;
    private CardLayout cardLayout = new CardLayout();
    private JPanel panelSachBanChay;
    private JPanel panelHieuSuatNV;
    private JPanel panelTonKho;
    private JPanel panelChiNhanh;
    private JButton thongKe;
    private JPanel panelThongKe;
    private ConnectThongKe connectThongKe;

    public ThongKe() {
        connectThongKe = new ConnectThongKe();
        this.setPreferredSize(new Dimension(1050, 700));
        this.setLayout(null);
        try {
            title_image = ImageIO.read(new File("resources/images/filter_40px.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        title = new JLabel("Thống Kê");
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(60, 20, 120, 40);
        this.add(title);
        initPanelBar();
    }

    public void initPanelBar() {
        panelBar = new JPanel();
        panelBar.setLayout(null);
        panelBar.setBounds(0, 72, 1050, 40);
        this.add(panelBar);
        sachBanChay = new JButton("Sách bán chạy");
        sachBanChay.setBackground(new Color(140, 181, 90));
        sachBanChay.setFocusPainted(false);
        sachBanChay.setForeground(Color.WHITE);
        sachBanChay.setFont(new Font("", Font.PLAIN, 16));
        sachBanChay.setBounds(0, 0, 160, 35);
        panelBar.add(sachBanChay);
        tonKho = new JButton("Tồn kho");
        tonKho.setBackground(Color.GRAY);
        tonKho.setFocusPainted(false);
        tonKho.setForeground(Color.WHITE);
        tonKho.setFont(new Font("", Font.PLAIN, 16));
        tonKho.setBounds(160, 0, 160, 35);
        panelBar.add(tonKho);
        hieusuatNV = new JButton("Hiệu suất nhân viên");
        hieusuatNV.setBackground(Color.GRAY);
        hieusuatNV.setFocusPainted(false);
        hieusuatNV.setForeground(Color.WHITE);
        hieusuatNV.setFont(new Font("", Font.PLAIN, 14));
        hieusuatNV.setBounds(320, 0, 162, 35);
        panelBar.add(hieusuatNV);
        ChiNhanh = new JButton("Chi nhánh");
        ChiNhanh.setBackground(Color.GRAY);
        ChiNhanh.setFocusPainted(false);
        ChiNhanh.setForeground(Color.WHITE);
        ChiNhanh.setFont(new Font("", Font.PLAIN, 16));
        ChiNhanh.setBounds(480, 0, 160, 35);
        panelBar.add(ChiNhanh);
        thongKe = new JButton("Thống kê");
        thongKe.setBackground(Color.GRAY);
        thongKe.setFocusPainted(false);
        thongKe.setForeground(Color.WHITE);
        thongKe.setFont(new Font("", Font.PLAIN, 16));
        thongKe.setBounds(640, 0, 160, 35);
        panelBar.add(thongKe);
        JButton exit = new JButton("Exit");
        exit.setBackground(Color.GRAY);
        exit.setFocusPainted(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("", Font.PLAIN, 16));
        exit.setBounds(800, 0, 160, 35);
        panelBar.add(exit);
        sachBanChay.addActionListener(this);
        hieusuatNV.addActionListener(this);
        tonKho.addActionListener(this);
        ChiNhanh.addActionListener(this);
        thongKe.addActionListener(this);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.cardLayout.show(Menu.panelCardLayout, "menu");
            }
        });
        initPanelAll();
    }

    public void initPanelAll() {
        panelCardLayout = new JPanel();
        this.add(panelCardLayout);
        panelCardLayout.setLayout(cardLayout);
        panelCardLayout.setBounds(0, 110, 1050, 590);
        panelCardLayout.setBackground(new Color(55, 55, 55));
        initSachBanChay();
        initChiNhanh();
        initHieuSuatNV();
        initTonKho();
        initThongKe();
        panelCardLayout.add(panelSachBanChay, "sachbanchay");
        panelCardLayout.add(panelHieuSuatNV, "hieusuatnhanvien");
        panelCardLayout.add(panelTonKho, "tonkho");
        panelCardLayout.add(panelChiNhanh, "ChiNhanh");
        panelCardLayout.add(panelThongKe, "thongke");
    }

    public void initThongKe() {
        panelThongKe = new JPanel();
        panelThongKe.setLayout(null);
        panelThongKe.setBounds(0, 110, 1050, 590);
        JLabel title = new JLabel("Doanh thu năm nay: ");
        title.setForeground(new Color(196, 17, 17));
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(340, 10, 400, 28);
        JLabel doanhThu = new JLabel();
        String res = String.valueOf(connectThongKe.getDoanhThuNam());
        if (res.equals("null"))
            res = "Năm nay hiệu sách đóng cửa không nhập xuất";
        doanhThu.setText(res);
        doanhThu.setBounds(560, 10, 500, 30);
        doanhThu.setForeground(new Color(176, 42, 42));
        doanhThu.setFont(new Font("", Font.BOLD, 20));
        panelThongKe.add(doanhThu);
        panelThongKe.add(title);
    }

    public void initChiNhanh() {
        panelChiNhanh = new JPanel();
        panelChiNhanh.setLayout(null);
        panelChiNhanh.setBounds(0, 110, 1050, 590);
        panelChiNhanh.setBackground(new Color(55, 55, 55));
        JLabel title = new JLabel("Thông tin mua bán của các chi nhánh trong năm nay");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("", Font.PLAIN, 18));
        title.setBounds(340, 10, 500, 28);
        panelChiNhanh.add(title);
        JTable tableChiNhanh = new JTable(connectThongKe.getDoanhThuCacChiNhanh());
        JScrollPane scrollPane = new JScrollPane(tableChiNhanh);
        scrollPane.setBounds(0, 40, 1050, 660);
        panelChiNhanh.add(scrollPane);
    }

    public void initTonKho() {
        panelTonKho = new JPanel();
        panelTonKho.setLayout(null);
        panelTonKho.setBounds(0, 110, 1050, 590);
        panelTonKho.setBackground(new Color(55, 55, 55));
        JLabel title = new JLabel("Số lượng sách tồn kho trong tháng này");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("", Font.PLAIN, 18));
        title.setBounds(340, 10, 400, 28);
        panelTonKho.add(title);
        JTable tableTonKho = new JTable(connectThongKe.getSoLuongTonKhoTrongThangNay());
        JScrollPane scrollPane = new JScrollPane(tableTonKho);
        scrollPane.setBounds(0, 40, 1050, 660);
        panelTonKho.add(scrollPane);
    }

    public void initHieuSuatNV() {
        panelHieuSuatNV = new JPanel();
        panelHieuSuatNV.setLayout(null);
        panelHieuSuatNV.setBounds(0, 110, 1050, 590);
        panelHieuSuatNV.setBackground(new Color(55, 55, 55));
        JLabel title = new JLabel("Top các nhân viên làm tốt theo tháng");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("", Font.PLAIN, 18));
        title.setBounds(350, 10, 400, 28);
        panelHieuSuatNV.add(title);
        JTable tableHieuSuatNV = new JTable(connectThongKe.getNhanVienTot());
        JScrollPane scrollPane = new JScrollPane(tableHieuSuatNV);
        scrollPane.setBounds(0, 40, 1050, 660);
        panelHieuSuatNV.add(scrollPane);
    }

    public void initSachBanChay() {
        panelSachBanChay = new JPanel();
        panelSachBanChay.setLayout(null);
        panelSachBanChay.setBounds(0, 110, 1050, 590);
        panelSachBanChay.setBackground(new Color(55, 55, 55));
        JButton all = new JButton("Tất cả");
        all.setBounds(0, 10, 100, 28);
        all.setBackground(new Color(39, 96, 131, 231));
        all.setFocusPainted(false);
        all.setForeground(Color.WHITE);
        all.setFont(new Font("", Font.PLAIN, 16));
        panelSachBanChay.add(all);
        JLabel month = new JLabel("Tháng:");
        month.setForeground(Color.WHITE);
        month.setFont(new Font("", Font.PLAIN, 16));
        month.setBounds(560, 10, 60, 28);
        panelSachBanChay.add(month);
        JTextField monthField = new JTextField();
        monthField.setBounds(620, 10, 60, 28);
        panelSachBanChay.add(monthField);
        JLabel year = new JLabel("Năm:");
        year.setForeground(Color.WHITE);
        year.setFont(new Font("", Font.PLAIN, 16));
        year.setBounds(700, 10, 50, 28);
        panelSachBanChay.add(year);
        JTextField yearField = new JTextField();
        yearField.setBounds(740, 10, 60, 28);
        panelSachBanChay.add(yearField);

        JLabel top = new JLabel("TOP");
        top.setForeground(Color.WHITE);
        top.setFont(new Font("", Font.PLAIN, 16));
        top.setBounds(820, 10, 40, 28);
        panelSachBanChay.add(top);
        String[] optionsv2 = { "2", "5", "10" };
        JComboBox selectOptionsTop = new JComboBox<>(optionsv2);
        selectOptionsTop.setBounds(860, 10, 60, 28);
        panelSachBanChay.add(selectOptionsTop);
        JButton search = new JButton("Load");
        search.setBounds(930, 10, 120, 28);
        search.setBackground(new Color(75, 184, 158));
        search.setFocusPainted(false);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("", Font.PLAIN, 16));
        panelSachBanChay.add(search);
        JTable tableSachBanChay = new JTable(connectThongKe.getSachBanChay());
        JScrollPane scrollPane = new JScrollPane(tableSachBanChay);
        scrollPane.setBounds(0, 40, 1050, 660);
        panelSachBanChay.add(scrollPane);

        all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableSachBanChay.setModel(connectThongKe.getSachBanChay());
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String top = selectOptionsTop.getSelectedItem().toString();
                String month = monthField.getText();
                String year = yearField.getText();
                if (month.isEmpty() || year.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    tableSachBanChay.setModel(connectThongKe.getSachBanChay(top, month, year));
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.drawImage(title_image, 20, 20, 38, 38, this);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 70, 1050, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sachBanChay) {
            sachBanChay.setBackground(new Color(140, 181, 90));
            hieusuatNV.setBackground(Color.GRAY);
            tonKho.setBackground(Color.GRAY);
            ChiNhanh.setBackground(Color.GRAY);
            thongKe.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "sachbanchay");
        } else if (e.getSource() == hieusuatNV) {
            hieusuatNV.setBackground(new Color(140, 181, 90));
            ChiNhanh.setBackground(Color.GRAY);
            tonKho.setBackground(Color.GRAY);
            sachBanChay.setBackground(Color.GRAY);
            thongKe.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "hieusuatnhanvien");
        } else if (e.getSource() == ChiNhanh) {
            ChiNhanh.setBackground(new Color(140, 181, 90));
            tonKho.setBackground(Color.GRAY);
            hieusuatNV.setBackground(Color.GRAY);
            sachBanChay.setBackground(Color.GRAY);
            thongKe.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "ChiNhanh");
        } else if (e.getSource() == tonKho) {
            tonKho.setBackground(new Color(140, 181, 90));
            ChiNhanh.setBackground(Color.GRAY);
            hieusuatNV.setBackground(Color.GRAY);
            sachBanChay.setBackground(Color.GRAY);
            thongKe.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "tonkho");
        } else if (e.getSource() == thongKe) {
            thongKe.setBackground(new Color(140, 181, 90));
            ChiNhanh.setBackground(Color.GRAY);
            hieusuatNV.setBackground(Color.GRAY);
            sachBanChay.setBackground(Color.GRAY);
            tonKho.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "thongke");
        }
    }
}
