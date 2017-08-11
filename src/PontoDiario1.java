public class PontoDiario1 {
	
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
	
	public static String converteMinutoHora(Integer minutos) {
		Integer minuto = minutos % 60;
		Integer horas = minutos /60;
		String resposta = "";
		if(horas<0){
			resposta +="- ";
		}else{
			resposta +="+ ";
		}
		if(horas<10){
			resposta+= "0"+Math.abs(horas)+":";
		}else{
			resposta += Math.abs(horas)+":";
		}
		if(horas<0){
			resposta +="- ";
		}else{
			resposta +="+ ";
		}
		if(horas<10){
			resposta+= "0"+Math.abs(minutos)+":";
		}else{
			resposta += Math.abs(minutos)+":";
		}
		
		return resposta;
	}
}
