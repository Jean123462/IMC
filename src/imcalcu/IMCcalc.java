package imcalcu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IMCcalc implements ActionListener {

	private JTextField campoPeso;
	private JTextField CampoAltura;
	private JLabel labelResultado;
	private JLabel labelIMC;

	public static void main(String[] args) {
		new IMCcalc();

	}

	public IMCcalc() {
		JFrame frame = new JFrame("Calculador IMC");
		frame.setSize(300, 200);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(4, 2, 10, 10));

		JLabel labelPeso = new JLabel("Peso (gramas)");
		campoPeso = new JTextField();

		JLabel labelAltura = new JLabel("Altura (metros)");
		CampoAltura = new JTextField();

		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(this);
		labelResultado = new JLabel("IMC: ");

		panel.add(labelPeso);
		panel.add(campoPeso);
		panel.add(labelAltura);
		panel.add(CampoAltura);
		panel.add(new JLabel(""));
		panel.add(calcular);
		panel.add(labelResultado);
		panel.add(new JLabel(""));

		frame.add(panel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double peso = Double.parseDouble(campoPeso.getText());
		double altura = Double.parseDouble(CampoAltura.getText());
		double imc = peso / (altura * altura);

		if (imc <= 18.5) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi um abaixo do peso");
		} else if (imc >= 18.6 && imc <= 24.9) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi o Peso ideal");
		} else if (imc >= 25 && imc < 29.9) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi é levemente acima do peso");
		} else if (imc >= 30 && imc < 34.9) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi Obesidade grau 1");
		} else if (imc >= 35 && imc < 39.9) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi Obesidade grau 2");
		} else if (imc >= 40) {
			labelResultado.setText("O seu IMC é de : "+imc + " e você possi Obesidade grau 3");

		}

	}
}