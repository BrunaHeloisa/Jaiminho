import java.util.Scanner;

public class Jaiminho {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer QT = Integer.parseInt(scanner.nextLine());
		String[] respostas = new String [QT];
		//LOOP PARA QUANTIDADE DE ENTRADAS
		for (int i = 0;i<QT;i++) {
			Integer N = Integer.parseInt(scanner.nextLine());
			PontoDiario1[] pontos = new PontoDiario1[N];
			// LOOP PARA QUANTIDADE DE PONTOS DIÁRIOS SOBRE CADA ENTRADA
			for (int j = 0;j<N;j++) {
				String ponto = scanner.nextLine();
				String[] entradas = ponto.split(" ");
				
				PontoDiario1 pontoDiario = new PontoDiario1();
				pontoDiario.entradaPrimeiro = entradas[0];
				pontoDiario.saidaPrimeiro = entradas[1];
				pontoDiario.entradaSegundo = entradas[3];
				pontoDiario.saidaSegundo = entradas[4];
				pontos[j] = pontoDiario;												
			}
			//calculando o saldo de horas sobre cada entrada
			Integer saldoHoras = 0;
			for (int j = 0; j < pontos.length;j++) {
				saldoHoras += pontos[j].calculaSaldoHoras();
			}
			respostas[i] = PontoDiario1.converteMinutoHora(saldoHoras);
		}
		for (String resposta: respostas){
			System.out.println(resposta);
		}
	}
}

	
class PontoDiario {
	
	String entradaPrimeiro;
	
	String saidaPrimeiro;
	
	String entradaSegundo;
	
	String saidaSegundo;
	
	public Integer calculaSaldoHoras() {
		Integer saldo = 0;
		saldo += calculaHoraPonto(entradaPrimeiro,"08:00",1);
		saldo += calculaHoraPonto(saidaPrimeiro,"12:00",2);
		saldo += calculaHoraPonto(entradaSegundo,"14:00",1);
		saldo += calculaHoraPonto(saidaSegundo,"18:00",2);
		return saldo;
	}

	private Integer calculaHoraPonto(String ponto, String referencial,int entradaSaida) {
		Integer minutosPonto = converteHoraMinuto(ponto);
		Integer minutosReferencial = converteHoraMinuto(referencial);
		Integer diferenca = minutosReferencial - minutosPonto;
		if(diferenca >= -5 && diferenca <= 5){
			minutosPonto = minutosReferencial; //NESSE CASO DÁ  A MESMA DE return 0;
		}
		if(entradaSaida == 1){
			return minutosReferencial - minutosPonto;
		} 
		else {
			return minutosPonto - minutosReferencial;
		}
	}
	
	private Integer converteHoraMinuto(String horaString) {
		String[] horaMinuto1 = horaString.split(":");
		Integer quantidadeMinutos1 = Integer.parseInt(horaMinuto1[0]) * 60;
		quantidadeMinutos1 += Integer.parseInt(horaMinuto1[1]);
		return quantidadeMinutos1;
	}
	
	public static String converteMinutoHora(Integer minuto) {
		Integer minutos = minuto % 60;
		Integer horas = minuto / 60;
		String resposta = "";
		minutos = Math.abs(minutos);
		horas = Math.abs(horas);
		if (minuto < 0) {
			resposta += "- ";
		} else {
			resposta += "+ ";
		}
		if (horas < 10) {
			resposta += "0"+horas+":";
		} else {
			resposta += horas+":";
		}
		if (minutos < 10) {
			resposta += "0"+minutos;
		} else {
			resposta += minutos;
		}
		return resposta;
	}
}