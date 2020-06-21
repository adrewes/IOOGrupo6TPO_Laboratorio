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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import dto.EstadoHabilitacionEnumDTO;
import dto.PracticaDTO;

public class PracticaABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPracticaID;
	private JTextField txtNombre;
	private JTextField txtGrupo;
	private JFormattedTextField txtValoresCriticos;
	private JFormattedTextField txtValoresReservados;
	private ModalResult modalResult;
	private JComboBox comboBoxEstado;
	private PracticaDTO practica = new PracticaDTO(); 
	private JFormattedTextField txtTiempoEntrega;

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
		
		JLabel lblPracticaID = new JLabel("Practica ID");
		
		txtPracticaID = new JTextField();
		txtPracticaID.setEditable(isIdEditable);
		txtPracticaID.setColumns(10);
		
		JLabel lblValoresCriticos = new JLabel("Valores Criticos");
		
		txtValoresCriticos = new JFormattedTextField();
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(20);
		
		txtGrupo = new JTextField();
		txtGrupo.setColumns(20);
		
		JLabel lblGrupo = new JLabel("Grupo");
		
		txtValoresReservados = new JFormattedTextField();
		
		JLabel lblValoresReservados = new JLabel("Valores Reservados");
		
		JLabel lblEstadoHabilitacion = new JLabel("Estado Habilitacion");
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoHabilitacionEnumDTO.values()));
		
		JLabel lblTiempoEntrega = new JLabel("Tiempo Entrega (Dias Hablies)");
		
		txtTiempoEntrega = new JFormattedTextField();
		txtTiempoEntrega.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblPracticaID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblGrupo)
							.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblValoresCriticos)
						.addComponent(lblValoresReservados)
						.addComponent(lblTiempoEntrega)
						.addComponent(lblEstadoHabilitacion))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTiempoEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPracticaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtValoresReservados, Alignment.LEADING)
							.addComponent(txtValoresCriticos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPracticaID)
						.addComponent(txtPracticaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrupo)
						.addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoresCriticos)
						.addComponent(txtValoresCriticos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoresReservados)
						.addComponent(txtValoresReservados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoEntrega)
						.addComponent(txtTiempoEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstadoHabilitacion))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(PracticaABM.class.getResource("/res/iconoConfirmar24px.png")));
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
				cancelButton.setIcon(new ImageIcon(PracticaABM.class.getResource("/res/iconoCancelar24px.png")));
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
				txtValoresCriticos.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####,##")));
				txtValoresReservados.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####,##")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public PracticaABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Practica", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public PracticaDTO getPractica() {
		return practica;
	}

	private void asignarDatosEntidad() {
		practica.setPracticaID(txtPracticaID.getText());
		practica.setNombre(txtNombre.getText());
		practica.setGrupo(txtGrupo.getText());
		practica.setValoresCriticos(txtValoresCriticos.getText());
		practica.setValoresReservados(txtValoresReservados.getText());
		practica.setTiempoEntrega(txtTiempoEntrega.getText());
		practica.setEstadoHabilitacion((EstadoHabilitacionEnumDTO)comboBoxEstado.getSelectedItem());
	}
	
	private void asignarDatosForm(){
		txtPracticaID.setText(practica.getPracticaID());
		txtNombre.setText(practica.getNombre());
		txtGrupo.setText(practica.getGrupo());
		txtValoresCriticos.setText(practica.getValoresCriticos());
		txtValoresReservados.setText(practica.getValoresReservados());
		txtTiempoEntrega.setText(practica.getTiempoEntrega());
		comboBoxEstado.setSelectedItem(practica.getEstadoHabilitacion());
	}
	public void setPractica(PracticaDTO practica) {
		this.practica = practica;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
