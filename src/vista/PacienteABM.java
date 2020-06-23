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

import dto.PacienteDTO;

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
import dto.SexoEnumDTO;

public class PacienteABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPacienteID;
	private JTextField txtDomicilio;
	private JTextField txtNombre;
	private JFormattedTextField txtFNacimiento;
	private PacienteDTO paciente = new PacienteDTO(); 
	private ModalResult modalResult;
	private JTextField txtDNI;
	private JTextField txtMail;
	private JComboBox comboBoxSexo;

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
		
		JLabel lblPacienteID = new JLabel("Paciente ID");
		
		txtPacienteID = new JTextField();
		txtPacienteID.setEditable(isIdEditable);
		txtPacienteID.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(50);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Nacimiento");
		
		txtFNacimiento = new JFormattedTextField();
		
		txtDNI = new JTextField();
		txtDNI.setColumns(8);
		
		JLabel lblDNI = new JLabel("DNI");
		
		txtMail = new JTextField();
		txtMail.setColumns(20);
		
		JLabel lblMail = new JLabel("Mail");
		
		JLabel lblSexo = new JLabel("Sexo");
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(SexoEnumDTO.values()));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblPacienteID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDNI)
							.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblDomicilio)
						.addComponent(lblMail)
						.addComponent(lblSexo)
						.addComponent(lblNewLabel_2))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPacienteID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFNacimiento, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPacienteID)
						.addComponent(txtPacienteID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNI)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDomicilio)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMail)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(comboBoxSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(PacienteABM.class.getResource("/res/iconoConfirmar24px.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						asignarDatosEntidad();
						modalResult = ModalResult.OK;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(PacienteABM.class.getResource("/res/iconoCancelar24px.png")));
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
				txtFNacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public PacienteABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Persona", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	private void asignarDatosEntidad() {
		paciente.setPacienteID(txtPacienteID.getText());
		paciente.setNombre(txtNombre.getText());
		paciente.setDni(txtDNI.getText());
		paciente.setDomicilio(txtDomicilio.getText());
		paciente.setMail(txtMail.getText());
		paciente.setSexo((SexoEnumDTO)comboBoxSexo.getSelectedItem());
		paciente.setFechaNacimiento(txtFNacimiento.getText());
	}
	
	private void asignarDatosForm(){
		txtPacienteID.setText(paciente.getPacienteID());
		txtNombre.setText(paciente.getNombre());
		txtDNI.setText(paciente.getDni());
		txtDomicilio.setText(paciente.getDomicilio());
		txtMail.setText(paciente.getMail());
		txtFNacimiento.setText(paciente.getFechaNacimiento());
		comboBoxSexo.setSelectedItem(paciente.getSexo());
	}
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
