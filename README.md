# Um estudo de caso: pegadinha dos tipos de dados decimais: Float? Double? BigDecimal?

## Introdução:

Nesse estudo de caso pretendo demonstrar alguns erros comuns de tipos de dados decimais na programação.

Quando analisamos o tipo float, de acordo com a documentação, sua precisão é de 6 a 7 casas decimais.
Quando analisamos o tipo double, de acordo com a documentação, sua precisão é de 15 a 16 casas decimais.

Isso pode nos levar a acreditar que, para um programa que iremos utilizar apenas duas casas decimais, o float ou o double são boas opções de tipo de dados.

Mas, a verdade é que, dependendo da confiabilidade necessária dos dados, mesmo para apenas duas casas decimais, talvez esses tipos não sejam a melhor opção.

Para isso, precisamos analisar as necessidades do sistema para não cair no erro de precisão de ponto flutuante.

No código do presente repositório, demonstro como podemos perceber esse erro simplesmente realizando sucessivas somas de apenas '0,01' que, teoricamente, não deveria causar problemas, devido a sua precisão.

## Proposta do código:

Basicamente, o código do presente repositório inicializa três variáveis: uma do tipo float, outra do tipo double e uma terceira do tipo BigDecimal, todas com o valor 2.000.

Em seguida, entra num loop que se repetirá por mil iterações e, a cada iteração, incrementa todos os números em 0,01 (1/100). Um centésimo é representado com duas casas decimais. Portanto, não era para termos problemas com o tipo float e, muito menos, com o tipo double.


## Ao executar o código, sua saída será algo assim:



    Inicialização: (Float = 2000.0) ; (Double = 2000.0) ; (BigDecimal = 2000)
    A cada iteração do loop vamos incrementar 0.01 ao seu valor e exibir como cada tipo de dado se comporta
    1: (Float = 2000.0) ; (Double = 2000.0) ; (BigDecimal = 2000) - Float e Double são Iguais: 2000.0;
    2: (Float = 2000.01) ; (Double = 2000.01) ; (BigDecimal = 2000.01);
    3: (Float = 2000.02) ; (Double = 2000.02) ; (BigDecimal = 2000.02);
    4: (Float = 2000.03) ; (Double = 2000.03) ; (BigDecimal = 2000.03);
    5: (Float = 2000.04) ; (Double = 2000.04) ; (BigDecimal = 2000.04);
    6: (Float = 2000.05) ; (Double = 2000.05) ; (BigDecimal = 2000.05);
    7: (Float = 2000.06) ; (Double = 2000.06) ; (BigDecimal = 2000.06);
    8: (Float = 2000.0701) ; (Double = 2000.07) ; (BigDecimal = 2000.07);
    9: (Float = 2000.0801) ; (Double = 2000.08) ; (BigDecimal = 2000.08);
    10: (Float = 2000.0901) ; (Double = 2000.09) ; (BigDecimal = 2000.09);
    11: (Float = 2000.1001) ; (Double = 2000.1) ; (BigDecimal = 2000.10);
    12: (Float = 2000.1101) ; (Double = 2000.11) ; (BigDecimal = 2000.11);
    13: (Float = 2000.1201) ; (Double = 2000.12) ; (BigDecimal = 2000.12);
    14: (Float = 2000.1301) ; (Double = 2000.1299999999999) ; (BigDecimal = 2000.13);
    15: (Float = 2000.1401) ; (Double = 2000.1399999999999) ; (BigDecimal = 2000.14);
    
    (...)
    
    995: (Float = 2009.9497) ; (Double = 2009.939999999991) ; (BigDecimal = 2009.94);
    996: (Float = 2009.9597) ; (Double = 2009.949999999991) ; (BigDecimal = 2009.95);
    997: (Float = 2009.9697) ; (Double = 2009.959999999991) ; (BigDecimal = 2009.96);
    998: (Float = 2009.9797) ; (Double = 2009.969999999991) ; (BigDecimal = 2009.97);
    999: (Float = 2009.9897) ; (Double = 2009.979999999991) ; (BigDecimal = 2009.98);
    1000: (Float = 2009.9998) ; (Double = 2009.989999999991) ; (BigDecimal = 2009.99);
    
    Somatória:
          Float: 2005010.0
         Double: 2005004.9999999942
     BigDecimal: 2005005.00






- Observe que, na primeira iteração, o código que compara float com double usando '==' exibe que as duas variáveis são iguais.  
  - Porém, a partir da segunda iteração, isso já não acontece mais.


- Com 7 iterações, o tipo float já começa a divergir do tipo double na quarta casa decimal:  
  - O tipo float guarda o valor incorreto de '2000.0701' enquanto o tipo double ainda guarda o valor correto de '2000.07'


- E, após 13 iterações, o tipo double já começa a divergir do tipo BigDecimal.  
  - O tipo double guarda o valor de '2000.12999...' enquanto o tipo BigDecimal guarda o valor correto de '2000.13'


- Quando o loop conclui as mil iterações, podemos verificar os seguintes resultados da soma:

              Float: 2005010.0
             Double: 2005004.9999999942
         BigDecimal: 2005005.00

- Observe que a diferença de float para double não é mais de frações, mas sim, de mais de 5 unidades.
- Já a diferença de double para BigDecimal pode ser desprezível, para a maioria dos sistemas.

## Conclusão:

   - Em seu código, pode ser consideravelmente interessante substituir as variáveis do tipo float para o tipo double, para a maioria dos casos.


   - O tipo double ainda é uma excelente opção para a maioria dos sistemas, pela facilidade e velocidade em realizar operações aritméticas além de consumir menos espaço em memória, quando o comparamos com o tipo BigDecimal.


   - Caso a precisão precise ser levada extremamente a sério, mesmo que para duas casas decimais, o BigDecimal pode ser a melhor opção.


   - Caso precise comparar um tipo de ponto flutuante com outro, evite usar o '=='. Substitua por '<=' ou '>=', ou considere uma margem de erro para considerar ambos os números como iguais. Por exemplo:

            // Float f1 == Float f2 ?
            if (Math.abs(f1 - f2) <= 0.0001f) {
                // Considera iguais com margem de erro <= 1/10000
            }

   - Se optar por usar o BigDecimal, por ser um objeto, as operações são realizadas por métodos. Inclusive as comparações.
   - O problema das frações fica ainda mais crítico quando fizermos uso de operações aritméticas mais complexas como: multiplicação, divisão, exponenciação, etc.

## Curiosidade:

- O problema exposto acima não é exclusivo do Java. O mesmo problema pode ser viso em outras linguagens como, por exemplo, C#.

E, se você gostou desse estudo de caso, por favor, não deixe de comentar!