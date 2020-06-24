package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import controller.ParametrosController;
import tablemodel.PacienteTableModel;
import tablemodel.SucursalTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class SucursalMainWindow {
	
	JFrame frame;
	private JTable table;
	private SucursalTableModel tableModel;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucursalMainWindow window = new SucursalMainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the application.
	 */
	public SucursalMainWindow() {
		tableModel = new SucursalTableModel();
		initialize();
	}
	
	private void agregarSucursal() {
		try {
			SucursalABM dialog = new SucursalABM(frame,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				tableModel.agregar(dialog.getSucursal());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	private void modificarSucursal() {
		try {
			SucursalABM dialog = new SucursalABM(frame,false);
			dialog.setSucursal(tableModel.getSucursalDTO(table.getSelectedRow()));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				tableModel.modificar(dialog.getSucursal());
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	private void eliminarSucursal() {
		try {
			int opcion = JOptionPane.showConfirmDialog(null, "Este seguro que desea eliminar a esta Sucursal?", null,
					JOptionPane.YES_NO_OPTION);
			switch (opcion) {
			case 0:
				// SI
				String sucursalIDADerivar = JOptionPane.showInputDialog("Por favor ingrese el ID de Sucursal a la cual derivar las peticiones activas");
				tableModel.eliminar(table.getSelectedRow(), sucursalIDADerivar);
				break;
			case 1:
				// NO
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}				

		
		frame = new JFrame();
		frame.setBounds(100, 100, 752, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Este window listener configura que se hace cuando se cierra la ventana
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int opcion = JOptionPane.showConfirmDialog(null, "Desea guardar los cambios realizados?", null,
						JOptionPane.YES_NO_OPTION);
				switch (opcion) {
				case 0:
					// SI
					tableModel.grabar();
					break;
				case 1:
					// NO
					break;

				}
			}

		});
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel.setMinimumSize(new Dimension(10, 50));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarSucursal();
			}
		});
		btnEliminar.setIcon(new ImageIcon(SucursalMainWindow.class.getResource("/res/iconoEliminar24px.png")));
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(SucursalMainWindow.class.getResource("/res/iconoModificar24px.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarSucursal();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(SucursalMainWindow.class.getResource("/res/iconoAgregar24px.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarSucursal();
			}
			
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEliminar)
							.addComponent(btnModificar)
							.addComponent(btnAgregar))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Listado de Sucursales");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setAutoscrolls(true);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
	          if (arg0.getClickCount() == 2)
	          	modificarSucursal();
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
	}
}
