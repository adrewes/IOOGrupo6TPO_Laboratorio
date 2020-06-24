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

import dto.PeticionDTO;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dto.EstadoEnumDTO;
import dto.EstadoHabilitacionEnumDTO;

public class PeticionABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPeticionID;
	private JTextField txtPacienteID;
	private PeticionDTO peticion = new PeticionDTO();
	private ModalResult modalResult;
	private JTextField txtObraSocial;
	private JFormattedTextField txtFchCarga;
	private JFormattedTextField txtFchEntrega;
	private JLabel lblWarningMessageFechaCarga = new JLabel("");
	private JLabel lblWarningMessageFechaEntrega = new JLabel("");
	private JLabel lblWarningMessagePeticionID = new JLabel("");
	private JLabel lblWarningMessagePacienteID = new JLabel("");
	private JLabel lblWarningMessageSucursalID = new JLabel("");
	private JTextField txtSucursalID;
	private JComboBox comboBoxEstado;

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
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblPeticionID = new JLabel("Peticion ID");

		txtPeticionID = new JTextField();
		txtPeticionID.setEditable(isIdEditable);
		txtPeticionID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtPeticionID.getText();
				int l = value.length();
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					lblWarningMessagePeticionID.setText("");
				} else {
					txtPeticionID.setEditable(false);
					lblWarningMessagePeticionID.setText("* Solo valor numerico");
				}
			}
		});
		txtPeticionID.setColumns(10);

		JLabel lblFchCarga = new JLabel("Fecha de Carga");

		JLabel lblPacienteID = new JLabel("Paciente ID");

		txtPacienteID = new JTextField();
		txtPacienteID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtPacienteID.getText();
				int l = value.length();
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					txtPacienteID.setEditable(true);
					lblWarningMessagePacienteID.setText("");
				} else {
					txtPacienteID.setEditable(false);
					lblWarningMessagePacienteID.setText("* Solo valor numerico");
				}

			}
		});
		txtPacienteID.setColumns(20);

		txtObraSocial = new JTextField();
		txtObraSocial.setColumns(8);

		JLabel lblObraSocial = new JLabel("Obra Social");

		JLabel lblFchEntrega = new JLabel("Fecha de Entrega");

		txtFchCarga = new JFormattedTextField();
		txtFchCarga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtFchCarga.getText();
				int l = value.length();
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					txtFchCarga.setEditable(true);
					lblWarningMessageFechaCarga.setText("");
				} else {
					txtFchCarga.setEditable(false);
					lblWarningMessageFechaCarga.setText("* Solo valor numerico");
				}
			}
		});
		txtFchCarga.setColumns(10);

		txtFchEntrega = new JFormattedTextField();
		txtFchEntrega.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtFchEntrega.getText();
				int l = value.length();
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					txtFchEntrega.setEditable(true);
					lblWarningMessageFechaEntrega.setText("");
				} else {
					txtFchEntrega.setEditable(false);
					lblWarningMessageFechaEntrega.setText("* Solo valor numerico");
				}
			}
		});
		txtFchEntrega.setColumns(10);

		JLabel lblSucursalID = new JLabel("Sucursal ID");

		txtSucursalID = new JTextField();
		txtSucursalID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtSucursalID.getText();
				int l = value.length();
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					txtSucursalID.setEditable(true);
					lblWarningMessageSucursalID.setText("");
				} else {
					txtSucursalID.setEditable(false);
					lblWarningMessageSucursalID.setText("* Solo valor numerico");
				}
			}
		});
		txtSucursalID.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoEnumDTO.values()));

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEstado)
							.addContainerGap(515, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblObraSocial, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(lblPacienteID)
								.addComponent(lblSucursalID)
								.addComponent(lblPeticionID)
								.addComponent(lblFchEntrega)
								.addComponent(lblFchCarga))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(txtFchCarga, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(337, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPeticionID, 0, 0, Short.MAX_VALUE)
														.addComponent(txtSucursalID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblWarningMessagePeticionID)
														.addComponent(lblWarningMessagePacienteID))
													.addPreferredGap(ComponentPlacement.RELATED, 93, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblWarningMessageFechaCarga)
														.addComponent(lblWarningMessageFechaEntrega)))
												.addComponent(txtFchEntrega, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPanel.createSequentialGroup()
												.addComponent(txtPacienteID, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 197, GroupLayout.PREFERRED_SIZE)))
										.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
									.addGap(96))))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWarningMessagePeticionID)
								.addComponent(txtPeticionID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblPeticionID)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWarningMessagePacienteID)
							.addGap(28))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSucursalID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSucursalID))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPacienteID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPacienteID))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblObraSocial))
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblWarningMessageFechaCarga)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEstado)
							.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtFchEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblFchEntrega))
						.addComponent(lblWarningMessageFechaEntrega))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFchCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFchCarga))
					.addGap(120))
		);
		lblWarningMessageFechaCarga.setForeground(Color.RED);
		lblWarningMessageFechaEntrega.setForeground(Color.RED);
		lblWarningMessagePacienteID.setForeground(Color.RED);
		lblWarningMessagePeticionID.setForeground(Color.RED);
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
				cancelButton.setIcon(new ImageIcon(PeticionABM.class.getResource("/res/iconoCancelar24px.png")));
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
				txtFchCarga.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
				txtFchEntrega.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PeticionABM(JFrame frame, boolean isIdEditable) {
		super(frame, "Peticion", true);
		setLocationRelativeTo(frame);
		inicializarControles(isIdEditable);
		asignarFormato();
	}

	public PeticionDTO getPeticion() {
		return peticion;
	}

	private void asignarDatosEntidad() {
		peticion.setPeticionID(txtPeticionID.getText());
		peticion.setSucursalID(txtSucursalID.getText());
		peticion.setPacienteID(txtPacienteID.getText());
		peticion.setObraSocial(txtObraSocial.getText());
		peticion.setFchCarga(txtFchCarga.getText());
		peticion.setFchEntrega(txtFchEntrega.getText());
		peticion.setEstado((EstadoEnumDTO) comboBoxEstado.getSelectedItem());
	}

	private void asignarDatosForm() {
		txtPeticionID.setText(peticion.getPeticionID());
		txtSucursalID.setText(peticion.getSucursalID());
		txtPacienteID.setText(peticion.getPacienteID());
		txtObraSocial.setText(peticion.getObraSocial());
		txtFchCarga.setText(peticion.getFchCarga());
		txtFchEntrega.setText(peticion.getFchEntrega());
		comboBoxEstado.setSelectedItem(peticion.getEstado());
	}

	public void setPeticion(PeticionDTO peticion) {
		this.peticion = peticion;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
