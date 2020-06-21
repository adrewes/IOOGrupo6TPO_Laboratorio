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
import dto.SucursalDTO;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class SucursalABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSucursalNumero;
	private JTextField txtDireccion;
	private SucursalDTO sucursal = new SucursalDTO(); 
	private ModalResult modalResult;
	private JTextField txtResponsableTecnico;

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
		
		JLabel lblSucursalID = new JLabel("Sucursal ID");
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		txtSucursalNumero = new JTextField();
		txtSucursalNumero.setEditable(isIdEditable);
		txtSucursalNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtSucursalNumero.getText();
	            int l = value.length();
	            if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	txtSucursalNumero.setEditable(true);
	               lblWarning.setText("");
	            } else {
	            	txtSucursalNumero.setEditable(false);
	               lblWarning.setText("* Solo valor numérico");
	            }
			}
		});
		txtSucursalNumero.setColumns(10);
		
		JLabel lblNombre = new JLabel("Direccion");
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(20);
		
		txtResponsableTecnico = new JTextField();
		txtResponsableTecnico.setColumns(8);
		
		JLabel lblDNI = new JLabel("Responsable Tecnico (Usuario)");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSucursalID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDNI)
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtResponsableTecnico)
							.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtSucursalNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblWarning)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSucursalID)
						.addComponent(txtSucursalNumero, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWarning))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNI)
						.addComponent(txtResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(237, Short.MAX_VALUE))
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public SucursalABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Sucursal", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	private void asignarDatosEntidad() {
		sucursal.setNumero(Integer.parseInt(txtSucursalNumero.getText()));
		sucursal.setDireccion(txtDireccion.getText());
		sucursal.setResponsableTecnico(txtResponsableTecnico.getText());
	}
	
	private void asignarDatosForm(){
		txtSucursalNumero.setText(Integer.toString(sucursal.getNumero()));
		txtDireccion.setText(sucursal.getDireccion());
		txtResponsableTecnico.setText(sucursal.getResponsableTecnico());

	}
	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
