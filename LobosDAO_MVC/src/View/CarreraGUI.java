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

public class CarreraGUI extends JFrame implements ActionListener{
	JLabel lblTitulo;
	JLabel lblCodigo;
	JLabel lblNombre;
	JLabel lblJefe;
	JTextField txtCodigo;
	JTextField txtNombre;
	JTextField txtJefe;
	JButton btnCreate;
	JButton btnRead;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnExist;
	JButton btnList;
	JButton btnProfesores;
	JButton btnEstudiantes;
	DefaultTableModel dataModel;
	Object[] cols;
	JTable tblDatos;
	JPanel pnlDatos;
	JScrollPane scrllPnlDatos;
	Font etiquetas = new Font("Arial", Font.BOLD, 25);
	int aligDerecha = SwingConstants.RIGHT;
	public CarreraGUI(){
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(800, 600);
		setTitle("Carreras");
		setLocationRelativeTo(this);
		setResizable(false);
		lblTitulo = new JLabel("Carreras");
		lblTitulo.setBounds(1, 1, 792, 40);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		lblCodigo = new JLabel("C�digo de Carrera");
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
		lblJefe = new JLabel("Jefe de Carrera");
		lblJefe.setBounds(1, 114, 396, 25);
		lblJefe.setFont(etiquetas);
		lblJefe.setHorizontalAlignment(aligDerecha);
		add(lblJefe);
		txtJefe = new JTextField();
		txtJefe.setBounds(398, 114, 200, 25);
		add(txtJefe);
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
		cols = new Object[]{"C�digo", "Nombre", "Jefe"};
		dataModel.setColumnIdentifiers(cols);
		scrllPnlDatos = new JScrollPane(tblDatos);
		scrllPnlDatos.setOpaque(true);
		scrllPnlDatos.setBackground(Color.WHITE);
		scrllPnlDatos.setBounds(1, 297, 792, 200);
		add(scrllPnlDatos);
		btnEstudiantes = new JButton("Estudiantes");
		btnEstudiantes.setBounds(1, 530, 110, 40);
		btnEstudiantes.addActionListener(this);
		add(btnEstudiantes);
		btnProfesores = new JButton("Profesores");
		btnProfesores.setBounds(683, 530, 110, 40);
		btnProfesores.addActionListener(this);
		add(btnProfesores);
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
			
		}else if(e.getSource()==btnProfesores){
			
		}else if(e.getSource()==btnEstudiantes){
			
		}
	}

}