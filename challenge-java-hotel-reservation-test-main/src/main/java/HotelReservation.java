public class HotelReservation {
    public String getCheapestHotel (String input) {
        float op1 = 0, op2 = 0, op3 = 0; // Variávies que guardam os valores de cada opção de hotel
        String[] str1 = input.split(":"); //O split separa a string a partir do character ':' em armazena em um vetor de tamanho 2.
        String tipo = str1[0]; //Tipo recebe o valor do indice 0 do vetor str1
        String[] dias = str1[1].split(","); // dias irá separar str1[1] sempre que encontrar um ','. O vetor dias é criado utilizando essa ação.
        String[] valor = new String[dias.length]; //Sera usado no primeiro for;
        String cheapest; // Variavel usada para armazenar qual hotel será o mais barato.
        int indice = 0;  // indice é um int criado para servir como contador de incremento no for melhorado.

        for (String dia : dias) { // for melhorado que itera dias
            valor[indice++] = dia.substring(dia.indexOf("(") + 1, dia.indexOf(")")); //substring em dia para encontrar o valor entre '(' e ')'.
        }


        if (tipo.equalsIgnoreCase("Regular")) { // Se o tipo for regular entra nesse if
            for (String dia : valor) { // Intera valor
                if (dia.equalsIgnoreCase("mon") || dia.equalsIgnoreCase("tue") || dia.equalsIgnoreCase("wed") || dia.equalsIgnoreCase("thu") || dia.equalsIgnoreCase("fri")) {//verifica se é dias de semana. se sim ele aplicará a cada op os valores respectivos a semana
                    op1 += 110;
                    op2 += 160;
                    op3 += 220;
                } else { // aqui ele ja entende que é finais de semana e aplica os valores correspondentes
                    op1 += 90;
                    op2 += 60;
                    op3 += 150;
                }
            }
        } else if (tipo.equalsIgnoreCase("Reward")) { // Se o if for reward entra nesse if, poderia ser utlizado ELSE, mas preferi garantir a entrada.
            for (String dia : valor) {// Intera valor
                if (dia.equalsIgnoreCase("mon") || dia.equalsIgnoreCase("tue") || dia.equalsIgnoreCase("wed") || dia.equalsIgnoreCase("thu") || dia.equalsIgnoreCase("fri")) {//verifica se é dias de semana. se sim ele aplicará a cada op os valores respectivos a semana
                    op1 += 80;
                    op2 += 110;
                    op3 += 100;
                } else {// aqui ele ja entende que é finais de semana e aplica os valores correspondentes
                    op1 += 80;
                    op2 += 50;
                    op3 += 40;
                }
            }
        }
        if(op1<op2 && op1<op3){ // Se op1 for o maior dentre os 3, cheapest recebe "Lakewood".
            cheapest = "Lakewood";
        }else if(op2<op1 && op2<op3){// Se op2 for o maior dentre os 3, cheapest recebe "Bridgewood".
            cheapest = "Bridgewood";
        }else{// Se nenhuma das duas acima foi verdadeiro, o op3 é o maior e cheapest recebe "Ridgewood".
            cheapest = "Ridgewood";
        }
        return cheapest; // Retorna uma string com valor de cheapest;
    }
}
