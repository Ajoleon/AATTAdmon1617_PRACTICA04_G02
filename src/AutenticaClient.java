
import static es.gob.jmulticard.asn1.bertlv.a.a;
import es.gob.jmulticard.jse.provider.DnieProvider;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase de la aplicación para enviar los datos al servidor y verificar
 * 
 * @author Juan Carlos Cuevas Martínez, Pablo Castillo Segura y Antonio José León Sánchez
 */
public class AutenticaClient extends javax.swing.JFrame {
    
    //Se inicializa constructor del usuario
    public static User user = new User();

    /**
     * Crea nuevo formulario JFrame
     */
    public AutenticaClient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAutentica = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jName = new javax.swing.JLabel();
        jButtonGrabar = new javax.swing.JButton();
        jLabel_apellidos = new javax.swing.JLabel();
        jLabel_dni = new javax.swing.JLabel();
        jApellidos = new javax.swing.JLabel();
        jDNI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("app_title")); // NOI18N

        jButtonAutentica.setText(bundle.getString("main_button_autenticate")); // NOI18N
        jButtonAutentica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutenticaActionPerformed(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelName.setText("Nombre:");

        jName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jName.setText("nombre");

        jButtonGrabar.setText("Graba certificado");
        jButtonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrabarActionPerformed(evt);
            }
        });

        jLabel_apellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_apellidos.setText("Apellidos:");

        jLabel_dni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_dni.setText("DNI:");

        jApellidos.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jApellidos.setText("apellidos");

        jDNI.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jDNI.setText("dni");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAutentica))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_apellidos)
                                    .addComponent(jLabel_dni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDNI)
                                    .addComponent(jApellidos))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jName)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_apellidos)
                    .addComponent(jApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_dni)
                    .addComponent(jDNI))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAutentica)
                    .addComponent(jButtonGrabar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAutenticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutenticaActionPerformed
        try {
            //Se inicializa almacén de claves
            iniKeyStore();
            
            try {
                
                //Método para realizar la petición al servidor y que devuelve la respuesta
                String resultado =  doAuth();
                
                //En función del resultado del servidor, muestro mensaje
                if(resultado.equals(resultados[0])){
                    infoBox(mensajes[0],"Resultado");
                }else if(resultado.equals(resultados[1])){
                    infoBox(mensajes[3],"Resultado");
                }else if(resultado.equals(resultados[2])){
                    infoBox(mensajes[1],"Resultado");
                }else{
                    infoBox(mensajes[2],"Resultado");
                }
              
            } catch (UnrecoverableKeyException ex) {
                Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SignatureException ex) {
                Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SignatureError ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableEntryException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAutenticaActionPerformed

    //Si se pulsa botón de grabar certificado
    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
      saveCertificate();
    }//GEN-LAST:event_jButtonGrabarActionPerformed

    /**
     * Método principal de la aplicación
     * 
     * @param args Argumentos de entrada por líne de comandos
     * @throws IOException Excepción al leer o escribir del canal
     * @throws NoSuchAlgorithmException Error en el algoritmo para encriptar
     * @throws CertificateException Fallo en el certificado del DNI
     * @throws UnrecoverableEntryException Fallo en la clave utilizada en el keymanager
     */
    public static void main(String args[]) throws IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutenticaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutenticaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutenticaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutenticaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            System.setProperty("es.gob.jmulticard.fastmode", "true");
            
            iniKeyStore();
         
            final Enumeration<String> aliases = dniKS.aliases();
            while (aliases.hasMoreElements()) {
                System.out.println(aliases.nextElement());
            }
            user = new User(authCert.toString());
       
            infoBox("Hola " + user.getName()," Bienvenido");

        } catch (KeyStoreException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
            dniKS = null;
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutenticaClient().setVisible(true);
                jName.setText(user.getName());
                jApellidos.setText(user.getApellidos());
                jDNI.setText(user.getDni());
            }
        });

    }
    
    //Arrays con resultados del servidor y mensajes
    public final static String[] resultados = {"OK","Error","ErrorUser"};
    public final static String[] mensajes = {"Autenticación Correcta.","Error en la autenticación, usuario inválido.",
                                            "Error de conexión.", "Error en la firma."};
    
    //Variables para realizar la firma
    public static String alias = "CertFirmaDigital";
    private static Provider dniProvider = null;
    private static KeyStore dniKS = null;
    private static X509Certificate authCert = null;
    private static RSAPublicKey rsa = null;
    
    //URL del servidor
    private static  String url = "192.168.0.107:8081";
    
    /**
     * @param args the command line arguments
     */
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    
    private static void iniKeyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        if (dniKS == null) {
          //Inicializamos almacén de claves con el certificado
          dniProvider = new DnieProvider();
          Security.addProvider(dniProvider);
          dniKS = KeyStore.getInstance("DNI"); //$NON-NLS-1$ 
          dniKS.load(null, null);
          authCert = (X509Certificate) dniKS.getCertificate("CertAutenticacion");
         
        }
    }

    /**
     * Devuelve los datos de entrada firmados en Base64
     *
     * @return Cadena que devuelve el servidor con la respuesta
     */
    private String doAuth() throws SignatureError, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, InvalidKeyException, MalformedURLException, SignatureException, IOException, InvalidKeySpecException {
        //Se inicializa firma con la seguridad de cifrado SHA1
        final Signature signature = Signature.getInstance("SHA1withRSA"); 
        
        //Se obtiene la clave del certificado del DNI
        signature.initSign((PrivateKey) dniKS.getKey(alias, null));
        rsa = (RSAPublicKey) dniKS.getCertificate(alias).getPublicKey();
        System.out.println("rsa: "+rsa);
        
        //Devuelve las cadenas de la url y la de datos sin firmar
        String [] datos = user.firma(url);
        
        //Utilizo los datos sin firmar para añadirlos a la firma
        signature.update(datos[1].getBytes()); //$NON-NLS-1$
        final byte[] signatureBytes = signature.sign();
        
        //Codifico los datos firmados y la clave en base 64
        byte[] encoded = Base64.getUrlEncoder().encode(signatureBytes);
        byte[] rsaencoded = Base64.getUrlEncoder().encode(rsa.getEncoded());
        System.out.println("encoded:"+new String(encoded));
        System.out.println("rsaencoded:"+new String(rsaencoded));
        
        //Cadena a enviar al servidor con los parámetros del formulario
        String enviar=datos[0] +"&key="+new String(rsaencoded) +"&firm="+ new String(encoded);
        System.out.println(enviar);
        System.out.println(datos[1]);
        
        //Llamo al método que realiza la petición
        String respuesta = peticion(enviar);
        System.out.println(respuesta);	
       
        //Devuelvo la respuesta
        return respuesta;
    }

    public class SignatureError extends Exception {

        private SignatureError(String message) {
            super(message);
        }

    }
    
    /**
     * Método para realizar la petición al servidor
     * 
     * @param aenviar Cadena de datos a enviar
     * @return Mensaje en función del resultado del servidor
     * @throws MalformedURLException Error al montar la URL
     * @throws ProtocolException Excepción en el protocolo de comunicación
     * @throws IOException Error al escribir o leer del canal
     */
    public static String peticion(String aenviar) throws MalformedURLException, ProtocolException, IOException{
        
        //Variable que indica la línea que se lee del canal
        String inputline= "";
        //Variable que contendrá el resultado del servidor separado por =
        String [] salida = null;
        
        
        byte[] datos = aenviar.getBytes( StandardCharsets.UTF_8 );
        int longitud = datos.length;
        
        //Cadena con la URL
        String direccion = "http://"+url+"/server/validar";
        System.out.println(direccion);
        
        try{
            //Monto la URL
            URL url = new URL(direccion);
            
            try{
                //Establezco conexión y parámetros
                HttpURLConnection conn= (HttpURLConnection) url.openConnection();         
                
                conn.setDoOutput(true);
                conn.setConnectTimeout(2000);//Tiempo de intento de conexión al servidor
                conn.setInstanceFollowRedirects( false );
                conn.setRequestMethod("POST");//Método POST
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
                conn.setRequestProperty("charset", "utf-8");
                conn.setRequestProperty("Content-Length", Integer.toString(longitud));
                conn.setUseCaches(false);
                
                //Escribe en el canal de escritura
                try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                    wr.write(datos);
                }
                
                //Canal de lectura
                Reader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                BufferedReader in = new BufferedReader(br);
                
                //Mientras lea líneas
                while ((inputline = in.readLine()) != null) {
                    //Si la línea empieza por Resultado=
                    if(inputline.startsWith("Resultado=")){
                        //Separo las palabras por el =
                        salida = inputline.split("=");
                    }
                }
                //Devuelvo la cadena que había detrás del =
                return salida[1];
            
            //Si no puedo leer o escribir
            }catch(IOException e){
                //Error de conexión
                return mensajes[2];
            }
        
        //Si la URL no está bien montada
        }catch(MalformedURLException u){
            //Error de URL
            return mensajes[3];
        }
        
    }
    
    /**
     * Método para guardar la clave pública en un fichero
     */
    public void saveCertificate() {
        try {
            // Se obtiene el motor de firma y se inicializa
            FileOutputStream keyfos = new FileOutputStream("public.key");
            
            byte encodedKey[] = rsa.getEncoded(); 

            //Se formatea la clave
            String rsakey = rsa.getFormat() + " " + rsa.getAlgorithm() + rsa.toString();
            System.out.println(rsakey);
            
            //Se escribe en el archivo
            keyfos.write(encodedKey);
            
            //Se cierra canal
            keyfos.close();
            System.out.println("Grabado");
       } catch (IOException ex) {
            Logger.getLogger(AutenticaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jApellidos;
    private javax.swing.JButton jButtonAutentica;
    private static javax.swing.JButton jButtonGrabar;
    private static javax.swing.JLabel jDNI;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_dni;
    private static javax.swing.JLabel jName;
    // End of variables declaration//GEN-END:variables
}
