package vista;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;

import dto.UsuarioDTO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import dto.RolEnumDTO;
import javax.swing.JPasswordField;

public class UsuarioABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuarioID;
	private JTextField txtNombreUsuario;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JFormattedTextField txtFchNacimiento;
	private UsuarioDTO usuario = new UsuarioDTO(); 
	private ModalResult modalResult;
	private JTextField txtDomicilio;
	private JTextField txtDni;
	private JPasswordField txtPassword;
	private JComboBox comboBoxRol = new JComboBox();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private void inicializarControles(boolean isIdEditable) {
		setBounds(100, 100, 584, 411);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario");
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(50);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(20);
		
		JLabel lblFchNacimiento = new JLabel("Nacimiento");
		
		txtFchNacimiento = new JFormattedTextField();
		
		JLabel lblPassword = new JLabel("Password");
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(20);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		
		JLabel lblDni = new JLabel("DNI");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblRol = new JLabel("Rol");
		
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"Recepcion", "Laboratorista", "Administrador"}));
		
		txtPassword = new JPasswordField();
		
		JLabel lblUsuarioID = new JLabel("Usuario ID");
		
		txtUsuarioID = new JTextField();
		txtUsuarioID.setEditable(isIdEditable);
		txtUsuarioID.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblDni)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblDomicilio)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblNombre)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblPassword)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblNombreUsuario)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblUsuarioID)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblFchNacimiento)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblRol)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsuarioID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFchNacimiento, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuarioID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuarioID))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreUsuario)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDomicilio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFchNacimiento)
						.addComponent(txtFchNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRol)
						.addComponent(comboBoxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("   OK   ");
				okButton.setIcon(new ImageIcon(UsuarioABM.class.getResource("/res/iconoConfirmar24px.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						asignarDatosEntidad();
						modalResult = ModalResult.OK;
						dispose();
					}
				});
				okButton.setActionCommand("  OK  ");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(UsuarioABM.class.getResource("/res/iconoCancelar24px.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modalResult = ModalResult.CANCELL;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	private void asignarFormato() {
		try {
			try {
				txtFchNacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public UsuarioABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Persona", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	private void asignarDatosEntidad() {
		usuario.setUsuarioID(txtUsuarioID.getText());
		usuario.setNombreUsuario(txtNombreUsuario.getText());
		usuario.setEmail(txtEmail.getText());
		usuario.setPassword(String.copyValueOf(txtPassword.getPassword()));
		usuario.setNombre(txtNombre.getText());
		usuario.setDomicilio(txtDomicilio.getText());
		usuario.setFchNacimiento(txtFchNacimiento.getText());
		usuario.setDni(txtDni.getText());
		usuario.setRol(comboBoxRol.getSelectedItem().toString());
		
	}
	
	private void asignarDatosForm(){
		txtUsuarioID.setText(usuario.getUsuarioID());
		txtNombreUsuario.setText(usuario.getNombreUsuario());
		txtEmail.setText(usuario.getEmail());
		txtPassword.setText(usuario.getPassword());
		txtNombre.setText(usuario.getNombre());
		txtDomicilio.setText(usuario.getDomicilio());
		txtDni.setText(usuario.getDni());
		txtFchNacimiento.setText(usuario.getFchNacimiento());
		comboBoxRol.setSelectedItem(usuario.getRol());
		System.out.print(usuario.getRol());
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
