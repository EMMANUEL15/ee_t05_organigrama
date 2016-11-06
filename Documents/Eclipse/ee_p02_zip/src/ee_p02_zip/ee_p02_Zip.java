package ee_p02_zip;


import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
/**
 * @author EMMANUEL
 */
public class ee_p02_Zip extends javax.swing.JFrame {
	private javax.swing.JButton Abrir;
    private javax.swing.JButton Descomprimir;
    private javax.swing.JTextField Ruta;
    private javax.swing.JButton comprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public String texto="";
    public String ruta;
    public String MsGuardar="";
    public ee_p02_Zip() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Ruta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Abrir = new javax.swing.JButton();
        comprimir = new javax.swing.JButton();
        Descomprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zip");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel2.setText("ZIP- Huffman");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Archivo:");

        jButton1.setText("Examinar");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
	  {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        }
	 );
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() 
	  {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        }
	 );
	  comprimir.setText("Comprimir");
        comprimir.addActionListener(new java.awt.event.ActionListener()
    	{
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprimirActionPerformed(evt);
            }
        }
	  );

        Descomprimir.setText("Descomprimir");
        Descomprimir.addActionListener(new java.awt.event.ActionListener()
	 {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescomprimirActionPerformed(evt);
            }
        }
	 );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(comprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Descomprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Abrir))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprimir)
                    .addComponent(Descomprimir))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    } 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser filechooser=new JFileChooser();
        int opcion=filechooser.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION){
        Ruta.setText(filechooser.getSelectedFile().getPath());
        }
    }   
    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {                                      
     
        Pantalla p=new Pantalla();
        try{
         FileReader f=new FileReader(Ruta.getText());
         BufferedReader b=new BufferedReader(f);
         String Contenido;
         while((Contenido=b.readLine())!=null){
             texto=texto+Contenido;
         }
       }catch(Exception e){ JOptionPane.showMessageDialog(rootPane,"No se encontro el archivo");}
       Ruta.setText("");
       
    } 
    private void comprimirActionPerformed(java.awt.event.ActionEvent evt) {                                          
      Lista L=new Lista();Pantalla p=new Pantalla();
      L.convers (texto);
    }    
    private void DescomprimirActionPerformed(java.awt.event.ActionEvent evt) {                                             
       Pantalla p=new Pantalla();
        p.dato(texto);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }                                            
    public void TxGuardar(String x){
        File Archivo;
       JFileChooser filechooser=new JFileChooser();
        int opcion=filechooser.showOpenDialog(this);
    if(opcion==JFileChooser.APPROVE_OPTION){
     Ruta.setText(filechooser.getSelectedFile().getPath());
        }
        Archivo =new File(Ruta.getText()+".txt");
    if(Ruta.getText().equals("")){ JOptionPane.showMessageDialog(rootPane,"Ingrese el Nombre!!");}
    else{
    	String Nombre=Ruta.getText()+"_zip.txt";
        try{
    	 FileWriter fichero =new FileWriter(Archivo);
    	 fichero.write(x);
    	 fichero.close();
    	 JOptionPane.showMessageDialog(rootPane,"Archivo Guardo con exito!");
     
   		 }catch(IOException e){
        JOptionPane.showMessageDialog(rootPane,""+x);
   	 }
    	Ruta.setText("");
     }
    }
    public  void Ejecutar() {
     ee_p02_Zip e=new ee_p02_Zip();
     e.setLocationRelativeTo(null);
     e.setVisible(true);
    }            
}