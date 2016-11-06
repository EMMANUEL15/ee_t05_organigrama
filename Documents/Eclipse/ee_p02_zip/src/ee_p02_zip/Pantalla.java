package ee_p02_zip;
import javax.swing.JOptionPane;

/**
 *
 * @author EMMANUEL
 */
public class Pantalla extends javax.swing.JFrame {
	private javax.swing.JButton Comprimir;
    private javax.swing.JButton Continuar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JTextPane PantallaM;
    private javax.swing.JScrollPane jScrollPane1;
    public String mostrar;
    public String contenido;
    public Pantalla() {
        initComponents();
    }
    @SuppressWarnings("unchecked")                       
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        PantallaM = new javax.swing.JTextPane();
        Mostrar = new javax.swing.JButton();
        Continuar = new javax.swing.JButton();
        Comprimir = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contenidio del Archivo");
        setAutoRequestFocus(false);
        setForeground(java.awt.Color.gray);

        jScrollPane1.setViewportView(PantallaM);

        Mostrar.setText("Mostrar contenido");
        Mostrar.addActionListener(new java.awt.event.ActionListener()
	 {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        }
		);
        Continuar.setText("Descomprimir y Guardar");
        Continuar.addActionListener(new java.awt.event.ActionListener() 
	 {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        }
	 );
        Comprimir.setText("Comprimimir y Guardar");
        Comprimir.addActionListener(new java.awt.event.ActionListener()
	 {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprimirActionPerformed(evt);
            }
        }
		);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Comprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mostrar)
                    .addComponent(Continuar)
                    .addComponent(Comprimir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {                                        
      PantallaM.setText(mostrar);
    }                                       

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    try{
      Extraer e=new Extraer();Pantalla p=new Pantalla();
      e.ExtraerArchivo(mostrar);
      p.setVisible(false);
      this.dispose();
    }catch(Exception e){JOptionPane.showMessageDialog(rootPane,"El Archivo ya esta descomprimido ");}
    }                                         

    private void ComprimirActionPerformed(java.awt.event.ActionEvent evt) {                                          
   	     try{
    	  Lista L=new Lista();Pantalla p=new Pantalla();
    	   L.LeerMsj(contenido,0);
    	  this.dispose();
   	 }catch(Exception e){JOptionPane.showMessageDialog(rootPane,"El Archivo ya esta descomprimido ");}
    }                                         
    public  void dato(String n){
         mostrar=n;
     }
    public  void dat(){
         PantallaM.setText(mostrar);
     }
    public  void datB(String n){
         contenido=n;
      }
    public static void main(String args[]) {
        Pantalla p=new Pantalla();
        java.awt.EventQueue.invokeLater(new Runnable() 
		{
           public void run() {
           		new Pantalla().setVisible(true);
            }
        }
		);
    }                 
}
