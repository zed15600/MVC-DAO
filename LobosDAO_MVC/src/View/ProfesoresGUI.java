package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class ProfesoresGUI extends JFrame implements ActionListener{
	JLabel lblTitulo;
	JLabel lblCodigo;
	JLabel lblNombre;
	JLabel lblTelefono;
	JLabel lblDireccion;
	JLabel lblCedula;
	JTextField txtCodigo;
	JTextField txtNombre;
	JTextField txtTelefono;
	JTextField txtDireccion;
	JTextField txtCedula;
	JButton btnAsignarCarrera;
	JButton btnCreate;
	JButton btnRead;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnExist;
	JButton btnList;
	JButton btnEstudiantes;
	JButton btnCarreras;
	DefaultTableModel dataModel;
	Object[] cols;
	JTable tblDatos;
	JPanel pnlDatos;
	JScrollPane scrllPnlDatos;
	Font etiquetas = new Font("Arial", Font.BOLD, 25);
	int aligDerecha = SwingConstants.RIGHT;
	public ProfesoresGUI(){
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(800, 600);
		setTitle("Profesores");
		setLocationRelativeTo(this);
		setResizable(false);
		lblTitulo = new JLabel("Profesores");
		lblTitulo.setBounds(1, 1, 792, 40);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		lblCodigo = new JLabel("C�digo de Profesor");
		lblCodigo.setBounds(1, 62, 396, 25);
		lblCodigo.setFont(etiquetas);
		lblCodigo.setHorizontalAlignment(aligDerecha);
		add(lblCodigo);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(398, 62, 200, 25);
		add(txtCodigo);
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(1, 88, 396, 25);
		lblNombre.setFont(etiquetas);
		lblNombre.setHorizontalAlignment(aligDerecha);
		add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(398, 88, 200, 25);
		add(txtNombre);
		lblTelefono = new JLabel("Tel�fono de Contacto");
		lblTelefono.setBounds(1, 114, 396, 25);
		lblTelefono.setFont(etiquetas);
		lblTelefono.setHorizontalAlignment(aligDerecha);
		add(lblTelefono);
		txtTelefono = new JTextField();
		txtTelefono.setBounds(398, 114, 200, 25);
		add(txtTelefono);
		lblDireccion = new JLabel("Direcci�n de Residencia");
		lblDireccion.setBounds(1, 140, 396, 25);
		lblDireccion.setFont(etiquetas);
		lblDireccion.setHorizontalAlignment(aligDerecha);
		add(lblDireccion);
		txtDireccion = new JTextField();
		txtDireccion.setBounds(398, 140, 200, 25);
		add(txtDireccion);
		lblCedula = new JLabel("C�dula de Ciudadan�a");
		lblCedula.setBounds(1, 166, 396, 25);
		lblCedula.setFont(etiquetas);
		lblCedula.setHorizontalAlignment(aligDerecha);
		add(lblCedula);
		txtCedula = new JTextField();
		txtCedula.setBounds(398, 166, 200, 25);
		add(txtCedula);
		btnCreate = new JButton("Guardar");
		btnCreate.setBounds(46, 237, 100, 40);
		btnCreate.addActionListener(this);
		add(btnCreate);
		btnRead = new JButton("Buscar");
		btnRead.setBounds(166, 237, 100, 40);
		btnRead.addActionListener(this);
		add(btnRead);
		btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(286, 237, 100, 40);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(406, 237, 100, 40);
		btnDelete.addActionListener(this);
		add(btnDelete);
		btnExist = new JButton("Existe");
		btnExist.setBounds(526, 237, 100, 40);
		btnExist.addActionListener(this);
		add(btnExist);
		btnList = new JButton("Listar");
		btnList.setBounds(646, 237, 100, 40);
		btnList.addActionListener(this);
		add(btnList);
		dataModel = new DefaultTableModel();
		tblDatos = new JTable(dataModel);
		cols = new Object[]{"C�digo", "Nombre", "Tel�fono", "Direcci�n", "C�dula"};
		dataModel.setColumnIdentifiers(cols);
		scrllPnlDatos = new JScrollPane(tblDatos);
		scrllPnlDatos.setOpaque(true);
		scrllPnlDatos.setBackground(Color.WHITE);
		scrllPnlDatos.setBounds(1, 297, 792, 200);
		add(scrllPnlDatos);
		btnCarreras = new JButton("Carreras");
		btnCarreras.setBounds(1, 530, 110, 40);
		btnCarreras.addActionListener(this);
		add(btnCarreras);
		btnEstudiantes = new JButton("Estudiantes");
		btnEstudiantes.setBounds(683, 530, 110, 40);
		btnEstudiantes.addActionListener(this);
		add(btnEstudiantes);
		show();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnCreate){
			
		}else if(e.getSource()==btnRead){
			
		}else if(e.getSource()==btnUpdate){
			
		}else if(e.getSource()==btnDelete){
			
		}else if(e.getSource()==btnExist){
			
		}else if(e.getSource()==btnList){
			
		}else if(e.getSource()==btnEstudiantes){
			
		}else if(e.getSource()==btnCarreras){
			
		}
	}

}