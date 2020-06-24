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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import dto.EstadoHabilitacionEnumDTO;
import dto.ResultadoDTO;
import dto.EstadoEnumDTO;

public class ResultadoABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPeticionID;
	private JTextField txtResultadoID;
	private JTextField txtValor;
	private JTextField txtDescripcion;
	private ModalResult modalResult;
	private JComboBox comboBoxEstado;
	private ResultadoDTO resultado = new ResultadoDTO(); 

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
		
		JLabel lblPeticionID = new JLabel("Peticion ID");
		
		txtPeticionID = new JTextField();
		txtPeticionID.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(20);
		
		JLabel lblResultadoID = new JLabel("Resultado ID");
		
		txtResultadoID = new JTextField();
		txtResultadoID.setEditable(isIdEditable);

		txtResultadoID.setColumns(20);
		
		txtValor = new JTextField();
		txtValor.setColumns(20);
		
		JLabel lblValor = new JLabel("Valor");
		
		JLabel lblEstadoHabilitacion = new JLabel("Estado Habilitacion");
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoEnumDTO.values()));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblResultadoID)
							.addGap(83)
							.addComponent(txtResultadoID, 0, 0, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblPeticionID)
							.addGap(93)
							.addComponent(txtPeticionID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescripcion)
								.addComponent(lblEstadoHabilitacion)
								.addComponent(lblValor))
							.addGap(55)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValor, 0, 0, Short.MAX_VALUE)
								.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(202, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResultadoID)
						.addComponent(txtResultadoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeticionID)
						.addComponent(txtPeticionID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValor))
					.addGap(8)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescripcion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstadoHabilitacion))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ResultadoABM.class.getResource("/res/iconoConfirmar24px.png")));
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
				cancelButton.setIcon(new ImageIcon(ResultadoABM.class.getResource("/res/iconoCancelar24px.png")));
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
	
	public ResultadoABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Resultado", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	private void asignarDatosEntidad() {
		resultado.setResultadoID(txtResultadoID.getText());
		resultado.setPeticionID(txtPeticionID.getText());
		resultado.setValor(txtValor.getText());
		resultado.setDescripcion(txtDescripcion.getText());
		resultado.setEstado((EstadoEnumDTO)comboBoxEstado.getSelectedItem());
	}
	
	private void asignarDatosForm(){
		txtResultadoID.setText(resultado.getResultadoID());
		txtPeticionID.setText(resultado.getPeticionID());
		txtValor.setText(resultado.getValor());
		txtDescripcion.setText(resultado.getDescripcion());
		comboBoxEstado.setSelectedItem(resultado.getEstado());
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
