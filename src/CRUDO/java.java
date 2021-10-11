/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class java extends JFrame {
    
    
    
    
    
    JLabel lb_nombres    = new JLabel("Nombres: ");
    JLabel lb_ap_paterno = new JLabel("Ap. Paterno: ");
    JLabel lb_ap_materno = new JLabel("Ap. Materno: ");
    JLabel lb_codigo     = new JLabel("Codigo: ");
    
    JTextField txf_nombres    = new JTextField();
    JTextField txf_ap_paterno = new JTextField();
    JTextField txf_ap_materno = new JTextField();
    JTextField txf_codigo     = new JTextField();
    
    
    MetodosSistema metodos=new MetodosSistema();
    
    
    
    public java(){
       JMenuBar  menuBar  = new JMenuBar();
       JMenu menuFile = new JMenu(); 
       JMenu menuMantenimiento = new JMenu ();
       JMenu menuReportes = new JMenu ();
       
       JMenuItem menuFileExit = new JMenuItem();
       JMenuItem menuMantenimientoRegistrar = new JMenuItem();
       JMenuItem menuMantenimientoEliminar = new JMenuItem ();
       
       JMenuItem menuReporteGeneral  = new  JMenuItem();
       JMenuItem menuReporteDetallado = new JMenuItem();
          
       menuFile.setText ("File");
       menuFileExit.setText("salir");
       
       menuMantenimiento.setText("crud");
       menuMantenimientoRegistrar.setText("Registrar");
       menuMantenimientoEliminar.setText("Eliminar");
       
       menuReportes.setText("Reportes");
       menuReporteGeneral.setText("R.Global");
       menuReporteDetallado.setText("R.detallado");
       menuFile.add(menuFileExit);
       menuMantenimiento.add(menuMantenimientoRegistrar);
       menuMantenimiento.add(menuMantenimientoEliminar);
       menuReportes.add(menuReporteGeneral);
       menuReportes.add(menuReporteDetallado);
       menuBar.add(menuFile);
       menuBar.add(menuMantenimiento);
       menuBar.add(menuReportes);
        setTitle("PRACTICA CRUD VECTOR");
        setJMenuBar(menuBar);
        setSize(new Dimension(650, 700));
        
        menuFileExit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  System.exit(0);
                }
            }
        );
        
        menuReporteGeneral.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 String columnas[] = {"Nombres","Ap_Paterno","Ap_Materno","Codigo"};
                 DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
                                           
                            
                            //  ArrayList<DatosPersona> datospersonaslist = new ArrayList<DatosPersona>();
                     ArrayList<DatosPersona> datospersonaslist = metodos.listarPersona();
                     for (DatosPersona datosPersona : datospersonaslist) {
                         Object[] objs ={datosPersona.nombres,datosPersona.ap_paterno,datosPersona.ap_materno,datosPersona.codigo};
                        tableModel.addRow(objs);
                        
                    }
                     JTable table = new JTable(tableModel);
                     JScrollPane  tabla1= new JScrollPane(table);
                       JPanel reporte = new JPanel();
                      reporte.add(tabla1);
                      
                      
                      Object msg[]={reporte};
                      JOptionPane.showMessageDialog(null, msg,"Reporte ",JOptionPane.QUESTION_MESSAGE);
                      
                         
                    
                 /* Object filas [][]=new Object[metodos.lista.size()][4];
                  Vector nuevoVector = metodos.lista;
                  for(int i =0; i<nuevoVector.size();i++){
                      DatosPersona v = (DatosPersona)metodos.lista.get(i);
                      filas[i][0]=v.nombres;
                      filas[i][1]=v.ap_paterno;
                      filas[i][2]=v.ap_materno;
                      filas[i][3]=v.codigo;
                      
                      
                      JTable tabla = new JTable(filas, columnas);
                      JScrollPane  tabla1= new JScrollPane(tabla);
                      
                      JPanel reporte = new JPanel();
                      reporte.add(tabla1);
                      
                      
                      Object msg[]={reporte};
                      JOptionPane.showMessageDialog(null, msg,"Reporte ",JOptionPane.QUESTION_MESSAGE);
                      
                      
                      
                      
                      
                      
                  }*/
                    
                }
            }
        );
       menuMantenimientoRegistrar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                   JPanel pan1 = new JPanel(new GridLayout(1,2));
                    pan1.add(lb_nombres);
                    pan1.add(txf_nombres);
                    
                    JPanel pan2 = new JPanel(new GridLayout(1,2));
                    pan2.add(lb_ap_paterno);
                    pan2.add(txf_ap_paterno);
                    
                    JPanel pan3 = new JPanel(new GridLayout(1,2));
                    pan3.add(lb_ap_materno);
                    pan3.add(txf_ap_materno);
                    
                    
                    JPanel pan4 = new JPanel(new GridLayout(1,2));
                    pan4.add(lb_codigo);
                    pan4.add(txf_codigo);
                  
                    Object msg []= {pan1, pan2, pan3, pan4};
                    
                            
                      if(JOptionPane.showOptionDialog(null, msg,"Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                    
                          
                          System.out.println("Probandooooo"+txf_nombres.getText());
                          DatosPersona dp= new DatosPersona();
                          dp.nombres=txf_nombres.getText();
                          dp.ap_paterno=txf_ap_paterno.getText();
                          dp.ap_materno=txf_ap_materno.getText();
                          dp.codigo=txf_codigo.getText();
                          
                          System.out.println(dp.nombres);
                          System.out.println(dp.ap_paterno);
                          System.out.println(dp.ap_materno);
                          System.out.println(dp.codigo);
                          
                          metodos.RegistrarPersona(dp);
                          JOptionPane.showMessageDialog(null,"Se registro conExito","Registro",JOptionPane.INFORMATION_MESSAGE);
                          
                          
                      } 
                 
                  
                } 
            }     
          );
    }
                 
               

}