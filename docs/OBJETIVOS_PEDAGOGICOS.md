# Objetivos pedagógicos

**A meta é explicar o mecanismo e demonstrar o resultado.** Cada atividade exige evidência observável.

| Competência | Atividade | Evidência de aprendizagem |
| --- | --- | --- |
| Construir invariantes | Manter todos os inícios ATG e o primeiro stop em cada quadro | Comparar 5.000 sequências com um oráculo simples |
| Separar busca e volume da saída | Retornar coordenadas antes de criar substrings | Explicar O(n+g) para a busca e o custo dos caracteres impressos |
| Justificar uma decisão gulosa | Ordenar e unir intervalos fechados | Provar que apenas o último componente pode mudar na varredura |
| Contar multiplicidades | Aplicar dois ponteiros com valores repetidos | Justificar n·m e n(n−1)/2; comparar com enumeração quadrática |
| Evitar overflow | Somar dois int em long | Demonstrar a contagem com extremos do tipo int |

## Sequência de estudo

1. Leia o contrato e resolva um exemplo pequeno à mão.
2. Preveja saída e estado intermediário antes de executar.
3. Confronte sua previsão com o programa.
4. Altere uma entrada de fronteira e justifique o resultado.
5. Explique o invariante violado em um teste negativo.
6. Proponha uma extensão com critério de aceitação.

## Rubrica sugerida

| Critério | Inicial | Adequado | Avançado |
| --- | --- | --- | --- |
| Explicação | Repete a saída | Explica etapas | Justifica invariante e contraexemplo |
| Verificação | Usa um exemplo | Testa fronteiras | Compara com referência independente |
| Limites | Omite hipóteses | Declara domínio | Explica falha e sua detecção |
| Reprodução | Depende do ambiente pessoal | Usa comandos e fixtures | Registra versão, origem e evidência |

Rubrica proposta nesta edição, sem estudo de eficácia pedagógica com participantes ou nota institucional.
