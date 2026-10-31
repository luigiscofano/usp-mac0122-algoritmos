# Relatório recuperado · Collatz, 2022

> Extração textual autorizada do documento do autor. As imagens incorporadas não fazem parte desta extração. O texto é preservado como acervo, inclusive imprecisões; ele não é o fonte do módulo novo em C11. Link e identificador privados de origem foram omitidos.

Conjectura de Collatz - EP1


Relatório MAC0122 - 2022.2


Professor: Carlos Eduardo ferreira


Aluno: Luigi Scofano de Araujo  -  N°USP: 13680334


===================================================================================================




Explicação do Programa:


  



Nessa parte do código, inicialmente, eu incluí as bibliotecas que seriam necessárias para a realização do programa. A biblioteca stdio.h foi usada para funções básicas como printf, scanf, entre outras e a biblioteca stdlib.h foi usada, exclusivamente, para utilizar o comando sizeof, que mede o tamanho de certa variável.


  



Nessa parte do código, eu criei a função main do programa. Assim, declarei as variáveis i e f, que foram informadas no enunciado do EP e outras três variáveis inteiras: n (usada para atualizar o laço for, que virá mais a frente), a, usada para representar o número do intervalo que está sendo analisado na conjectura de collatz) e cont (utilizado para contar o número de passos necessários até chegar no 1). Além disso, também declarei uma variável b do tipo float (usada para a mesma finalidade que a variável a, porém funcionando para números decimais, quando for necessário).


Ademais, utilizei os comandos printf e scanf para imprimir na tela as frases “Digite o valor de i:” e “digite o valor de f:” e depois escanear esses valores e salvá-los nas variáveis ie  f criadas anteriormente.


  



Nessa parte do código, ainda dentro da função main, eu criei o laço for, com o intuito de realizar as operações da conjectura de collatz para cada inteiro dentro do intervalo [i,f].


Neste laço for, eu inicializei as variáveis a e b como n, para que os valores utilizados tivessem o mesmo valor do número analisado na conjectura de collatz. Dessa forma, se o número recebido for negativo, o programa dirá que esse valor é inválido e se o número for um inteiro positivo o programa inicia um laço while para realizar a sequência de collatz.


No laço while, a condição para realizar as operações de dentro do laço é o número analisado ser diferente de 1, pois se for igual a 1 significa que o programa chegou ao fim. Dessa forma, se o número for par, ele é dividido por dois, no primeiro laço if. Se o número for ímpar existem duas possibilidades: ou ele estoura o tamanho de uma variável do tipo int durante as contas ou não. Se ele não estourar ele entra no laço else, no qual o valor é multiplicado por três e acrescido em 1. Caso ele vá estourar o tamanho do int, ele entra no laço if else, no qual todas as parcelas da conta são divididas por mil, diminuindo o valor, para que assim ele não ultrapasse o valor permitido que cabe em um int. Ao fim do laço if else, o contador é acrescido em duas unidades, pois além de realizar a operação necessária para números ímpares, ele também realiza a operação necessária para números pares, para diminuir o valor em definitivo antes de multiplicá-lo por mil, novamente, para retornar ao valor que ele deveria ser originalmente.


  



Por fim, o programa acaba com o comando return 0, finalizando o código quando o laço for for finalizado.


Programa Completo:


  





Estratégia para valores muito grandes:


Para valores que estourassem o tamanho suportado pela variável do tipo int, a estratégia utilizada foi descobrir em quais contas ocorreria essa extrapolação.


Neste sentido, a extrapolação só ocorreria em casos em que o número fosse ímpar e tivesse que ser multiplicado por 3 e depois acrescido em 1. Assim, para descobrir em quais contas isso ocorreria, criei um laço else if,no qual a condição de entrada seria que o número fosse ímpar e que o número fosse maior que o valor máximo suportado por um int  subtraído de 1, dividido por 3 ((sizeof(int)-1)/3).


Dessa forma, para impedir que a extrapolação ocorresse, na hora de realizar a conta, cada parcela da conta foi dividida por 1000, resultando em um valor muito menor que o esperado, que caberia em um int. 


Assim, a próxima etapa (divisão por 2) é realizada e depois o número é multiplicado por 1000 novamente para retornar ao valor que deveria ser.




Observações e Dificuldades:


Encontrei dificuldades na otimização do código. Embora tenha conseguido fazer o programa funcionar para valores que não funcionava anteriormente (como o 127), com a utilização do recurso para a extrapolação explicado acima, o programa ainda é um pouco lento para valores em que as contas se tornam mais complexas (como o 121, por exemplo).


Busquei formas de melhorar a eficiência do programa, como utilizar menos variáveis e realizar o incremento de variáveis com variável++ ao invés de variável = variável +1, mas mesmo assim o programa continuou demorando mais para alguns casos do que para outros.




Bibliografia:


https://sergioprado.org/otimizacao-de-codigo-em-linguagem-c-parte-2/ (Otimização de Códigos)


https://multivix.edu.br/wp-content/uploads/2020/02/revista-esfera-tecnologia-v04-n01-artigo03.pdf (Artigo sobre a co jectura de collatz)






=================================================
========================================================================
