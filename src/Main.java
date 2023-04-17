import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // Inicializamos as variáveis do tipo Float, Double e BigDecimal:
        float somaParcialFloat = 2000f, incrementoFloat = 0.01f, somaFinalFloat = 0;
        double somaParcialDouble = 2000d, incrementoDouble = 0.01d, somaFinalDouble = 0;
        BigDecimal somaParcialBigDecimal = new BigDecimal("2000"), incrementoBigDecimal = new BigDecimal("0.01"), somaFinalBigDecimal = new BigDecimal(0);


        System.out.println("Inicialização: (Float = " + somaParcialFloat + ") ; (Double = " + somaParcialDouble + ") ; (BigDecimal = "+somaParcialBigDecimal+")\n");

        // Aqui definimos a qtde de iterações, ou seja, quantas vezes vamos somar 0,01 a cada tipo de dado:
        double qtdeIncremento = 1000;

        System.out.println("A cada iteração do loop vamos incrementar 0.01 ao seu valor e exibir como cada tipo de dado se comporta");
        for (int i = 1; i <= qtdeIncremento; i++) {

            System.out.print(i + ": (Float = " + somaParcialFloat + ") ; (Double = " + somaParcialDouble + ") ; (BigDecimal = "+somaParcialBigDecimal+")");

            // Veja porque não é recomendado comparar float com double usando '==' (apenas no primeiro loop as duas varipaveis são iguais):
            if ((somaParcialFloat == somaParcialDouble))
                System.out.println(" - Float e Double são Iguais: " + somaParcialDouble + ";");
            else
                System.out.println(";");

            somaParcialFloat += incrementoFloat;
            somaFinalFloat += somaParcialFloat;

            somaParcialDouble += incrementoDouble;
            somaFinalDouble += somaParcialDouble;

            somaParcialBigDecimal = somaParcialBigDecimal.add(incrementoBigDecimal);
            somaFinalBigDecimal = somaFinalBigDecimal.add(somaParcialBigDecimal);



            // Base64: RXN0dWRvIGRlIENhc286IHBlZ2FkaW5oYSBkb3MgdGlwb3MgZGUgZGFkb3MgZGVjaW1haXMgLSBpbXBsZW1lbnRhZG8gcG9yIE1hcnRvbkx5cmEgZW0gMTcvMDQvMjAyMyBlc3BlY2lhbG1lbnRlIHBhcmEgbyBGw7NydW0gZGEgRGlvLm1l
        }
        System.out.println("\nSomatória:");
        System.out.println("      Float: " + somaFinalFloat);
        System.out.println("     Double: " + somaFinalDouble);
        System.out.println(" BigDecimal: " + somaFinalBigDecimal);

    }
}