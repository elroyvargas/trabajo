package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import implementacion.ImplPersona;
import entidad.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    JTextField fromField = new JTextField(" ", 30);
    JTextField toField = new JTextField(30);
    JButton goButton = new JButton("Exit");
    JButton addButton = new JButton("Add");
    JButton delButton = new JButton("Remove");
    JTable jTable;
    JScrollPane jSP;
    ImplPersona  personData = new ImplPersona();

    public PersonDialog() {
        setSize(500, 500);
        setTitle("Person Dialog");
        setLocationRelativeTo(null);

        initForm();
        paintTable();
    }

    private void paintTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        List<Persona> lis = personData.list();
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
        for (Persona d : lis) {
            modelo.addRow(new Object[] { d.getId(), d.getNombres(), d.getSexo() });
        }
    }

    void initForm() {

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][] {
                // { 1, 2 },
                // { 3, 4 }
        }, new String[] { "ID", "Name", "Sex" }));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("From:"));
        add(fromField);
        add(new JLabel("To:"));
        add(toField);
        add(addButton);
        add(delButton);
        add(jSP);
        add(goButton);

        // Manejo de eventos
        final JDialog outer = this;
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println(" goButton has press ");
                outer.setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson(e);
            }
        });
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson(e);
            }
        });

    }

    void addPerson(ActionEvent e) {
        System.out.println(" addButton has press ");
        Persona d = new Persona();
        d.setNombres(fromField.getText());
        d.setSexo(toField.getText());
        personData.create(d);
        paintTable();
    }

    void delPerson(ActionEvent e) {
        if (jTable.getSelectedRow() != -1) {
            System.out.println(" delButton has press ");
            int[] row = jTable.getSelectedRows();
            String ids = jTable.getValueAt(row[0], 0).toString();
            System.out.println("selected: " + ids);
            int id = Integer.parseInt(ids);
            try {
                personData.delete(id);
            } catch (Exception ex) {
                Logger.getLogger(PersonDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            paintTable();
        }
    }
}