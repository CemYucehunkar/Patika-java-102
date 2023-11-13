package WİEW;

import Helper.Confing;
import Helper.Helper;
import Model.Otel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Employee extends JFrame {

    private JPanel wrapper;
    private JScrollPane scr_otel_list;
    private JTable tbl_otel_list;
    private JTextField fld_otel_name;
    private JTextField fld_otel_city;
    private JTextField fld_otel_loc;
    private JTextField fld_otel_mail;
    private JTextField fld_otel_phone;
    private JTextField fld_otel_star;
    private JButton ekleButton;
    private JTextField fld_otel_adres;
    private JTextField fld_tex;
    private JTextField fld_otel_id;
    private JButton btn_otel_delete;
    private JTextField textField1;
    private JButton ekleButton1;
    private JTextField textField2;
    private JButton silButton;
    private JPanel wraperrıght;
    private JTextField textField3;

    private DefaultTableModel mdl_otel_list;
    private Object[] row_otel_list;


    public Employee() {
        add(wrapper);
        setSize(500, 700);
        setTitle(Confing.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        Helper.setLayout();
        setResizable(true);


        mdl_otel_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_otellist = {"id", "Otel Adı", "Şehir", "Bölge", "Adres", "Star", "İletişim","Oda Özellikleri"};
        mdl_otel_list.setColumnIdentifiers(col_otellist);
        row_otel_list = new Object[col_otellist.length];
        loadOtelList();
        tbl_otel_list.setModel(mdl_otel_list);
        tbl_otel_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_otel_list.getTableHeader().setReorderingAllowed(false);
        tbl_otel_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_otel_id = tbl_otel_list.getValueAt(tbl_otel_list.getSelectedRow(), 0).toString();
                fld_otel_id.setText(select_otel_id);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        });


        ekleButton.addActionListener(e -> {
            if (Helper.isEmpty(fld_otel_name) ||
                    Helper.isEmpty(fld_otel_city) ||
                    Helper.isEmpty(fld_otel_loc) ||
                    Helper.isEmpty(fld_otel_adres) ||
                    Helper.isEmpty(fld_otel_star) ||
                    Helper.isEmpty(fld_otel_phone) ||
                    Helper.isEmpty(fld_tex) ||
                    Helper.isEmpty(fld_otel_mail)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_otel_name.getText();
                String city = fld_otel_city.getText();
                String bolge = fld_otel_loc.getText();
                String adres = fld_otel_adres.getText();
                String star = fld_otel_star.getText();
                String phone = fld_otel_phone.getText();
                String room = fld_tex.getText();
                String mail = fld_otel_mail.getText();

                if (Otel.add(name, city, bolge, adres, star, phone,mail)) {
                    Helper.showMsg("done");
                    loadOtelList();

                   /* fld_otel_name.setText(null);
                    fld_otel_city.setText(null);
                    fld_otel_loc.setText(null);
                    fld_otel_adres.setText(null);
                    fld_otel_star.setText(null);
                    fld_otel_phone.setText(null);
                    fld_tex.setText(null);*/
                }
            }

        });
        btn_otel_delete.addActionListener(e -> {
            if (Helper.isEmpty(fld_otel_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int select_id = Integer.parseInt(fld_otel_id.getText());
                    if (Otel.delete(select_id)) {
                        Helper.showMsg("done");
                        loadOtelList();
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }


        });

    }

    private void loadOtelList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_otel_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;

        for (Otel obj : Otel.getList()) {
            i = 0;

            row_otel_list[i++] = obj.getId();
            row_otel_list[i++] = obj.getName();
            row_otel_list[i++] = obj.getSehir();
            row_otel_list[i++] = obj.getBolge();
            row_otel_list[i++] = obj.getAdres();
            row_otel_list[i++] = obj.getStar();
            row_otel_list[i++] = obj.getPhone();
            row_otel_list[i++] = obj.getRoom();
            mdl_otel_list.addRow(row_otel_list);


        }
    }


    public static void main(String[] args) {
        Employee employee = new Employee();

    }
}
