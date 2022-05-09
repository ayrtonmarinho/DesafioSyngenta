public class HotelReservation {
    public String getCheapestHotel (String input) {
        float op1 = 0, op2 = 0, op3 = 0;
        String[] str1 = input.split(":");
        String tipo = str1[0];
        String[] dias = str1[1].split(",");
        String[] valor = new String[dias.length];
        String cheapest;
        int indice = 0;
        for (String dia : dias) {
            valor[indice++] = dia.substring(dia.indexOf("(") + 1, dia.indexOf(")"));
        }


        if (tipo.equalsIgnoreCase("Regular")) {
            for (String dia : dias) {
                if (dia.equalsIgnoreCase("mon") || dia.equalsIgnoreCase("tue") || dia.equalsIgnoreCase("wed") || dia.equalsIgnoreCase("thu") || dia.equalsIgnoreCase("fri")) {
                    op1 += 110;
                    op2 += 160;
                    op3 += 220;
                } else {
                    op1 += 90;
                    op2 += 60;
                    op3 += 150;
                }
            }
        } else if (tipo.equalsIgnoreCase("Reward")) {
            for (String dia : dias) {
                if (dia.equalsIgnoreCase("mon") || dia.equalsIgnoreCase("tue") || dia.equalsIgnoreCase("wed") || dia.equalsIgnoreCase("thu") || dia.equalsIgnoreCase("fri")) {
                    op1 += 80;
                    op2 += 110;
                    op3 += 100;
                } else {
                    op1 += 80;
                    op2 += 50;
                    op3 += 40;
                }
            }
        }
        if(op1<op2 && op1<op3){
            cheapest = "Lakewood";
        }else if(op2<op1 && op2<op3){
            cheapest = "Bridgewood";
        }else{
            cheapest = "Ridgewood";
        }
        return cheapest;
    }
}
